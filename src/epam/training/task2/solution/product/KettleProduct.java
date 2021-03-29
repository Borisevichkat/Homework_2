package epam.training.task2.solution.product;

public class KettleProduct extends Product{
    private double powerConsumption;
    private double weight;
    private double capacity;
    private double height;

    public KettleProduct(Builder builder) {
        super(builder.price);
        this.powerConsumption = builder.powerConsumption;
        this.weight = builder.weight;
        this.capacity = builder.capacity;
        this.height = builder.height;
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

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Kettle: Power consumption=%f, Capacity=%f, Height=%f, Weight=%f, Price=%f",
                powerConsumption, capacity, height, weight, getPrice());
    }

    public static class Builder {
        private double price;
        private double powerConsumption;
        private double weight;
        private double capacity;
        private double height;

        public Builder() {
        }

        public KettleProduct build() {
            return new KettleProduct(this);
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
        public void setHeight(double height) {
            this.height = height;
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
                    case ("HEIGHT"):
                        builder.setHeight(Double.parseDouble(paramVal));
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
