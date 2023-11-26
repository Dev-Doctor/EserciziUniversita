
/**
 * @author Davide Restelli
 */

public class Corso {
	private String nomeCorso;
	private int codiceCorso;
	private Docente docenteCorso;

	public Corso(String nomeCorso, int codiceCorso, Docente docenteCorso) {
		this.nomeCorso = nomeCorso;
		this.codiceCorso = codiceCorso;
		this.docenteCorso = docenteCorso;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public int getCodiceCorso() {
		return codiceCorso;
	}

	public Docente getDocenteCorso() {
		return docenteCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public void setCodiceCorso(int codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	@Override
	public String toString() {
		return nomeCorso + "(" + codiceCorso + ")";
	}
}
