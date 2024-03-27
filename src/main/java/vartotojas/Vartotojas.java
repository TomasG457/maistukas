package vartotojas;

public class Vartotojas {
    private int vartotojoId;
    private String vardas;
    private String elPastoAdresas;
    private int role;
    private String slaptazodis;

    public Vartotojas() {
    }

    public Vartotojas(int vartotojoId, String vardas, String elPastoAdresas, int role, String slaptazodis) {
        this.vartotojoId = vartotojoId;
        this.vardas = vardas;
        this.elPastoAdresas = elPastoAdresas;
        this.role = role;
        this.slaptazodis = slaptazodis;
    }

    public Vartotojas(String vardas, String elPastoAdresas, int role, String slaptazodis) {
        this.vardas = vardas;
        this.elPastoAdresas = elPastoAdresas;
        this.role = role;
        this.slaptazodis = slaptazodis;
    }

    public int getVartotojoId() {
        return vartotojoId;
    }


    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }
    public String getElPastoAdresas() {
        return elPastoAdresas;
    }

    public void setElPastoAdresas(String elPastoAdresas) {
        this.elPastoAdresas = elPastoAdresas;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    @Override
    public String toString() {
        return "Vartotojas: " +
                "vartotojoId: " + vartotojoId +
                ", vardas: '" + vardas + '\'' +
                ", el. paštas:' " + elPastoAdresas + '\'' +
                ", rolė: " + role +
                ", slaptažodis: '" + slaptazodis + '\'';
    }
}
