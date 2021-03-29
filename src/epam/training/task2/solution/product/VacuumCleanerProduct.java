package epam.training.task2.solution.product;

public class VacuumCleanerProduct extends Product{

    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleanerProduct(Builder builder){
        super(builder.price);
        this.powerConsumption = builder.powerConsumption;
        this.filterType = builder.filterType;
        this.bagType = builder.bagType;
        this.wandType = builder.wandType;
        this.motorSpeedRegulation = builder.motorSpeedRegulation;
        this.cleaningWidth = builder.cleaningWidth;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }
    @Override
    public String toString() {
        return String.format("Vacuum Cleaner: Power Consumption=%f, Filter Type=%s, Bag Type=%s, Wand Type=%s, Motor Speed Regulation=%f, Cleaning Width=%f, Price=%f",
                powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth, getPrice());
    }

    public static class Builder {
        private double price;
        private double powerConsumption;
        private String filterType;
        private String bagType;
        private String wandType;
        private double motorSpeedRegulation;
        private double cleaningWidth;

        public Builder() {
        }

        public VacuumCleanerProduct build() {
            return new VacuumCleanerProduct(this);
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setPowerConsumption(double powerConsumption) {
            this.powerConsumption = powerConsumption;
        }

        public void setFilterType(String filterType) {
            this.filterType = filterType;
        }

        public void setBagType(String bagType) {
            this.bagType = bagType;
        }

        public void setWandType(String wandType) {
            this.wandType = wandType;
        }

        public void setMotorSpeedRegulation(double motorSpeedRegulation) {
            this.motorSpeedRegulation = motorSpeedRegulation;
        }

        public void setCleaningWidth(double cleaningWidth) {
            this.cleaningWidth = cleaningWidth;
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
                    case ("FILTER_TYPE"):
                        builder.setFilterType(paramVal);
                        break;
                    case ("BAG_TYPE"):
                        builder.setBagType(paramVal);
                        break;
                    case ("WAND_TYPE"):
                        builder.setWandType(paramVal);
                        break;
                    case ("MOTOR_SPEED_REGULATION"):
                        builder.setMotorSpeedRegulation(Double.parseDouble(paramVal));
                        break;
                    case ("CLEANING_WIDTH"):
                        builder.setCleaningWidth(Double.parseDouble(paramVal));
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
