public class Sprzeglo extends Komponent {
    //atrybut Sprzegla
    private boolean stanSprzegla;

    //getter i setter stanu sprzegla
    public boolean getStanSprzegla() {
        return stanSprzegla;
    }

    //metody sprzegla
    public void wcisnij(){
        stanSprzegla = true;
    }
    public void zwolnij(){
        stanSprzegla = false;
    }

        public Sprzeglo(String nazwa, double waga, double cena, boolean stanSprzegla) {
            super(nazwa, waga, cena);
            this.stanSprzegla = stanSprzegla;
    }
}
