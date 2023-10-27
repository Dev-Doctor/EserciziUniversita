package Esercizi_27_10_2023;

import prog.io.*;
import java.util.Random;

/**
 * @author Davide Restelli
 */

/*
	!!! --- In questa versione utilizzo un Array normale --- !!!

	TESTO ESERCIZIO:
	Scrivete un'applicazione che generi un array di interi pseudocasuali e lo visualizzi a video. La
	dimensione dell'array e il valore massimo dei valori da generare devono essere forniti come
	input dall'utente. Usare la classe java.util.Random.

	Inserisci la dimensione dell'array : 10
	Inserisci il valore massimo da generare : 100
	[59,99,98,81,63,56,12,56,91,8]
 */

public class ArrayRandomPositivi {

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
		Integer[] numeri_random = new Integer[size];
		// per ogni casella dell'array genero un numero casuale
		// uso un FOR e NON un FOR EACH perche' usando questi tipi di array serve una variabile che fa' da puntatore (in questo caso i)
		for(int i = 0; i < numeri_random.length; i++) {
			numeri_random[i] = random.nextInt(valore_massimo);
		}

		// scrivo in console tutti i numeri generati separati da una virgola
		for(int numero : numeri_random) {
			output.print(numero + ",");
		}
	}
}
