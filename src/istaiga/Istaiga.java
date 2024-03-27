package istaiga;

public class Istaiga {

    //id, pavadinimas, kodas, adresas

    private int id;
    private String pavadinimas;
    private int kodas;
    private String adresas;

    public Istaiga() {
    }

    public Istaiga(int id, String pavadinimas, int kodas, String adresas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kodas = kodas;
        this.adresas = adresas;
    }

    public Istaiga(String pavadinimas, int kodas, String adresas) {
        this.pavadinimas = pavadinimas;
        this.kodas = kodas;
        this.adresas = adresas;
    }

    public int getId() {
        return id;
    }



    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public int getKodas() {
        return kodas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    @Override
    public String toString() {
        return "Istaiga{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kodas=" + kodas +
                ", adresas='" + adresas + '\'' +
                '}';
    }
}
