package Esercizi_27_10_2023;
// import e' d'obbligo se vuoi usare la relativa libreria
import prog.io.*;
import prog.utili.*;

/**
 * @author Davide Restelli
 */

/*
	SEMPRE SECONDO ESERCIZIO MA UTILIZZANDO LA LIBRERIA

	TESTO ESERCIZIO:
	Scrivere un programma che presa in input una sequenza di n numeri (la richiesta di
	inserimento si ferma quando l’utente inserisce il valore 0) stampi la sequenza ordinata.

	Input:
		5, 6, 7, 3, 2, 1
	Output:
		1, 2, 3, 5, 6, 7
 */
public class OrdinaSequenza {
	public static void main(String[] args) {
		// inizializzazione per l'input della libreria di merda
		ConsoleInputManager input = new ConsoleInputManager();
		// inizializzazione per l'output della libreria di merda
		ConsoleOutputManager output = new ConsoleOutputManager();

		// inizializzo l'ggetto Sequenza
		Sequenza<Integer> lista_numeri = new Sequenza<Integer>();
		/*
			inizializzo a true la variabile che mi fa controllare il loop.
		 	Cosi' basta controllare se la condizione e' vera ( numero_corrent != 0 )
		 	e cambio la variabile a false per uscire dal loop
		*/
		boolean uscita = true;

		// loop do-while, viene eseguito per forza una volta
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
				// e ordina la Sequenza (si ordina cosi' usando la libreria)
				SequenzaOrdinata<Integer> sequenza_ordinata = SequenzaOrdinata.fromSequenza(lista_numeri);
				lista_numeri = sequenza_ordinata.toSequenza();
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