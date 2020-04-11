

import java.io.*;
import java.time.LocalDate;

public class Main {
    /*
Ekstensja
 Ekst. - trwałość +
 Atr. złożony +
 Atr. opcjonalny +
 Atr. powt. +
 Atr. klasowy +
 Atr. pochodny +
 Met. klasowa +
 Przesłonięcie, przeciążenie + 
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

        Oferta oferta3 = new Oferta("Oferta wyjatkowa", "To jest miejsce na opis","Patryk Tomaszewski", date,
                24, uslugaInternet); //przeciazony opis.

        //Atrybut klasowy
        Oferta.setGrupaDocelowa("Firma");
        System.out.println("Atrybut klasowy: " + Oferta.getGrupaDocelowa());

        //Atrybut prosty
        System.out.println("Atrybut prosty: " + oferta.getNazwa());

        //Atrybut pochodny
        System.out.println("Atrybut pochodny: " + oferta.getDataKoncaDostepnosciOferty());

       // Atrybut zlozony
        oferta2.addSprzetModemwiFi(sprzetModemWiFi1);
        System.out.println("Atrybut zlozony: " + oferta2.getSprzetModemWiFi().toString());
        oferta3.addSprzetModemwiFi(sprzetModemWiFi);
        //Atrybut opcjonalny
        System.out.println("Atrybut opcjonalny:");
        System.out.println("oferta  " + oferta.getNazwa() + " nie ma uslugi w zestawie " + oferta.getUslugaInternet());
        System.out.println("oferta  " + oferta2.getNazwa() + " Pełna opcja uslugi i sprzet " + oferta2.getUslugaInternet().toString() + " " + oferta2.getSprzetModemWiFi().toString());
        //Przeciazenie metody dla opisu.
        System.out.println("oferta" + oferta3.getNazwa() + oferta3.getOpis());
        //Atrybut powtarzalny
        System.out.print("Atrybut powtarzalny, ");
        oferta.addSprzetModemwiFi(sprzetModemWiFi);
        oferta.addSprzetModemwiFi(sprzetModemWiFi1);
        System.out.println("Sprzet w ofercie " + oferta.getNazwa() + ":");
        for(SprzetModemWiFi s : oferta.getSprzetModemWiFi()){
            System.out.println(s.toString()); //przeslonieta metoda toString()
        }

        ObjectPlus.pokazEkstensje(Oferta.class);
        ObjectPlus.pokazEkstensje(SprzetModemWiFi.class);
        ObjectPlus.pokazEkstensje(UslugaInternet.class);

        try
        {
            //zapis z dysku do pliku "DaneOfertSprzetuUslug"
            FileOutputStream fileOutput = new FileOutputStream("DaneOfertSprzetuUslug");
            ObjectOutputStream StreamOutput = new ObjectOutputStream(fileOutput);
            ObjectPlus.zapiszEkstensje(StreamOutput);
            StreamOutput.close();
            fileOutput.close();
        }
        catch(IOException i) {
            i.printStackTrace();
        }


    }

}
