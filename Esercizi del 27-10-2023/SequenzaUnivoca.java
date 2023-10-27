package Esercizi_27_10_2023;
// import e' d'obbligo se vuoi usare la relativa libreria
import prog.io.*;
import prog.utili.Sequenza;

/**
 * @author Davide Restelli
 */

	/*
		L'idea e quella di andare a prendere tutti i numeri inseriti dall'utente
		e successivamente creare un array vuote e si va a controllare ogni numero di quelli inseriti dall'utente
		e se non e' contenuto nel nuovo array, lo si aggiunge.
		Il risultato e' un array che contiene una copia sola di tutti quelli inseriti dall'utente.

		TESTO ESERCIZIO:
		Scrivere un programma che presa in input una sequenza di n numeri (la richiesta di
		inserimento si ferma quando l’utente inserisce il valore 0) stampi la sequenza senza
		duplicazioni.

		Input:
			5, 6, 6, 1, 2, 1
		Output:
			5, 6, 1, 2
	 */

public class SequenzaUnivoca {
	public static void main(String[] args) {
		// inizializzazione per l'input della libreria di merda
		ConsoleInputManager input = new ConsoleInputManager();
		// inizializzazione per l'output della libreria di merda
		ConsoleOutputManager output = new ConsoleOutputManager();

		// inizializzo l'ggetto Sequenza
		Sequenza<Integer> lista_numeri = new Sequenza<Integer>();
		// creo una nuova lista vuota che servira' per dopo quando rimuoviamo i duplicati
		Sequenza<Integer> lista_no_duplicati = new Sequenza<Integer>();
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

				// PER OGNI numero nella sequenza lista_numeri
				for(int numero : lista_numeri) {
					//	SE la nuova lista NON contiene il numero corrente
					//		il punto esclamativo davanti alla lista inverte il risultato
					//		(esempio se fosse true, con il punto escamativo sarebbe false)
					if(!lista_no_duplicati.contains(numero)) {
						//	aggiungi il numero alla lista_no_duplicati
						lista_no_duplicati.add(numero);
					}
				}
			}
		} while(uscita);

		output.println("Lista senza duplicati: ");
		// PER OGNI numero nella lista
		for (int numero : lista_no_duplicati) {
			// scrivilo in console
			output.print(String.valueOf(numero) + " ");
		}
	}
}
