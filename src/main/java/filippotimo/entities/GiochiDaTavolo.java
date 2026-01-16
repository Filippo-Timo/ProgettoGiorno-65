package filippotimo.entities;

public class GiochiDaTavolo extends Giochi {

    private int numeroDiGiocatori;
    private int durataMediaPartita;

    public GiochiDaTavolo(int id, String titolo, int annoPubblicazione, double prezzo, int numeroDiGiocatori, int durataMediaPartita) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.numeroDiGiocatori = numeroDiGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroDiGiocatori() {
        return numeroDiGiocatori;
    }

    public void setNumeroDiGiocatori(int numeroDiGiocatori) {
        this.numeroDiGiocatori = numeroDiGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        this.durataMediaPartita = durataMediaPartita;
    }

    @Override
    public String toString() {
        return "GiochiDaTavolo{" +
                "numeroDiGiocatori=" + numeroDiGiocatori +
                ", durataMediaPartita=" + durataMediaPartita +
                '}';
    }
}
