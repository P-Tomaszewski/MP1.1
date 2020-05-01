
import java.io.Serializable;

public class EquipmentModemWiFi extends Equipment implements Serializable {
    private static final long serialVersionUID = 017L;
    int maxSpeed;
    int minSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public EquipmentModemWiFi(String model, String nrSeryjny, int maxSpeed, int minSpeed) {
     super(model, nrSeryjny);
     setMaxSpeed(maxSpeed);
     setMinSpeed(minSpeed);
    }


    public String toString(){
        return "Model: "+ model + " Numer seryjny: " + serialNumber + " predkosc min: " + minSpeed +"Mb/s predkosc max: " + maxSpeed +"Mb/s";
    }

}
