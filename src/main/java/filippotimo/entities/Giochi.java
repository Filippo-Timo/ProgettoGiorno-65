package filippotimo.entities;

public abstract class Giochi {

    private int id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Giochi(int id, String titolo, int annoPubblicazione, double prezzo) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        if (prezzo != 0) {
            this.prezzo = prezzo;
        } else {
            System.out.println("Il prezzo inserito non è valido, il prezzo del gioco verrà impostato automaticamente a 1");
            this.prezzo = 1;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Giochi{" +
                "id = " + id +
                ", titolo = " + titolo +
                ", annoPubblicazione = " + annoPubblicazione +
                ", prezzo = " + prezzo +
                '}';
    }

}
