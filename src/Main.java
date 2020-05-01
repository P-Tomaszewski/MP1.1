

import java.io.*;
import java.time.LocalDate;

public class Main {
    /*
Ekstensja
 Ekst. - trwałość +
 Atr. złożony +
 Atr. opcjonalny musi zwracac null i wyswielac cos  +
 Atr. powt. nie moze byc polaczony z klasa +
 Atr. klasowy +
 Atr. pochodny nie moze byc setera +
 Met. klasowa +
 Przesłonięcie, przeciążenie + 
    */
    public static void main(String[] args) throws Exception {

        if (new File("DaneOfertSprzetuUslug").isFile()) {
            try {
                FileInputStream fileInput = new FileInputStream("DaneOfertSprzetuUslug");
                ObjectInputStream streamInput = new ObjectInputStream(fileInput);
                //odczyt z "daneFirmowe"
                ObjectPlus.readEkstansja(streamInput);
                streamInput.close();
                fileInput.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Nie znaleziono klasy.");
                c.printStackTrace();
                return;
            }
        }

        LocalDate date = LocalDate.now();

        EquipmentModemWiFi equipmentModemWiFi = new EquipmentModemWiFi("AsusXC190", "AWR12334",
                120, 80);
        EquipmentModemWiFi equipmentModemWiFi1 = new EquipmentModemWiFi("AsusXC170", "AWT33321",
                200, 100);
        InternetService internetService = new InternetService("10", 20);
        InternetService internetService1 = new InternetService("20", 25);
        Offer offer = new Offer("Oferta Noworoczna", "Oferta na nowy rok", date,
                12);
        Offer offer2 = new Offer("Oferta zwykła", null, date,
                24, internetService);

        Offer offer3 = new Offer("Oferta wyjatkowa", "To jest miejsce na opis", "Patryk Tomaszewski", date,
                24, internetService); //przeciazony opis.


        //Atrybut prosty
        System.out.println("Atrybut prosty: " + offer.getName());

        //Atrybut pochodny
        System.out.println("Atrybut pochodny: " + offer.getOfferAvailabilityEndDate());

        // Atrybut zlozony
        offer2.addEquipmentModemWiFi(equipmentModemWiFi1);
        System.out.println("Atrybut zlozony: " + offer2.getEquipmentModemWiFi().toString());
        offer3.addEquipmentModemWiFi(equipmentModemWiFi);
        //Atrybut opcjonalny
       System.out.println("Atrybut opcjonalny: " + offer2.getDescript());
        //Przeciazenie metody dla opisu.
        System.out.println("oferta" + offer3.getName() + offer3.getDescript());
        //Atrybut powtarzalny
        System.out.print("Atrybut powtarzalny, ");
        offer.addEquipmentModemWiFi(equipmentModemWiFi);
        offer.addEquipmentModemWiFi(equipmentModemWiFi1);
        System.out.println("Sprzet w ofercie " + offer.getName() + ":");
        for (EquipmentModemWiFi s : offer.getEquipmentModemWiFi()) {
            System.out.println(s.toString()); //przeslonieta metoda toString()
        }

        ObjectPlus.showEkstansja(Offer.class);
        ObjectPlus.showEkstansja(EquipmentModemWiFi.class);
        ObjectPlus.showEkstansja(InternetService.class);

        try {
            // do pliku "DaneOfertSprzetuUslug"
            FileOutputStream fileOutput = new FileOutputStream("DaneOfertSprzetuUslug");
            ObjectOutputStream StreamOutput = new ObjectOutputStream(fileOutput);
            ObjectPlus.saveEkstansja(StreamOutput);
            StreamOutput.close();
            fileOutput.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
