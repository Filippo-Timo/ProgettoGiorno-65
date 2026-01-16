package filippotimo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collezione {

    // --------------------------------------------- CREO LA LISTA DEI GIOCHI ---------------------------------------------
    private List<Giochi> libreriaDeiGiochi;


    // --------------------------------------------- COSTRUTTORE (in cui inserisco già 5 giochi) ---------------------------------------------
    public Collezione() {
        libreriaDeiGiochi = new ArrayList<>();

        libreriaDeiGiochi.add(new Videogiochi(1, "Mario", 1990, 12.0, "NES", 50, Genere.Azione));
        libreriaDeiGiochi.add(new Videogiochi(2, "Pokemon", 2000, 50.0, "GameBoy", 100, Genere.Avventura));
        libreriaDeiGiochi.add(new GiochiDaTavolo(3, "Monopoly", 1985, 30.0, 2, 6));
        libreriaDeiGiochi.add(new Videogiochi(4, "FIFA", 2018, 45.0, "PS4", 120, Genere.Sport));
        libreriaDeiGiochi.add(new GiochiDaTavolo(5, "Cluedo", 1995, 25.0, 2, 6));
    }

    // --------------------------------------------- METODI ---------------------------------------------

    // PRIMO METODO:

    public void aggiungiGioco(Giochi giocoDaAggiungere) {
        boolean duplicato = libreriaDeiGiochi.stream()
                .anyMatch(gioco -> gioco.getId() == giocoDaAggiungere.getId());

        if (duplicato) {
            System.out.println("Il gioco è già presente nella libreria!");
        } else {
            libreriaDeiGiochi.add(giocoDaAggiungere);
            System.out.println("Gioco aggiunto correttamente!");
        }
    }

    public List<Giochi> getLibreriaDeiGiochi() {
        return libreriaDeiGiochi;
    }

    // SECONDO METODO:

    public Giochi riceraGiocoPerId(int id) {
        return libreriaDeiGiochi.stream().filter(gioco -> gioco.getId() == id).findFirst().orElse(null);
    }

//    TERZO METODO:

    public List<Giochi> ricercaGiocoPerPrezzo(double prezzo) {
        return libreriaDeiGiochi.stream().filter(giochi -> giochi.getPrezzo() < prezzo).collect(Collectors.toList());
    }

    //    QUARTO METODO:

    public List<Giochi> ricercaGiocoPerNumeroGiocatori(int numG) {
        return libreriaDeiGiochi.stream().filter(giochi -> giochi instanceof GiochiDaTavolo)
                .map(giochi -> ((GiochiDaTavolo) giochi))
                .filter(giochiT -> giochiT.getNumeroDiGiocatori() == numG)
                .collect(Collectors.toList());
    }

    //    QUINTO METODO:

    public boolean rimuoviGiocoPerId(int id) {
        boolean giocoRimosso = libreriaDeiGiochi.removeIf(gioco -> gioco.getId() == id);
        if (giocoRimosso == true) {
            System.out.println("Gioco rimosso correttamente");
        } else {
            System.out.println("Gioco non trovato, riprova inserendo un altro id");
        }
        return giocoRimosso;
    }
}
