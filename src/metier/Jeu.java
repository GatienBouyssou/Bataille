package metier;


public class Jeu {
	private boolean gagnant;
	private int tour;
	
	public Jeu() {
		this.gagnant = false;
		this.tour = 1;
	}
	 
	public boolean estGagnant(Plateau plat){
		if((plat.getNbrBat3() == 0) && (plat.getNbrBat4()== 0) && (plat.getNbrBat5() == 0)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean getGagnant() {
		return gagnant;
	}

	public void setGagnant() {
		this.gagnant = true;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

}
