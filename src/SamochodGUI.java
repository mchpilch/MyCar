import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SamochodGUI extends Thread {
    private JPanel Samochod;
    private JPanel dane;
    private JPanel skrzynia_biegow;
    private JPanel silnik;
    private JPanel sprzeglo;
    private JPanel funkcjonalnosci;
    private JTextField TextFieldSamModel;
    private JTextField TextFieldSamNrRejestracyjny;
    private JButton wlaczButton;
    private JButton usunButton;
    private JButton dodajNowyButton;
    private JComboBox comboBox1;
    private JButton wylaczButton;
    private JButton zwiekszBiegButton;
    private JButton zmniejszBiegButton;
    private JButton dodajGazuButton;
    private JButton ujmijGazuButton;
    private JButton nacisnijButton;
    private JButton zwolnijButton;
    private JTextField TextFieldSamWaga;
    private JTextField TextFieldSamPredkosc;
    private JTextField TextFieldSbNazwa;
    private JTextField TextFieldSbCena;
    private JTextField TextFieldSbWaga;
    private JTextField TextFieldSbBieg;
    private JTextField TextFieldSiNazwa;
    private JTextField TextFieldSiCena;
    private JTextField TextFieldSiWaga;
    private JTextField TextFieldSiObroty;
    private JTextField TextFieldSpNazwa;
    private JTextField TextFieldSpCena;
    private JTextField TextFieldSpWaga;
    private JTextField TextFieldSpStan;
    private JLabel Obraz_auta;
    private JPanel Mapa;
    private Samochod samochod;

    @Override
    public void run() {
        super.run();
        while(true) {
            if(samochod != null) {
                //System.out.println("Samochod " + samochod.getModel() + " istnieje");
                refresh(samochod);
            }else{
                System.out.println("Samochod jest NULL'em -> dodaj pojazd");
            }try{
                    sleep(200);
                }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }


    public SamochodGUI() {
        wlaczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null) {
                    samochod.wlacz();
                    refresh(samochod);
                }
            }
        });
        wylaczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null) {
                    samochod.wylacz();
                    refresh(samochod);
                }
            }
        });
        zwiekszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null){
                    samochod.zwiekszBieg();
                     refresh(samochod);
                }
            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null) {
                    samochod.zmniejszBieg();
                    refresh(samochod);
                }
            }
        });
        dodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null) {
                    samochod.zwiekszObroty();
                    refresh(samochod);
                }
            }
        });
        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null) {
                    samochod.zmniejszObroty();
                    refresh(samochod);
                }
            }
        });
        nacisnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null) {
                    samochod.wcisnij();
                    refresh(samochod);
                }
            }
        });
        zwolnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null) {
                    refresh(samochod);
                    samochod.zwolnij();
                    refresh(samochod);
                }
            }
        });
        dodajNowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowySamochodGUI(comboBox1);
                f.pack();
                f.setVisible(true);
                refresh(samochod);
            }
        });
        Mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(samochod != null){
                super.mousePressed(e);
                    samochod.jedzDo(new Pozycja(e.getX(), e.getY()));
                    refresh(samochod);
                }
                refresh(samochod);
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexToRemove = comboBox1.getSelectedIndex();
                if(comboBox1.getItemCount() != 0){
                    System.out.println("Usunieto samochod: "+samochod.getMarka()+" "+samochod.getModel());
                    samochod.interrupt();
                    comboBox1.removeItemAt(indexToRemove);
                    refresh(samochod);
                }
                if(comboBox1.getItemCount() == 0){
                    Obraz_auta.setVisible(false);
                    TextFieldSamModel.setText("");
                    TextFieldSamNrRejestracyjny.setText("");
                    TextFieldSamWaga.setText("");
                    TextFieldSamPredkosc.setText("");
                    TextFieldSbNazwa.setText("");
                    TextFieldSbCena.setText("");
                    TextFieldSbWaga.setText("");
                    TextFieldSbBieg.setText("");
                    TextFieldSiNazwa.setText("");
                    TextFieldSiCena.setText("");
                    TextFieldSiWaga.setText("");
                    TextFieldSiObroty.setText("");
                    TextFieldSpNazwa.setText("");
                    TextFieldSpCena.setText("");
                    TextFieldSpWaga.setText("");
                    TextFieldSpStan.setText("");
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod = (Samochod) comboBox1.getSelectedItem();
                //Samochod samochod = (Samochod) comboBox1.getSelectedItem(); <- przez to męczyłem się 3h
                refresh(samochod);
            }
        });
        start();
    }

    private void refresh(Samochod samochod) {
        if(samochod != null) {

            Obraz_auta.setVisible(true);

            TextFieldSamModel.setText(samochod.getModel());
            TextFieldSamNrRejestracyjny.setText(samochod.getNrRejest());
            TextFieldSamWaga.setText(String.valueOf(samochod.getWaga()));
            TextFieldSamPredkosc.setText(String.valueOf(100*samochod.getAktPredkosc()));

            TextFieldSbNazwa.setText(String.valueOf(samochod.getSkrzyniaBiegow().getIloscBiegow())+" biegowa");//TextFieldSbNazwa.setText(samochod.getSkrzyniaBiegow().getNazwa());
            TextFieldSbCena.setText(String.valueOf(samochod.getSkrzyniaBiegow().getCena()));
            TextFieldSbWaga.setText(String.valueOf(samochod.getSkrzyniaBiegow().getWaga()));
            TextFieldSbBieg.setText(String.valueOf(samochod.getSkrzyniaBiegow().getAktBieg()));

            TextFieldSiNazwa.setText(samochod.getSilnik().getRodzaj());//
            TextFieldSiCena.setText(String.valueOf(samochod.getSilnik().getCena()));
            TextFieldSiWaga.setText(String.valueOf(samochod.getSilnik().getWaga()));
            TextFieldSiObroty.setText(String.valueOf((samochod.getSilnik().getObroty()))) ;

            TextFieldSpNazwa.setText(samochod.getSkrzyniaBiegow().getSprzeglo().getNazwa());
            TextFieldSpCena.setText(String.valueOf(samochod.getSkrzyniaBiegow().getSprzeglo().getCena()));
            TextFieldSpWaga.setText(String.valueOf(samochod.getSkrzyniaBiegow().getSprzeglo().getWaga()));
            TextFieldSpStan.setText(String.valueOf(samochod.getSkrzyniaBiegow().getSprzeglo().getStanSprzegla()));

            Obraz_auta.setLocation((int) samochod.getAktPozycja().getX(), (int) samochod.getAktPozycja().getY());
            Obraz_auta.setLocation((int) samochod.getAktPozycja().getX(), (int) samochod.getAktPozycja().getY());
        }

    }

    public static void main(String[] args) {

//        Silnik boxter = new Silnik("boxter", 350,15000,6000,0, "benzyna");
//        Sprzeglo spPorshe = new Sprzeglo("spPorshe",5,3000, false);
//        SkrzyniaBiegow automaticPorshe = new SkrzyniaBiegow("automaticPorshe",35,5000,0,7,1,spPorshe);
//        Pozycja pozycjaZeroPorshe = new Pozycja(25,25);
//        Samochod wysigowka = new Samochod(false,"KR12345","911GT",330,boxter,automaticPorshe,850,pozycjaZeroPorshe);

        JFrame frame = new JFrame("SamochodGUI");
        frame.setPreferredSize(new Dimension(1600, 800));
        frame.setContentPane(new SamochodGUI().Samochod);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
