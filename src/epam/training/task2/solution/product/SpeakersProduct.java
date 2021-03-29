package epam.training.task2.solution.product;

public class SpeakersProduct extends Product{

    private double powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private double cordLength;

    public SpeakersProduct(Builder builder){
        super(builder.price);
        this.powerConsumption = builder.powerConsumption;
        this.numberOfSpeakers = builder.numberOfSpeakers;
        this.frequencyRange = builder.frequencyRange;
        this.cordLength = builder.cordLength;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }
    @Override
    public String toString() {
        return String.format("Speakers: Power Consumption=%f, Number Of Speakers=%s, Frequency Range=%s, Cord Length=%s, Price=%f",
                powerConsumption, numberOfSpeakers, frequencyRange, cordLength, getPrice());
    }

    public static class Builder {
        private double price;
        private double powerConsumption;
        private int numberOfSpeakers;
        private String frequencyRange;
        private double cordLength;

        public Builder() {
        }

        public SpeakersProduct build() {
            return new SpeakersProduct(this);
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setPowerConsumption(double powerConsumption) {
            this.powerConsumption = powerConsumption;
        }

        public void setNumberOfSpeakers(int numberOfSpeakers) {
            this.numberOfSpeakers = numberOfSpeakers;
        }

        public void setFrequencyRange(String frequencyRange) {
            this.frequencyRange = frequencyRange;
        }

        public void setCordLength(double cordLength) {
            this.cordLength = cordLength;
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
                    case ("NUMBER_OF_SPEAKERS"):
                        builder.setNumberOfSpeakers(Integer.parseInt(paramVal));
                        break;
                    case ("FREQUENCY_RANGE"):
                        builder.setFrequencyRange(paramVal);
                        break;
                    case ("CORD_LENGTH"):
                        builder.setCordLength(Double.parseDouble(paramVal));
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
