package ja.organizmy.zwierzeta;

import ja.Ekran;
import ja.Organizm;
import ja.Pozycja;
import ja.organizmy.Zwierze;

import java.util.Vector;

public class Zaba extends Zwierze {

    public Zaba() {
        podwojnyRuch = false;
        sila = 0;
        inicjatywa = 2;
        znak = "\uD83D\uDC38";
    }

    public Organizm dziecko() {
        return new Zaba();
    }

    @Override
    public void akcja() {
        swiat.idz(this, pozycja.obok(2));
        if (podwojnyRuch) {
            podwojnyRuch = false;
            akcja();
        }
    }

    @Override
    public void kolizja(Zwierze wchodzacy) {
        Pozycja wolnaPozycja = new Pozycja(0, 0);
        boolean znalezionoWolneMiejsce = swiat.znajdzWolneMiejsceObok(1,
                this.pozycja,
                wolnaPozycja);
        if (wchodzacy.getZnak() != getZnak() && znalezionoWolneMiejsce) {
            Vector<String> komunikat = new Vector<>();
            komunikat.add(getZnak());
            komunikat.add("\uD83D\uDCA8\n");
            Ekran.wstawKomunikat(komunikat);
            swiat.idz(this, wolnaPozycja);
        } else {
            super.kolizja(wchodzacy);
        } ;
    }
}
