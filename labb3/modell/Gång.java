package labb3.modell;

public class Gång {
 
	// Tillståndsvariabler för hålla parametrarna till konstruktorn
	private Rum från;
	private Väderstreck riktningUtUrFrån;
	private Rum till;
	private Väderstreck riktningInITill;

	public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,
		Väderstreck riktningInITill) {
		this.från = från;
		this.riktningUtUrFrån = riktningUtUrFrån;
		this.till = till;
		this.riktningInITill = riktningInITill;
	}


	//Instansmetoder som returnerar tillståndsvariablerna
	public Rum från() {
		return från;
	}
	
	public Väderstreck riktningUtUrFrån() {
		return riktningUtUrFrån;
	}

	public Rum till() {
		return till;
	}

	public Väderstreck riktningInITill() {
		return riktningInITill;
	}
}
