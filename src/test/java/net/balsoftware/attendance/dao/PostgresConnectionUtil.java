package net.balsoftware.attendance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnectionUtil {

    // Singleton - user getInstance()
    private PostgresConnectionUtil() {
    }

    private static class SingletonHelper{
        private static final PostgresConnectionUtil INSTANCE = new PostgresConnectionUtil();
    }
    public static PostgresConnectionUtil getInstance() {
        return PostgresConnectionUtil.SingletonHelper.INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/api";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","postgres");
//        props.setProperty("ssl","true");
        Connection conn = DriverManager.getConnection(url, props);
        return conn;
    }
}
