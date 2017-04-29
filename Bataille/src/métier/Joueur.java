package métier;

public class Joueur {
	
	private int score;
	private String nom;
	//private int nbrDeBat;
	
	public Joueur(String nom){
		this.score = 0;
		this.nom = nom;
		//this.nbrDeBat=5;
	}

//	public int getNbrDeBat() {
//		return nbrDeBat;
//	}
//
//	public void setNbrDeBat(int nbrDeBat) {
//		this.nbrDeBat = nbrDeBat;
//	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
