import sun.util.resources.LocaleData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public  class Oferta  implements Serializable {
    private String name;
    private String descript;
    private LocalDate dataUtworzeniaOferty;
    private int okresZobowiazania; //12 lub 24 miesiace ZMIENIC NA ENUM
    private LocalDate dataKoncaDostepnosciOferty; //atr. pochodny z dataUtworzenia
    private UslugaInternet uslugaInternet; //atr. zlozony i opcjonalny
    private SprzetModemWiFi sprzetModemWiFi; //atr. zlozony i opcjonalny
    private static ArrayList<Oferta> oferty; // ekstansja klasy

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

    public SprzetModemWiFi getSprzetModemWiFi() {
        return sprzetModemWiFi;
    }

    public void setSprzetModemWiFi(SprzetModemWiFi sprzetModemWiFi) {
        this.sprzetModemWiFi = sprzetModemWiFi;
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

    private static void addOferta(Oferta oferta){
        if(oferta == null){
            oferty = new ArrayList<Oferta>();
        }
        oferty.add(oferta);
    }
    public static void removeOferta(Oferta oferta){
        if(oferty != null){
            oferty.remove(oferta);
        }
    }
    public static void printOferty(String param){
        if(param == null){
            for(Oferta h : oferty){
                System.out.println(h.toString());
            }
        }
        else if(param == "name"){
            for(Oferta h : oferty){
                System.out.println(h.getName());
            }
        }
        else if(param == "descript"){
            for(Oferta h : oferty){
                System.out.println(h.getDescript());
            }
        }
        else if(param == "dataUtworzeniaOferty"){
            for(Oferta h : oferty){
                System.out.println(h.getDataUtworzeniaOferty());
            }
        }
        else if(param == "dataKoncaDostepnosciOferty"){
            for(Oferta h : oferty){
                System.out.println(h.getDataKoncaDostepnosciOferty());
            }
        }
        else if(param == "okresZobowiazania"){
            for(Oferta h : oferty){
                System.out.println(h.getOkresZobowiazania());
            }
        }
        else if(param == "uslugaInternet"){
            for(Oferta h : oferty){
                if(h.getUslugaInternet() != null)
                    System.out.println(h.getUslugaInternet());
            }
        }
        else if(param == "sprzetModemWiFi"){
            for(Oferta h : oferty){
                if(h.getSprzetModemWiFi() != null)
                    System.out.println(h.getSprzetModemWiFi());
            }
        }
    }

    public static void saveOferta(ObjectOutputStream stream) throws IOException {
        stream.writeObject(oferty);
    }
    @SuppressWarnings("unchecked")
    public static void readOferta(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        oferty = (ArrayList<Oferta>) stream.readObject();
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Oferta: " + getName() + ", ");
        result.append("Opis:  " + getDescript() + " ");
        if(getUslugaInternet() != null){
            result.append("Usluga: " + getUslugaInternet().toString());
        }
        if(getSprzetModemWiFi() != null){
            result.append("Sprzet: " +getSprzetModemWiFi().toString());
        }
        return result.toString();
    }

    public Oferta(String name, String descript, LocalDate dataUtworzeniaOferty, int okresZobowiazania,
                  SprzetModemWiFi sprzetModemWiFi) {
        setName(name);
        setDescript(descript);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        setSprzetModemWiFi(sprzetModemWiFi);
    }

    public Oferta(String name, String descript, LocalDate dataUtworzeniaOferty, int okresZobowiazania,
                  UslugaInternet uslugaInternet) {
        setName(name);
        setDescript(descript);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        setUslugaInternet(uslugaInternet);
    }

    public Oferta(String name, String descript, LocalDate dataUtworzeniaOferty, int okresZobowiazania,
                   UslugaInternet uslugaInternet, SprzetModemWiFi sprzetModemWiFi) {
        setName(name);
        setDescript(descript);
        setDataUtworzeniaOferty(dataUtworzeniaOferty);
        setOkresZobowiazania(okresZobowiazania);
        setUslugaInternet(uslugaInternet);
        setSprzetModemWiFi(sprzetModemWiFi);
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






}
