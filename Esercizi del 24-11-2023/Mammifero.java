package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public abstract class Mammifero extends Animale {
	private static final int MAX_GIORNI_ALLATTAMENTO = 700;
	private int giorniAllattamento;

	public Mammifero() {
		giorniAllattamento = 0;
	}

	public Mammifero(String tipo, int giorniAllattamento) throws Exception {
		super(tipo);
		this.setGiorniAllattamento(giorniAllattamento);
	}

	public int getGiorniAllattamento() {
		return giorniAllattamento;
	}

	public void setGiorniAllattamento(int giorniAllattamento) throws Exception {
		if(giorniAllattamento < 0 || giorniAllattamento > MAX_GIORNI_ALLATTAMENTO) {
			throw new Exception(
					String.format(
							"Il numero di giorni deve essere inferiore a %d (corrente: %d)",
							MAX_GIORNI_ALLATTAMENTO,
							giorniAllattamento
					)
			);
		}
		this.giorniAllattamento = giorniAllattamento;
	}
}
