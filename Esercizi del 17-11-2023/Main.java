
/**
 * @author Davide Restelli
 */

public class Main {
	public static void main(String[] args) {
//		CREAZIONE STUDENTI
		Studente davide = new Studente("Davide", "Restelli", 69420);
		Studente francesca = new Studente("Francesca", "Cognome", 53134);
		Studente another_one = new Studente("Elizabeth", "Booker", 77);

//		CREAZIONE PROFESSORI
		Docente davide_docente = new Docente("Davide", "Tosi", "architettura degli elaborati");
		Docente silvia_docente = new Docente("Silvia", "Corchs", "informatica");
		Docente samantha = new Docente("Barbara", "Fagiolini",  "algebra & geometria");

//		CREAZIONI CORSI
		Corso algebra_geometria = new Corso("Algebra & Geometria", 0, samantha);
		Corso architettura = new Corso("Architettura degli Elaborati", 1, davide_docente);
		Corso informatica = new Corso("Informatica", 2, silvia_docente);
		Corso base_dati = new Corso("Base di Dati", 3, silvia_docente);
		Corso come_volare = new Corso("Come Volare", 4, samantha);

//		AGGIUNGO AGLI STUDENTI I CORSI
		davide.SeguiCorso(informatica);
		davide.SeguiCorso(algebra_geometria);
		davide.SeguiCorso(architettura);

//		Scrivo a schermo il
		System.out.println(davide.toString());



	}
}
