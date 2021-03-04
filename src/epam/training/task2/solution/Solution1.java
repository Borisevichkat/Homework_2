package epam.training.task2.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import epam.training.task2.solution.product.*;

public class Solution1{

    public static ArrayList<Product> readDB () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/k_voroshkovatut.by/IdeaProjects/EPAM_HW22/src/resourses/appliances_db.txt"));
        ArrayList<Product> items = new ArrayList<Product>();
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
                items.add(generateProductByParams(productName, params));
            }
        }
        return items;
    }

    private static Product generateProductByParams(String productName, String[] params) {
        Product newProduct = null;
        switch (productName) {
            case ("Oven"):
                newProduct = OvenProduct.parseString(params).build();
                break;
        }
        return newProduct;
    }

    public static ArrayList<Product> findKettle(ArrayList<Product> items){
        ArrayList<Product> result = new ArrayList<Product>();
        for(Product item : items) {
            if (item instanceof OvenProduct) {
                result.add(item);
            }
        }
        return result;
    }

    public static void printItems(ArrayList<Product> items) {
        String result = "";
        /*for(ProductItem item: items) {
            result += item.productName + ":\n";
            for(String key: item.params.keySet()) {
                result += key + "=" + item.params.get(key) + "\n";
            }
            result += "------------\n";
        }*/
        System.out.print(result);
    }

    public static ArrayList<Product> findMinProductWithMinPrice(ArrayList<ProductItem> items) {
        ArrayList<Product> result = new ArrayList<Product>();
        Integer minPrice = null;
        /*for (ProductItem item : items) {
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
        }*/
        return result;
    }
}