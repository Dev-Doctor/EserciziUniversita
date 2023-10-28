import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Davide Restelli
 */

/*
	!!! --- Ho aggiunti gli input per i vari valori anche se non erano richiesti nel testo dell'esercizio --- !!!

	TESTO ESERCIZIO:
	Estendete l'esercizio precedente in modo che l'applicazione:
		• calcoli e visualizzi la somma dei valori contenuti nella matrice
		• verifichi se la matrice è quadrata e in tal caso determini e visualizzi la diagonale della
			matrice.
	Esempio di esecuzione:
		== Matrice generata
		-9,7,3
		-9,-6,-1
		-7,6,9
		La somma dei valori contenuti nella matrice è -7
		La matrice è quadrata
		La diagonale è [-9,-6,9]
	Esempio di esecuzione:
		== Matrice generata
		-4,-1,4,4,1
		-4,-1,-2,9,6
		La somma dei valori contenuti nella matrice è 12
		La matrice non è quadrata.
*/
public class EsMatrice2 {

	public static int[][] matriceIntRandom(int righe, int colonne, int bound) {
		int[][] matrix = new int[colonne][righe];
		Random random = new Random();
		// dichiaro la variabile negative_bound che da come risultato il valore bould ma negativo (perche' un numero * -1 restituisce lo stesso numero ma negativo, dovresti saperlo :) )
		int negative_bound = bound * -1;

		for(int i = 0; i < colonne; i++) {
			for(int j = 0; j < righe; j++) {
				/*
				La formula utilizza in questo caso e' la seguente: ((max - min) + 1) + min;

				in questo caso visto che max e min sono lo stesso numero, cioe' vogliamo numeri che vanno come nell'esempio
				fornito dalla prof da 100 a -100 usiamo la stessa variabile, che e' la grandezza massima inserita dall'utente
				*/
				matrix[i][j] = random.nextInt((bound - negative_bound) + 1) + negative_bound;
			}
		}

		// restituisce la matrice generata
		return matrix;
	}

	/*
		funzione che presa in input
			- una matrice di interi
			- una stringa che serve per separare le colonne
			- una stringa che serve per separare le righe
		restituisce una stringa generata che rappresenta la matrice passata
	 */
	//									↓ Matrice		↓ separatore colonne	↓ separatore righe
	public static String toString(int[][] matrice, String sepColonne, String sepRighe) {
		// inizializzo la stringa con niente all'interno, le virgolette vuote sono ESTREMAMENTE importanti se non ci fossero il += darebbe un errore
		// visto che la variabile sarebbe nulla
		String matrice_stringa = "";

		for(int i = 0; i < matrice.length; i++) {
			for(int j = 0; j < matrice[1].length; j++) {
				/*
					controlla se j (colonna) e' diverso dal massimo
						se matrice[1].length (le colonne) e' 10
						il numero massimo raggiungibile da j e' 9 perche' c'e' un < e non un <= nel for
						quindi sommandogli 1 e' uguale al numero di colonne della matrice
					questo serve per far si che nella stringa alla fine della riga non ci sia anche il simbolo della divisione della colonna (oltre che quello della riga)
					ESEMPIO: se il simbolo separatore delle colonne e' "," e quello di fine riga e' ";"
						senza questo semplice controllo verrebbe:
					5,1,-3,;										5,1,-3;
					1,3,2,;	 --> con il controllo invece viene -->	1,3,2;
					3,5,-5,;										3,5,-5;
				*/
				if(j + 1 != matrice[1].length) {
					// aggiungi il valore della cella piu' il separatore delle colonne alla fine della stringa
					matrice_stringa += matrice[i][j] + sepColonne;
				} else {
					// INVECE aggiungici solo il valore della cella alla fine della stringa
					matrice_stringa += matrice[i][j];
				}
			}
			// alla fine di tutte le colonne per la singola riga aggiungi il separatore di stringhe e vai a capo
			matrice_stringa += sepRighe + "\n";
		}
		// restituisce la stringa finita
		return matrice_stringa;
	}

	public static int CalcolaTotateMatrice(int[][] matrice) {
		int somma_totale = 0;
		for(int i = 0; i < matrice.length; i++) {
			for(int j = 0; j < matrice[1].length; j++) {
				somma_totale += matrice[i][j];
			}
		}
		return somma_totale;
	}

	// La funziona prende in input una matrice e restituisce un'ArrayList con dentro tutti i valori della diagonale
	public static ArrayList<Integer> OttieniDiagonale(int[][] matrice) {
		// inizializza l'ArrayList
		ArrayList<Integer> diagonale = new ArrayList<Integer>();
		/*
			doppio FOR come sempre per ciclare una matrice,
					!!! - NOTA BENE - !!!
			Sto usando una sola grandezza come limite della grandezza della matrice.
			Inteso: sto usando solo matrice.lenght (righe/verticale) e non anche matrice[0].lenght (colonne/orizzontale)
			perche' il controllo per questa funzione in questo programma viene fatto priama di chiamarla/convocarla
			se venisse eseguita senza l'IF (matrice.length == matrice[0].length)
			darebbe errore se la matrice non fosse quadrata
			Spero di essermi speigato ¯\_(ツ)_/¯
		 */
		for(int i = 0; i < matrice.length; i++) {
			for(int j = 0; j < matrice.length; j++) {
				// i valori della diagonale sono sempre quelli dove le cordinate della casella coincidono,
				// ce l'hanno spiegato anche in matematica
				if (i == j) {
					// aggiungilo all'array diagonale che contiene tutti i valori della diagonale
					diagonale.add(matrice[i][j]);
				}
			}
		}
		return diagonale;
	}

	public static void main(String[] args) {
		// input e output della libreria del libro
		ConsoleInputManager input = new ConsoleInputManager();
		ConsoleOutputManager output = new ConsoleOutputManager();

		// spero che queste 3 righe siano abbastanza chiare senza che io debba specificare/spiegare niente :/
		int nRighe = input.readInt("Inserisci il numero delle righe: ");
		int nColonne = input.readInt("Inserisci il numero delle colonne: ");
		int bound = input.readInt("Inserisci il numero massimo che puo' essere generato: ");

		// eseguo la funzione matriceIntRandom con i numeri inseriti dall'utente
		int[][] matrice = matriceIntRandom(nRighe,nColonne,bound);

		output.println("== Matrice generata");

		// passo alla funzione toString la matrice e i separatori per le colonne e le righe
		String matrice_stringa = toString(matrice, ",", "");
		output.println(matrice_stringa);

		// passo alla funziona CalcolaTotateMatrice la matrice e ottengo la somma di tutte le caselle
		int somma_matrice = CalcolaTotateMatrice(matrice);
		// scrivo a schermo la somma di tutte le celle
		output.println("La somma dei valori contenuti nella matrice è: " + somma_matrice);

		// SE la lunghezza dei due array e' uguale vuol dire che la matrice e' un quadrato
		if(matrice.length == matrice[0].length) {
			// QUINDI scrivi a schermo che la matrice e' quadrata
			output.println("La matrice è quadrata");
			// eseguo la funzione OttieniDiagonale passando come parametro la matrice e restituisce un'ArrayList con dentro tutti i valori di qui e' composta la diagonale
			// !!! --- L'ARRAYLIST E' PRATICAMENTE UGUALE ALL'OGGETTO DELLA LIBRERIA DEL LIBRO CHIAMATO "SEQUENZA" --- !!!
			// ho preferito utilizzare l'ArrayList che la Sequenza
			ArrayList<Integer> diagonale = OttieniDiagonale(matrice);
			// scrive a schermo tutti i valori della diagonale
			output.println("La diagonale è " + diagonale);
		} else {
			// ALTRIMENTI se i due array non sono grandi uguali, vuol dire che non e' un quadrato quindi scrivi a schermo che non e' una matrice quadrata
			output.println("La matrice non e' quadrata");
		}
	}
}
