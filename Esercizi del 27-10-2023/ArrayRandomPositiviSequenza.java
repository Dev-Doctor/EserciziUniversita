package Esercizi_27_10_2023;

import prog.io.*;
import prog.utili.*;

import java.util.Random;

/**
 * @author Davide Restelli
 */

/*
	!!! --- In questa versione utilizzo una Sequenza della libreria del libro (praticamente uguale all'ArrayList ma inferiore) --- !!!

	TESTO ESERCIZIO:
	Scrivete un'applicazione che generi un array di interi pseudocasuali e lo visualizzi a video. La
	dimensione dell'array e il valore massimo dei valori da generare devono essere forniti come
	input dall'utente. Usare la classe java.util.Random.

	Inserisci la dimensione dell'array : 10
	Inserisci il valore massimo da generare : 100
	[59,99,98,81,63,56,12,56,91,8]
 */
public class ArrayRandomPositiviSequenza {

	public static void main(String[] args) {
		// inizializzazione per l'input della libreria del libro
		ConsoleInputManager input = new ConsoleInputManager();
		// inizializzazione per l'output della libreria del libro
		ConsoleOutputManager output = new ConsoleOutputManager();

		// chiedo all'utente la grandezza dell'Array
		int size = input.readInt("Inserisci la dimensione dell'array: ");
		// chiedo all'utente la grandezza massima del valore
		int valore_massimo = input.readInt("Inserisci il valore massimo da generare: ");

		// inizializzo l'oggetto random
		Random random = new Random();

		// creo l'array con la grandezza massima inserita dall'utente
		Sequenza<Integer> numeri_random = new Sequenza<Integer>();
		// per ogni casella dell'array genero un numero casuale
		for(int i = 0; i < size; i++) {
			// per aggingere valori a una Sequenza si usa nome_sequenza.add(valore)
			// random.nextInt(val) genera un numero casuale da 0 a val
			numeri_random.add(random.nextInt(valore_massimo));
		}

		// scrivo la sequenza in console
		output.print(numeri_random);
	}
}
