import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NowySamochodGUI extends JFrame {
    private JPanel secGUI;
    private JButton dodajButton;
    private JButton anulujButton;
    private JTextField textField1nrRej;
    private JTextField textField2model;
    private JTextField textField3marka;
    private JTextField textField4predkoscMax;
    private JRadioButton a5BiegowManualnaRadioButton;
    private JRadioButton a6BiegowManualnaRadioButton;
    private JRadioButton benzynaRadioButton;
    private JRadioButton dieselRadioButton;

    public NowySamochodGUI(JComboBox comboBox1) {
        setContentPane(secGUI);
        secGUI.setPreferredSize(new Dimension(400, 200));

        ButtonGroup groupBiegi = new ButtonGroup(); //dzieki temu tylko jeden moze byc oznaczony
        groupBiegi.add(a5BiegowManualnaRadioButton);
        groupBiegi.add(a6BiegowManualnaRadioButton);

        ButtonGroup groupPaliwo = new ButtonGroup();
        groupPaliwo.add(benzynaRadioButton);
        groupPaliwo.add(dieselRadioButton);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(textField1nrRej.getText().length() != 0 && textField2model.getText().length() != 0 && textField3marka.getText().length() != 0 && textField4predkoscMax.getText().length() != 0) {
                        int limitBiegu = 0;
                        String rodzajPaliwa = "";

                        if (a5BiegowManualnaRadioButton.isSelected()) {
                            limitBiegu = 5;
                        } else if (a6BiegowManualnaRadioButton.isSelected()) {
                            limitBiegu = 6;
                        }
                        ;
                        if (benzynaRadioButton.isSelected()) {
                            rodzajPaliwa = "benzyna";
                        } else if (dieselRadioButton.isSelected()) {
                            rodzajPaliwa = "diesel";
                        }
                        Silnik nowySilnik = new Silnik("nowySilnik od " + textField2model.getText(), 300, 20000, 5000, 0, rodzajPaliwa);
                        Sprzeglo noweSprzeglo = new Sprzeglo("noweSprzeglo od " + textField2model.getText(), 3, 5000, false);
                        SkrzyniaBiegow nowaSkrzyniaBiegow = new SkrzyniaBiegow("nowaSkrzBieg od " + textField2model.getText(), 45, 9000, 0, limitBiegu, 1, noweSprzeglo);
                        Pozycja nowaPozycjaStartowa = new Pozycja(5, 5);
                        //if(textField4predkoscMax)
                        Samochod nowySamochod = new Samochod(false, textField1nrRej.getText(), textField2model.getText(), textField3marka.getText(), Double.parseDouble(textField4predkoscMax.getText()), nowySilnik, nowaSkrzyniaBiegow, 850, nowaPozycjaStartowa);
                        comboBox1.addItem(nowySamochod);
                        System.out.println("Dodano nowy samochod: " + nowySamochod.getMarka() + " " + nowySamochod.getModel());
                    }
            }
        });

        textField4predkoscMax.addKeyListener(new KeyAdapter() { //zabezpieczenie gdyby ktos zamiast predkosci chcial wpisac literki
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))){
                        getToolkit().beep();
                        e.consume(); //it will not be typed
                }
            }
        });
    }




//    public static void main(String[] args) {
//        JFrame frame = new JFrame("NowySamochodGUI");
//        frame.setContentPane(new NowySamochodGUI().secGUI);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
