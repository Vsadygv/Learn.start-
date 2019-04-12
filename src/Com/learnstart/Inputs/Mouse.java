package Com.learnstart.Inputs;

import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import Com.learnstart.main.King;

public class Mouse implements MouseListener {

	public King k;
	public Polygon text1;
	public Polygon text2;
	public Polygon text3;

	public Mouse(King k) {
		this.k = k;
		int textx[] = new int[4];
		int text1y[] = new int[4];
		int text2y[] = new int[4];
		int text3y[] = new int[4];
		textx[0] = 0;
		textx[1] = King.WIDTH;
		textx[2] = King.WIDTH;
		textx[3] = 0;
		text1y[0] = King.HEIGHT * 39 / 80;
		text1y[1] = King.HEIGHT * 39 / 80;
		text1y[2] = King.HEIGHT * 23 / 40;
		text1y[3] = King.HEIGHT * 23 / 40;
		text1 = new Polygon(textx, text1y, 4);
		text2y[0] = King.HEIGHT * 47 / 80;
		text2y[1] = King.HEIGHT * 47 / 80;
		text2y[2] = King.HEIGHT * 27 / 40;
		text2y[3] = King.HEIGHT * 27 / 40;
		text2 = new Polygon(textx, text2y, 4);
		text3y[0] = King.HEIGHT * 55 / 80;
		text3y[1] = King.HEIGHT * 55 / 80;
		text3y[2] = King.HEIGHT * 31 / 40;
		text3y[3] = King.HEIGHT * 31 / 40;
		text3 = new Polygon(textx, text3y, 4);
	}

	public Mouse() {

	}

	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (k != null) {
				if (text1.contains(e.getPoint()) && !k.ingame()) {
					k.show2();
				} else if (text2.contains(e.getPoint())) {

				} else if (text3.contains(e.getPoint())) {
					k.stop();
				}
			}
		}
		return;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}
