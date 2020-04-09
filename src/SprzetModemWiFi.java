import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SprzetModemWiFi extends ObjectPlus implements Serializable {
    private static final long serialVersionUID = 017L;

    String model;
    String nrSeryjny;
    int predkoscMax;
    int predkoscMin;

    private static ArrayList<SprzetModemWiFi> sprzetModemWiFis;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrSeryjny() {
        return nrSeryjny;
    }

    public void setNrSeryjny(String nrSeryjny) {
        this.nrSeryjny = nrSeryjny;
    }

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
       setModel(model);
       setNrSeryjny(nrSeryjny);
        setPredkoscMin(predkoscMin);
       setPredkoscMax(predkoscMax);
       addSprzetModemWiFi(this);
    }

    public String toString(){
        return "Model: "+ model + " Numer seryjny: " + nrSeryjny+ " predkosc min: " + predkoscMin+"Mb/s predkosc max: " + predkoscMax+"Mb/s";
    }

    private static void addSprzetModemWiFi(SprzetModemWiFi sprzetModemWiFi){
        if(sprzetModemWiFis == null){
            sprzetModemWiFis = new ArrayList<>();
        }
        sprzetModemWiFis.add(sprzetModemWiFi);
    }
    public static void removeSprzetModemWiFi(SprzetModemWiFi sprzetModemWiFi){
        if(sprzetModemWiFis != null){
            sprzetModemWiFis.remove(sprzetModemWiFi);
        }
    }

    public static void printSprzetModemWiFi(){
        for(SprzetModemWiFi s : sprzetModemWiFis){
            System.out.println(s.toString());
        }
    }
}
