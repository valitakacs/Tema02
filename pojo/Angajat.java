package ro.Emanuel.Tema02.pojo;

public class Angajat {
    private int id;
    private String nume;
    private String prenume;
    private String functie;
    private float salar;

    public Angajat() {

    }

    public Angajat(int id, String nume, String prenume, String functie, float salar) {
        super();
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
        this.salar = salar;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public float getSalar() {
        return salar;
    }

    public void setSalar(float salar) {
        this.salar = salar;
    }
}
