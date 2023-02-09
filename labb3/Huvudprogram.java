// Anton Nyström Viggo Härdelin 

package labb3;

import static labb3.modell.Väderstreck.*;

import java.awt.Color;
import java.util.ArrayList;

import labb3.modell.*;

public class Huvudprogram {

	public static void main(String[] args) throws Exception {

		ArrayList<Rum> rum = new ArrayList<Rum>();
		
		//Kör detta för att visa nya rummen som vi skapat

		//nyaRum(rum);

		//Kör detta för att visa progammet med håkans rum
		//Detta är en ny uppsättning av rum och gångar
		gamlaRum(rum);
		// Dessa rum och gångar morsvarar de i laborationsinstruktionen.
	
		// Skapar en nivå med argumenten rum.get(3) och rum.
		Nivå nivån = new Nivå(rum.get(3), rum);


		// Skapar en instans av klassen GUI som tar nivån som argument
		GUI gui = new GUI(nivån);
		
	}

	public static void nyaRum(ArrayList<Rum> rum) throws Exception{
		// Här är rummen vi skapade enligt TODO
		rum.add(new Rum(Color.CYAN, 75, 75, 250, 250));
		rum.add(new Rum(Color.CYAN, 75, 50, 500, 150));
		rum.add(new Rum(Color.CYAN, 100, 50, 175, 100));
		rum.add(new Rum(Color.CYAN, 100, 75, 355, 200));
		//rum.add(new Rum(Color.CYAN, 100, 75, 3250, 500));
		//rum.add(new Rum(Color.CYAN, 75, 75, 4500, 1250));
		//rum.add(new Rum(Color.CYAN, 100, 50, 2750, 3250));
		//rum.add(new Rum(Color.CYAN, 75, 100, 750, 2750));

		Rum.kopplaIhop(rum.get(0), SÖDER, rum.get(1), NORR);
		Rum.kopplaIhop(rum.get(0), ÖSTER, rum.get(2), NORR);
		Rum.kopplaIhop(rum.get(1), SÖDER, rum.get(3), VÄSTER);
		Rum.kopplaIhop(rum.get(2), SÖDER, rum.get(3), NORR);
		Rum.kopplaIhop(rum.get(2), ÖSTER, rum.get(0), VÄSTER);

	
	}


	public static void gamlaRum(ArrayList<Rum> rum) throws Exception{
		// Här har vi rummen som Håkan hade skapat	
		rum.add(new Rum(Color.RED, 75, 75, 25, 25));
		rum.add(new Rum(Color.BLUE, 75, 50, 50, 150));
		rum.add(new Rum(Color.MAGENTA, 100, 50, 175, 100));
		rum.add(new Rum(Color.YELLOW, 100, 75, 200, 200));
		rum.add(new Rum(Color.CYAN, 100, 75, 325, 50));
		rum.add(new Rum(Color.ORANGE, 75, 75, 450, 125));
		rum.add(new Rum(Color.PINK, 100, 50, 275, 325));
		rum.add(new Rum(Color.GREEN, 75, 100, 75, 275));

		Rum.kopplaIhop(rum.get(0), SÖDER, rum.get(1), NORR);
		Rum.kopplaIhop(rum.get(0), ÖSTER, rum.get(2), NORR);
		Rum.kopplaIhop(rum.get(1), SÖDER, rum.get(3), VÄSTER);
		Rum.kopplaIhop(rum.get(2), SÖDER, rum.get(3), NORR);
		Rum.kopplaIhop(rum.get(2), ÖSTER, rum.get(4), VÄSTER);
		Rum.kopplaIhop(rum.get(4), ÖSTER, rum.get(5), NORR);
		Rum.kopplaIhop(rum.get(5), SÖDER, rum.get(6), ÖSTER);
		Rum.kopplaIhop(rum.get(3), ÖSTER, rum.get(5), VÄSTER);
		Rum.kopplaIhop(rum.get(3), SÖDER, rum.get(6), NORR);
		Rum.kopplaIhop(rum.get(7), ÖSTER, rum.get(6), VÄSTER);
		
	}
}
