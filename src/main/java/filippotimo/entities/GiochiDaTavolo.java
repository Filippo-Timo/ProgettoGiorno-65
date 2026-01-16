package filippotimo.entities;

public class GiochiDaTavolo extends Giochi {

    private int numeroDiGiocatori;
    private int durataMediaPartita;

    public GiochiDaTavolo(int id, String titolo, int annoPubblicazione, double prezzo, int numeroDiGiocatori, int durataMediaPartita) {
        super(id, titolo, annoPubblicazione, prezzo);
        if (numeroDiGiocatori != 0 && numeroDiGiocatori >= 1 && numeroDiGiocatori <= 10) {
            this.numeroDiGiocatori = numeroDiGiocatori;
        } else {
            System.out.println("Il numero di giocatori inserito non è valido!");
        }
        if (durataMediaPartita > 0) {
            this.durataMediaPartita = durataMediaPartita;
        } else {
            System.out.println("Il numero della durata media della partita inserito non è valido, la durata media sarà impostata automaticamente a 1");
            this.durataMediaPartita = 1;
        }
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
        return "Gioco da tavolo {" +
                "id = " + getId() +
                ", titolo = " + getTitolo() +
                ", annoPubblicazione = " + getAnnoPubblicazione() +
                ", prezzo = " + getPrezzo() +
                ", numeroDiGiocatori = " + numeroDiGiocatori +
                ", durataMediaPartita = " + durataMediaPartita +
                '}';
    }
}
