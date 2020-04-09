import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UslugaInternet extends ObjectPlus {

    private static final long serialVersionUID = 217L;
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
        addUslugaInternet(this);
    }

    public String toString(){
        return "pakiet danych: " + pakietDanychWGb + "Gb cena: " + cena+ "zl";
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
}
