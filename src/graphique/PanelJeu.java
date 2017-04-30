package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Case;

public class PanelJeu extends JPanel {
	
	// private JLabel jl_Score= new JLabel("Score :");
	// private JLabel jl_NbrBateau = new JLabel("Nombre Bateau :");
	// private JLabel jl_Case= new JLabel("Case Selectionné :");
	// private JButton jb_Tirer= new JButton("Tirer!");
	// private JLabel jl_etat= new JLabel("");
	///defrrfrf

	private JLabel jl_titre = new JLabel("Paramètre de Jeu");
	private JPanel jp_param = new JPanel();
	private JLabel jl_joueur = new JLabel("Voulez vous jouer à ");
	private JPanel jp_nbrJoueur = new JPanel();
	private JLabel jl_taillePlateau = new JLabel("Quelle dimension de plateau ");
	private JPanel jp_taillePlateau = new JPanel();
	private JButton jb_validerParametre = new JButton("Valider param");
	private JTextField jtf_Platx = new JTextField();
	private JLabel jl_par = new JLabel("par");
	private JTextField jtf_Platy = new JTextField();
	
	public String getJtf_Platx() {
		return jtf_Platx.getText();
	}


	public String getJtf_Platy() {
		return jtf_Platy.getText();
	}


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
	
	//Le plateau avec des cases
	private JPanel jp_tabjeu = new JPanel();
	
	
	
	
	
	private JLabel jl_nbrBateau3 = new JLabel("Combien voulez vous de bateau (3)");
	private JTextField jtf_nbrBateau3 = new JTextField();
	private JLabel jl_nbrBateau4 = new JLabel("Combien voulez vous de bateau (4)");
	private JTextField jtf_nbrBateau4 = new JTextField();
	private JLabel jl_nbrBateau5 = new JLabel("Combien voulez vous de bateau (5)");
	private JTextField jtf_nbrBateau5 = new JTextField();
	
	
	private JPanel jp_tableau = new JPanel();

	private int rows;
	private int cols;
	private JButton tableauBouton[][] = new JButton[50][50];
	private JButton bouton = new JButton("Demarrer");
	

	public PanelJeu(){
			this.add(bouton);
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					parametre();
				}
			});
			jb_validerParametre.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					CreerTableau();
					
					tableauBouton[0][0].addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							jeu();
							
						}
					});
				}
			});
	}
	
	
	public void CreerTableau(){
		
		this.revalidate();
		this.removeAll();
		
		this.add(jp_tableau, BorderLayout.CENTER);
		
		rows = 10;
		cols = 10;
		jp_tableau.setLayout(new GridLayout(rows, cols));
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				tableauBouton[i][j] = new JButton(i + ""+j);
				tableauBouton[i][j].setBackground(Color.white);;
				tableauBouton[i][j].addMouseListener(new Placement());
				jp_tableau.add(tableauBouton[i][j]);							
			}
		}
	}
	
	
	class Placement implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			try{
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						if(e.getSource() == tableauBouton[i][j]){
							int taille = 3;
							for(int k=0; k<taille; k++){
								tableauBouton[i][j+k].setBackground(Color.BLACK);													
							}
						}
					}
				}
			}catch(NullPointerException np){
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						tableauBouton[i][j].setBackground(Color.white);		
					}
				}
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					tableauBouton[i][j].setBackground(Color.white);		
				}
			}
		}		
	}
	
	
	
	public void parametre(){
		
		this.removeAll();
		this.revalidate();
		this.setLayout(new BorderLayout());
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
	
	
	
	class Tire implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					if (e.getSource() == tableauBouton[i][j]) {
						if (getTour == 1) {
							platJoueur1.tirer(i,j);
						}
						else
						{
							platJoueur2.tirer(i,j);
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
			try{
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						if(e.getSource() == tableauBouton[i][j]){
							tableauBouton[i][j].setBackground(Color.BLACK);		
						}
					}
				}
			}catch(NullPointerException np){
				for(int i=0; i<rows; i++){
					for(int j=0; j<cols; j++){
						tableauBouton[i][j].setBackground(Color.white);		
					}
				}
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					tableauBouton[i][j].setBackground(Color.white);		
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
		this.add(jp_tabjeu, BorderLayout.CENTER);
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
		
		
		rows = 10;
		cols = 10;
		jp_tabjeu.setLayout(new GridLayout(rows, cols));
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				tableauBouton[i][j] = new JButton(i + ""+j);
				tableauBouton[i][j].setBackground(Color.white);;
				tableauBouton[i][j].addMouseListener(new Tire());
				jp_tabjeu.add(tableauBouton[i][j]);							
			}
		}
	}
	
	
	
	
}