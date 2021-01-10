package ja;


import ja.organizmy.Roslina;
import ja.organizmy.Zwierze;

import java.util.*;

public class Swiat {
    private int tura;
    private Vector<Organizm> organizmy;

    public Swiat() {
        this.tura = 1;
        this.organizmy = new Vector<>();
    }

    public void wykonajTure() {
        weryfikujCzyWszystkoGit();
        ustawKolejnoscWalk();

        int size = organizmy.size();
        for (int i = 0; i < size; i++) {
            Organizm organizm = organizmy.get(i);
            if (organizm.getZyje()) {
                organizm.akcja();
            }
        }
        usunMartweOrganizmy();

        this.tura += 1;
        Ekran.wstawTure(tura);
    }

    public void dodajOrganizm(Organizm organizm) {
        organizmy.add(organizm);
        organizm.zarejestrujSwiat(this);
    }

    public void zabij(Organizm organizm) {
        organizm.setZyje(false);
    }

    public void rysujSwiat() {
        for (Organizm organizm : organizmy) {
            organizm.rysowanie();
        }
        Ekran.wyswietl();
    }

    public void idz(Organizm ruszajacySie, Pozycja pozycja) {
        Organizm stojacy = znajdz(pozycja);

        if (stojacy == ruszajacySie) {
            return; // LOL XD
        }

        if (stojacy == null) {
            ruszajacySie.setPozycja(pozycja);

        } else {
            stojacy.kolizja(ruszajacySie);

        }
    }


    public Organizm znajdz(Pozycja pozycja) {
        for (Organizm organizm : organizmy) {
            if (organizm.getZyje() && organizm.getPozycja() == pozycja) {
                return organizm;
            }
        }
        return null;
    }

    public Zwierze rozmnorz(Zwierze pasywny, Zwierze inicjator) {
        Organizm nowe = rozmnorz((Organizm) pasywny, 1);
        if (nowe != null) {
            Vector<String> komunikat = new Vector<>();
            komunikat.add(pasywny.getZnak());
            komunikat.add("\uD83D\uDC95");
            Ekran.wstawKomunikat(komunikat);
        }
        return (Zwierze) nowe;
    }

    public Roslina rozmnorz(Roslina roslina) {
        Organizm nowe = rozmnorz((Organizm) roslina, 1);

        if (nowe != null) {
            Vector<String> komunikat = new Vector<>();
            komunikat.add(roslina.getZnak());
            komunikat.add("\uD83D\uDCA6\n");
            Ekran.wstawKomunikat(komunikat);
        }

        return (Roslina) nowe;
    }


    public Organizm rozmnorz(Organizm organizm, int zasieg) {
        Pozycja wolnaPozycja = new Pozycja(0, 0);
        boolean znalezionoWolneMiejsce = znajdzWolneMiejsceObok(zasieg,
                organizm.getPozycja(),
                wolnaPozycja);
        if (!znalezionoWolneMiejsce) {
            return null;
        }

        Organizm dziecko = organizm.dziecko();
        dodajOrganizm(dziecko);
        idz(dziecko, wolnaPozycja);
        return dziecko;
    }

    public boolean znajdzWolneMiejsceObok(int zasieg, Pozycja pozycja, Pozycja wybranaPozycja) {
        Vector<Integer> proby = new Vector<>();

        Random rand = new Random();
        for (int iloscProb = 0; iloscProb < zasieg; iloscProb++) {
            int wylosowanyKierunek = rand.nextInt(zasieg * 2 + 1) * (zasieg * 2 + 1);

            if (proby.contains(wylosowanyKierunek)) {
                continue;
            }
            proby.add(wylosowanyKierunek);

            int x = (wylosowanyKierunek / ((zasieg + 1) * 2) - zasieg / 2);
            int y = (wylosowanyKierunek % ((zasieg + 1) * 2) - zasieg / 2);
            wybranaPozycja = new Pozycja(pozycja.getRzad() + x, pozycja.getKolumna() + y);

            Organizm zajety = znajdz(wybranaPozycja);

            if (zajety != null) {
                continue;
            } else {
                return true; // OK!
            }
        }
        return false;
    }


    private void ustawKolejnoscWalk() {
        Collections.sort(organizmy, (a, b) -> {
            if (a.jakaInicjatywa() == b.jakaInicjatywa()) {
                return a.wiek() - b.wiek();
            }
            return a.jakaInicjatywa() - b.jakaInicjatywa();
        });
    }

    private void usunMartweOrganizmy() {
        organizmy.removeIf(Organizm::getZyje);
    }

    private void weryfikujCzyWszystkoGit() {
        int ilosc_zyjacych = 0;

        for (Organizm organizm : organizmy) {
            if (organizm.getZyje()) {
                ilosc_zyjacych += 1;
            }
        }

        if (0 == ilosc_zyjacych || ilosc_zyjacych > 400) {
//            throw "Ilosc Zyjacych zwierzat sie nie zgadza!";
        }
    }

    public int jakaTura() {
        return tura;
    }
}
