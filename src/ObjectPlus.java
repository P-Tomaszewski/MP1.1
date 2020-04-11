import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class ObjectPlus implements Serializable
{
    private static final long serialVersionUID = 0071L;

    private static Hashtable<Class<? extends ObjectPlus>, Vector<ObjectPlus>> ekstensje = new Hashtable<>();

    public ObjectPlus(){
        Vector<ObjectPlus> ekstensja = null;
        Class<? extends ObjectPlus> klasa = this.getClass();

        if(ekstensje.containsKey(klasa))
        {
            ekstensja = ekstensje.get(klasa);
        }
        else
        {
            ekstensja = new Vector<>();
            ekstensje.put(klasa, ekstensja);
        }
        ekstensja.add(this);
    }

    public static void saveEkstansja(ObjectOutputStream stream) throws IOException
    {
        stream.writeObject(ekstensje);
    }

    public static void readEkstansja(ObjectInputStream stream) throws IOException, ClassNotFoundException
    {
        ekstensje = (Hashtable) stream.readObject();
    }

    public static void showEkstansja(Class klasa) throws Exception
    {
        Vector ekstensja = null;

        if(ekstensje.containsKey(klasa))
        {
            ekstensja = ekstensje.get(klasa);
        }
        else
        {
            throw new Exception("Unknown class " + klasa);
        }

        System.out.println("Ekstensja klasy: " + klasa.getSimpleName());

        for(Object obiekt : ekstensja)
        {
            System.out.println(obiekt);
        }
    }
}