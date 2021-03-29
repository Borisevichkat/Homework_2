package epam.training.task2.solution.service.impl;

import epam.training.task2.solution.dao.CheapestApplianceDAO;
import epam.training.task2.solution.dao.DAOException;
import epam.training.task2.solution.dao.DAOProvider;
import epam.training.task2.solution.product.Product;
import epam.training.task2.solution.service.*;

import java.util.ArrayList;

public class CheapestProductServiceImpl implements CheapestProductService {
    @Override
    public ArrayList<Product> getCheapestProducts() throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        CheapestApplianceDAO cheapestApplianceDAO = provider.getFindCheapestAppliance();
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        ParseProductService parseProductService = serviceProvider.getParseProductService();

        ArrayList<Product> products = new ArrayList<Product>();

        try {
            ArrayList<String> lines = cheapestApplianceDAO.findCheapestAppliance();
            for (String line : lines) {
                String productName = Parser.getProductName(line);
                String[] params = Parser.getParamsByLine(line);
                products.add(parseProductService.generateProduct(productName, params));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return products;
    }
}
