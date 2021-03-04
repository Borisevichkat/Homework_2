package epam.training.task2.solution.dao;

import java.util.ArrayList;

public interface ReadApplianceDAO {
    ArrayList<String> readApplianceData() throws DAOException;
    ArrayList<String> readApplianceDataByCategory(String categoryName) throws DAOException;
}
