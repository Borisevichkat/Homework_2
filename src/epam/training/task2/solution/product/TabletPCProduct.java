package epam.training.task2.solution.product;

public class TabletPCProduct extends Product {

    private double batteryCapacity;
    private double displayInches;
    private double memoryRom;
    private double flashMemoryCapacity;
    private String color;

    public TabletPCProduct (Builder builder){
        super(builder.price);
        this.batteryCapacity = builder.batteryCapacity;
        this.displayInches = builder.displayInches;
        this.memoryRom = builder.memoryRom;
        this.flashMemoryCapacity = builder.flashMemoryCapacity;
        this.color = builder.color;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public double getMemoryRom() {
        return memoryRom;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("TabletPC: Battery Capacity=%f, Display Inches=%f, Memory Rom=%f, Flash Memory Capacity=%f, Color=%s, Price=%f",
                batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color, getPrice());
    }

    public static class Builder{
        private double price;
        private double batteryCapacity;
        private double displayInches;
        private double memoryRom;
        private double flashMemoryCapacity;
        private String color;

        public Builder(){
        }

        public TabletPCProduct build(){
            return new TabletPCProduct(this);
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setBatteryCapacity(double batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
        }

        public void setDisplayInches(double displayInches) {
            this.displayInches = displayInches;
        }

        public void setMemoryRom(double memoryRom) {
            this.memoryRom = memoryRom;
        }

        public void setFlashMemoryCapacity(double flashMemoryCapacity) {
            this.flashMemoryCapacity = flashMemoryCapacity;
        }

        public void setColor(String color) {
            this.color = color;
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
                    case ("DISPLAY_INCHES"):
                        builder.setDisplayInches(Double.parseDouble(paramVal));
                        break;
                    case ("MEMORY_ROM"):
                        builder.setMemoryRom(Double.parseDouble(paramVal));
                        break;
                    case ("FLASH_MEMORY_CAPACITY"):
                        builder.setFlashMemoryCapacity(Double.parseDouble(paramVal));
                        break;
                    case ("COLOR"):
                        builder.setColor(paramVal);
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
