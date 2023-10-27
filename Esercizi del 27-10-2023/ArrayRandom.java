package Esercizi_27_10_2023;
import prog.io.*;
import prog.utili.Sequenza;

import java.util.Random;

/**
 * @author Davide Restelli
 */

/*
	!!! --- In questa versione utilizzo una Sequenza della libreria del libro (praticamente uguale all'ArrayList ma inferiore) --- !!!
	!!! --- Se ti serve con gli altri metodi, prova a modificare uno degli altri file di esempio :) --- !!!

	TESTO ESERCIZIO:
	Modificate l'applicazione precedente in modo che le posizioni dell'array siano riempite con
	valori interi pseudo-casuali positivi e negativi con valore assoluto minore di un valore
	specificato dall'utente.

	Inserisci la dimensione dell'array: 10
	Inserisci il valore massimo da generare: 100
	[-16,-58,-59,-61,12,93,0,8,-31,-74]
 */
public class ArrayRandom {

	public static void main(String[] args) {
		// inizializzazione per l'input della libreria del libro
		ConsoleInputManager input = new ConsoleInputManager();
		// inizializzazione per l'output della libreria del libro
		ConsoleOutputManager output = new ConsoleOutputManager();

		// chiedo all'utente la grandezza dell'Array
		int size = input.readInt("Inserisci la dimensione dell'array: ");
		// chiedo all'utente la grandezza massima del valore
		int max = input.readInt("Inserisci il valore massimo da generare: ");

		// inizializzo l'oggetto random
		Random random = new Random();

		// creo l'array con la grandezza massima inserita dall'utente
		Sequenza<Integer> numeri_random = new Sequenza<Integer>();
		// per ogni casella dell'array genero un numero casuale
		for(int i = 0; i < size; i++) {
			/*
				La formula utilizza in questo caso e' la seguente: ((max - min) + 1) + min;

				in questo caso visto che max e min sono lo stesso numero, cioe' vogliamo numeri che vanno come nell'esempio
				fornito dalla prof da 100 a -100 usiamo la stessa variabile, che e' la grandezza massima inserita dall'utente
			*/
			// dichiaro la variabile min che da come risultato il valore massimo ma negativo
			int min = max * -1;
			numeri_random.add(random.nextInt((max - min) + 1) + min);
		}

		// scrivo la sequenza in console
		output.print(numeri_random);
	}
}
