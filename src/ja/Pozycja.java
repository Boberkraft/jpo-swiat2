package ja;

import java.util.Objects;
import java.util.Random;

import static java.lang.Math.random;

public class Pozycja {
    protected int rzad;
    protected int kolumna;

    public Pozycja(int rzad, int kolumna) {
        int rem;

        rem = rzad % 20;
        this.rzad = (rem >= 0) ? rem : rem + 20;

        rem = kolumna % 20;
        this.kolumna = (rem >= 0) ? rem : rem + 20;
    }

    public Pozycja() {

    }

    public int getRzad() {
        return this.rzad;
    }

    public int getKolumna() {
        return this.kolumna;
    }

    public Pozycja obok(int zakres) {
        Random rand = new Random();
        int deltaRzad = 0;
        int deltaKolumna = 0;

        while (deltaRzad == 0 && deltaKolumna == 0) {
            deltaRzad = rand.nextInt(zakres * 2 + 1) - zakres;
            deltaKolumna = rand.nextInt(zakres * 2 + 1) - zakres;
        }

        return new Pozycja(rzad + deltaRzad, kolumna + deltaKolumna);
    }

    public int jednowymiarowo() {
        return rzad * 20 + kolumna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozycja pozycja = (Pozycja) o;
        return rzad == pozycja.rzad &&
                kolumna == pozycja.kolumna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rzad, kolumna);
    }
}
