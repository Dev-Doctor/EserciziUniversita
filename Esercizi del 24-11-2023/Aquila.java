package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public class Aquila extends Ucello {
	private float aperturaAlare;

	public Aquila() {
		aperturaAlare = 0;
	}

	public Aquila(String tipo, int numeroUova, float aperturaAlare) {
		super(tipo, numeroUova);
		this.aperturaAlare = aperturaAlare;
	}

	public float getAperturaAlare() {
		return aperturaAlare;
	}

	public void setAperturaAlare(float aperturaAlare) {
		this.aperturaAlare = aperturaAlare;
	}

	@Override
	public String toString() {
		return String.format(
				"Aquila %s, con apertura alare di %f m, ha deposto %d uova.",
				getTipo(),
				aperturaAlare,
				getNumeroUova()
		);
	}
}
