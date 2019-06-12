package net.balsoftware.attendance.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionHelper {
    Connection getConnection() throws SQLException;
}
