public abstract class Komponent {
    //atrybuty komponentu
    private final String nazwa;
    private final double waga;
    private final double cena;

    //gettery  atrybutów komponentu
    public String getNazwa() {
        return nazwa;
    }

    public Double getWaga() {
        return waga;
    }

    public Double getCena() {
        return cena;
    }

    //konstruktor komponentu
    public Komponent(String nazwa, double waga, double cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }
}
