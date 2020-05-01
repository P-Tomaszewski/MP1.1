import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public  class Offer extends ObjectPlus implements Serializable{

    private static final long serialVersionUID = 007L;
    private String name;
    private String descript; // opcjonalny
    private LocalDate offerCreationDate;
    private int commitmentPeriod; //atr prosty okres zob.
    private static int minCommitmentPeriod = 12; //atr.klasowy
    private static int maxCommitmentPeriod = 24;
    private LocalDate offerAvailabilityEndDate; //atr. pochodny z dataUtworzenia
    private InternetService internetService; //atr. zlozony
    private ArrayList<EquipmentModemWiFi> equipmentModemWiFi; //atr. powtarzalny


    public LocalDate getOfferAvailabilityEndDate() {
        return offerAvailabilityEndDate;
    }

    public int getCommitmentPeriod() {
        return commitmentPeriod;
    }

    public void setCommitmentPeriod(int commitmentPeriod) {
        if(commitmentPeriod < minCommitmentPeriod) {
            throw new IllegalArgumentException("commitmentPeriod must by >= 12");
        } else if(commitmentPeriod > maxCommitmentPeriod)
        {
            throw new IllegalArgumentException("commitmentPeriod must by <= 24");
        }
        this.commitmentPeriod = commitmentPeriod;
    }

    public InternetService getInternetService() {
        return internetService;
    }

    public void setInternetService(InternetService internetService) {
        this.internetService = internetService;
    }

    public ArrayList<EquipmentModemWiFi> getEquipmentModemWiFi(){
        return this.equipmentModemWiFi;
    }

    public void addEquipmentModemWiFi(EquipmentModemWiFi equipmentModemWiFi){
        this.equipmentModemWiFi.add(equipmentModemWiFi);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        if(descript == null){
            return "brak opisu.";
        }
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public void setDescript(String descript, String author) {
        this.descript = descript + " created by " + author;
    } // przeciazenie metody

    public LocalDate getOfferCreationDate() {
        return offerCreationDate;
    }

    public void setOfferCreationDate(LocalDate offerCreationDate) {

        this.offerCreationDate = offerCreationDate;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Nazwa oferty: " + getName() + ", ");
        result.append("Opis:  " + getDescript() + ", ");
        result.append("Data utworzenia "+ getOfferCreationDate() + ", ");
        result.append("Data konca ofert: " + getOfferAvailabilityEndDate() + ", ");
        result.append("Długosc zobowiązania: " + getCommitmentPeriod() + ", ");

        if(getInternetService() != null){
            result.append("Usluga: " + getInternetService().toString());
        }
        if(getEquipmentModemWiFi() != null){
            result.append(" Sprzet: " + getEquipmentModemWiFi().toString());
        }
        return result.toString();
    }

    public Offer(String name, String descript, LocalDate offerCreationDate, int commitmentPeriod) {
        setName(name);
        setDescript(descript);
        setOfferCreationDate(offerCreationDate);
        offerAvailabilityEndDate = offerCreationDate.plusYears(1);
        setCommitmentPeriod(commitmentPeriod);
        this.equipmentModemWiFi = new ArrayList<>();
    }

    public Offer(String name, String descript, LocalDate offerCreationDate, int commitmentPeriod,
                 InternetService internetService) {
        setName(name);
        setDescript(descript);
        setOfferCreationDate(offerCreationDate);
        offerAvailabilityEndDate = offerCreationDate.plusYears(1);
        setCommitmentPeriod(commitmentPeriod);
        setInternetService(internetService);
        this.equipmentModemWiFi = new ArrayList<>();
    }

    public Offer(String name, String descript, String author, LocalDate offerCreationDate, int commitmentPeriod,
                 InternetService internetService) {
        setName(name);
        setDescript(descript, author);
        setOfferCreationDate(offerCreationDate);
        offerAvailabilityEndDate = offerCreationDate.plusYears(1);
        setCommitmentPeriod(commitmentPeriod);
        setInternetService(internetService);
        this.equipmentModemWiFi = new ArrayList<>();
    }

    //metody klasowe
    public static double getMinCommitmentPeriod(){
        return minCommitmentPeriod;
    }
    public static double getMaxCommitmentPeriod(){
        return maxCommitmentPeriod;
    }
}
