package ja.organizmy.zwierzeta;

import ja.Organizm;
import ja.organizmy.Zwierze;

public class Owca extends Zwierze {
    public Owca() {
        podwojnyRuch = false;
        sila = 4;
        inicjatywa = 4;
        znak = "\uD83D\uDC11";
    }

    public Organizm dziecko() {
        return new Owca();
    }
}
