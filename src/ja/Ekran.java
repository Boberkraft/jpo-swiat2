package ja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import ja.ekran.BloczekOrganizmu;
import ja.ekran.MiejsceZwierzat;

public class Ekran extends JFrame implements ActionListener {
    static Ekran instancja;

    public static void initialize(Swiat swiat) {
        instancja = new Ekran(swiat);
    }

    public static void wyczysc() {
        for (int i = 0; i < Swiat.ROZMIAR; i++) {
            for (int j = 0; j < Swiat.ROZMIAR; j++) {
                instancja.miejsceZwierzat.getBloczek(i, j).setText(" ");
            }
        }

    }

    public static void wstawZnak(String znak, Pozycja pozycja) {
        instancja.miejsceZwierzat.getBloczek(pozycja.rzad, pozycja.kolumna).setText(znak);
    }

    public static void wyswietlKomunikaty() {
        Collections.reverse(instancja.komunikatyBuffer);
        instancja.komunikatyMiejsce.setText(String.join("\n", instancja.komunikatyBuffer));
        instancja.komunikatyBuffer.clear();

    }

    public static void wstawTure(int tura) {
        instancja.turaLabel.setText("Aktualna tura: " + tura);
    }

    public static void wstawKomunikat(Vector<String> komunikat) {
        instancja.komunikatyBuffer.add(String.join(" ", komunikat));
    }

    Swiat swiat;
    MiejsceZwierzat miejsceZwierzat;
    JLabel turaLabel;
    JTextArea komunikatyMiejsce;
    Vector<String> komunikatyBuffer;

    Container contentPanel;

    public Ekran(Swiat swiat) {
        this.swiat = swiat;
        this.komunikatyBuffer = new Vector<>();
        this.contentPanel = getContentPane();

        setTitle("Andrzej Bisewski 182619");

        GridLayout gridLayout = new GridLayout(1, 2);
        contentPanel.setLayout(gridLayout);
        setVisible(true);
        setLocationRelativeTo(null);
        initMiejsceZwierzat();
        initPrzyciski();
        pack();
        setSize(1920, 1080);

    }

    private void initMiejsceZwierzat() {
        miejsceZwierzat = new MiejsceZwierzat();
        contentPanel.add(miejsceZwierzat);
    }

    private void initPrzyciski() {
        komunikatyMiejsce = new JTextArea(15, 1);
        komunikatyMiejsce.setEditable(false);
        JScrollPane scroll = new JScrollPane(komunikatyMiejsce);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("tw-emoji2.ttf"));
            komunikatyMiejsce.setFont(font.deriveFont(Font.PLAIN, 32));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        turaLabel = new JLabel();
        turaLabel.setText("Aktualna tura: 1");

        JButton nastepnaTura = new JButton();
        nastepnaTura.setText("Następna tura");
        nastepnaTura.addActionListener(this);

        JPanel prawyPanel = new JPanel();
        prawyPanel.setPreferredSize(new Dimension(100, 100));
        prawyPanel.setLayout(new BoxLayout(prawyPanel, BoxLayout.Y_AXIS));
        prawyPanel.add(nastepnaTura);
        prawyPanel.add(turaLabel);
        prawyPanel.add(scroll);
        prawyPanel.setVisible(true);
        contentPanel.add(prawyPanel);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            swiat.wykonajTure();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        swiat.rysujSwiat();
    }
}
