package labb3.modell;

import java.awt.Color;

import labb3.GlobalaKonstanter;
import labb3.verktyg.Punkt;

public class Rum {

	// TODO: Lägg till tillståndsvariabler.
	private Color golvfärg;
	private int bredd;
	private int höjd;
	private Punkt öv;
	private Gång[] gångar;

	public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
		// TODO: Kopiera parametrarna in i tillståndsvariablerna. (övX,övY) är
		// koordinaten för rummets övre vänstra hörn och lagras lämpligen som en
		// instans av klassen Punkt i paketet verktyg.
		this.golvfärg = golvfärg;
		this.bredd = bredd;
		this.höjd = höjd;
		this.öv = new Punkt(övX, övY);
		this.gångar = new Gång[GlobalaKonstanter.ANTAL_VÄDERSTRECK];
	}

	// TODO: Skriv "getters", metoder som returnerar tillståndsvariablernas
	// värden.
	public Color golvgärg() {
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


	// TODO: Skriv instansmetoden
	//
	// finnsUtgångÅt(Väderstreck väderstreck)
	//
	// som ska kontrollera om det från ett rum finns en utgång åt visst
	// väderstreck.
	boolean finnsUtgångÅt(Väderstreck väderstreck) {
		return this.gångar[väderstreck.index()] != null;
	}

	// TODO: Skriv instansmetoden
	//
	// Gång gångenÅt(Väderstreck väderstreck) som
	//
	// returnerar den gång som leder från ett rum i riktning väderstreck. Om
	// sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.
	Gång gångenÅt(Väderstreck väderstreck) throws Exception {
		if (!finnsUtgångÅt(väderstreck)) {
			throw new Exception("Ingen gång finns åt specificerat väderstreck");
		}
		return this.gångar[väderstreck.index()];
	}

	// TODO: Skrivklar metoden nedan som kopplar ihop två rum med en gång.
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
