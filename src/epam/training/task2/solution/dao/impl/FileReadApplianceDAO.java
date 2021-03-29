package epam.training.task2.solution.dao.impl;

import epam.training.task2.solution.dao.*;
import epam.training.task2.solution.service.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadApplianceDAO implements ReadApplianceDAO {
    @Override
    public ArrayList<String> readApplianceData() throws DAOException {

        ArrayList<String> lines = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/appliances_db.txt"));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                //line = line.replaceAll("\\s+", "");
                lines.add(line);
            }
        }catch (IOException e) {
            throw new DAOException(e);
        }
        return lines;
    }

    @Override
    public ArrayList<String> readApplianceDataByCategory(String category) throws DAOException {

        ArrayList<String> lines = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/appliances_db.txt"));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String productName = Parser.getProductName(line);
                if (productName.contains(category)) {
                    lines.add(line);
                }
            }
        }catch (IOException e) {
            throw new DAOException(e);
        }
        return lines;
    }
}
