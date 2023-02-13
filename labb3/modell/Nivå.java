// Anton Nyström Viggo Härdelin 

package labb3.modell;

import java.util.ArrayList;
import java.util.Observable;

import labb3.verktyg.Punkt;

// Nivån är observable
public class Nivå extends Observable {

	
	// Tillståndsvariabler
	private ArrayList<Rum> rum;
	private Rum användarensrum;


	public Nivå(Rum startrum, ArrayList<Rum> rum) throws Exception {
		// Flytta in tillståndsvariablerna
		this.användarensrum = startrum;
		this.rum = rum;

		// Kontroll av att startrum är del av rumlistan
		if (!rum.contains(startrum)) {
			throw new RuntimeException("Startrum ej del av rumlistan");
		}

		// Kolla overlaps mellan rum
		for (int i = 0; i < this.rum.size()-1; i++) {
			for (int j = 0; j < this.rum.size(); j++) {
				if (i == j) {
					continue;
				}
				
				if (checkOverlap(this.rum.get(i), this.rum.get(j))) {
					throw new RuntimeException("Rum överlappar");
				}
			}
		}
	}

	// Kollar overlaps mellan rum genom att testa motsatsen
	private boolean checkOverlap(Rum rum1, Rum rum2) {
		Punkt öv1 = rum1.öv();
		Punkt öv2 = rum2.öv();
		
		// 1 vänster om 2 eller 2 vänster om 1
		if (öv1.x() + rum1.bredd() < öv2.x() || öv2.x() + rum2.bredd() < öv1.x()) {
			return false;
		}

		// 1 ovanför 2 eller 2 ovanför 1
		if (öv1.y() + rum1.höjd() < öv2.y() || öv2.y() + rum2.höjd() < öv1.y()) {
			return false;
		}

		return true;
	}

	// Getter för rumlistan
	public ArrayList<Rum> rum() {
		return this.rum;
	}

	// Getter för användarens rum 
	public Rum nuvarandeRum() {
		return användarensrum;
	}

	// Förflytta användaren åt väderstreck
	public void hoppaÅt(Väderstreck väderstreck) {
		try {
			användarensrum = användarensrum.gångenÅt(väderstreck).till();
			setChanged();
			notifyObservers();
		} catch (Exception e) {
			// .gångenÅt kastar ett undantag om det ej finns en gång åt väderstreck
			// Fånga den här och gör ingenting eftersom inget ska hända om det ej finns en gång
		}
	}
}
