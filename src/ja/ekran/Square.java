package ja.ekran;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Square extends JLabel {
    public Square() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        var x = new Random();

        if (x.nextInt(2) == 1) {
            setText("\uD83D\uDC15");
        } else {
            setText("\uD83D\uDC38");
        }


        //        setText("X");
        Font font = null;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("tw-emoji2.ttf"));
        } catch (
                FontFormatException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        setFont(font.deriveFont(Font.PLAIN, 32));
    }

}
