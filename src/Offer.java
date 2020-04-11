import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public  class Offer extends ObjectPlus implements Serializable{

    private static final long serialVersionUID = 007L;
    private String name;
    private String descript;
    private LocalDate offerCreationDate;
    private int commitmentPeriod; //atr prosty okres zob.
    private LocalDate offerAvailabilityEndDate; //atr. pochodny z dataUtworzenia
    private InternetService internetService; //atr. zlozony i opcjonalny
    private ArrayList<EquipmentModemWiFi> equipmentModemWiFi; //atr. powtarzalny i opcjonalny
    private static String targetGroup; //atr.klasowy

    public static String getTargetGroup() {
        return targetGroup; }

    public static void setTargetGroup(String targetGroup) {
        Offer.targetGroup = targetGroup;
    } //metoda klasowa

    public LocalDate getOfferAvailabilityEndDate() {
        return offerAvailabilityEndDate;
    }

    public int getCommitmentPeriod() {
        return commitmentPeriod;
    }

    public void setCommitmentPeriod(int commitmentPeriod) {
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

    public void removeEquipmentModemWiFi(EquipmentModemWiFi equipmentModemWiFi){
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
    } // przeciazenie metody

    public LocalDate getOfferCreationDate() {
        return offerCreationDate;
    }

    public void setOfferCreationDate(LocalDate offerCreationDate) {
        if(commitmentPeriod == 12) {
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
        setCommitmentPeriod(commitmentPeriod);
        this.equipmentModemWiFi = new ArrayList<>();
    }

    public Offer(String name, String descript, LocalDate offerCreationDate, int commitmentPeriod,
                 InternetService internetService) {
        setName(name);
        setDescript(descript);
        setOfferCreationDate(offerCreationDate);
        setCommitmentPeriod(commitmentPeriod);
        setInternetService(internetService);
        this.equipmentModemWiFi = new ArrayList<>();
    }

    public Offer(String name, String descript, String author, LocalDate offerCreationDate, int commitmentPeriod,
                 InternetService internetService) {
        setName(name);
        setDescript(descript, author);
        setOfferCreationDate(offerCreationDate);
        setCommitmentPeriod(commitmentPeriod);
        setInternetService(internetService);
        this.equipmentModemWiFi = new ArrayList<>();
    }
}
