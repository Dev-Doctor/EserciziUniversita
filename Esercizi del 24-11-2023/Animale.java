package Esercizi_24_11_2023;

/**
 * @author Davide Restelli
 */

public abstract class Animale {
	private String tipo;

	public Animale() {
		tipo = "";
	}

	public Animale(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
