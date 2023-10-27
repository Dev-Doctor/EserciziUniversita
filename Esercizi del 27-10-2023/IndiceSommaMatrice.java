package Esercizi_27_10_2023;
// import e' d'obbligo se vuoi usare la relativa libreria
import prog.io.*;

/*
    TESTO ESERCIZIO:
    Scrivere un programma che presa in input una matrice stampi la somma della riga con la
    somma più alta e la somma della colonna con la somma più alta. Stampare inoltre l’indice di
    tali colonne.

    Input:
        1 2 3
        3 4 5
        5 6 7
    Output:
        La somma più alta è: 18 in posizione 3 (Riga)
        La somma più alta è: 15 in posizione 3 (Colonna)
 */

/**
 * @author Davide Restelli
 */
public class IndiceSommaMatrice {
    public static void main(String[] args) {
        // inizializzazione per l'input della libreria di merda
        ConsoleInputManager input = new ConsoleInputManager();
        // inizializzazione per l'output della libreria di merda
        ConsoleOutputManager output = new ConsoleOutputManager();

        // chiede all'utente il numero di colonne della matrice e salva in variabile "colonne"
        int colonne = input.readInt("Inserisci il numero di colonne: ");
        // chiede all'utente il numero di righe della matrice e salva in variabile "righe"
        int righe = input.readInt("Inserisci il numero di righe: ");
        // creazione della matrice(tabella)
        Integer[][] matrice = new Integer[colonne][righe];

        /*
         * doppio for per ciclare tutte le celle della tabella
         * il primo serve per le colonne
         * il secondo server per le righe
         */
        for (int i = 0; i < colonne; i++) {
            for (int j = 0; j < righe; j++) {
                matrice[i][j] = input.readInt("Inserisci il valore per la cella " + i + "," + j + ": ");
            }
        }

        /*
        *   crezione della variabile che contiene la somma maggiore delle colonne
        *   viene inizializza a il numero piu' piccolo rappresentabile con una variabile di tipo int
        */
        int somma_colonna_maggiore = Integer.MIN_VALUE;
        // variabile che contiene la colonna che ha la somma maggiore
        int colonna_maggiore = 0;
        /*
         * doppio for per ciclare tutte le celle della tabella
         * il primo serve per le colonne
         * il secondo server per le righe
         */
        for (int i = 0; i < colonne; i++) {
            // somma totale della colonna corrente (i)
            // viene settata adesso a zero perche' quando si passa alla seconda colonna si ricomincia da capo
            // e quindi il valore deve essere a 0 e non il valore della somma della colonna precedente
            int somma_colonna_corrente = 0;
            for (int j = 0; j < righe; j++) {
                // somma il valore della riga corrente alla somma totale
                // += e' la stessa cosa di scrivere => somma_colonna_corrente = somma_colonna_corrente + matrice[i][j];
                somma_colonna_corrente += matrice[i][j];
            }
            // dopo aver sommato tulla la colonna (perche' siamo fuori dal for)
            // SE la somma di tutti  i valori della colonna e' MAGGIORE di quella corrente salvata
            // ALLORA diventa la nuova somma piu' grande
            if (somma_colonna_corrente > somma_colonna_maggiore) {
                // sovrascrive la vecchia somma maggiore con quella nuova
                somma_colonna_maggiore = somma_colonna_corrente;
                // salva il numero della colonna dove la somma e' maggiore
                // il "+ 1" serve perche' per esempio se la somma maggiore e' nella prima colonna a schermo scrive 1 (perche' i+1) e non 0
                colonna_maggiore = i + 1;
            }
        }

        /*
         *   crezione della variabile che contiene la somma maggiore delle riga
         *   viene inizializza a il numero piu' piccolo rappresentabile con una variabile di tipo int
         */
        int somma_riga_maggiore = Integer.MIN_VALUE;
        // variabile che contiene la riga che ha la somma maggiore
        int riga_maggiore = 0;
        /*
         * doppio for per ciclare tutte le celle della tabella
         * il primo serve per le RIGHE
         * il secondo serve per le COLONNE
         */
        for (int j = 0; j < righe; j++) {
            // somma totale della righe corrente (j)
            // viene settata adesso a zero perche' quando si passa alla seconda riga ricomincia da capo
            // e quindi il valore deve essere a 0 e non il valore della somma della riga precedente
            int somma_riga_corrente = 0;
            for (int i = 0; i < colonne; i++) {
                // somma il valore della riga corrente alla somma totale
                // += e' la stessa cosa di scrivere => somma_riga_corrente = somma_riga_corrente + matrice[i][j];
                somma_riga_corrente += matrice[i][j];
            }
            // dopo aver sommato tulla la riga (perche' siamo fuori dal for)
            // SE la somma di tutti  i valori della riga e' MAGGIORE di quella corrente salvata
            // ALLORA diventa la nuova somma piu' grande
            if (somma_riga_corrente > somma_riga_maggiore) {
                // sovrascrive la vecchia somma maggiore con quella nuova
                somma_riga_maggiore = somma_riga_corrente;
                // salva il numero della riga dove la somma e' maggiore
                // il "+ 1" serve perche' per esempio se la somma maggiore e' nella prima riga a schermo scrive 1 (perche' j+1) e non 0
                riga_maggiore = j + 1;
            }
        }

        // scrive a schermo il risultato
        // il + serve per concatenare variabili e stringhe insieme
        output.println("La colonna con la somma piu' grande e' la: " + colonna_maggiore + ", con somma totale: " + somma_colonna_maggiore);
        output.println("La righa con la somma piu' grande e' la: " + riga_maggiore + ", con somma totale: " + somma_riga_maggiore);
    }
}