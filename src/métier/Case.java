package métier;

public class Case {
	
	private boolean estoccupé;
	private boolean dejaTiré;
	private Bateau occupePar;
	
	
	public Case() {
		this.estoccupé = false;
		this.dejaTiré = false;
		this.occupePar = null;
	}


	public boolean getEstoccupé() {
		return estoccupé;
	}


	public void setEstoccupé() {
		this.estoccupé = true;
	}


	public boolean getDejaTiré() {
		return dejaTiré;
	}


	public void setDejaTiré() {
		this.dejaTiré = true;
	}


	public Bateau getOccupePar() {
		return occupePar;
	}


	public void setOccupePar(Bateau occupePar) {
		this.occupePar = occupePar;
	} 
	

}
