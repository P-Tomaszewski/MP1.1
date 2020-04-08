import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UslugaInternet {
    String pakietDanychWGb;
    double cena;

    private static ArrayList<UslugaInternet> uslugaInternets;

    public String getPakietDanychWGb() {
        return pakietDanychWGb;
    }

    public void setPakietDanychWGb(String pakietDanychWGb) {
        this.pakietDanychWGb = pakietDanychWGb;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public UslugaInternet(String pakietDanychWGb, double cena) {
        setCena(cena);
       setPakietDanychWGb(pakietDanychWGb);
    }

    public String toString(){
        return pakietDanychWGb + "Gb"+ " " + cena+ "zl";
    }

    private static void addUslugaInternet(UslugaInternet uslugaInternet){
        if(uslugaInternets == null){
            uslugaInternets = new ArrayList<UslugaInternet>();
        }
        uslugaInternets.add(uslugaInternet);
    }
    public static void removeUslugaInternet(SprzetModemWiFi sprzetModemWiFi){
        if(uslugaInternets != null){
            uslugaInternets.remove(sprzetModemWiFi);
        }
    }

    public static void printUslugaInternet(){
        for(UslugaInternet s : uslugaInternets){
            System.out.println(s.toString());
        }
    }

    public static void saveUslugaInternet(ObjectOutputStream stream) throws IOException {
        stream.writeObject(uslugaInternets);
    }
    @SuppressWarnings("unchecked")
    public static void readUslugaInternet(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        uslugaInternets = (ArrayList<UslugaInternet>) stream.readObject();
    }
}
