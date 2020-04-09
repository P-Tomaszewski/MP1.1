

import java.io.*;
import java.time.LocalDate;

public class Main {

    /*
Ekstensja
 Ekst. - trwałość
 Atr. złożony
 Atr. opcjonalny
 Atr. powt.
 Atr. klasowy
 Atr. pochodny
 Met. klasowa
 Przesłonięcie, przeciążenie
    */
    public static void main(String[] args) throws Exception {

        if(new File("DaneOfertSprzetuUslug").isFile())
        {
            try
            {
                //miejsce docelowe pliku w workspace
                FileInputStream fileInput = new FileInputStream("DaneOfertSprzetuUslug");
                ObjectInputStream streamInput = new ObjectInputStream(fileInput);
                //odczyt z dysku do pliku "daneFirmowe"
                ObjectPlus.odczytajEkstensje(streamInput);
                streamInput.close();
                fileInput.close();
            }
            catch(IOException i){
                i.printStackTrace();
                return;
            }
            catch(ClassNotFoundException c){
                System.out.println("Nie znaleziono klasy.");
                c.printStackTrace();
                return;
            }
        }


        LocalDate date = LocalDate.now();
        SprzetModemWiFi sprzetModemWiFi = new SprzetModemWiFi("AsusXC190", "AWR12334",
                120, 80);
        SprzetModemWiFi sprzetModemWiFi1 = new SprzetModemWiFi("AsusXC170", "AWT33321",
                200, 100);
        UslugaInternet uslugaInternet = new UslugaInternet("10", 20);
        UslugaInternet uslugaInternet1 = new UslugaInternet("20", 25);
        Oferta oferta = new Oferta("Oferta Noworoczna", "Oferta na nowy rok", date,
                12);
        Oferta oferta2 = new Oferta("Oferta zwykła", "Oferta klasyczna", date,
                24, uslugaInternet);
        System.out.println("Ekstensja klasy Sprzet: ");
        SprzetModemWiFi.printSprzetModemWiFi();
        System.out.println();

        System.out.println("Ekstensja klasy Usluga: ");
        UslugaInternet.printUslugaInternet();
        System.out.println();

        System.out.println("Ekstensja klasy Oferta:");
        Oferta.printOferty(null);
        System.out.println();

        //Atrybut klasowy
        Oferta.setGrupaDocelowa("Firma");
        System.out.println("Atrybut klasowy: " + Oferta.getGrupaDocelowa());

        //Atrybut prosty
        System.out.println("Atrybut prosty: " + oferta.getName());

        //Atrybut pochodny
        System.out.println("Atrybut pochodny: " + oferta.getDataKoncaDostepnosciOferty());

       // Atrybut zlozony
        oferta2.addSprzetModemwiFi(sprzetModemWiFi1);
        System.out.println("Atrybut z�o�ony: " + oferta2.getSprzetModemWiFi().toString());

        //Atrybut opcjonalny
        System.out.println("Atrybut opcjonalny:");
        System.out.println("oferta  " + oferta.getName() + " nie ma uslugi w zestawie " + oferta.getUslugaInternet());
        System.out.println("oferta  " + oferta2.getName() + " Pełna opcja uslugi i sprzet " + oferta2.getUslugaInternet().toString() + " " + oferta2.getSprzetModemWiFi().toString());

        //Atrybut powtarzalny
        System.out.println("Atrybut powtarzalny:");
        oferta.addSprzetModemwiFi(sprzetModemWiFi);
        oferta.addSprzetModemwiFi(sprzetModemWiFi1);
        System.out.println("Sprzet w ofercie " + oferta.getName() + ":");
        for(SprzetModemWiFi s : oferta.getSprzetModemWiFi()){
            System.out.println(s.toString()); //przeslonieta metoda toString()
        }

        ObjectPlus.pokazEkstensje(Oferta.class);

        try
        {
            //miejsce docelowe pliku w workspace
            //zapis z dysku do pliku "daneFirmowe"
            FileOutputStream fileOutput = new FileOutputStream("DaneOfertSprzetuUslug");
            ObjectOutputStream StreamOutput = new ObjectOutputStream(fileOutput);
            ObjectPlus.zapiszEkstensje(StreamOutput);
            StreamOutput.close();
            fileOutput.close();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }

        System.out.println("Ekstensja klasy Oferta po dodaniu sprzetu:");
        Oferta.printOferty(null);
        System.out.println();


    }

}
