package net.balsoftware.attendance.dao;

import net.balsoftware.attendance.connection.ConnectionHelper;
import net.balsoftware.attendance.model.Student;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostgresConnectionTest extends TestAbstract {
    @Test
    public void canGetStudentList() throws SQLException, IOException {
        StudentDAO studentDAO = injector.getInstance(StudentDAO.class);
        List<Student> students = studentDAO.getAllStudents();
        assertEquals(3, students.size());
        
//        String query = "select * from student";
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet resultSet = stmt.executeQuery(query);
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int createdById = resultSet.getInt("created_by_id");
//                String createdTimestamp = resultSet.getString("created_timestamp");
//                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
//                        .appendPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"
//                        ).parseLenient()
//                        .appendOffset("+HH:MM", "Z")
//                        .toFormatter();
//                ZonedDateTime createdZonedDateTime = ZonedDateTime.parse(createdTimestamp, formatter);
//                String firstName = resultSet.getString("first_name");
//                String lastName = resultSet.getString("last_name");
//
//                Student student = new Student()
//                        .withCreatedById(id)
//                        .withCreatedTimestamp(createdZonedDateTime)
//                        .withFirstName(firstName)
//                        .withLastName(lastName)
//                        .withCreatedById(createdById);
//                System.out.println(student);
//            }
//        } catch (SQLException e ) {
//            e.printStackTrace();
//        } finally {
//            if (stmt != null) { stmt.close(); }
//        }
    }
}
