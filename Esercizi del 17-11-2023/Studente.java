import java.util.ArrayList;

/**
 * @author Davide Restelli
 */

public class Studente {
	private static int MAX_CORSI = 5;
	private String nome;
	private String cognome;
	private int matricola;
	private ArrayList<Corso> corsiSeguiti;

	public Studente(String nome, String  cognome, int matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.corsiSeguiti = new ArrayList<Corso>();
	}

	public void SeguiCorso(Corso corso) {
		if(!IsCorsoSeguito(corso) && corsiSeguiti.size() < MAX_CORSI) {
			corsiSeguiti.add(corso);
		}
	}

	public boolean IsCorsoSeguito(Corso daControllare) {
		for(Corso corso : corsiSeguiti) {
			if(corso.getCodiceCorso() == daControllare.getCodiceCorso()) {
				return true;
			}
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		String risultato = "Nome: " + nome + "\nCognome: " + cognome + "\nMatricola: " + matricola + "\nCorsi Seguiti (" + corsiSeguiti.size() + "/" + MAX_CORSI + "):";
		for (Corso c : corsiSeguiti) {
			Docente docente_corso = c.getDocenteCorso();
			risultato += "\n\t- " +c.getNomeCorso() + " (" + docente_corso.toString() + ")";
		}
		return risultato;
	}
}
