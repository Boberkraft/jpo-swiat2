package ja;

import ja.organizmy.zwierzeta.*;
import ja.organizmy.rosliny.*;

import java.util.function.Consumer;

public class Main {
    public static Swiat swiat;

    public static void dodaj(Organizm co, int x, int y){
        swiat.dodajOrganizm(co);
        swiat.idz(co, new Pozycja(x, y));
    }
    public static void main(String[] args) throws InterruptedException {
        swiat = new Swiat();

        dodaj(new Wilk(), 14, 1);
        dodaj(new Wilk(), 13, 1);
        dodaj(new Wilk(), 2, 1);
        dodaj(new Wilk(), 5, 1);
        dodaj(new Wilk(), 8, 1);
        dodaj(new Wilk(), 17, 1);
        dodaj(new Owca(), 3, 3);
        dodaj(new Owca(), 4, 16);
        dodaj(new Owca(), 6, 6);
        dodaj(new Owca(), 14, 13);
        dodaj(new Zmija(), 7, 7);
        dodaj(new Zmija(), 13, 15);
        dodaj(new Zmija(), 10, 10);
        dodaj(new Leniwiec(), 16, 10);
        dodaj(new Leniwiec(), 15, 10);
        dodaj(new Leniwiec(), 15, 7);
        dodaj(new Zaba(), 3, 9);
        dodaj(new Zaba(), 3, 7);
        dodaj(new Zaba(), 1, 7);
        dodaj(new Zaba(), 5, 7);
        dodaj(new Zaba(), 10, 7);
        dodaj(new Zaba(), 6, 15);
        dodaj(new Zaba(), 13, 3);
        dodaj(new Zaba(), 16, 8);
        dodaj(new Koka(), 8, 8);
        dodaj(new Koka(), 9, 4);
        dodaj(new Koka(), 10, 2);
        dodaj(new Mlecz(), 10, 15);
        dodaj(new Trawa(), 10, 17);
        dodaj(new Trawa(), 10, 18);

        for (int i = 0; i < 100000; i++) {
            swiat.rysujSwiat();
            Thread.sleep(1000);
            swiat.wykonajTure();


            //            try {
//            } catch (const char*msg){
//                std::cout << msg << std::endl;
//                return 0;
//            }

        }
    }
}
