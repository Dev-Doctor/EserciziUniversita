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
	!!! --- In questa versione utilizzo un'ArrayList (superiore a Sequenza della libreria del libro ma simile) --- !!!
	!!! --- L'ArrayList E' LO STANDARD, QUINDI E' CONSIGLIABILE IMPARARE A USARE QUELLO AL POST DI Sequenza --- !!!

	TESTO ESERCIZIO:

	Scrivere un'applicazione "ElencaFigure" il cui compito
	consiste nel leggere i dati relativi a una sequenza di figure
	(quadrati, rettangoli e cerchi) e nel produrre un elenco
	di tutte le figure inserite, suddiviso per tipo

	Esempio di esecuzione:

		*** ELENCO DEI CERCHI ***
			raggio = 5.0
			raggio = 2.0

		*** ELENCO DEI QUADRATI ***
			lato = 6.0
			lato = 7.0

		*** ELENCO DEI RETTANGOLI ***
			base = 2.0, altezza = 3.0
 */

public class ElencaFigure {

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
			if (ultima_figura != null) {
				lista_figure.add(ultima_figura);
			}

			continua = input.readSiNo("Continuare? s/n ");
		} while (continua);

		// inizializzo variabili che conterrano scritto i risultati
		String messaggio_cerchi = "*** ELENCO DEI CERCHI ***\n";
		String messaggio_quadrati = "*** ELENCO DEI QUADRATI ***\n";
		String messaggio_rettangoli = "*** ELENCO DEI RETTANGOLI ***\n";

		// PER OGNI figura in lista_figure
		for (Figura figura_corrente : lista_figure) {

			/*
				!!! /|\ !!!

				gli \t servono per scrivere il carattere di quando premi TAB sulla tastiera, prova a premerlo
				gli \n servono per andare a capo poi nel risultato, praticamente dicono al programma di interrompere la riga corrente e quindi di andare a capo

				\t e \n in questo programma sono completamente estetici e se non messi non cambiano il risultato del programma,
				comunque non vanno rimossi perche' rendono la visualizzazione del risultato molto piu' piacevole da leggere
				e molto spesso questo vuol dire avere qualche punto in piu' quando viene valutato il codice che non fanno mai male

				!!! \|/ !!!
			*/

			// SE e' un cerchio
			if (figura_corrente instanceof Cerchio) {
				// aggiungi alla fine della variabile "messaggio_cerchi" i relativi dati della figura corrente
				messaggio_cerchi += "\traggio = " + ((Cerchio) figura_corrente).getRaggio() + "\n";
				// SE e' un quadrato
			} else if (figura_corrente instanceof Quadrato) {
				// aggiungi alla fine della variabile "messaggio_quadrati" i relativi dati della figura corrente
				messaggio_quadrati += "\tlato = " + ((Quadrato) figura_corrente).getLato() + "\n";
				// oppure (se e' un rettangolo visto che abbiamo solo 3 opzioni non serve rimettere else if ma solo else)
			} else {
				// aggiungi alla fine della variabile "messaggio_rettangoli" i relativi dati della figura corrente
				messaggio_rettangoli += "\tbase = " + ((Rettangolo) figura_corrente).getBase() + " , Altezza = " + ((Rettangolo) figura_corrente).getAltezza() + "\n";
			}
		}
		// scrivi a schermo tutti i dati
		output.println(messaggio_cerchi);
		output.println(messaggio_quadrati);
		output.println(messaggio_rettangoli);
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
}
