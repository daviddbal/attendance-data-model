package net.balsoftware.attendance.dao;

import java.sql.*;

public class SetupTables {
    public static void setupTables() {
        String createStudentTables = "CREATE TABLE tutorials_tbl ( \n" +
                "   id INT NOT NULL, \n" +
                "   title VARCHAR(50) NOT NULL, \n" +
                "   author VARCHAR(20) NOT NULL, \n" +
                "   submission_date DATE, \n" +
                ");";
    }

    public static void main(String[] args) {

        String url = "jdbc:h2:tcp://localhost:9092/testdb";
        String user = "sa";
        String passwd = "s$cret";

        String query = "SELECT * FROM cars";

        try (Connection con = DriverManager.getConnection(url, user, passwd);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {

                System.out.printf("%d %s %d%n", rs.getInt(1),
                        rs.getString(2), rs.getInt(3));
            }

        } catch (SQLException ex) {

//            Logger lgr = Logger.getLogger(JavaSeH2Server.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
