package net.balsoftware.attendance.dao;

import net.balsoftware.attendance.model.Student;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PostgresConnectionTest {
    @Test
    public void canGetStudentList() throws SQLException, IOException {
        Connection connection = PostgresConnectionUtil.getInstance().getConnection();
        String query = "select * from student";
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int createdById = resultSet.getInt("created_by_id");
                Timestamp createdTimestamp = resultSet.getTimestamp("created_timestamp");

                System.out.println(createdTimestamp);
//                ZonedDateTime createdZonedDateTime = ZonedDateTime.from(createdTimestamp.toInstant());
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Student student = new Student()
                        .withCreatedById(id)
//                        .withCreatedTimestamp(createdZonedDateTime)
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .withCreatedById(createdById);
                System.out.println(student);
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
