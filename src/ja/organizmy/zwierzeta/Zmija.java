package ja.organizmy.zwierzeta;

import ja.Organizm;
import ja.organizmy.Zwierze;

public class Zmija extends Zwierze {
    public Zmija() {
        podwojnyRuch = false;
        sila = 2;
        inicjatywa = 3;
        znak = "\uD83D\uDC0D";
    }

    public Organizm dziecko() {
        return new Zmija();
    }


    @Override
    public void kolizja(Zwierze wchodzacy) {
        super.kolizja(wchodzacy);
        if (!zyje) {
            swiat.zabij(wchodzacy);
        }
    }
}
