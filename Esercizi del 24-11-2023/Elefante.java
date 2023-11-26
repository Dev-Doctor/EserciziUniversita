package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public class Elefante extends Mammifero {
	private boolean zanne;

	public Elefante() {
		zanne = false;
	}

	public Elefante(String tipo, int giorniAllattamento, boolean zanne) throws Exception {
		super(tipo, giorniAllattamento);
		this.zanne = zanne;
	}

	public boolean isZanne() {
		return zanne;
	}

	public void setZanne(boolean zanne) {
		this.zanne = zanne;
	}
}
