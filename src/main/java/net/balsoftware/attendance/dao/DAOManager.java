package net.balsoftware.attendance.dao;

public class DAOManager {
    // Singleton - user getInstance()
    private DAOManager() {
    }

    private static class SingletonHelper{
        private static final DAOManager INSTANCE = new DAOManager();
    }
    public static DAOManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

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
            studentDAO = new StudentDAO();
        }
        return studentDAO;
    }
}
