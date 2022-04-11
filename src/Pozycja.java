public class Pozycja {
    //atrybuty pozycji (koordynaty)
    private double x;
    private double y;

    public static final double dT = (200);

    //getter i setter kordów
    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //konstruktor pozycji
    Pozycja(double x,double y){
        this.x = x;
        this.y = y;
    }



    //metody klasy Pozycja
    public void przemiesc(double V, double dT,Pozycja cel){ //zwraca nowa pozycje
            double dX = V * dT * (cel.x - this.x)/Math.sqrt(Math.pow((cel.x - this.x), 2) + Math.pow((cel.y - this.y), 2));
            double dY = V * dT * (cel.y - this.y)/Math.sqrt(Math.pow((cel.x - this.x), 2) + Math.pow((cel.y - this.y), 2));
            //System.out.println("dX=" + dX + "\t" + "dY= "+ dY);
                if (Math.abs(dX) < Math.abs(cel.x - this.x)) {
                    this.x = this.x + dX;
                }else{
                    this.x = cel.x;}

                if (Math.abs(dY) < Math.abs(cel.y - this.y)){
                    this.y = this.y + dY;}
                else{
                    this.y = cel.y;}
        }

}
