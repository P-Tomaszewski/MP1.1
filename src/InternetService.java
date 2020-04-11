
import java.io.Serializable;
import java.util.ArrayList;

public class InternetService extends ObjectPlus implements Serializable {

    private static final long serialVersionUID = 217L;
    String pakietDanychWGb;
    double cena;

    private static ArrayList<InternetService> uslugaInternets;

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

    public InternetService(String pakietDanychWGb, double cena) {
        setCena(cena);
        setPakietDanychWGb(pakietDanychWGb);
    }
    public String toString(){
        return "pakiet danych: " + pakietDanychWGb + "Gb cena: " + cena+ "zl";
    }
}
