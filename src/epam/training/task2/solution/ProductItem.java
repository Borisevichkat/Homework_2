package epam.training.task2.solution;

import java.util.HashMap;

public class ProductItem {

    public String productName;
    public HashMap<String, Object> params;

    public ProductItem(String productName, HashMap<String, Object> params) {
        this.productName = productName;
        this.params = params;
    }
}
