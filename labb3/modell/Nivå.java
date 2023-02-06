package labb3.modell;

import java.util.ArrayList;
import java.util.Observable;

import labb3.verktyg.Punkt;

// TODO: Gör så att klassen Nivå ärver Observable i paketet java.util. 
public class Nivå extends Observable {

	// TODO: Lägg till tillståndsvariabler för att hålla reda på nivåns rum och
	// i vilket rum som användaren "är".

	private ArrayList<Rum> rum;
	private Rum användarensrum;


	public Nivå(Rum startrum, ArrayList<Rum> rum) throws Exception {
		// TODO: Kopiera in startrum och rum in i tillståndsvariablerna.
		this.användarensrum = startrum;
		this.rum = rum;

		// TODO: Kontrollera att startrum finns med i rum. Om inte, kasta
		// undantag med lämpligt felmeddelande.
		if (!rum.contains(startrum)) {
			throw new RuntimeException("Startrum ej del av rumlistan");
		}

		// TODO: Kontrollera att inga rum överlappar varandra. Om det ändå är
		// fallet, kasta undantag med lämpligt felmeddelande.
		for (int i = 0; i < this.rum.size()-1; i++) {
			for (int j = i+1; j < this.rum.size(); j++) {
				if (checkOverlap(this.rum.get(i), this.rum.get(j))) {
					throw new RuntimeException("Rum överlappar");
				}
			}
		}
	}

	private boolean checkOverlap(Rum rum1, Rum rum2) {
		Punkt öv1 = rum1.öv();
		Punkt öv2 = rum2.öv();
		
		// 1 vänster om 2 eller 2 vänster om 1
		if (öv1.x() + rum1.bredd() < öv2.x() || öv2.x() + rum2.bredd() < öv1.x()) {
			return false;
		}

		// 1 ovanför 2 eller 2 ovanför 1
		if (öv1.y() - rum1.höjd() < öv2.y() || öv2.y() - rum2.höjd() < öv1.y()) {
			return false;
		}

		return true;
	}

	// TODO: Skriv en instansmetod som returnerar alla rummen. Denna behöver
	// Målarduk för att veta vilka rum som finns på nivån och som ska ritas ut.
	public Rum[] rum() {
		return (Rum[]) rum.toArray();
	}

	// TODO Skriv en instansmetod som returnerar en referens till det rum som
	// användaren "är i".
	public Rum nuvarandeRum() {
		return användarensrum;
	}

	// TODO: Skriv klar instansmetoden hoppaÅt nedan så att den ändrar det rum
	// som användaren "är i" om det är möjligt genom att följa en gång från
	// rummet och i riktning väderstreck.
	//
	// Om väderstreck inte är en riktning i vilken det finns en gång, så ändras
	// inte rummet användaren "är i" (och inte heller kastas undantag). (Denna
	// metod använder kontrolldelen av programmet för att begära ett hopp till
	// angränsande rum efter att användaren tryckt på en tangent.)

	public void hoppaÅt(Väderstreck väderstreck) {
		try {
			användarensrum = användarensrum.gångenÅt(väderstreck).till();
			setChanged();
			notifyObservers();
		} catch (Exception e) {
			// Gick ej att gå
		}
	}
}
