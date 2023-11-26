package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public class Tigre extends Mammifero {
	private String coloreMantello;

	public Tigre() {
		coloreMantello = "";
	}

	public Tigre(String tipo, int giorniAllattamento, String coloreMantello) throws Exception {
		super(tipo, giorniAllattamento);
		this.coloreMantello = coloreMantello;
	}

	public String getColoreMantello() {
		return coloreMantello;
	}

	public void setColoreMantello(String coloreMantello) {
		this.coloreMantello = coloreMantello;
	}

	@Override
	public String toString() {
		return String.format(
			"Tigre %s, con mantello di colore \'%s\', ha allattato i suoi piccoli per %d giorni.",
				getTipo(),
				getColoreMantello(),
				getGiorniAllattamento()
		);
	}
}
