package Com.learnstart.Inputs;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Com.Graphics.Hub;
import Com.learnstart.main.King;

public class Mouse2 implements MouseListener {
	Robot r;
	Point start = new Point(0, 0);
	Point end = new Point(0, 0);
	Hub gh;

	public Mouse2(Hub gh) {
		this.gh = gh;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void mouseClicked(MouseEvent e) {
		start = e.getPoint();
		for (int i = 0; i < Hub.ports.length; i++) {
			if (Hub.ports[i].contains(e.getPoint())) {
				System.err.println("You Clicked Square " + i);
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
		end = e.getPoint();
	}

	public void tick() {
		if (Math.abs(start.getX() - end.getX()) >= King.HEIGHT / 10 || Math.abs(start.getY() - end.getY()) >= King.HEIGHT / 10) {
			System.err.println(end.x - start.x);

			gh.xoff -= (end.x - start.x);
//			gh.yoff += (end.y - start.y);
			end.setLocation(0, 0);
			start.setLocation(0, 0);
//			System.err.println(gh.xoff);
		}
//		if (King.f.isActive())
//			r.mouseMove(King.WIDTH / 4, King.HEIGHT / 2);
//		r
	}
}
