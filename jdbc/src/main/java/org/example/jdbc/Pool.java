package org.example.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Pool {

    public String propertiesName = "connection-INF.properties";

    private static Pool instance = null;

    protected int maxConnect = 100;

    protected int normalConnect = 10;

    protected String driverName = null;

    protected Driver driver = null;

    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void loadDrivers(String dri) {
        try {
            driver = (Driver) Class.forName(dri).getConstructor().newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("Successfully registered JDBC Driver " + dri);
        } catch (Exception e) {
            System.err.println("Cannot registered JDBC Driver " + dri);
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesName);
        Properties prop = new Properties();
        prop.load(in);
        this.driverName = prop.getProperty("driver");
        this.maxConnect = Integer.parseInt(prop.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(prop.getProperty("normalConnect"));
    }

    public abstract void createPool();

    /**
     * 返回数据库连接池Pool的实例
     * @return Pool
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public static synchronized Pool getInstance() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (instance == null) {
            instance = (Pool) Class.forName("org.example.jdbc.Pool").getDeclaredConstructor().newInstance();
        }
        return instance;
    }

    public abstract Connection getConnection();

    public abstract Connection getConnection(long time);

    public abstract void releaseConnection(Connection conn);

    public abstract int getNum();

    public abstract int getActiveNum();

    protected synchronized void release() {
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("Successfully release JDBC Driver " + driver.getClass().getName());
        } catch (SQLException e) {
            System.err.println("Cannot Release JDBC Driver " + driver.getClass().getName());
            e.printStackTrace();
        }
    }

}
