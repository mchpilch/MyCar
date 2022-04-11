public class SkrzyniaBiegow extends Komponent {

    //atrybuty Skrzyni Biegow
    private int aktualnyBieg = 1;
    private int iloscBiegow;
    private static double aktualnePrzelozenie;// = 1;

    private Sprzeglo sprzeglo;

    //Gettery i settery skrzyni biegow
    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public int getIloscBiegow() {
        return iloscBiegow;
    }

    public static double getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }

    public Sprzeglo getSprzeglo() {
        return this.sprzeglo;
    }

    //metody skrzyni biegow
    public int zwiekszBieg(){
        if(getSprzeglo().getStanSprzegla() == true) {
            if (aktualnyBieg < iloscBiegow) {
                aktualnyBieg += 1;
                aktualnePrzelozenie += 0.2;
            }
            return aktualnyBieg;
        }else{
            return aktualnyBieg;
        }
    }
    public int zmniejszBieg(){
        if(getSprzeglo().getStanSprzegla() == true) {
            if (aktualnyBieg > 0) {
                aktualnyBieg -= 1;
                aktualnePrzelozenie -= 0.2;
            }
            return aktualnyBieg;
        }else{
            return aktualnyBieg;
        }
    }

    public int getAktBieg(){
        return aktualnyBieg;
    }
    public double getAktPrzelozenie(){
        return aktualnePrzelozenie;
    }

    //konstruktor skrzyni biegow
    public SkrzyniaBiegow(String nazwa, double waga, double cena, int aktualnyBieg, int iloscBiegow, double aktualnePrzelozenie, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.aktualnePrzelozenie = aktualnePrzelozenie;
        this.sprzeglo = sprzeglo;
    }
}
