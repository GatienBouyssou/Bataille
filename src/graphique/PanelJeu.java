package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Bateau;
import metier.Plateau;
import metier.Jeu;

public class PanelJeu extends JPanel {
	
	// private JLabel jl_Score= new JLabel("Score :");
	// private JLabel jl_NbrBateau = new JLabel("Nombre Bateau :");
	// private JLabel jl_Case= new JLabel("Case Selectionné :");
	// private JButton jb_Tirer= new JButton("Tirer!");
	// private JLabel jl_etat= new JLabel("");

	private JLabel jl_titre = new JLabel("Paramètre de Jeu");
	private JPanel jp_param = new JPanel();
	private JPanel jp_placementBateau= new JPanel();
	private JLabel jl_taillePlateau = new JLabel("Quelle dimension de plateau ");
	private JPanel jp_taillePlateau = new JPanel();
	private JButton jb_validerParametre = new JButton("Valider param");
	private JTextField jtf_Platx = new JTextField();
	private JLabel jl_par = new JLabel("par");
	private JTextField jtf_Platy = new JTextField();
	
	private JRadioButton jrb_3 = new JRadioButton("Bateau de 3");
	private JRadioButton jrb_4 = new JRadioButton("Bateau de 4");
	private JRadioButton jrb_5 = new JRadioButton("Bateau de 5");
	

	private JLabel jl_sensBateau = new JLabel("Choisir le sens : ");
	private JRadioButton jrb_vertical = new JRadioButton("Vertical");
	private JRadioButton jrb_horizontal = new JRadioButton("Horizontal");

	//partie du jeu
	//partie de gauche purement informative
	private JPanel jp_jeu = new JPanel();
	private JLabel jl_joueur1 = new JLabel("Joueur1");
	private JLabel jl_joueur2 = new JLabel("Joueur2");
	private JLabel jl_score = new JLabel("score : ");
	private JLabel jl_score1 = new JLabel("score : ");
	private JLabel jl_scorej1 = new JLabel("0");
	private JLabel jl_scorej2 = new JLabel("0");
	private JLabel jl_rien = new JLabel(" ");
	private JLabel jl_rien2 = new JLabel(" ");
	private JLabel jl_commentaire = new JLabel("Cliquer sur une case pour tirer");
	//Le plateau avec des cases
	private JPanel jp_tabjeu1 = new JPanel();
	private JPanel jp_tabjeu2 = new JPanel();
	private Jeu jeu = new Jeu();
	
	
	
	
	private JLabel jl_nbrBateau3 = new JLabel("Combien voulez vous de bateau (3)");
	private JTextField jtf_nbrBateau3 = new JTextField();
	private JLabel jl_nbrBateau4 = new JLabel("Combien voulez vous de bateau (4)");
	private JTextField jtf_nbrBateau4 = new JTextField();
	private JLabel jl_nbrBateau5 = new JLabel("Combien voulez vous de bateau (5)");
	private JTextField jtf_nbrBateau5 = new JTextField();
	
	
	private JPanel jp_tableau = new JPanel();

	private int rows;
	private int cols;
	private int tailleBat;
	private boolean isVertical=true;
	private JButton tableauBouton[][] = new JButton[50][50];
	private JPanel jp_boutonDemarrer = new JPanel();
	private JButton bouton = new JButton("Demarrer");
	// attention modification valeur mise par défault ici
	private Plateau plat = new Plateau(10, 10, 0, 0, 0);
	
	private Plateau platJoueur;
	private Plateau platJoueur1;
	private Plateau platJoueur2;
	private int AQuiLeTour=1;
	private JButton jb_validerPlateau = new JButton("Valider");

	public PanelJeu(){
			this.setLayout(new BorderLayout());
			this.add(bouton, BorderLayout.CENTER);
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					parametre();
				}
			});
			jb_validerParametre.addActionListener(new ActionListener() {
				
//				
				@Override
				public void actionPerformed(ActionEvent e) {
					try{
					platJoueur = new Plateau(Integer.valueOf(jtf_Platx.getText()), Integer.valueOf(jtf_Platy.getText()),Integer.valueOf(jtf_nbrBateau3.getText()), Integer.valueOf(jtf_nbrBateau4.getText()), Integer.valueOf(jtf_nbrBateau5.getText()) );
					if(platJoueur.PlateauSuffisant()){
					CreerTableau();
					}
					else{
						System.out.println("Espace pas suffisant");
					}
					}catch( NumberFormatException nfe){
						System.out.println("Saisir des chiffres");
					}
				}
			});
			jb_validerPlateau.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(AQuiLeTour==1){
						System.out.println("oui");
						platJoueur1=platJoueur;
						platJoueur = new Plateau(Integer.valueOf(jtf_Platx.getText()), Integer.valueOf(jtf_Platy.getText()),Integer.valueOf(jtf_nbrBateau3.getText()), Integer.valueOf(jtf_nbrBateau4.getText()), Integer.valueOf(jtf_nbrBateau5.getText()) );
						CreerTableau();
						
						AQuiLeTour=2;
					}
					else{
						System.out.println("oui2");
						
						platJoueur2=platJoueur;
						jb_validerPlateau.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								jeu();
								
							}
						});
					}
				}
			});
			
	}
	
	class Placement implements MouseListener{		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			try{
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						if(e.getSource() == tableauBouton[i][j]){
								platJoueur.positionner(new Bateau("Bat",tailleBat, isVertical), i, j );	
						}
					}
				}
				}catch(ArrayIndexOutOfBoundsException np){
					for(int i=0; i<rows; i++){
						for(int j=0; j<cols; j++){
							if(tableauBouton[i][j].getText()!="Occupe")
							{
							tableauBouton[i][j].setBackground(Color.white);		
							}
						}
					}
					System.out.println("Le bateau ne loge pas");
				}
				

		}
		@Override
		public void mouseReleased(MouseEvent e) {
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					if(e.getSource() == tableauBouton[i][j]){
						for(int k=0; k<tailleBat; k++){
							if(platJoueur.isPlacementReussi())
							{
							if(isVertical){
								tableauBouton[i+k][j].setBackground(Color.red);													
								}
							else{
								tableauBouton[i][j+k].setBackground(Color.red);													
							}
							}
						}
					}
				}
			}
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					if(!plat.emplcmtDisp(i, j)){
					tableauBouton[i][j].setBackground(Color.red);
					}
				}
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			try{
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						if(e.getSource() == tableauBouton[i][j]){
							for(int k=0; k<tailleBat; k++){
								if(isVertical)
								{
								if(platJoueur.emplcmtDisp(i+k,j)){
									tableauBouton[i+k][j].setBackground(Color.BLACK);
									}
								}
								else{
									if(platJoueur.emplcmtDisp(i,j+k)){
										tableauBouton[i][j+k].setBackground(Color.BLACK);
									}
								}
							}
						}
					}
				}
			}catch(ArrayIndexOutOfBoundsException aioe){
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						if(platJoueur.emplcmtDisp(i, j)){
							tableauBouton[i][j].setBackground(Color.white);
						}
					}
				}
			}catch(NullPointerException np){
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						if(platJoueur.emplcmtDisp(i, j)){
							tableauBouton[i][j].setBackground(Color.white);
						}
					}
				}
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					if(platJoueur.emplcmtDisp(i, j)){
						tableauBouton[i][j].setBackground(Color.white);
						}
				}
			}
		}		
	}
	
	
	public void CreerTableau(){
		
		this.revalidate();
		this.removeAll();
		tailleBat=3;
		jp_tableau= new JPanel();
		this.add(jp_tableau, BorderLayout.CENTER);
		
		rows = Integer.parseInt(jtf_Platx.getText());
		cols = Integer.parseInt(jtf_Platy.getText());
		jp_tableau.setLayout(new GridLayout(rows, cols));
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				tableauBouton[i][j] = new JButton(i + ""+j);
				tableauBouton[i][j].setBackground(Color.white);;
				tableauBouton[i][j].addMouseListener(new Placement());
				jp_tableau.add(tableauBouton[i][j]);							
			}
		}
		this.add(jp_placementBateau, BorderLayout.WEST);
		jp_placementBateau.setLayout(new BoxLayout(jp_placementBateau, BoxLayout.PAGE_AXIS));
		this.jl_titre.setText("Quelle bateau : ");
		this.jp_placementBateau.add(jl_titre);
		ButtonGroup bg_tailleBateau = new ButtonGroup();
		bg_tailleBateau.add(jrb_3);
		bg_tailleBateau.add(jrb_4);
		bg_tailleBateau.add(jrb_5);
		this.jp_placementBateau.add(jrb_3);
		this.jp_placementBateau.add(jrb_4);
		this.jp_placementBateau.add(jrb_5);
		jrb_3.setSelected(true);		
		ButtonGroup bg_sensBateau = new ButtonGroup();
		bg_sensBateau.add(jrb_vertical);
		bg_sensBateau.add(jrb_horizontal);
		jrb_vertical.setSelected(true);
		this.jp_placementBateau.add(jl_sensBateau);
		this.jp_placementBateau.add(jrb_vertical);
		this.jp_placementBateau.add(jrb_horizontal);
		this.jp_placementBateau.add(jb_validerPlateau);
		
		
		this.jrb_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tailleBat=3;
			}
		});
		this.jrb_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tailleBat=4;
			}
		});
		this.jrb_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tailleBat=5;
			}
		});
		
		this.jrb_vertical.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isVertical=true;
			}
		});
		this.jrb_horizontal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isVertical=false;
			}
		});
		
	}
	
	

	
	
	public void parametre(){
		
		this.removeAll();
		this.revalidate();
		this.add(jl_titre, BorderLayout.NORTH);
		jl_titre.setHorizontalAlignment(SwingConstants.CENTER);
		jp_param.setLayout(new GridLayout(6, 2));
		this.add(jp_param, BorderLayout.CENTER);
		jp_param.add(jl_taillePlateau);
		jp_param.add(jp_taillePlateau);
		jp_taillePlateau.add(jtf_Platx);
		jp_taillePlateau.add(jl_par);
		jp_taillePlateau.add(jtf_Platy);
		jtf_Platx.setPreferredSize(new Dimension(50, 50));
		jtf_Platy.setPreferredSize(new Dimension(50, 50));
		jp_param.add(jl_nbrBateau3);
		jp_param.add(jtf_nbrBateau3);
		jp_param.add(jl_nbrBateau4);
		jp_param.add(jtf_nbrBateau4);
		jp_param.add(jl_nbrBateau5);
		jp_param.add(jtf_nbrBateau5);
		JPanel jp_pourboutonvalider = new JPanel();
		this.add(jp_pourboutonvalider, BorderLayout.SOUTH);
		jp_pourboutonvalider.add(jb_validerParametre);
		jb_validerParametre.setHorizontalAlignment(SwingConstants.CENTER);

		
		
	}
	
	/**
	 * La classe permettant de tirer sur l'autre plateau
	**/
	
	class Tire implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					if (e.getSource() == tableauBouton[i][j]) {
						int res = 0;
						if (jeu.getTour()==1) {
							res = platJoueur1.tirer(i, j);
						}
						else
						{
							res = platJoueur2.tirer(i, j);
						}
						
						
						if (res == 0) {
							jl_commentaire.setText("Vous avez déjà tiré sur cette case !");
						}else if (res == 1) {
							tableauBouton[i][j].setBackground(Color.BLUE);
						}else if (res == 2) {
							tableauBouton[i][j].setBackground(Color.RED);
							jl_commentaire.setText("Cliquez sur une case pour tirer");
						}else{
							jl_commentaire.setText("Touché coulé");
						}
						if (jeu.getTour() == 1) {
							jeu.setTour(2);
						}
						else{
							jeu.setTour(1);
						}
					}		
				}
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
		
		}
		@Override
		public void mouseReleased(MouseEvent e) {
	
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					if(e.getSource() == tableauBouton[i][j]){
						if (jeu.getTour() == 1) {
							if (platJoueur1.aDejaEteTire(i, j)) {
								if (platJoueur1.aEteTouché(i, j)) {
									tableauBouton[i][j].setBackground(Color.BLUE);
								}
								else{
									tableauBouton[i][j].setBackground(Color.RED);
								}
							}
							else{
								tableauBouton[i][j].setBackground(Color.BLACK);		
							}
						}
						else
						{
							if (platJoueur2.aDejaEteTire(i, j)) {
								if (platJoueur2.aEteTouché(i, j)) {
									tableauBouton[i][j].setBackground(Color.BLUE);
								}
								else{
									tableauBouton[i][j].setBackground(Color.RED);
								}
							}
							else{
								tableauBouton[i][j].setBackground(Color.BLACK);		
							}
						}
						
					}
				}
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					if (jeu.getTour() == 1) {
						if (platJoueur1.aDejaEteTire(i, j)) {
							if (platJoueur1.aEteTouché(i, j)) {
								tableauBouton[i][j].setBackground(Color.BLUE);
							}
							else{
								tableauBouton[i][j].setBackground(Color.RED);
							}
						}else{
							tableauBouton[i][j].setBackground(Color.white);
						}
					}
					else
					{
						if (platJoueur2.aDejaEteTire(i, j)) {
							if (platJoueur2.aEteTouché(i, j)) {
								tableauBouton[i][j].setBackground(Color.BLUE);
							}
							else{
								tableauBouton[i][j].setBackground(Color.RED);
							}
						}
						else{
							tableauBouton[i][j].setBackground(Color.white);		
						}
					}
							
				}
			}
		}		
	}
	
	
	public void jeu(){
		
		this.removeAll();
		this.revalidate();
		//déclare le layout
		this.setLayout(new BorderLayout());
		//Les deux panel un qui contient le plateau et l'autre les info des joueurs

		this.add(jp_jeu, BorderLayout.WEST);
		
		jp_jeu.setLayout(new GridLayout(5,2));
		//postionnement des labels
		jp_jeu.add(jl_joueur1);
		jp_jeu.add(jl_rien);		
		jp_jeu.add(jl_score);		
		jp_jeu.add(jl_scorej1);
		jp_jeu.add(jl_joueur2);
		jp_jeu.add(jl_rien2);	
		jp_jeu.add(jl_score1);
		jp_jeu.add(jl_scorej2);
		jp_jeu.add(jl_commentaire);
		
		
		rows = 10;
		cols = 10;
		jp_tabjeu1.setLayout(new GridLayout(rows, cols));
		
		
		
		
		
		
		//while (jeu.getGagnant() == false) {
			if (jeu.getTour() == 1) {
				this.add(jp_tabjeu1, BorderLayout.CENTER);
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						tableauBouton[i][j] = new JButton(i + ""+j);
						tableauBouton[i][j].setBackground(Color.white);;
						tableauBouton[i][j].addMouseListener(new Tire());
						jp_tabjeu1.add(tableauBouton[i][j]);			
					}
				}
			}
			else
			{
				System.out.println("oui");
				this.add(jp_tabjeu2, BorderLayout.CENTER);
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						tableauBouton[i][j] = new JButton(i + ""+j);
						tableauBouton[i][j].setBackground(Color.white);;
						tableauBouton[i][j].addMouseListener(new Tire());
						jp_tabjeu2.add(tableauBouton[i][j]);			
					}
				}
			}
		//}
		
		
	}	
}