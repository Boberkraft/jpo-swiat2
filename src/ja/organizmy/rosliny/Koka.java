package ja.organizmy.rosliny;

import ja.Organizm;
import ja.organizmy.Roslina;
import ja.organizmy.Zwierze;

public class Koka extends Roslina {
    public Koka() {
        znak = "\uD83C\uDF44";
    }

    public Organizm dziecko() {
        return new Koka();
    }

    @Override
    public void kolizja(Organizm wchodzacy) {
        ((Zwierze) wchodzacy).dajBuffaPodwojnegoRuchu();
        super.kolizja(wchodzacy);
    }
}
