import prog.io.ConsoleInputManager;
import java.util.Random;

/**
 * @author Davide Restelli
 */

/*
	!!! --- Ho aggiunti gli input per i vari valori anche se non erano richiesti nel testo dell'esercizio --- !!!

	TESTO ESERCIZIO:
	Sviluppate un'applicazione che fornisca i metodi statici descritti nel seguito, e che testi tali
	metodi generando una matrice di dimensione random contenente valori casuali e
	visualizzando la matrice generata.
		• public static int[][] matriceIntRandom(int righe, int colonne, int bound)
			Costruisce la matrice di int della dimensione specificata in cui le celle contengono valori
			generati a caso compresi fra -bound e bound.
		• public static String toString(int[][] matrice, String sepColonne, String sepRighe)
			Restituisce la stringa che descrive la matrice specificata come argomento in cui i valori nelle
			righe della matrice sono separati dalla stringa sepColonne e le righe sono separate dalla
			stringa sepRighe.
	Esempio di esecuzione:
		== Matrice generata
		5,-7,-5,7,-6,-5
		-7,-3,0,-3,8,7
		3,-2,3,7,1,-7
		-2,4,0,-4,-9,-5
*/
public class EsMatrice1 {

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
					5,1,-3,;					5,1,-3;
					1,3,2,;	 --> con il controllo invece viene -->	1,3,2;
					3,5,-5,;					3,5,-5;
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

	public static void main(String[] args) {
		ConsoleInputManager input = new ConsoleInputManager();

		// spero che queste 3 righe siano abbastanza chiare senza che io debba specificare/spiegare niente :/
		int nRighe = input.readInt("Inserisci il numero delle righe: ");
		int nColonne = input.readInt("Inserisci il numero delle colonne: ");
		int bound = input.readInt("Inserisci il numero massimo che puo' essere generato: ");

		// eseguo la funzione matriceIntRandom con i numeri inseriti dall'utente
		int[][] matrice = matriceIntRandom(nRighe,nColonne,bound);

		System.out.println("== Matrice generata");

		// anche queste spero siano chiare
		int sepColonne = input.readInt("Inserisci il separatore di colonne: ");
		int sepRighe = input.readInt("Inserisci il separatore di righe: ");

		// passo alla funzione toString la matrice e i separatori per le colonne e le righe
		String matrice_stringa = toString(matrice, ",", "");
		// scrivo in console al stringa della matrice
		System.out.println(matrice_stringa);
	}
}
