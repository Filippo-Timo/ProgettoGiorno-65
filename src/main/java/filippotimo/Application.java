package filippotimo;

import filippotimo.entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Collezione libreria = new Collezione();

        boolean continua = true;

        while (continua) {
            System.out.println("Inserisci un numero da 1 a 7 per eseguire un comando: 0. Interrompi il processo, 1. Aggiungi gioco, 2. cerca per ID, 3. Cerca per prezzo, 4. Cerca per numero di giocatori, 5. Rimuovi un elemento per ID, 6. Aggiorna un elemento per ID, 7. Statistiche della collezione");
            int casoDaEseguire = Integer.parseInt(scanner.nextLine());

            switch (casoDaEseguire) {
                case 0:
                    System.out.println("Hai scelto di terminare il processo");
                    continua = false;
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
                    double prezzo = Double.parseDouble(scanner.nextLine());

                    if (tipo.equals("videogioco")) {
                        System.out.print("Piattaforma: ");
                        String piattaforma = scanner.nextLine();
                        System.out.print("Durata ore: ");
                        int durata = Integer.parseInt(scanner.nextLine());
                        System.out.print("Genere (Azione, Avventura, Rpg, Sport, Fps, Moba, Mmo): ");
                        String genereInput = scanner.nextLine();
                        Genere genere;

                        try {
                            genere = Genere.valueOf(genereInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Genere non valido, imposto Azione di default");
                            genere = Genere.Azione;
                        }

                        Videogiochi nuovoVideogioco = new Videogiochi(id, titolo, anno, prezzo, piattaforma, durata, genere);
                        libreria.aggiungiGioco(nuovoVideogioco);

                    } else if (tipo.equals("gioco da tavolo")) {
                        GiochiDaTavolo nuovoGiocoDaTavolo = new GiochiDaTavolo(id, titolo, anno, prezzo, 2, 4);
                        libreria.aggiungiGioco(nuovoGiocoDaTavolo);

                    } else {
                        System.out.println("Tipo non valido!");
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
                        System.out.println("Nessun gioco trovato con ID " + idCercato);
                    }
                    break;

                case 3:
                    System.out.print("Mostra giochi con prezzo inferiore a: ");
                    double prezzoLimite = Double.parseDouble(scanner.nextLine());
                    List<Giochi> giochiEconomici = libreria.ricercaGiocoPerPrezzo(prezzoLimite);
                    if (!giochiEconomici.isEmpty()) {
                        giochiEconomici.forEach(System.out::println);
                    } else {
                        System.out.println("Nessun gioco trovato sotto il prezzo " + prezzoLimite);
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

                default:
                    System.out.println("Il numero selezionato non è valido");
            }
        }
    }
}
