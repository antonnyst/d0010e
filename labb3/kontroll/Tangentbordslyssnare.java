// Anton Nyström Viggo Härdelin 

package labb3.kontroll;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import labb3.modell.Nivå;
import labb3.modell.Väderstreck;

public class Tangentbordslyssnare implements KeyListener {
	private Nivå enNivå;

	public Tangentbordslyssnare(Nivå enNivå) {
		this.enNivå = enNivå;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Omvandla tangenttryck till väderstreck och flytta användaren
		//
		// w betyda "hoppa åt NORR",
		// d betyda "hoppa åt ÖSTER",
		// s betyda "hoppa åt SÖDER" och
		// a betyda "hoppa åt VÄSTER".
		switch(e.getKeyChar()){
			case 'w':
				enNivå.hoppaÅt(Väderstreck.NORR);
				break;
			case 'd':
				enNivå.hoppaÅt(Väderstreck.ÖSTER);
				break;
			case 's':
				enNivå.hoppaÅt(Väderstreck.SÖDER);
				break;
			case 'a':
				enNivå.hoppaÅt(Väderstreck.VÄSTER);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Används inte men måste implementeras eftersom keyTyped finns i
		// gränssnittet KeyListener.
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Används inte men måste implementeras eftersom keyReleased finns is
		// gränssnittet KeyListener.
	}
}
