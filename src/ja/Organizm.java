package ja;

public abstract class Organizm {
    protected int sila;
    protected int inicjatywa;
    protected int urodziny;
    protected Pozycja pozycja;
    protected boolean zyje;
    protected Swiat swiat;
    protected String znak;

    public abstract Organizm dziecko();

    public void zarejestrujSwiat(Swiat swiat) {
        this.urodziny = swiat.jakaTura();
        this.zyje = true;
        this.swiat = swiat;
    }

    void rysowanie() {
        Ekran.wstawZnak(znak, pozycja);
    }

    int jakaInicjatywa() {
        return inicjatywa;
    }

    protected int jakaSila() {
        return sila;
    }

    int wiek() {
        return swiat.jakaTura() - urodziny;
    }

    public boolean getZyje() {
        return zyje;
    }

    public boolean czyNieZyje() {
        return !zyje;
    }


    public void setZyje(boolean b) {
        this.zyje = b;
    }

    public void setPozycja(Pozycja pozycja) {
        this.pozycja = pozycja;
    }

    public Pozycja getPozycja() {
        return this.pozycja;
    }

    public String getZnak() {
        return znak;
    }

    public void setZnak(String znak) {
        this.znak = znak;
    }

    public abstract void kolizja(Organizm ruszajacySie);

    public abstract void akcja();
}
