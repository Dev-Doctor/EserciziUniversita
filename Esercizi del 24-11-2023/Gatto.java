package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public class Gatto extends Mammifero {
	private String coloreDelPelo;

	public Gatto() {
		coloreDelPelo = "";
	}

	public Gatto(String tipo, int giorniAllattamento, String colorePelo) throws Exception {
		super(tipo, giorniAllattamento);
		this.coloreDelPelo = colorePelo;
	}

	public String getColoreDelPelo() {
		return coloreDelPelo;
	}

	public void setColoreDelPelo(String coloreDelPelo) {
		this.coloreDelPelo = coloreDelPelo;
	}

	@Override
	public String toString() {
		return String.format(
			"Gatto %s, con pelo di colore \'%s\', ha allattato i suoi piccoli per %d giorni.",
			getTipo(),
			coloreDelPelo,
			getGiorniAllattamento()
		);
	}
}
