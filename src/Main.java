import sun.util.resources.LocaleData;

import java.io.*;
import java.time.LocalDate;

public class Main {

    /*
    PREZ4
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
    public static void main(String[] args) {

        SprzetModemWiFi sprzetModemWiFi = new SprzetModemWiFi("AsusXC190", "AWR12334",
                120, 80);
        SprzetModemWiFi sprzetModemWiFi1 = new SprzetModemWiFi("AsusXC170", "AWT33321",
                200, 100);

        UslugaInternet uslugaInternet = new UslugaInternet("10", 20);
        UslugaInternet uslugaInternet1 = new UslugaInternet("20", 25);

        LocalDate date = LocalDate.now();

        Oferta oferta = new Oferta("Oferta Noworoczna", "Oferta na nowy rok", date,12, sprzetModemWiFi);


        //Wy�wietlanie ekstensji koni - metoda bez parametru
        System.out.println("Ekstensja klasy Horse:");
      //  Oferta.printOferty(null);
        System.out.println();

        //Atrybut klasowy
//        Oferta.setStableName("The Horse Kingdom");
//        System.out.println("Atrybut klasowy: " + Horse.getStableName());

        //Atrybut prosty
        System.out.println("Atrybut prosty: " + oferta.getName());

        //Atrybut pochodny
        System.out.println("Atrybut pochodny: " + oferta.getDataKoncaDostepnosciOferty());

        //Atrybut z�o�ony
//        horse2.setDefaultRider(rider3);
//        System.out.println("Atrybut z�o�ony: " + horse2.getDefaultRider().toString());

        //Atrybut opcjonalny
//        System.out.println("Atrybut opcjonalny:");
//        System.out.println("Ko� " + horse1.getName() + " nie ma obje�d�aj�cego: " + horse1.getDefaultRider());
//        System.out.println("Ko� " + horse3.getName() + " ma obje�d�aj�cego: " + horse3.getDefaultRider().toString());

        //Atrybut powtarzalny
//        System.out.println("Atrybut powtarzalny:");
//        horse3.addDescendant(horse1);
//        horse3.addDescendant(horse2);
//        System.out.println("Potomkowie konia " + horse3.getName() + ":");
//        for(Horse h : horse3.getDescendants()){
//            System.out.println(h.toString()); //Przes�oni�ta metoda toString()
//        }



        try{
            //Zapisywanie do pliku
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("BackupFile")));
            Oferta.saveOferta(out);
            SprzetModemWiFi.saveSprzetModemWiFis(out);
            UslugaInternet.saveUslugaInternet(out);
            out.close();
            System.out.println("Ekstensje klas Rider i Horse zapisane do pliku.");

            //Odczytywanie z pliku
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("BackupFile")));
            Oferta.readOferta(in);
            UslugaInternet.readUslugaInternet(in);
            in.close();
            System.out.println(oferta);
            System.out.println("Ekstensje klas Rider i Horse wczytane z pliku.");
        } catch (FileNotFoundException ex){
            System.out.println("Plik nie zosta� odnaleziony.");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
