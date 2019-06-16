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
        assertEquals(1, students.size());
    }
}
