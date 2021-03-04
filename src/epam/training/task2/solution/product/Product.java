package epam.training.task2.solution.product;

public abstract class Product {
    private double price;

    public Product() {
    }

    public Product(double price) {
        this.price = price;
    }

    public void setPrice(double p_price) {
        this.price = p_price;
    }

    public double getPrice() {
        return this.price;
    }
}
