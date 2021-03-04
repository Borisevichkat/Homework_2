package epam.training.task2.solution.product;

public class RefrigeratorProduct extends Product{

    private double powerConsumption;
    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public RefrigeratorProduct( Builder builder){
        super(builder.price);
        this.powerConsumption = builder.powerConsumption;
        this.weight = builder.weight;
        this.freezerCapacity = builder.freezerCapacity;
        this.overallCapacity = builder.overallCapacity;
        this.height = builder.height;
        this.width = builder.width;
    }
    public double getPowerConsumption(){
        return powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public double getOverallCapacity(){
        return overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return String.format("Power Consunption=%f, Weight=%f, Freezer Capacity=%f, Overeall Capacity=%f, Height=%f, Width=%f, Price=%f",
                powerConsumption, weight, freezerCapacity, overallCapacity, height, width, getPrice());
    }

    public static class Builder{
        private double price;
        private double powerConsumption;
        private double weight;
        private double freezerCapacity;
        private double overallCapacity;
        private double height;
        private double width;

        public Builder(){
        }

        public RefrigeratorProduct build(){
            return new RefrigeratorProduct(this);
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

        public void setFreezerCapacity(double freezerCapacity) {
            this.freezerCapacity = freezerCapacity;
        }

        public void setOverallCapacity(double overallCapacity) {
            this.overallCapacity = overallCapacity;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public void setWidth(double width) {
            this.width = width;
        }
    }
    public static Builder parseString(String[] params){
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
                    case ("FREEZER_CAPACITY"):
                        builder.setFreezerCapacity(Double.parseDouble(paramVal));
                        break;
                    case ("OVERALL_CAPACITY"):
                        builder.setOverallCapacity(Double.parseDouble(paramVal));
                        break;
                    case ("HEIGHT"):
                        builder.setHeight(Double.parseDouble(paramVal));
                        break;
                    case ("WIDTH"):
                        builder.setWidth(Double.parseDouble(paramVal));
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
