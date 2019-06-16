package net.balsoftware.attendance.dao;

import net.balsoftware.attendance.connection.ConnectionHelper;
import net.balsoftware.attendance.connection.PostgresConnectionHelper;

public class DAOManager {
    // Singleton - user getInstance()
    private DAOManager() {
        connectionHelper = new PostgresConnectionHelper();
    }

    private static class SingletonHelper{
        private static final DAOManager INSTANCE = new DAOManager();
    }
    public static DAOManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private final ConnectionHelper connectionHelper;
    private EventDAO eventDAO;
    private StudentDAO studentDAO;

    public EventDAO getEventDAO() {
        if (eventDAO == null) {
            eventDAO = new EventDAO();
        }
        return eventDAO;
    }

    public StudentDAO getStudentDAO() {
        if (studentDAO == null) {
            studentDAO = new StudentDAO(connectionHelper);
        }
        return studentDAO;
    }
}
