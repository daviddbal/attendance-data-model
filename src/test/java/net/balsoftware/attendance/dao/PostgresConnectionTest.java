package net.balsoftware.attendance.dao;

import org.junit.Test;

import java.sql.*;

public class PostgresConnectionTest {
    @Test
    public void canGetTableList() throws SQLException {
        Connection connection = PostgresConnectionUtil.getInstance().getConnection();
        String query = "select * from users";
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            final int columnCount = resultSetMetaData.getColumnCount();
            System.out.println(columnCount);
            while (resultSet.next()) {
                Object[] values = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    values[i - 1] = resultSet.getObject(i);
                }
                System.out.println(values);
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
