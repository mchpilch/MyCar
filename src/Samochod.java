public class Samochod extends Thread{
    //atrybuty samochodu
    private boolean stanWlaczenia;
    private final String nrRejest;
    private final String model;
    private final String marka;
    private final double predkoscMax;
    public final static double rozmiarFelgi = (0.38);
    private final double wagaKaroseria;
    private final double przeskalowanie;

    private final  Silnik silnik; //jak tu bylo private static to wszystkie samochody dostawaly komponenty od ostatniego utworzonego samochodu
    private final  SkrzyniaBiegow skrzyniaBiegow;

    public Pozycja aktPozycja;
    private Pozycja cel;

    //gettery i settery atrybutow samochodu

    public String getNrRejest() {
        return nrRejest;
    }

    public String getModel() {
        return model;
    }
    public String getMarka() {
        return marka;
    }

    public Silnik getSilnik() {
        return this.silnik;
    }

    public SkrzyniaBiegow getSkrzyniaBiegow() {
        return this.skrzyniaBiegow;
    }

    public Pozycja getAktPozycja() {
        return aktPozycja;
    }

    //metody (klasy samochod) "samochodu"
    public void wlacz(){
        stanWlaczenia = true;
        getSilnik().uruchom();
    }
    public void wylacz(){
        stanWlaczenia = false;
        getSilnik().zatrzymaj();
    }

    public void wcisnij() { this.getSkrzyniaBiegow().getSprzeglo().wcisnij();    }
    public void zwolnij() {   this.getSkrzyniaBiegow().getSprzeglo().zwolnij();    }
    public void zmniejszBieg() {
        this.skrzyniaBiegow.zmniejszBieg();
    }
    public void zwiekszBieg() {
        this.skrzyniaBiegow.zwiekszBieg();
    }
    public void zwiekszObroty() {
        this.silnik.zwiekszObroty();
    }
    public void zmniejszObroty() {
        this.silnik.zmniejszObroty();
    }


    public void jedzDo (Pozycja cel){    //Kompozycję uzyskujemy poprzez definiowanie w nowej klasie pól, które są obiektami istniejących klas.
        this.cel = cel; //ustawiam cel podrozy
    }


    public double getWaga(){
        return  (silnik.getWaga()+ skrzyniaBiegow.getWaga()+ skrzyniaBiegow.getSprzeglo().getWaga() + wagaKaroseria);
    }

    public double getAktPredkosc(){
        //System.out.println("aktObroty: " + this.silnik.getObroty() + " aktPrzelozenie: " + this.skrzyniaBiegow.getAktPrzelozenie());
        double V = this.silnik.getObroty()*this.skrzyniaBiegow.getAktPrzelozenie()*(3.14*this.rozmiarFelgi)/przeskalowanie;
        if(100*V < predkoscMax){
            return V;
        }else{
            return predkoscMax/100;
        }
    }

    @Override
    public String toString() {
        return nrRejest + ", " + marka + ", " + model + " " + getAktPredkosc();
    }

    //konstruktor samochodu
    public Samochod(boolean stanWlaczenia, String nrRejest, String model,String marka, double predkoscMax, Silnik silnik, SkrzyniaBiegow skrzyniaBiegow, double wagaWlasna,Pozycja aktPozycja){
        this.stanWlaczenia = stanWlaczenia;
        this.nrRejest = nrRejest;
        this.model = model;
        this.marka = marka;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzyniaBiegow = skrzyniaBiegow;
        this.wagaKaroseria = wagaWlasna;
        this.aktPozycja = aktPozycja;
        this.cel = aktPozycja;//taki trick
        this.start();

        this.przeskalowanie = 5000;
    }
    public void run(){
        while(true){
            aktPozycja.przemiesc(getAktPredkosc(), Pozycja.dT, cel);
            System.out.println("Model:  \t" + getModel()+ " \t "+ "Wspolrzedne: \t X: \t" + aktPozycja.getX() +"\t Y: \t" + aktPozycja.getY() +"\t Szybkość V: "+ getAktPredkosc()/*+" \t Silnik: "+ silnik.getNazwa()+"\t Skrzynia: "+getSkrzyniaBiegow().getNazwa()+"\t Sprzeglo: "+ skrzyniaBiegow.getSprzeglo().getNazwa()*/); //commandline//console
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                return;
            }

        }
    }
   public static void main(String[] args) {


//        Silnik smaluch = new Silnik("smaluch", 180,400,3500,2,"benzyna");
//        Sprzeglo sp126P = new Sprzeglo("sp126P",5,300, false);
//        SkrzyniaBiegow manualMaluch = new SkrzyniaBiegow("manualMaluch",50,250,1,5,2,sp126P);
//        Pozycja pozycjaZeroMaluch = new Pozycja(0,0);
//        Samochod maluch = new Samochod(true,"WA01944","126P","Fiat",200,smaluch,manualMaluch,225,pozycjaZeroMaluch);
//
//       Silnik boxter = new Silnik("boxter", 350,15000,6000,100,"benzyna");
//       Sprzeglo spPorshe = new Sprzeglo("spPorshe",5,3000, false);
//       SkrzyniaBiegow automaticPorshe = new SkrzyniaBiegow("automaticPorshe",35,5000,1,7,2,spPorshe);
//       Pozycja pozycjaZeroPorshe = new Pozycja(0,0);
//       //Samochod AUDI = new Samochod(true,"WWA2133","TT","AUDI",330,boxter,automaticPorshe,333,pozycjaZeroPorshe)
//       Samochod porshe = new Samochod(true,"KR12345","911GT","Porshe",200,boxter,automaticPorshe,850,pozycjaZeroPorshe);
//
//
//        Pozycja porsheCel = new Pozycja(50,40); //tworze cel podrozy
//        Pozycja maluchCel = new Pozycja(70,20); //tworze cel podrozy
//
//        porshe.jedzDo(porsheCel);//ustawiam cel podrozy
//        maluch.jedzDo(maluchCel);//ustawiam cel podrozy
    }
}
