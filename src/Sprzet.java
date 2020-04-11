public abstract class Sprzet extends ObjectPlus {
    private static final long serialVersionUID = 0172L;
    String model;
    String nrSeryjny;


    public Sprzet(String model, String nrSeryjny) {
        this.model = model;
        this.nrSeryjny = nrSeryjny;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrSeryjny() {
        return nrSeryjny;
    }

    public void setNrSeryjny(String nrSeryjny) {
        this.nrSeryjny = nrSeryjny;
    }


}
