package org.example.template.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class DaoFactory {

    private static final Map<Class<? extends JdbcTemplate>, JdbcTemplate> map = new ConcurrentHashMap<>();

    private static final DataSource dataSource;

    static {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            map.put(MemberDao.class, new MemberDao(dataSource));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JdbcTemplate getDao(Class<? extends JdbcTemplate> clazz) {
        return map.get(clazz);
    }
}
