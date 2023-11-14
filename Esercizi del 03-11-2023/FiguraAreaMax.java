package Esercizi_03_11_2023;


import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Cerchio;
import prog.utili.Figura;
import prog.utili.Quadrato;
import prog.utili.Rettangolo;

import java.util.ArrayList;

/**
 * @author Davide Restelli
 */

/*
	TESTO ESERCIZIO:
	Scrivere un'applicazione "FiguraAreaMax" per determinare
	la figura di area maggiore in una sequenza di figure
	(quadrati, rettangoli e cerchi) fornite da tastiera.

	Esempio di esecuzione:
		la figura di area maggiore è un cerchio
 		raggio = 6.0
 		area = 113.09733552923255 perimetro = 37.69911184307752
*/
public class FiguraAreaMax {

	public static void main(String[] args) {
		// Inizializzo come sempre la classe input e la classe output
		ConsoleOutputManager output = new ConsoleOutputManager();
		ConsoleInputManager input = new ConsoleInputManager();

		// dichiaro l'array che conterra' tutte le nostre figure
		ArrayList<Figura> lista_figure = new ArrayList<Figura>();
		// dichiaro la varriabile per il loop
		// (non la inizializzo perche' tanto nel ciclo sei obbligato a inserire si o no quando viene chiesto di continuare)
		boolean continua;

		// ciclo per tutte le figure, continua a chiedere figure finche l'utente non vuole uscire
		do {
			// chiama la funzione "LeggiFigura" che si occupa di gestire la presa in input delle varie figure
			Figura ultima_figura = LeggiFigura(input, output);
			// se l'ultima fingura inserita NON e' null ALLORA l'aggiungo alla lista
			// questo serve per evitare che se l'utente quando gli viene richesta che tipo di figura inserire "c/q/r" inserisce un'altra lettera
			// genererebbe un errore successivamente
			if(ultima_figura != null) {
				lista_figure.add(ultima_figura);
			}

			continua = input.readSiNo("Continuare? s/n ");
		} while(continua);

		// chiama la funzione "CercaFiguraAreaMaggiore" passandogli l'ArrayList che contiene la lista delle figure
		Figura figura_maggiore = CercaFiguraAreaMaggiore(lista_figure);
		// dichiaro e inizializzo a ""
		String nome_figura = "";

		// controllo che tipo di figura e' la figura maggiore e salvo il nome nella variabile nome_figura
		if(figura_maggiore instanceof Cerchio) {
			nome_figura = "cerchio";
		} else if(figura_maggiore instanceof Quadrato) {
			nome_figura = "quadrato";
		} else {
			// qui non ho messo un altro if(figura_maggiore instanceof Rettangolo) perche' tanto abbiamo solo tre casi
			// quindi se non e' Cerchio e non e' Quadrato e' per forza Rettangolo
			nome_figura = "rettangolo";
		}

		// scrivo di che tipo e' la figura maggiore
		output.println("La figura maggiore e' un " + nome_figura);
		// scrivo perimetro
		output.println("\t Perimetro: " + figura_maggiore.getPerimetro());
		// scrivo area
		output.println("\t Area: " + figura_maggiore.getArea());
		// SE figura_maggiore e' un Cerchio scrivo anche il raggio facendo un cast
		if(figura_maggiore instanceof Cerchio) {
			output.println("\t Raggio: " + ((Cerchio) figura_maggiore).getRaggio());
		}
	}

	// funzione che si occupa della presa in input delle figure
	private static Figura LeggiFigura(ConsoleInputManager input, ConsoleOutputManager output) {
		// chiede che tipo di figura l'utente vuole inserire
		char figura_string = input.readChar("Inserisci il tipo di figura (c/q/r): ");
		// inizializzo una Figura vuota
		Figura figura;

		//  Character.toLowerCase(figura_string) converte tutto il testo da maiuscolo a minuscolo
		// perche' se un'utente inserisce C e' diverso da inserire c.
		switch(Character.toLowerCase(figura_string)) {
			// credo che dentro questo switch sia tutto gia' abbastanza chiaro
			// caso per il cerchio
			case 'c':
				double raggio = input.readDouble("Inserisci il raggio del cerchio: ");
				figura = new Cerchio(raggio);
				break;

			// caso per il quadrato
			case 'q':
				double lato = input.readDouble("Inserisci il lato del quadrato: ");
				figura = new Quadrato(lato);
				break;

			// caso per il rettangolo
			case 'r':
				double base = input.readDouble("Inserisci la base del rettangolo: ");
				double altezza = input.readDouble("Inserisci l'altezza del rettangolo: ");
				figura = new Rettangolo(base, altezza);
				break;

			/*
				Non so' se la prof ha spiegato cos'e' il default nello switch.
				Io lo spiego tanto non mi costa niente, praticamente lo switch seglie di eseguire il codice dentro il default
				quando non c'e' nessun caso che gestisce il valore inserito.
				per esempio in questo caso noi gestiamo i casi c, q ed r. Quindi se io per case decido di inserire "q"
				il programma visto che non trova nessun "case 'u'" esegue il codice che c'e' nel "default"
				!ATTENZIONE! il default NON ha bisogno del break;
			*/
			default:
				// metto a null che poi controllo nel main
				figura = null;
		}
		// ritorno la figura inserita
		return figura;
	}

	/*
		Questa funzione serve a cercare la figura con area maggiore nella lista
		ogni "giro" del for each, controlla se l'area di "figura_maggiore" e' minore dell'area della "figura_corrente"
	 	se trova una corrispondenza rimpiazza la "figura_maggiore" con "figura_corrente"
	*/
	private static Figura CercaFiguraAreaMaggiore(ArrayList<Figura> lista_figure) {
		// inizializzo "figura_maggiore" a null
		Figura figura_maggiore = null;
		// PER ogni figura in lista_figure
		for (Figura figura_corrente : lista_figure) {
			// SE "figura_maggiore" e' UGUALE a null OPPURE l'area di "figura_maggiore" e' MINORE dell'area di "figura_corrente"
			if(figura_maggiore == null || figura_maggiore.getArea() < figura_corrente.getArea()) {
				// rimpiazzo "figura_maggiore" con "figura_corrente"
				figura_maggiore = figura_corrente;
			}
		}
		// ritorno la figura maggiore
		return figura_maggiore;
	}
}
