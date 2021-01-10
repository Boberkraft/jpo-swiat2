package ja.organizmy;

import ja.Ekran;
import ja.Organizm;

import java.util.Random;
import java.util.Vector;

public abstract class Roslina extends Organizm {
    public Roslina() {
        inicjatywa = 0;
        sila = 0;
        znak = "RR";
    }

    public void akcja() {
        Random rand = new Random();
        if (rand.nextInt(100) < 20) {
            swiat.rozmnorz(this);
        }
    }

    public void kolizja(Organizm wchodzacy) {
        Vector<String> komunikat = new Vector<>();
        komunikat.add(wchodzacy.getZnak());
        komunikat.add("\uD83C\uDF74");
        komunikat.add(getZnak());
        Ekran.wstawKomunikat(komunikat);
        swiat.zabij(this);
        swiat.idz(wchodzacy, getPozycja());
    }

}
