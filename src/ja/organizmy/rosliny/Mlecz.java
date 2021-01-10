package ja.organizmy.rosliny;

import ja.Organizm;
import ja.organizmy.Roslina;

public class Mlecz extends Roslina {
    public Mlecz() {
        znak = "\uD83C\uDF31";
    }

    public Organizm dziecko() {
        return new Mlecz();
    }

    @Override
    public void akcja() {
        super.akcja();
        super.akcja();
        super.akcja();
    }
}
