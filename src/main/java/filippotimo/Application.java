package filippotimo;

import filippotimo.entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Collezione libreria = new Collezione();

        Videogiochi primoGioco = new Videogiochi(1, "Mario", 1984, 50.0, "Gamecube", 100, Genere.Azione);
        Videogiochi secondoGioco = new Videogiochi(2, "Pokemon", 2000, 60.0, "GameBoy color", 120, Genere.Avventura);
        GiochiDaTavolo terzoGioco = new GiochiDaTavolo(3, "Monopoly", 1985, 25.0, 8, 6);
        GiochiDaTavolo quartoGioco = new GiochiDaTavolo(4, "Cluedo", 2008, 30.0, 4, 6);
        Videogiochi quintoGioco = new Videogiochi(5, "Zelda", 2005, 55.0, "Playstation 1", 90, Genere.Avventura);

        libreria.aggiungiGioco(primoGioco);
        libreria.aggiungiGioco(secondoGioco);
        libreria.aggiungiGioco(terzoGioco);
        libreria.aggiungiGioco(quartoGioco);
        libreria.aggiungiGioco(quintoGioco);

        System.out.println(libreria);

        // questa variabil mi serve pr il ciclo while
        boolean continua = true;

        while (continua) {
            System.out.println("Inserisci un numero da 1 a 7 per eseguire un comando: 0. Interrompi il processo, 1. Aggiungi gioco, 2. cerca per ID, 3. Cerca per prezzo, 4. Cerca per numero di giocatori, 5. Rimuovi un elemento per ID, 6. Aggiorna un elemento per ID, 7. Statistiche della collezione");
            int casoDaEseguire = Integer.parseInt(scanner.nextLine());

            switch (casoDaEseguire) {
                case 0:
                    System.out.println("Hai scelto di terminare il processo");
                    continua = false;
                    scanner.close();
                    break;

                case 1:
                    System.out.println("Hai scelto di aggiungere un gioco alla libreria");
                    System.out.println("Scrivere 'videogioco' o 'gioco da tavolo':");
                    String tipo = scanner.nextLine();

                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Anno: ");
                    int anno = Integer.parseInt(scanner.nextLine());
                    System.out.print("Prezzo: ");
                    double prezzo = Double.parseDouble(scanner.nextLine()); // QUESTO L'HO TROVATO SU INTERNET

                    if (tipo.equals("videogioco")) {
                        System.out.print("Piattaforma: ");
                        String piattaforma = scanner.nextLine();
                        System.out.print("Durata ore: ");
                        int durata = Integer.parseInt(scanner.nextLine());
                        System.out.print("Genere (Azione, Avventura, Rpg, Sport, Fps, Moba, Mmo): ");
                        String genereInput = scanner.nextLine();
                        Genere genere;

                        try {
                            genere = Genere.valueOf(genereInput); // con il valeOf trasgormo la stringa mella variabile genereInput in un elemento dell'enum (l'ho trovato su internet)
                        } catch (IllegalArgumentException e) { // QUESTA ECFEZIONE L'HO TROVATA SU INTERNET
                            System.out.println("Genere non valido, imposto Azione di default");
                            genere = Genere.Azione;
                        }

                        Videogiochi nuovoVideogioco = new Videogiochi(id, titolo, anno, prezzo, piattaforma, durata, genere);
                        libreria.aggiungiGioco(nuovoVideogioco);

                    } else if (tipo.equals("gioco da tavolo")) {
                        GiochiDaTavolo nuovoGiocoDaTavolo = new GiochiDaTavolo(id, titolo, anno, prezzo, 2, 2);
                        libreria.aggiungiGioco(nuovoGiocoDaTavolo);

                    } else {
                        System.out.println("Il tipo inserito non è valido!");
                    }
                    for (Giochi gioco : libreria.getLibreriaDeiGiochi()) {
                        System.out.println(gioco);
                    }
                    break;

                case 2:
                    System.out.print("Inserisci l'ID del gioco da cercare: ");
                    int idCercato = Integer.parseInt(scanner.nextLine());
                    Giochi giocoTrovato = libreria.riceraGiocoPerId(idCercato);
                    if (giocoTrovato != null) {
                        System.out.println("Gioco trovato: " + giocoTrovato);
                    } else {
                        System.out.println("Non ho trovato un gioco con ID " + idCercato);
                    }
                    break;

                case 3:
                    System.out.print("Questi sono i giochi con il prezzo inferiore a: ");
                    double prezzoLimite = Double.parseDouble(scanner.nextLine());
                    List<Giochi> giochiEconomici = libreria.ricercaGiocoPerPrezzo(prezzoLimite);
                    if (!giochiEconomici.isEmpty()) {
                        giochiEconomici.forEach(System.out::println);
                    } else {
                        System.out.println("Nessun gioco trovato al di sotto il prezzo " + prezzoLimite);
                    }
                    break;

                case 4:
                    System.out.print("Mostra giochi da tavolo con numero di giocatori pari a: ");
                    int numGiocatori = Integer.parseInt(scanner.nextLine());
                    List<Giochi> giochiConNumeroGiocatori = libreria.ricercaGiocoPerNumeroGiocatori(numGiocatori);

                    if (!giochiConNumeroGiocatori.isEmpty()) {
                        for (int i = 0; i < giochiConNumeroGiocatori.size(); i++) {
                            System.out.println(giochiConNumeroGiocatori.get(i));
                        }
                    } else {
                        System.out.println("Nessun gioco da tavolo trovato con " + numGiocatori + " giocatori.");
                    }
                    break;

                case 5:
                    System.out.print("Inserisci l'ID del gioco da rimuovere: ");
                    int idDaRimuovere = Integer.parseInt(scanner.nextLine());
                    libreria.rimuoviGiocoPerId(idDaRimuovere);
                    break;

                case 6:
                    System.out.print("Inserisci ID del gioco da modificare: ");
                    int idModifica = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuovo titolo: ");
                    String newTitolo = scanner.nextLine();

                    System.out.print("Nuovo anno: ");
                    int newAnno = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuovo prezzo: ");
                    double newPrezzo = Double.parseDouble(scanner.nextLine());

                    System.out.print("Per il tipo scrivi videogioco o gioco da tavolo: ");
                    String newTipo = scanner.nextLine();

                    if (newTipo.equals("videogioco")) {
                        System.out.print("Nuova piattaforma: ");
                        String newPiattaforma = scanner.nextLine();

                        System.out.print("Nuova durata in ore: ");
                        int newDurata = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nuovo genere (Azione, Avventura, Rpg, Sport, Fps, Moba, Mmo): ");
                        // QUA HO COPATO DAL CASE 1
                        String newGenereInput = scanner.nextLine();
                        Genere genere;

                        try {
                            genere = Genere.valueOf(newGenereInput); // con il valeOf trasgormo la stringa mella variabile newGenereInput in un elemento dell'enum (l'ho trovato su internet)
                        } catch (IllegalArgumentException e) {
                            genere = Genere.Azione;
                        }

                        Videogiochi nuovoVideogioco = new Videogiochi(
                                idModifica, newTitolo, newAnno, newPrezzo,
                                newPiattaforma, newDurata, genere
                        );

                        libreria.modificaGiocoDaZeroById(idModifica, nuovoVideogioco);

                    } else if (newTipo.equals("gioco da tavolo")) {
                        System.out.print("Nuovo numero di giocatori: ");
                        int newNumeroGiocatori = Integer.parseInt(scanner.nextLine());

                        GiochiDaTavolo nuovoGiocoDaTavolo = new GiochiDaTavolo(
                                idModifica, newTitolo, newAnno, newPrezzo, newNumeroGiocatori, newNumeroGiocatori
                        );

                        libreria.modificaGiocoDaZeroById(idModifica, nuovoGiocoDaTavolo);
                    }
                    break;

                default:
                    System.out.println("Il numero selezionato non è valido");
            }
        }
    }
}
