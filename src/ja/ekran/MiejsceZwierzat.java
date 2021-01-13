package ja.ekran;

import ja.Swiat;

import javax.swing.*;
import java.awt.*;

public class MiejsceZwierzat extends JPanel {
    private BloczekOrganizmu[][] bloczki;

    public MiejsceZwierzat() {
        GridLayout gridLayout = new GridLayout(Swiat.ROZMIAR, Swiat.ROZMIAR);
        setLayout(gridLayout);
        setVisible(true);
        setSize(800, 800);

        bloczki = new BloczekOrganizmu[Swiat.ROZMIAR][];
        for (int i = 0; i < Swiat.ROZMIAR; i++) {
            bloczki[i] = new BloczekOrganizmu[Swiat.ROZMIAR];
            for (int j = 0; j < Swiat.ROZMIAR; j++) {
                BloczekOrganizmu bloczekOrganizmu = new BloczekOrganizmu();
                bloczki[i][j] = bloczekOrganizmu;
                add(bloczekOrganizmu);
            }
        }
    }

    public BloczekOrganizmu getBloczek(int rzad, int kolumna) {
        return bloczki[rzad][kolumna];
    }
}
