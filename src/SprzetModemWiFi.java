import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SprzetModemWiFi {
    String model;
    String nrSeryjny;
    int predkoscMax;
    int predkoscMin;

    private static ArrayList<SprzetModemWiFi> sprzetModemWiFis;

    public SprzetModemWiFi(String model, String nrSeryjny, int predkoscMax, int predkoscMin) {
        this.model = model;
        this.nrSeryjny = nrSeryjny;
        this.predkoscMax = predkoscMax;
        this.predkoscMin = predkoscMin;
    }

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

    public String toString(){
        return model + " " + nrSeryjny+ " " + predkoscMin+"Mb/s " + predkoscMax+"Mb/s";
    }

    private static void addSprzetModemWiFi(SprzetModemWiFi sprzetModemWiFi){
        if(sprzetModemWiFis == null){
            sprzetModemWiFis = new ArrayList<SprzetModemWiFi>();
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

    public static void saveSprzetModemWiFis(ObjectOutputStream stream) throws IOException {
        stream.writeObject(sprzetModemWiFis);
    }
    @SuppressWarnings("unchecked")
    public static void readSprzetModemWiFis(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        sprzetModemWiFis = (ArrayList<SprzetModemWiFi>) stream.readObject();
    }
}