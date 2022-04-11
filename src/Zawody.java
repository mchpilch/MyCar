public class Zawody {
    //atrybuty zawodow
    private String nazwa;
    private String data;

    //gettery i settery atrybutow zawodow
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    //metody zawodow
    public boolean rozegrajZawody(){
        return true;
    }
}
