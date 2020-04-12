public abstract class Equipment extends ObjectPlus {
    private static final long serialVersionUID = 0172L;
    String model;
    String serialNumber;


    public Equipment(String model, String serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }
}

