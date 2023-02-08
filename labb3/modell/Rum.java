package labb3.modell;

import java.awt.Color;

import labb3.GlobalaKonstanter;
import labb3.verktyg.Punkt;

public class Rum {

	// Tillståndsvariabler.
	private Color golvfärg;
	private int bredd;
	private int höjd;
	private Punkt öv;
	private Gång[] gångar;

	public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
		// Kopierar parametrarna in i tillståndsvariablerna.
		this.golvfärg = golvfärg;
		this.bredd = bredd;
		this.höjd = höjd;
		this.öv = new Punkt(övX, övY);
		this.gångar = new Gång[GlobalaKonstanter.ANTAL_VÄDERSTRECK];
	}

	// Getters för variablerna
	public Color golvfärg() {
		return golvfärg;
	}

	public int bredd() {
		return bredd;
	}

	public int höjd() {
		return höjd;
	}

	public Punkt öv() {
		return öv;
	}


	// Kolla om det finns en utgång
	boolean finnsUtgångÅt(Väderstreck väderstreck) {
		return this.gångar[väderstreck.index()] != null;
	}

	// Returnerar gången åt den riktningen eller kastar ett undantag om det inte finns en gång
	public Gång gångenÅt(Väderstreck väderstreck) throws Exception {
		if (!finnsUtgångÅt(väderstreck)) {
			throw new Exception("Ingen gång finns åt specificerat väderstreck");
		}
		return this.gångar[väderstreck.index()];
	}

	// Kopplar ihop två rum
	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
			Rum till, Väderstreck riktningInITill) throws Exception {
		// Ej till och från samma rum
		if (från.equals(till)) {
			throw new Exception("Ej till och från samma rum");
		}
		
		// Ej dubbelgång
		if (från.finnsUtgångÅt(riktningUtUrFrån) || till.finnsUtgångÅt(riktningInITill)) {
			throw new Exception("Gång finns redan vid en av utgångarna");
		}
		
		// Från -> Till
		från.gångar[riktningUtUrFrån.index()] = new Gång(från, riktningUtUrFrån, till, riktningInITill);

		// Till -> Från
		till.gångar[riktningInITill.index()] = new Gång(till, riktningInITill, från, riktningUtUrFrån);
	}
}
