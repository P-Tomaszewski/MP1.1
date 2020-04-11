
import java.io.Serializable;

public class InternetService extends ObjectPlus implements Serializable {

    private static final long serialVersionUID = 217L;
    String dataPacketGb;
    double price;

    public String getDataPacketGb() {
        return dataPacketGb;
    }

    public void setDataPacketGb(String dataPacketGb) {
        this.dataPacketGb = dataPacketGb;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public InternetService(String dataPacketGb, double price) {
        setPrice(price);
        setDataPacketGb(dataPacketGb);
    }
    public String toString(){
        return "pakiet danych: " + dataPacketGb + "Gb cena: " + price + "zl";
    }
}
