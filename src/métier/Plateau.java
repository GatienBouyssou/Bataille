package m�tier;

public class Plateau {
	
	private Case[][] plat;
	private final int taillePlat;
	
	public Plateau(int taillePlat) {
		this.plat = new Case[taillePlat][taillePlat]; 
		for (int i = 0; i < plat.length; i++) {
			for (int j = 0; j < plat.length; j++) {
				this.plat[i][j] = new Case();
			}
		}
		this.taillePlat = taillePlat;
	}
	
	
	public boolean emplcmtDisp(int x, int y){
		if(plat[x][y].getEstoccup�()){
			return false;
		} 
		else{
			return true;
		}
	}
	
	public void positionner(Bateau bat, int x, int y){
		
		boolean peutPosit = false;
		
		System.out.println(bat.isEstVertical());
		if (bat.isEstVertical()) {
			
	
			while (peutPosit == false) {
				
				// faire un scanner pour ressaisir les valeurs 
				
				peutPosit = true;
				System.out.println(peutPosit);
				System.out.println(y + bat.getTaille());
				System.out.println(this.taillePlat);
				//v�rifie que le bateau loge bien dans la grille
				if (((y + bat.getTaille()) > this.taillePlat) || (y < 0)) {
					System.out.println("vous ne pouvez pas posez votre bateau en dehors de la grille !");
					peutPosit = false;
				}
				else{
					
					// v�rifie qu'il n'y a pas de bateau � l'endroit ou l'on veut le poser 
					for (int i = 0; i < bat.getTaille(); i++) {
						if (this.plat[x + i][y].getEstoccup�()) {
							peutPosit = false;
							System.out.println("La case est occup�");
						}
					}
					
				}				
				
				
				System.out.println(peutPosit);
			}
			
			// Positionne le bateau case � case
			for (int i = 0; i < bat.getTaille(); i++) {
				this.plat[x][y + i].setEstoccup�();
				this.plat[x][y + i].setOccupePar(bat);
			}
		
			
		}
		else {
			
			while (peutPosit == false) {
				
				// faire un scanner pour ressaisir les valeurs 
				
				peutPosit = true;
				System.out.println(this.taillePlat);
				//v�rifie que le bateau loge bien dans la grille
				if (((x + bat.getTaille()) > this.taillePlat) || (y < 0)) {
					System.out.println("vous ne pouvez pas posez votre bateau en dehors de la grille !");
					peutPosit = false;
				}
				else
				{
					
					// v�rifie qu'il n'y a pas de bateau � l'endroit ou l'on veut le poser 
					for (int i = 0; i < bat.getTaille(); i++) {
						System.out.println("la");
						if (this.plat[x][y + i].getEstoccup�()) {
							peutPosit = false;
							System.out.println("il y a d�j� un bateau ");
						}
					}
					
				}				
				System.out.println(peutPosit);
				
			}
			
			//Positionne le bateau case � case
			for (int i = 0; i < bat.getTaille(); i++) {
				this.plat[x + i][y].setEstoccup�();		
				this.plat[x][y + i].setOccupePar(bat);
			}
		
		} 
	}
	
	public void tirer( int x , int y){
		
		while(this.plat[x][y].getDejaTir�()) {
			System.out.println("Vous avez d�j� tir� sur cette case");
			//scanner x,y
		} 
		
		
		// Fait que le joueur ne puisse plus tirer sur cette case
		this.plat[x][y].setDejaTir�();
		
		//Test si un bateau est touch�
		if (this.plat[x][y].getEstoccup�()) {
			System.out.println("Touch� !");
			//enl�ve un point de vie au bateau 
			
			this.plat[x][y].getOccupePar().setPtDeVie(this.plat[x][y].getOccupePar().getPtDeVie() - 1);
			System.out.println(this.plat[x][y].getOccupePar().getPtDeVie());
			
			//v�rifie si le bateau est coul�
			if (this.plat[x][y].getOccupePar().getPtDeVie() == 0) {
				System.out.println("Coul� !");
				this.plat[x][y].getOccupePar().setestCoul�();
			}
		}
		else{
			System.out.println("A l'eau");
			
		}
				
	}

}
