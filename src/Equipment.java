public abstract class Equipment extends ObjectPlus {
    private static final long serialVersionUID = 0172L;
    String model;
    String serialNumber;


    public Equipment(String model, String serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


}
