package filippotimo.entities;

public class Videogiochi extends Giochi {

    public Genere genere;
    private String piattaforma;
    private int durataDiGioco;

    public Videogiochi(int id, String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durataDiGioco, Genere genere) {
        super(id, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        if (durataDiGioco > 0) {
            this.durataDiGioco = durataDiGioco;
        } else {
            System.out.println("Il numero della durata del videogioco inserito non è valido, la durata sarà impostata automaticamente a 1");
            this.durataDiGioco = 1;
        }
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurataDiGioco() {
        return durataDiGioco;
    }

    public void setDurataDiGioco(int durataDiGioco) {
        this.durataDiGioco = durataDiGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco {" +
                "id = " + getId() +
                ", titolo = " + getTitolo() +
                ", annoPubblicazione = " + getAnnoPubblicazione() +
                ", prezzo = " + getPrezzo() +
                ", piattaforma = " + piattaforma +
                ", durataDiGioco = " + durataDiGioco +
                ", genere = " + genere +
                '}';
    }
}
