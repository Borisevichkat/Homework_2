package epam.training.task2.solution.dao;

import java.util.ArrayList;

public interface CheapestApplianceDAO {
    ArrayList<String> findCheapestAppliance() throws DAOException;
}
