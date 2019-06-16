package net.balsoftware.attendance.dao;

import net.balsoftware.attendance.connection.ConnectionHelper;

import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Singleton
public class PostgresTestConnectionHelper implements ConnectionHelper {

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
            URL propertiesUrl = PostgresConnectionTest.class.getResource(fileName);
            prop = new Properties();

            // load a properties file
            prop.load(propertiesUrl.openStream());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
