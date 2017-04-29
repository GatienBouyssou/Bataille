package graphique;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	private PanelJeu pan = new PanelJeu();
	public Fenetre(){
		this.setSize(600,600);
		this.setTitle("Bataille Navale");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(pan);
		this.setVisible(true);
	}

}