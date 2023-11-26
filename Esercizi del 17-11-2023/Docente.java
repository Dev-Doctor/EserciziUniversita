
/**
 * @author Davide Restelli
 */

public class Docente {
	private String nome;
	private String cognome;
	private String materia;

	public Docente(String nome, String cognome, String materia) {
		this.nome = nome;
		this.cognome = cognome;
		this.materia = materia;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getMateria() {
		return materia;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return nome + " " + cognome;
	}
}
