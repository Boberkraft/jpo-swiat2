package ja.organizmy.zwierzeta;

import ja.Organizm;
import ja.organizmy.Zwierze;

public class Wilk extends Zwierze {
    public Wilk() {
        podwojnyRuch = false;
        sila = 9;
        inicjatywa = 5;
        znak = "\uD83D\uDC15";
    }

    public Organizm dziecko() {
        return new Wilk();
    }
}
