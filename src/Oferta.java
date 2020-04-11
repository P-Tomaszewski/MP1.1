import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public  class Oferta extends ObjectPlus implements Serializable{

    private static final long serialVersionUID = 007L;
    private String nazwa;
    private String opis;
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
    } //metoda klasowa

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

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setDescript(String descript, String author) {
        this.opis = descript + " created by " + author;
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
        result.append("Nazwa oferty: " + getNazwa() + ", ");
        result.append("Opis:  " + getOpis() + " ");
        if(getUslugaInternet() != null){
            result.append("Usluga: " + getUslugaInternet().toString());
        }
        if(getSprzetModemWiFi() != null){
            result.append(" Sprzet: " +getSprzetModemWiFi().toString());
        }
        return result.toString();
    }


    public Oferta(String nazwa, String opis, LocalDate dataUtworzeniaOferty, int okresZobowiazania) {
        setNazwa(nazwa);
        setOpis(opis);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        this.sprzetModemWiFi = new ArrayList<>();
    }

    public Oferta(String nazwa, String opis, LocalDate dataUtworzeniaOferty, int okresZobowiazania,
                  UslugaInternet uslugaInternet) {
        setNazwa(nazwa);
        setOpis(opis);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        setUslugaInternet(uslugaInternet);
        this.sprzetModemWiFi = new ArrayList<>();
    }

    public Oferta(String nazwa, String opis, String author, LocalDate dataUtworzeniaOferty, int okresZobowiazania,
                  UslugaInternet uslugaInternet) {
        setNazwa(nazwa);
        setDescript(opis, author);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        setUslugaInternet(uslugaInternet);
        this.sprzetModemWiFi = new ArrayList<>();
    }
}
