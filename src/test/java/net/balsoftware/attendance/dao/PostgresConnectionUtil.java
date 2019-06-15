package net.balsoftware.attendance.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Properties databaseProperties = readTestDatabaseProperties();
        String url = databaseProperties.getProperty("url");
        Connection conn = DriverManager.getConnection(url, databaseProperties);
        return conn;
    }

    private Properties readTestDatabaseProperties() {
        Properties prop = null;
        String fileName = "test_database_config.properties";
        try {
            URL url = PostgresConnectionTest.class.getResource(fileName);
            prop = new Properties();

            // load a properties file
            prop.load(url.openStream());

            // get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
