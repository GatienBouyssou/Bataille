package métier;

public class Jeu {
	 
	
	public static void main(String[] args) {
		// ne sait pas quoi en faire doit on les instancier dans plateau ?
		Joueur joueur1 = new Joueur("joueur1");
		Joueur joueur2 = new Joueur("joueur2");

		// variables qui peuvent être aussi choisies par l'utilisateur  
		final  int nbrDeBatParJoueur = 5;
		final int largeurDuPlateau = 10;
		 
		
		Plateau platJoueur1  = new Plateau(largeurDuPlateau);
		Plateau platJoueur2 = new Plateau(largeurDuPlateau);
		
		// Création des bateux du joueur 1 
		Bateau[] tabBatJ1 = new Bateau[nbrDeBatParJoueur];
		tabBatJ1[0]=new Bateau("bat1", 2, true);
		tabBatJ1[1]=new Bateau("bat2", 3, false);
		tabBatJ1[2]=new Bateau("bat3", 3, true);
		tabBatJ1[3]=new Bateau("bat4", 4, false);
		tabBatJ1[4]=new Bateau("bat5", 5, true);
		
		// création des bateaux du joueur 2
		Bateau[] tabBatJ2 = new Bateau[nbrDeBatParJoueur];
		tabBatJ2[0]=new Bateau("bat1", 2, true);
		tabBatJ2[1]=new Bateau("bat2", 3, false);
		tabBatJ2[2]=new Bateau("bat3", 3, true);
		tabBatJ2[3]=new Bateau("bat4", 4, false);
		tabBatJ2[4]=new Bateau("bat5", 5, true);
		
		// variables annexes 
		boolean gagnant = false;
		int nbrTour = 0;
		
		System.out.println("Positionnez vos bateaux");
		System.out.println("Le joueur 1 positionne ses bateaux");
		
		
		platJoueur1.positionner(tabBatJ1[0], 5, 3);
		System.out.println("oui");
		//platJoueur1.positionner(tabBatJ1[1], 8, 3);
//		platJoueur1.positionner(tabBatJ1[2], 5, 3);
//		platJoueur1.positionner(tabBatJ1[3], 5, 3);
//		platJoueur1.positionner(tabBatJ1[4], 5, 3);
		
		
		//Phase de jeu réel
		while (gagnant == false) {
			//Tour du joueur 1
			platJoueur2.tirer(5, 3);
			for (int i = 0; i < tabBatJ2.length; i++) {
				gagnant = true;
				if(tabBatJ2[i].isestCoulé() == false){
					gagnant = false;
				}
			}
			//Ce joueur a t il gagné ?
			if (gagnant) {
				System.out.println("Le joueur 1 a gagné !");
			}
			
			
			//Tour du joueur 2
			platJoueur1.tirer(5, 3);
			for (int i = 0; i < tabBatJ1.length; i++) {
				if(tabBatJ1[i].isestCoulé() == false){
					gagnant = false;
				}
			}
			
			if (gagnant) {
				System.out.println("Le joueur 1 a gagné !");
			}
		}
		
		
	
	}
	
}
