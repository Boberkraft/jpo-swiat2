package ja.organizmy.zwierzeta;

import ja.Organizm;
import ja.organizmy.Zwierze;

public class Leniwiec extends Zwierze {
    private boolean spi;

    public Leniwiec() {
        podwojnyRuch = false;
        spi = false;
        sila = 2;
        inicjatywa = 1;
        znak = "\uD83E\uDDA5";
    }

    public Organizm dziecko() {
        return new Leniwiec();
    }

    @Override
    public void akcja() {
        spi = !spi;
        if (!spi) {
            super.akcja();
        }
    }
}
