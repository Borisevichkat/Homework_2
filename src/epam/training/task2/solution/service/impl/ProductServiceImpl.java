package epam.training.task2.solution.service.impl;

import epam.training.task2.solution.dao.DAOException;
import epam.training.task2.solution.dao.DAOProvider;
import epam.training.task2.solution.dao.ReadApplianceDAO;
import epam.training.task2.solution.product.Product;
import epam.training.task2.solution.service.*;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {

    @Override
    public ArrayList<Product> getProducts() throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        ReadApplianceDAO readApplianceDAO = provider.getReadApplianceDAO();
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        ParseProductService parseProductService = serviceProvider.getParseProductService();

        ArrayList<Product> products = new ArrayList<Product>();

        try {
            ArrayList<String> lines = readApplianceDAO.readApplianceData();
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

    @Override
    public ArrayList<Product> getProductsByCategory(String category) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        ReadApplianceDAO readApplianceDAO = provider.getReadApplianceDAO();
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        ParseProductService parseProductService = serviceProvider.getParseProductService();

        ArrayList<Product> products = new ArrayList<Product>();

        try {
            ArrayList<String> lines = readApplianceDAO.readApplianceDataByCategory(category);
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
