package epam.training.task2.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution1{

    public static ArrayList<ProductItem> readDB () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/k_voroshkovatut.by/IdeaProjects/EPAM_HW22/src/resourses/appliances_db.txt"));
        ArrayList<ProductItem> items = new ArrayList<ProductItem>();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            line = line.replaceAll("\\s+","");
            String[] arr = line.split(":");
            if (arr.length == 2) {
                String productName = arr[0].replaceAll("\\s+","");
                String paramsAll = arr[1];
                String[] params = paramsAll.split(",");
                HashMap<String, Object> values = new HashMap<String, Object>();
                for (String keyval : params) {
                    String[] inputParams = keyval.split("=");
                    if (inputParams.length == 2) {
                        values.put(String.valueOf(inputParams[0]), inputParams[1]);
                    }
                }
                items.add(new ProductItem(productName, values));
            }
        }
        return items;
    }

    public static ArrayList<ProductItem> findKettle(ArrayList<ProductItem> items){
        ArrayList<ProductItem> result = new ArrayList<ProductItem>();
        for(ProductItem item : items) {
            if (item.productName.equals("Kettle")) {
                result.add(item);
            }
        }
        return result;
    }

    public static void printItems(ArrayList<ProductItem> items) {
        String result = "";
        for(ProductItem item: items) {
            result += item.productName + ":\n";
            for(String key: item.params.keySet()) {
                result += key + "=" + item.params.get(key) + "\n";
            }
            result += "------------\n";
        }
        System.out.print(result);
    }

    public static ArrayList<ProductItem> findMinProductWithMinPrice(ArrayList<ProductItem> items) {
        ArrayList<ProductItem> result = new ArrayList<ProductItem>();
        Integer minPrice = null;
        for (ProductItem item : items) {
            Object price = item.params.get("Price");
            if (price != null) {
                Integer curPrice = (Integer) price;
                if (minPrice == null) {
                    minPrice = curPrice;
                }
                if (curPrice < minPrice) {
                    minPrice = curPrice;
                    result = new ArrayList<ProductItem>();
                    result.add(item);
                } else if (curPrice == minPrice) {
                    result.add(item);
                }
            }
        }
    }
}