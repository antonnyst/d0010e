// Anton Nyström Viggo Härdelin 
package labb3.vy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import labb3.GlobalaKonstanter;
import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;
import labb3.verktyg.Grafik;
import labb3.verktyg.Punkt;


//Gör så att Målarduk(subklass) klassen ärver JPanel(Superklass)
public class Målarduk extends JPanel {

	private final Nivå enNivå;

	public Målarduk(Nivå enNivå) {
		this.enNivå = enNivå;
		this.setBackground(GlobalaKonstanter.MARKFÄRG); //Sätter bakgrundsfärgen till markfärg
		this.setFocusable(true); // anropar metoden setFocusable på this med argument true
		// Detta behövs för att lyssnaren i programmet ska reagera.
	}

	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Anropar till paintComponent i överklassen JPanel, skickar g som argument 


		//Ritar en grafisk vy av enNivå
		ArrayList<Rum> allaRum = enNivå.rum();
		for(int i = 0; i < allaRum.size(); i++){ //Loopar genom alla rum som finns i 
			ritaRum(g, allaRum.get(i));			//ArrayListen allaRum för att bli utritade på målarduk
			ritaGångarFrånRum(g, allaRum.get(i)); //Gör samma sak med alla gångar.
		}
		
		ritaMarkörFörVarAnvändarenÄr(g); //Kallar på metoden som ritar ut var användaren finns
	}
	//Ritar rum
	private void ritaRum(Graphics g, Rum ettRum) {
		g.setColor(GlobalaKonstanter.VÄGGFÄRG);
		g.fillRect(ettRum.öv().x(), ettRum.öv().y(), ettRum.bredd(), ettRum.höjd());
		g.setColor(ettRum.golvfärg());
		g.fillRect(ettRum.öv().x()+GlobalaKonstanter.VÄGGTJOCKLEK, ettRum.öv().y()+GlobalaKonstanter.VÄGGTJOCKLEK,
		 ettRum.bredd()-2*GlobalaKonstanter.VÄGGTJOCKLEK, ettRum.höjd()-2*GlobalaKonstanter.VÄGGTJOCKLEK);
	}

	private void ritaGångarFrånRum(Graphics g, Rum ettRum) {
		for(Väderstreck riktning: Väderstreck.values()){ //Loopar genom alla riktingar i rummet för att hitta
			try{										// in/ut-gångar
				ritaGång(g, ettRum.gångenÅt(riktning));
			}
			catch(Exception e){ 
			}	
		}
	}

	private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
		int x;
		int y;
		switch(enRiktning) {
			case NORR:
				x = ettRum.öv().x() + ettRum.bredd() / 2;
				y = ettRum.öv().y() + GlobalaKonstanter.VÄGGTJOCKLEK;
				return new Punkt(x, y); 
			case ÖSTER:
				x = ettRum.öv().x() + ettRum.bredd() - GlobalaKonstanter.VÄGGTJOCKLEK;
				y = ettRum.öv().y() + ettRum.höjd() / 2;
				return new Punkt(x, y);
			case SÖDER:
				x = ettRum.öv().x() + ettRum.bredd() / 2;
				y = ettRum.öv().y() + ettRum.höjd() - GlobalaKonstanter.VÄGGTJOCKLEK;
				return new Punkt(x, y); 
			case VÄSTER:
				x = ettRum.öv().x() + GlobalaKonstanter.VÄGGTJOCKLEK;
				y = ettRum.öv().y() + ettRum.höjd() / 2;
				return new Punkt(x, y); 
			default:
				return null;
		}
	}

	private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
		int x;
		int y;
		switch(enRiktning) {
			case NORR:
				x = ettRum.öv().x() + ettRum.bredd() / 2;
				y = ettRum.öv().y() - GlobalaKonstanter.HALV_VÄGGTJOCKLEK;
				return new Punkt(x, y); 
			case ÖSTER:
				x = ettRum.öv().x() + ettRum.bredd() + GlobalaKonstanter.HALV_VÄGGTJOCKLEK;
				y = ettRum.öv().y() + ettRum.höjd() / 2;
				return new Punkt(x, y);
			case SÖDER:
				x = ettRum.öv().x() + ettRum.bredd() / 2;
				y = ettRum.öv().y() + ettRum.höjd() + GlobalaKonstanter.HALV_VÄGGTJOCKLEK;
				return new Punkt(x, y); 
			case VÄSTER:
				x = ettRum.öv().x() - GlobalaKonstanter.HALV_VÄGGTJOCKLEK;
				y = ettRum.öv().y() + ettRum.höjd() / 2;
				return new Punkt(x, y); 
			default:
				return null;
		}
	}

	private void ritaGång(Graphics g, Gång enGång) {
		//Definerar punkterna som variabler så att koden som ritar nedan 
		// ska bli mer lättläst
		Punkt b1 = baspunkt( enGång.från(), enGång.riktningUtUrFrån());
		Punkt p1 = pivotpunkt(enGång.från(), enGång.riktningUtUrFrån());
		Punkt b3 = baspunkt(enGång.till(), enGång.riktningInITill());
		Punkt p3 = pivotpunkt(enGång.till(), enGång.riktningInITill());
		// Ritar sträcken i gångarnas punkter 
		Grafik.drawThickLine(g, b3, p3, GlobalaKonstanter.VÄGGTJOCKLEK, GlobalaKonstanter.GÅNGFÄRG);
		Grafik.drawThickLine(g, b1, p1, GlobalaKonstanter.VÄGGTJOCKLEK, GlobalaKonstanter.GÅNGFÄRG);
		Grafik.drawThickLine(g, p1, p3, GlobalaKonstanter.VÄGGTJOCKLEK, GlobalaKonstanter.GÅNGFÄRG);

		// Ritar cirklar på punkterna p1 och p3 enligt instruktion
		Grafik.fillCircle(g, p1, GlobalaKonstanter.HALV_VÄGGTJOCKLEK, GlobalaKonstanter.GÅNGFÄRG);
		Grafik.fillCircle(g, p3, GlobalaKonstanter.HALV_VÄGGTJOCKLEK, GlobalaKonstanter.GÅNGFÄRG);
	}
	//Ritar en markör för att visa var användaren befinner sig, i detta fall
	//är det en svart prick som befinner sig i mitten av rummet som använder är i.
	private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {
		// Delar på 2 för att få användaren i mitten av rummet och inte i hörnet
		Punkt userPosition= new Punkt(enNivå.nuvarandeRum().öv().x()+enNivå.nuvarandeRum().bredd()/2, 
		 enNivå.nuvarandeRum().öv().y()+enNivå.nuvarandeRum().höjd()/2);
		Grafik.fillCircle(g, userPosition, GlobalaKonstanter.ANVÄNDARRADIE, GlobalaKonstanter.ANVÄNDARFÄRG);
	}
}
