public class Silnik extends Komponent{
    //atrybuty silnika
    private double maxObroty;
    private double obroty;// = 1;
    private String rodzaj;//Diesel lub Benzyna

    //gettery i settery atrybutów silnika
    public double getMaxObroty() {
        return maxObroty;
    }

    public void setMaxObroty(double maxObroty) {
        this.maxObroty = maxObroty;
    }

    public double getObroty() {
        return obroty;
    }

    public void setObroty(double obroty) {
        this.obroty = obroty;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    //metody "silnika"
    public void uruchom(){
        setObroty(750);
    }
    public void zatrzymaj(){
        setObroty(0);
    }
    public double zwiekszObroty(){
        if(obroty < maxObroty) {
            obroty += 250;
        }
        return obroty;
    }
    public double zmniejszObroty(){
        if(obroty >= 250) {
            obroty -= 250;
        }
        return  obroty;
    }

    //konstruktor silnika
    public Silnik(String nazwa, double waga, double cena, double maxObroty, double obroty ,String rodzaj) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
        this.rodzaj = rodzaj;
    }

}
