package ja.organizmy.rosliny;

import ja.Organizm;
import ja.organizmy.Roslina;

public class Trawa extends Roslina {
    public Trawa() {
        znak = "\uD83C\uDF3E";
    }

    public Organizm dziecko() {
        return new Trawa();
    }
}
