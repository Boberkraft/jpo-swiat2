package ja.ekran;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BloczekOrganizmu extends JLabel {
    public BloczekOrganizmu() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("tw-emoji2.ttf"));
            setFont(font.deriveFont(Font.PLAIN, 32));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }


    }
}
