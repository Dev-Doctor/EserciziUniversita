package Esercizi_27_10_2023;
// import e' d'obbligo se vuoi usare la relativa libreria ( di merda in questo caso :) )
import prog.io.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Davide Restelli
 */

/*
	TESTO ESERCIZIO:
	Scrivere un programma che presa in input una sequenza di n numeri (la richiesta di
	inserimento si ferma quando l’utente inserisce il valore 0) stampi la sequenza ordinata.

	Input:
		5, 6, 7, 3, 2, 1
	Output:
		1, 2, 3, 5, 6, 7
 */
public class OrdinaSequenzaArrayList {
	public static void main(String[] args) {
		// inizializzazione per l'input della libreria di merda
		ConsoleInputManager input = new ConsoleInputManager();
		// inizializzazione per l'output della libreria di merda
		ConsoleOutputManager output = new ConsoleOutputManager();

		// inizializzo l'ArrayList
		ArrayList<Integer> lista_numeri = new ArrayList<Integer>();
		/*
			inizializzo a true la variabile che mi fa controllare il loop.
		 	Cosi' basta controllare se la condizione e' vera ( numero_corrent != 0 )
		 	e cambio la variabile a false per uscire dal loop
		*/
		boolean uscita = true;

		// loop do-while, viene eseguito perforza una volta
		do {
			// numero corrente inserito dall'utente
			int numero_corrente = input.readInt("Inserisci un numero: ");

			// SE il numero_corrente e' DIVERSO da 0,
			if(numero_corrente != 0) {
				// aggiungilo alla lista dei numeri
				lista_numeri.add(numero_corrente);
			// ALTRIMENTI
			} else {
				// setta la variabile di uscita a false
				uscita = false;
				// e ordina l'ArrayList (si ordina cosi' senza usare quella libreria)
				Collections.sort(lista_numeri);
			}
		} while(uscita);

		output.println("Lista ordinata: ");
		// PER OGNI numero nella lista
		for (int numero : lista_numeri) {
			// scrivilo in console
			output.print(String.valueOf(numero) + " ");
		}
	}
}