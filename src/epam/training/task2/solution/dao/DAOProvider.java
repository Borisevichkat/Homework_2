package epam.training.task2.solution.dao;

import epam.training.task2.solution.dao.impl.*;

public final class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    //private final UserDAO userDAO = new FileUserDAO();
    private final ReadApplianceDAO readApplianceDAO = new FileReadApplianceDAO();

    private DAOProvider() {}

//    public UserDAO getUserDAO() {
//        return userDAO;
//    }

    public ReadApplianceDAO getReadApplianceDAO() {
        return readApplianceDAO;
    }

    public ReadApplianceDAO getReadApplianceDAO(String category) {
        return readApplianceDAO;
    }

    public static DAOProvider getInstance() {
        return instance;
    }
}