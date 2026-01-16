package filippotimo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collezione {

    // --------------------------------------------- CREO LA LISTA DEI GIOCHI ---------------------------------------------
    private List<Giochi> libreriaDeiGiochi;


    // --------------------------------------------- COSTRUTTORE ---------------------------------------------
    public Collezione() {
        libreriaDeiGiochi = new ArrayList<>(); // inizializzo la lista vuota
    }


    // --------------------------------------------- METODI ---------------------------------------------

    // PRIMO METODO:
    // Aggiungere un elemento

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
    // Ricerca per ID

    public Giochi riceraGiocoPerId(int id) {
        return libreriaDeiGiochi.stream().filter(gioco -> gioco.getId() == id).findFirst().orElse(null);
    }

    // TERZO METODO:
    // Ricerca per prezzo

    public List<Giochi> ricercaGiocoPerPrezzo(double prezzo) {
        return libreriaDeiGiochi.stream().filter(giochi -> giochi.getPrezzo() < prezzo).collect(Collectors.toList());
    }

    // QUARTO METODO:
    // Ricerca per numero di giocatori

    public List<Giochi> ricercaGiocoPerNumeroGiocatori(int numG) {
        return libreriaDeiGiochi.stream().filter(giochi -> giochi instanceof GiochiDaTavolo)
                .map(giochi -> ((GiochiDaTavolo) giochi))
                .filter(giochiT -> giochiT.getNumeroDiGiocatori() == numG)
                .collect(Collectors.toList());
    }

    // QUINTO METODO:
    // Rimozione di un elemento trovato per ID

    public boolean rimuoviGiocoPerId(int id) {
        boolean giocoRimosso = libreriaDeiGiochi.removeIf(gioco -> gioco.getId() == id);
        if (giocoRimosso == true) {
            System.out.println("Gioco rimosso correttamente");
        } else {
            System.out.println("Gioco non trovato, riprova inserendo un altro id");
        }
        return giocoRimosso;
    }

    // SESTO METODO:
    // Aggiornamento di un elemento esistente trovato per ID

    public boolean modificaGiocoDaZeroById(int id, Giochi nuovoGioco) {

        for (int i = 0; i < libreriaDeiGiochi.size(); i++) {
            if (libreriaDeiGiochi.get(i).getId() == id) {
                libreriaDeiGiochi.set(i, nuovoGioco);
                System.out.println("Gioco modificato correttamente! Questo è il nuovo " + nuovoGioco);
                return true;
            }
        }
        System.out.println("Gioco non trovato");
        return false;
    }

    // SETTIMO METODO:
    // Stampa le statistiche della collezione (devo usare .summaryStatistics() come ha fatto il prof ieri)

    @Override
    public String toString() {
        return "Collezione { " +
                "libreriaDeiGiochi = " + libreriaDeiGiochi +
                '}';
    }
}
