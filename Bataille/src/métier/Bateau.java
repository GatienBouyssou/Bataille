package m�tier;

public class Bateau {
	
	private final String nom;
	private final int taille;
	private int ptDeVie;
	private boolean estCoul�;
	private boolean estVertical;
	
	public Bateau(String nom, int taille, boolean estVertical) {
		this.taille = taille;
		this.ptDeVie = taille;
		this.estCoul� = false;
		this.estVertical = estVertical;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public boolean isEstVertical() {
		return estVertical;
	}

	public void setEstVertical(boolean estVertical) {
		this.estVertical = estVertical;
	}

	public int getTaille() {
		return taille;
	}


	public int getPtDeVie() {
		return ptDeVie;
	}

	public void setPtDeVie(int ptDeVie) {
		this.ptDeVie = ptDeVie;
	}

	public boolean isestCoul�() {
		return estCoul�;
	}

	public void setestCoul�() {
		this.estCoul� = true;
	}
	
	
	
	
}
