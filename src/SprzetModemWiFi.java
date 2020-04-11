
import java.io.Serializable;
import java.util.ArrayList;

public class SprzetModemWiFi extends Sprzet implements Serializable {
    private static final long serialVersionUID = 017L;
    int predkoscMax;
    int predkoscMin;

    private static ArrayList<SprzetModemWiFi> sprzetModemWiFis;


    public int getPredkoscMax() {
        return predkoscMax;
    }

    public void setPredkoscMax(int predkoscMax) {
        this.predkoscMax = predkoscMax;
    }

    public int getPredkoscMin() {
        return predkoscMin;
    }

    public void setPredkoscMin(int predkoscMin) {
        this.predkoscMin = predkoscMin;
    }

    public SprzetModemWiFi(String model, String nrSeryjny, int predkoscMax, int predkoscMin) {
     super(model, nrSeryjny);
     setPredkoscMax(predkoscMax);
     setPredkoscMax(predkoscMin);
    }

    //Przesloniecie metody
    public String getModel() {
        return "Model routera: " + model;
    }

    public String toString(){
        return "Model: "+ model + " Numer seryjny: " + nrSeryjny+ " predkosc min: " + predkoscMin+"Mb/s predkosc max: " + predkoscMax+"Mb/s";
    }

}
