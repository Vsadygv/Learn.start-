package Com.learnstart.Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Com.Graphics.Ogla.Ogla;
import Com.learnstart.enums.Levels;
import Com.learnstart.main.Screen;

public class KeyBoard implements KeyListener {
	public boolean[] pressed;

	public KeyBoard() {
		pressed = new boolean[4];
	}

	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == 10) {
			Screen.can = true;
		}
		if (Screen.GameState == Levels.Hub) {
			if (arg0.getKeyCode() == 37) {
				if (!pressed[0]) {
					Ogla.check = true;
				}
				pressed[0] = true;
			}
			if (arg0.getKeyCode() == 38) {
				if (!pressed[1]) {
					Ogla.check = true;
				}
				pressed[1] = true;
			}
			if (arg0.getKeyCode() == 39) {
				if (!pressed[2]) {
					Ogla.check = true;
				}
				pressed[2] = true;
			}
			if (arg0.getKeyCode() == 40) {
				if (!pressed[3]) {
					Ogla.check = true;
				}
				pressed[3] = true;
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == 37) {
			pressed[0] = false;
			Ogla.check = true;
		}
		if (arg0.getKeyCode() == 38) {
			pressed[1] = false;
			Ogla.check = true;
		}
		if (arg0.getKeyCode() == 39) {
			pressed[2] = false;
			Ogla.check = true;
		}
		if (arg0.getKeyCode() == 40) {
			pressed[3] = false;
			Ogla.check = true;
		}
	}

	public void keyTyped(KeyEvent arg0) {

	}

}
