package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public abstract class Ucello extends Animale {
	private int numeroUova;

	public Ucello() {
		numeroUova = 0;
	}

	public Ucello(String tipo, int numeroUova) {
		super(tipo);
		this.numeroUova = numeroUova;
	}

	public int getNumeroUova() {
		return numeroUova;
	}

	public void setNumeroUova(int numeroUova) {
		this.numeroUova = numeroUova;
	}
}
