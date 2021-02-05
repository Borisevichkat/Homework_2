package epam.training.task2.solution;

import java.io.IOException;
import java.util.ArrayList;

public class Task {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<ProductItem> items = Solution1.readDB();
        ArrayList<ProductItem> kettles = Solution1.findKettle(items);
        Solution1.printItems(kettles);
    }
}
