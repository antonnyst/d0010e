package labb3;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import labb3.kontroll.Tangentbordslyssnare;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.vy.Målarduk;


 
//Ärver JFrame och implementerar gränssnittet Observer
public class GUI extends JFrame implements Observer {

	private Målarduk målarduk;

	public GUI(Nivå enNivå) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Gör så att enNivå observerar this
		enNivå.addObserver(this);
		//Tilldelar tillståndsvariabeln målarduk en instans av klassen Målarduk	
		målarduk = new Målarduk(enNivå);

		int maxX = 0;
		int maxY = 0;
		
		ArrayList<Rum> allaRum = enNivå.rum();
		for (int i = 0; i < allaRum.size(); i++) {
			Rum ettRum = allaRum.get(i);
			if (ettRum.öv().x()+ettRum.bredd() > maxX) {
				maxX = ettRum.öv().x()+ettRum.bredd();
			}
			if (ettRum.öv().y()+ettRum.höjd() > maxY) {
				maxY = ettRum.öv().y()+ettRum.höjd();
			}
		}

		
		//Sätter målardukens dimensioner 
		målarduk.setPreferredSize(new Dimension(maxX + GlobalaKonstanter.DUBBEL_VÄGGTJOCKLEK,
		 maxY + GlobalaKonstanter.DUBBEL_VÄGGTJOCKLEK));


		//Keylistner på målarduken
		målarduk.addKeyListener(new Tangentbordslyssnare(enNivå));

		//Anropar setContentPane med målarduk, så att målarduk är
		// den yta som vår JFrame kommer att ha. Sen återstår bara att
		// göra setVisible(true) och pack().
		setContentPane(målarduk);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		// Detta anrop triggar ett anrop till paintComponent i Målarduk. 
		this.målarduk.repaint();
	}
}
