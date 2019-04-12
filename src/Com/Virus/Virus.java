package Com.Virus;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import Com.learnstart.main.King;
import Com.learnstart.main.Screen;

public class Virus {
	public double current, last;
	public int x, y = King.HEIGHT / 2, dy, dx, i, w, h;
	List<Image> imgs;

	public Virus() {
		w = King.HEIGHT / 10;
		h = King.HEIGHT / 10;
		x = w + 1;
		dy = -5;
		dx = 3;
		imgs = Screen.setArray(getClass().getResource("/Com/Graphics/Ogla/Virus_running.gif"), "gif");
	}

	public void tick() {

	}

	public void render(Graphics2D g) {
		g.drawImage(imgs.get(i), x, y, w, h, null);
	}
}
