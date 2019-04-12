package Com.learnstart.main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Com.Create.Load;
import Com.Graphics.Ogla.Ogla;
import Com.Graphics.Ogla.Sprite;
import Com.learnstart.enums.Levels;

public class Intro {
	Integer[][] Image;
	Screen screen;
	List<Image> Og;
	Ogla ogla;
	int o;
	int x;
	long last;
	int index;

	public Intro(Screen screen) {
		Og = new ArrayList<Image>();
		Image = Load.loadint("Intro.txt", 6, 6);
		this.screen = screen;
		ogla = new Ogla(screen);
		Og.add(Sprite.Hflip((BufferedImage) Sprite.Ogla[5].img));
		Og.add(Sprite.Hflip((BufferedImage) Sprite.Ogla[6].img));
		x = (King.WIDTH / 4) - (King.HEIGHT * 9 / 120);
		Start.editon(true);
	}

	public void render(Graphics2D g2) {
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				g2.drawImage(Sprite.s[Image[j][i]].img, temp2, temp1, King.HEIGHT * 9 / 60, King.HEIGHT * 9 / 60, null);
				temp2 += King.HEIGHT * 9 / 60;
			}
			temp2 = 0;
			temp1 += King.HEIGHT * 9 / 60;
		}
		if (Screen.current != 20) {
			g2.drawImage(Sprite.Ogla[o].img, x, (int) ((King.HEIGHT * 9 / 60) * 4.3), King.HEIGHT * 9 / 60, King.HEIGHT * 9 / 60, null);
		} else {
			g2.drawImage(Og.get(index), x, (int) ((King.HEIGHT * 9 / 60) * 4.3), King.HEIGHT * 9 / 60, King.HEIGHT * 9 / 60, null);
		}
	}

	@SuppressWarnings("unchecked")
	public void tick() {
		if (Screen.current == 4) {
			o = 25;
			Start.clear();
		} else if (Screen.current == 5) {
			o = 0;
		} else if (Screen.current == 20) {
			long current = System.currentTimeMillis();
			x -= King.WIDTH / 200;
			if (current - last >= 200) {
				if (index == 1) {
					index = 0;
				} else {
					index = 1;
				}
				last = current;
			}
			if (x <= -(King.HEIGHT * 9 / 60)) {
				Screen.GameState = Levels.Hub;
				screen.s.geth().getL().set(20, true);
				Start.main();
			}
		}
	}
}
