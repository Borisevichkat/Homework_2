package epam.training.task2.solution;

import java.io.IOException;
import java.util.ArrayList;

import epam.training.task2.solution.product.Product;

public class Task {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<Product> items = Solution1.readDB();
        ArrayList<Product> kettles = Solution1.findKettle(items);
        Solution1.printItems(kettles);
    }
}
