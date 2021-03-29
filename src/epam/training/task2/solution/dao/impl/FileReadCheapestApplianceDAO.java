package epam.training.task2.solution.dao.impl;

import epam.training.task2.solution.dao.*;
import epam.training.task2.solution.service.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileReadCheapestApplianceDAO implements CheapestApplianceDAO {
    @Override
    public ArrayList<String> findCheapestAppliance() throws DAOException {

        ArrayList<String> lines = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/appliances_db.txt"));
            double minPrice = 0;

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                HashMap<String, String> params = Parser.parseParamsLine(line);
                if (params.containsKey("price")) {
                    double currentPrice = Double.valueOf(params.get("price"));
                    if (currentPrice < minPrice || lines.isEmpty()) {
                        minPrice = currentPrice;
                        lines.clear();
                        lines.add(line);
                    } else if (currentPrice == minPrice) {
                        lines.add(line);
                    }
                }
            }
        }catch (IOException e) {
            throw new DAOException(e);
        }
        return lines;
    }
}
