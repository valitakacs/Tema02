package ro.Emanuel.Tema02.pojo;

public class Client {
    private int id;
    private String nume;
    private String cnp;
    private String adresa;
    private String telefon;
    private int varsta;

    public Client(int id, String nume, String cnp, String adresa, String telefon, int varsta) {
        this.id = id;
        this.nume = nume;
        this.cnp = cnp;
        this.adresa = adresa;
        this.telefon = telefon;
        this.varsta = varsta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
