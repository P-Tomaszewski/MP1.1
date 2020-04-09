import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public  class Oferta extends ObjectPlus implements Serializable{

    private static final long serialVersionUID = 007L;
    private String name;
    private String descript;
    private LocalDate dataUtworzeniaOferty;
    private int okresZobowiazania;
    private LocalDate dataKoncaDostepnosciOferty; //atr. pochodny z dataUtworzenia
    private UslugaInternet uslugaInternet; //atr. zlozony i opcjonalny
    private ArrayList<SprzetModemWiFi> sprzetModemWiFi; //atr. powtarzalny i opcjonalny

    private static ArrayList<Oferta> oferty; // ekstansja klasy
    private static String grupaDocelowa; //atr.klasowy

    public static String getGrupaDocelowa() {
        return grupaDocelowa; }

    public static void setGrupaDocelowa(String grupaDocelowa) {
        Oferta.grupaDocelowa = grupaDocelowa;
    }

    public LocalDate getDataKoncaDostepnosciOferty() {
        return dataKoncaDostepnosciOferty;
    }

    public int getOkresZobowiazania() {
        return okresZobowiazania;
    }

    public void setOkresZobowiazania(int okresZobowiazania) {
        this.okresZobowiazania = okresZobowiazania;
    }

    public UslugaInternet getUslugaInternet() {
        return uslugaInternet;
    }

    public void setUslugaInternet(UslugaInternet uslugaInternet) {
        this.uslugaInternet = uslugaInternet;
    }

    public ArrayList<SprzetModemWiFi> getSprzetModemWiFi(){
        return this.sprzetModemWiFi;
    }

    public void addSprzetModemwiFi(SprzetModemWiFi sprzetModemWiFi){
        this.sprzetModemWiFi.add(sprzetModemWiFi);
    }

    public void removeSrzetModemWiFi(SprzetModemWiFi sprzetModemWiFi){
        this.sprzetModemWiFi.remove(sprzetModemWiFi);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public LocalDate getDataUtworzeniaOferty() {
        return dataUtworzeniaOferty;
    }

    public void setDataUtworzeniaOferty(LocalDate dataUtworzeniaOferty) {
        if(okresZobowiazania == 12) {
            this.dataKoncaDostepnosciOferty = dataUtworzeniaOferty.plusYears(1);
        } else
        {
            this.dataKoncaDostepnosciOferty = dataUtworzeniaOferty.plusYears(2);
        }
        this.dataUtworzeniaOferty = dataUtworzeniaOferty;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Nazwa oferty: " + getName() + ", ");
        result.append("Opis:  " + getDescript() + " ");
        if(getUslugaInternet() != null){
            result.append("Usluga: " + getUslugaInternet().toString());
        }
        if(getSprzetModemWiFi() != null){
            result.append(" Sprzet: " +getSprzetModemWiFi().toString());
        }
        return result.toString();
    }

    public Oferta(String name, String descript, LocalDate dataUtworzeniaOferty, int okresZobowiazania) {
        setName(name);
        setDescript(descript);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        this.sprzetModemWiFi = new ArrayList<>();
    }

    public Oferta(String name, String descript, LocalDate dataUtworzeniaOferty, int okresZobowiazania,
                  UslugaInternet uslugaInternet) {
        setName(name);
        setDescript(descript);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        setUslugaInternet(uslugaInternet);
        this.sprzetModemWiFi = new ArrayList<>();
    }
}
