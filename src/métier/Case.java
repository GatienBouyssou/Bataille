package m�tier;

public class Case {
	
	private boolean estoccup�;
	private boolean dejaTir�;
	private Bateau occupePar;
	
	
	public Case() {
		this.estoccup� = false;
		this.dejaTir� = false;
		this.occupePar = null;
	}


	public boolean getEstoccup�() {
		return estoccup�;
	}


	public void setEstoccup�() {
		this.estoccup� = true;
	}


	public boolean getDejaTir�() {
		return dejaTir�;
	}


	public void setDejaTir�() {
		this.dejaTir� = true;
	}


	public Bateau getOccupePar() {
		return occupePar;
	}


	public void setOccupePar(Bateau occupePar) {
		this.occupePar = occupePar;
	} 
	

}
