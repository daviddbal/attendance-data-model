package net.balsoftware.attendance.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.balsoftware.attendance.dao.DAOManager;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionHelperC3PO implements ConnectionHelper {

    // Singleton - user getInstance()
    private ConnectionHelperC3PO() {
        try {
            // TODO - USE ENVIRONMENT VARIABLES IN DOCKER FOR THESE PROPERTIES
//            cpds.setDriverClass("org.postgresql.Driver");
            cpds.setDriverClass("org.h2.Driver");
            cpds.setJdbcUrl("jdbc:h2:mem:test");
            cpds.setUser("user");
            cpds.setPassword("password");
        } catch (PropertyVetoException e) {
            // handle the exception
        }
    }

    private static class SingletonHelper{
        private static final ConnectionHelperC3PO INSTANCE = new ConnectionHelperC3PO();
    }
    public static ConnectionHelperC3PO getInstance() {
        return ConnectionHelperC3PO.SingletonHelper.INSTANCE;
    }

    private ComboPooledDataSource cpds = new ComboPooledDataSource();

    @Override
    public Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }
}
