package epam.training.task2.solution.product;

public class LaptopProduct extends Product{

    private double batteryCapacity;
    private String os;
    private double memoryRom;
    private double systemMemory;
    private double cpu;
    private double displayInchs;

    public LaptopProduct(Builder builder){
        super(builder.price);
        this.batteryCapacity = builder.batteryCapacity;
        this.os = builder.os;
        this.memoryRom = builder.memoryRom;
        this.systemMemory = builder.systemMemory;
        this.cpu = builder.cpu;
        this.displayInchs = builder.displayInchs;
    }
    public double getBatteryCapacity(){
        return batteryCapacity;
    }
    public String getOs(){
        return os;
    }
    public double getMemoryRom() {
        return memoryRom;
    }
    public double getSystemMemory() {
        return systemMemory;
    }
    public double getCpu(){
        return cpu;
    }
    public double getDisplayInches(){
        return  displayInchs;
    }

    @Override
    public String toString() {
        return String.format("Laptop: Battery capacity=%f, Os=%s, Memory Rom=%f, System Memory=%f, CPU=%f, Display Inchs=%f, Price=%f",
                batteryCapacity, os, memoryRom, systemMemory, cpu, displayInchs, getPrice());
    }

    public static class Builder {
        private double price;
        private double batteryCapacity;
        private String os;
        private double memoryRom;
        private double systemMemory;
        private double cpu;
        private double displayInchs;

        public Builder() {
        }

        public LaptopProduct build () {
            return new LaptopProduct(this);
        }

        public void setPrice ( double price){
            this.price = price;
        }
        public void setBatteryCapacity(double batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
        }
        public void setOs(String os) {
            this.os = os;
        }
        public void setMemoryRom(double memoryRom) {
            this.memoryRom = memoryRom;
        }
        public void setSystemMemory(double systemMemory) {
            this.systemMemory = systemMemory;
        }
        public void setCpu(double cpu) {
            this.cpu = cpu;
        }
        public void setDisplayInchs(double displayInches) {
            this.displayInchs = displayInchs;
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
                    case ("BATTERY_CAPACITY"):
                        builder.setBatteryCapacity(Double.parseDouble(paramVal));
                        break;
                    case ("OS"):
                        builder.setOs(paramVal);
                        break;
                    case ("MEMORY_ROM"):
                        builder.setMemoryRom(Double.parseDouble(paramVal));
                        break;
                    case ("SYSTEM_MEMORY"):
                        builder.setMemoryRom(Double.parseDouble(paramVal));
                        break;
                    case ("CPU"):
                        builder.setCpu(Double.parseDouble(paramVal));
                        break;
                    case ("DISPLAY_INCHS"):
                        builder.setDisplayInchs(Double.parseDouble(paramVal));
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
