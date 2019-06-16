package net.balsoftware.attendance.dao;

import net.balsoftware.attendance.connection.ConnectionHelper;
import net.balsoftware.attendance.model.Student;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final ConnectionHelper connectionHelper;

    @Inject
    public StudentDAO(ConnectionHelper connectionHelper) {
        this.connectionHelper = connectionHelper;
    }

    public String getStudentById(int id) {
        throw new RuntimeException("not implemented");
    }

    public List<Student> getAllStudents() throws SQLException {
        Connection connection = connectionHelper.getConnection();
        List<Student> students = new ArrayList<>();
        String query = "select * from student";
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int createdById = resultSet.getInt("created_by_id");
                String createdTimestamp = resultSet.getString("created_timestamp");
                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                        .appendPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
                        .parseLenient()
                        .appendOffset("+HH:MM", "Z")
                        .toFormatter();
                ZonedDateTime createdZonedDateTime = ZonedDateTime.parse(createdTimestamp, formatter);
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Student student = new Student()
                        .withCreatedById(id)
                        .withCreatedTimestamp(createdZonedDateTime)
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .withCreatedById(createdById);
                System.out.println(student);
                students.add(student);
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return students;
    }
}
