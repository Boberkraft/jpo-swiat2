package ja.organizmy;

import ja.Ekran;
import ja.Organizm;

import java.util.Vector;

public abstract class Zwierze extends Organizm {
    protected boolean podwojnyRuch;

    public Zwierze() {
        znak = "ZZ";
        podwojnyRuch = false;
    }

    public void akcja() {
        swiat.idz(this, pozycja.obok(1));
        if (podwojnyRuch) {
            podwojnyRuch = false;
            akcja();
        }
    }

    public void kolizja(Organizm wchodzacy) {
        kolizja((Zwierze) wchodzacy);
    }

    public void kolizja(Zwierze wchodzacy) {
        if (znak == wchodzacy.getZnak()) {
            swiat.rozmnorz(this, wchodzacy);
        } else {
            Vector<String> komunikat = new Vector<>();

            if (wchodzacy.jakaSila() >= jakaSila()) {
                komunikat.add(wchodzacy.getZnak());
                komunikat.add("\uD83D\uDD2A");
                komunikat.add(getZnak());
                swiat.zabij(this);
                swiat.idz(wchodzacy, getPozycja());
            } else {
                komunikat.add(getZnak());
                komunikat.add("\uD83D\uDEE1 ");
                komunikat.add(wchodzacy.getZnak());
                swiat.zabij(wchodzacy);
            }

            Ekran.wstawKomunikat(komunikat);

        }
    }

    public void dajBuffaPodwojnegoRuchu() {
        podwojnyRuch = true;
    }
}
