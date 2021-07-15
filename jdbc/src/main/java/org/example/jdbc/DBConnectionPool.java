package org.example.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public final class DBConnectionPool extends Pool {
    
    private int checkedOut; // 正在使用的连接数
    private Vector<Connection> availConnections = new Vector<>();
    private String password = null;
    private String url = null;
    private String username = null;
    private static int num = 0; // 空闲连接数
    private static int activeNum = 0; // 当前可用的连接数
    private static volatile DBConnectionPool pool = null;
    
    public static DBConnectionPool getInstance() {
        if (pool == null) {
            synchronized (DBConnectionPool.class) {
                if (pool == null) {
                    pool = new DBConnectionPool();
                }
            }
        }
        return pool;
    }
    
    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection c = newConnection();
                if (c != null) {
                    availConnections.addElement(c);
                    num++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void init() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesName);

        Properties prop = new Properties();
        prop.load(in);
        this.username = prop.getProperty("username");
        this.password = prop.getProperty("password");
        this.driverName = prop.getProperty("driverName");
        this.url = prop.getProperty("url");
        this.maxConnect = Integer.parseInt(prop.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(prop.getProperty("normalConnect"));
    }

    @Override
    public synchronized void releaseConnection(Connection conn) {
        availConnections.addElement(conn);
        num++;
        checkedOut--;
        activeNum--;
        notifyAll();
    }

    private Connection newConnection() {
        Connection conn = null;
        try {
            if (username == null) {
                conn = DriverManager.getConnection(url);
            } else {
                conn = DriverManager.getConnection(url, username, password);
            }
            System.out.println("Connection Pool created a new Connection");
        } catch (SQLException e) {
            System.out.println("Cannot created a new Connection");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 从连接池获取连接
     * @return 连接池返回的连接
     */
    @Override
    public synchronized Connection getConnection() {
        Connection conn = null;
        if (availConnections.size() > 0) {
            num--;
            conn = availConnections.firstElement();
            availConnections.removeElementAt(0);
            try {
                if (conn.isClosed()) {
                    System.out.println("Remove an unavailable connection from connection pool");
                    conn = getConnection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (maxConnect == 0 || checkedOut < maxConnect) {
            conn = newConnection();
        }
        if (conn != null) {
            checkedOut++;
        }
        activeNum++;
        return conn;
    }

    /**
     * 允许等待时间内获取连接
     * @param time
     * @return 允许等待时间
     */
    @Override
    public synchronized Connection getConnection(long time) {
        long startTime = System.nanoTime();
        Connection conn;
        while ((conn = getConnection()) == null) {
            try {
                // 当前无空闲连接，等待其他连接释放
                wait(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (System.nanoTime() - startTime >= time) {
                return null;
            }
        }
        return conn;
    }

    /**
     * 返回当前空闲连接数
     * @return 空闲连接数
     */
    @Override
    public int getNum() {
        return num;
    }

    /**
     * 返回当前可用连接数
     * @return 当前可用连接数
     */
    @Override
    public int getActiveNum() {
        return activeNum;
    }

    /**
     * 关闭所有连接
     */
    @Override
    public synchronized void release() {
        try {
            Enumeration<Connection> allConnections = availConnections.elements();
            while (allConnections.hasMoreElements()) {
                Connection conn = allConnections.nextElement();
                try {
                    conn.close();
                    num--;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            availConnections.removeAllElements();
            activeNum = 0;
        } finally {
            super.release();
        }
    }

    @Override
    public void createPool() {
        pool = new DBConnectionPool();
        if (pool != null) {
            System.out.println("Successfully create DBConnectionPool");
        } else {
            System.out.println("Cannot create DBConnectionPool");
        }
    }
}
