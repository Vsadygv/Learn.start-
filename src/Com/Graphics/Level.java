package Com.Graphics;

import java.awt.Graphics2D;

import Com.Create.Load;
import Com.Graphics.Ogla.Sprite;
import Com.learnstart.main.King;
import Com.learnstart.main.Screen;

public class Level {
	public Integer[][] background;
	public Screen s;

	public Level(Screen s) {
		this.s = s;
		background = Load.loadint("Level_2.txt", 5, 5);
	}

	public void tick() {
//		if (s.current == )
	}

	public void render(Graphics2D g2) {
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < background.length; i++) {
			for (int j = 0; j < background[0].length; j++) {
				g2.drawImage(Sprite.mount[background[j][i]].img, temp2, temp1, King.HEIGHT * 9 / 50, King.HEIGHT * 9 / 50, null);
				temp2 += King.HEIGHT * 9 / 50;
			}
			temp2 = 0;
			temp1 += King.HEIGHT * 9 / 50;
		}
		g2.drawImage(Sprite.Ogla[0].img, (King.WIDTH / 4) - (King.HEIGHT * 9 / 120), (int) ((King.HEIGHT * 9 / 60) * 4.15), King.HEIGHT * 9 / 60, King.HEIGHT * 9 / 60, null);
	}
}
