// Anton Nyström Viggo Härdelin 

package labb3.modell;

public enum Väderstreck {
	NORR(0), ÖSTER(1), SÖDER(2), VÄSTER(3);
	// Vädersteck
	// 
	// NORR.index() returnerar 0, 
	// ÖSTER.index() returnerar 1,
	// SÖDER.index() returnerar 2 och 
	// VÄSTER.index() returnerar 3. 

	private int index;

	private Väderstreck(int index) {
		this.index = index;
	}

	int index() {
		return this.index;
	}
}
