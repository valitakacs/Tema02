package ro.Emanuel.Tema02.pojo;

public class Banca {
    private int id;
    private String nume;
    private String adresa;
    private String telefon;
    private String an_infiintare;
    private String capital;

    public Banca(){

    }

    public Banca(int id, String nume, String adresa, String telefon, String an_infiintare, String capital) {
        super();
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.an_infiintare = an_infiintare;
        this.capital = capital;
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

    public String getAnInfiintare() {
        return an_infiintare;
    }

    public void setAnInfiintare(String an_infiintare) {
        this.an_infiintare = an_infiintare;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
