package Esercizi_24_11_2023;

import java.util.ArrayList;

/**
 * @author Davide Restelli
 */

public class Main {
	public static void main(String[] args) {
		ArrayList<Animale> animali = new ArrayList<Animale>();

		AddParrot(animali, "amazzone", 3, "blu/rosse");
		AddParrot(animali, "cacatua", 2, "giallo/verde");
		AddParrot(animali, "caicco", 5, "rosa/nero");
		AddParrot(animali, "ara", 1, "celesti");
		AddParrot(animali, "cocorita", 4, "bianche");

		AddTiger(animali, "siberiana", 200, "bianco");
		AddTiger(animali, "della Cina meridionale", 250, "bianco/nero");
		AddTiger(animali, "indocinese", 300, "rosso/nero");
		AddTiger(animali, "malese", 760, "rosso/bianco/nero");

		AddEagle(animali, "pescatrice", 5, 2f);
		AddEagle(animali, "reale", 3, 1.9f);
		AddEagle(animali, "testa bianca", 2, 2.3f);

		System.out.println("Animali osservati: ");
		for (Animale animale : animali) {
			System.out.println("\t - " + animale.toString());
		}
	}

	public static void AddEagle(ArrayList<Animale> animali, String tipo,
								int numeroUova, float aperturaAlare) {
		try {
			animali.add(new Aquila(tipo, numeroUova, aperturaAlare));
		} catch (Exception e) {
			System.out.printf("Errore nella creazione di un'Aquila %s: %s",
					tipo,
					e.getMessage()
			);
		}
	}

	public static void AddTiger(ArrayList<Animale> animali, String tipo,
								int giorniAllattamento, String coloreMantello) {
		try {
			animali.add(new Tigre(tipo, giorniAllattamento, coloreMantello));
		} catch (Exception e) {
			System.out.printf("Errore nella creazione di una Tigre %s: %s\n",
					tipo,
					e.getMessage()
			);
		}
	}
	private static void AddParrot(ArrayList<Animale> animali, String tipo,
								  int numeroUova, String colorePiume) {
		try {
			animali.add(new Pappagallo(tipo, numeroUova, colorePiume));
		} catch (Exception e) {
			System.out.printf("Errore nella creazione di un Pappagallo %s: %s\n",
					tipo,
					e.getMessage()
			);
		}
	}
}
