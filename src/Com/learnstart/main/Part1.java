package Com.learnstart.main;

import java.awt.Graphics2D;

import Com.Create.Load;
import Com.Graphics.Ogla.Sprite;

public class Part1 {
	Integer[][] background;

	public Part1() {
		background = Load.loadint("Level_2.txt", 6, 6);
	}

	public void tick() {

	}

	public void render(Graphics2D g2) {
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				g2.drawImage(Sprite.mount[background[j][i]].img, temp2, temp1, King.HEIGHT * 9 / 60, King.HEIGHT * 9 / 60, null);
				temp2 += King.HEIGHT * 9 / 60;
			}
			temp2 = 0;
			temp1 += King.HEIGHT * 9 / 60;
		}
	}
}
