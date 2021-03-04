package epam.training.task2.solution.dao.impl;

import epam.training.task2.solution.dao.*;
import java.util.ArrayList;

public class FileReadApplianceDAO implements ReadApplianceDAO {
    @Override
    public ArrayList<String> readApplianceData() throws DAOException {

        DAOProvider provider = DAOProvider.getInstance();
        ReadApplianceDAO readApplianceDAO = provider.getReadApplianceDAO();

        try {
            return readApplianceDAO.readApplianceData();
        } catch (DAOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public ArrayList<String> readApplianceDataByCategory(String category) throws DAOException {

        DAOProvider provider = DAOProvider.getInstance();
        ReadApplianceDAO readApplianceDAO = provider.getReadApplianceDAO();

        try {
            return readApplianceDAO.readApplianceDataByCategory();
        } catch (DAOException e) {
            throw new DAOException(e);
        }
        return null;
    }
}
