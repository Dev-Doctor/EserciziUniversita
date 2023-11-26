package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public class Pappagallo extends Ucello {
	private String colorazionePiume;

	public Pappagallo() {
		colorazionePiume = "";
	}

	public Pappagallo(String tipo, int numeroUova, String colorazionePiume) {
		super(tipo, numeroUova);
		this.colorazionePiume = colorazionePiume;
	}

	public String getColorazionePiume() {
		return colorazionePiume;
	}

	public void setColorazionePiume(String colorazionePiume) {
		this.colorazionePiume = colorazionePiume;
	}

	@Override
	public String toString() {
		return String.format(
				"Pappagallo %s, con piume \'%s\', ha deposto %d uova.",
				getTipo(),
				colorazionePiume,
				getNumeroUova()
		);
	}
}
