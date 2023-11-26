package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public class Cane extends Mammifero {
	private boolean randagio;

	public Cane() {
		randagio = false;
	}

	public Cane(String tipo, int giorniAllattamento, boolean randagio) throws Exception {
		super(tipo, giorniAllattamento);
		this.randagio = randagio;
	}

	public boolean isRandagio() {
		return randagio;
	}

	public void setRandagio(boolean randagio) {
		this.randagio = randagio;
	}
}
