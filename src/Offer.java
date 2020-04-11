import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public  class Offer extends ObjectPlus implements Serializable{

    private static final long serialVersionUID = 007L;
    private String name;
    private String descript;
    private LocalDate offerCreationDate;
    private int commimentPeriod;
    private LocalDate offerAvailabilityEndDate; //atr. pochodny z dataUtworzenia
    private InternetService internetService; //atr. zlozony i opcjonalny
    private ArrayList<EquipmentModemWiFi> equipmentModemWiFi; //atr. powtarzalny i opcjonalny

    private static ArrayList<Offer> oferty; // ekstansja klasy
    private static String grupaDocelowa; //atr.klasowy

    public static String getGrupaDocelowa() {
        return grupaDocelowa; }

    public static void setGrupaDocelowa(String grupaDocelowa) {
        Offer.grupaDocelowa = grupaDocelowa;
    } //metoda klasowa

    public LocalDate getOfferAvailabilityEndDate() {
        return offerAvailabilityEndDate;
    }

    public int getCommimentPeriod() {
        return commimentPeriod;
    }

    public void setCommimentPeriod(int commimentPeriod) {
        this.commimentPeriod = commimentPeriod;
    }

    public InternetService getUslugaInternet() {
        return internetService;
    }

    public void setInternetService(InternetService internetService) {
        this.internetService = internetService;
    }

    public ArrayList<EquipmentModemWiFi> getEquipmentModemWiFi(){
        return this.equipmentModemWiFi;
    }

    public void addSprzetModemwiFi(EquipmentModemWiFi equipmentModemWiFi){
        this.equipmentModemWiFi.add(equipmentModemWiFi);
    }

    public void removeSrzetModemWiFi(EquipmentModemWiFi equipmentModemWiFi){
        this.equipmentModemWiFi.remove(equipmentModemWiFi);
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

    public void setDescript(String descript, String author) {
        this.descript = descript + " created by " + author;
    }

    public LocalDate getOfferCreationDate() {
        return offerCreationDate;
    }

    public void setOfferCreationDate(LocalDate offerCreationDate) {
        if(commimentPeriod == 12) {
            this.offerAvailabilityEndDate = offerCreationDate.plusYears(1);
        } else
        {
            this.offerAvailabilityEndDate = offerCreationDate.plusYears(2);
        }
        this.offerCreationDate = offerCreationDate;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Nazwa oferty: " + getName() + ", ");
        result.append("Opis:  " + getDescript() + " ");
        if(getUslugaInternet() != null){
            result.append("Usluga: " + getUslugaInternet().toString());
        }
        if(getEquipmentModemWiFi() != null){
            result.append(" Sprzet: " + getEquipmentModemWiFi().toString());
        }
        return result.toString();
    }


    public Offer(String name, String descript, LocalDate offerCreationDate, int commimentPeriod) {
        setName(name);
        setDescript(descript);
        setOfferCreationDate(offerCreationDate);
        setCommimentPeriod(commimentPeriod);
        this.equipmentModemWiFi = new ArrayList<>();
    }

    public Offer(String name, String descript, LocalDate offerCreationDate, int commimentPeriod,
                 InternetService internetService) {
        setName(name);
        setDescript(descript);
        setOfferCreationDate(offerCreationDate);
        setCommimentPeriod(commimentPeriod);
        setInternetService(internetService);
        this.equipmentModemWiFi = new ArrayList<>();
    }

    public Offer(String name, String descript, String author, LocalDate offerCreationDate, int commimentPeriod,
                 InternetService internetService) {
        setName(name);
        setDescript(descript, author);
        setOfferCreationDate(offerCreationDate);
        setCommimentPeriod(commimentPeriod);
        setInternetService(internetService);
        this.equipmentModemWiFi = new ArrayList<>();
    }
}
