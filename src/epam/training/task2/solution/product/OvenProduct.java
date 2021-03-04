package epam.training.task2.solution.product;

import epam.training.task2.solution.product.Product;

public class OvenProduct extends Product {
    private double powerConsumption;
    private double weight;
    private double capacity;
    private double depth;
    private double height;
    private double width;

    public OvenProduct(Builder builder) {
        super(builder.price);
        this.powerConsumption = builder.powerConsumption;
        this.weight = builder.weight;
        this.capacity = builder.capacity;
        this.depth = builder.depth;
        this.height = builder.height;
        this.width = builder.width;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getHeight() {
        return height;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() {
        return weight;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return String.format("Power consumption=%f, Capacity=%f, Depth=%f, Width=%f, Height=%f, Weight=%f, Price=%f",
                powerConsumption, capacity, depth, width, height, weight, getPrice());
    }

    public static class Builder {
        private double price;
        private double powerConsumption;
        private double weight;
        private double capacity;
        private double depth;
        private double height;
        private double width;

        public Builder() {
        }

        public OvenProduct build() {
            return new OvenProduct(this);
        }

        public void setPrice(double price) {
            this.price = price;
        }
        public void setPowerConsumption(double powerConsumption) {
            this.powerConsumption = powerConsumption;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }
        public void setCapacity(double capacity) {
            this.capacity = capacity;
        }
        public void setDepth(double depth) {
            this.depth = depth;
        }
        public void setHeight(double height) {
            this.height = height;
        }
        public void setWidth(double width) {
            this.width = width;
        }
    }

    public static Builder parseString(String[] params) {
        Builder builder = new Builder();
        for (String keyval : params) {
            String[] inputParams = keyval.split("=");
            if (inputParams.length == 2) {
                String paramName = String.valueOf(inputParams[0]);
                String paramVal = String.valueOf(inputParams[1]);
                switch (paramName) {
                    case ("POWER_CONSUMPTION"):
                        builder.setPowerConsumption(Double.parseDouble(paramVal));
                        break;
                    case ("WEIGHT"):
                        builder.setWeight(Double.parseDouble(paramVal));
                        break;
                    case ("CAPACITY"):
                        builder.setCapacity(Double.parseDouble(paramVal));
                        break;
                    case ("DEPTH"):
                        builder.setDepth(Double.parseDouble(paramVal));
                        break;
                    case ("HEIGHT"):
                        builder.setHeight(Double.parseDouble(paramVal));
                        break;
                    case ("WIDTH"):
                        builder.setWeight(Double.parseDouble(paramVal));
                        break;
                    case ("PRICE"):
                        builder.setPrice(Double.parseDouble(paramVal));
                        break;
                }
            }
        }
        return builder;
    }
}
