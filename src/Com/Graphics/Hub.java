package Com.Graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Com.Create.Load;
import Com.Graphics.Ogla.Ogla;
import Com.Graphics.Ogla.Sprite;
import Com.Noise.Music.Music_Handler;
import Com.learnstart.main.King;
import Com.learnstart.main.Screen;

public class Hub {
//	ImageIcon dirt, grass1, grass2, dedge, gedge, dtop, sky, sky1, sky2, sky3, Arrow;
	public int amount;
	public static Rectangle[] ports;
//	int amount2;
	Screen s;
	public int h = King.HEIGHT / 10;
	Music_Handler mh;
	Integer[][] spot;
	public int xoff;
	public int yoff;
	Ogla o;
//	Virus v;
	public int offsetMaxX, offsetMaxY, offsetMinX, offsetMinY, camX, camY;

	public Hub(Screen s) {
		spot = Load.loadint("Level_1.txt", 17, 17);
		o = new Ogla(s);
		offsetMaxX = (h * spot.length) - (King.WIDTH / 2);
		offsetMaxY = (h * spot.length) - (King.HEIGHT * 9 / 10);
		offsetMinX = 0;
		offsetMinY = 0;
		camX = o.getX() - ((h * 13) / 2);
		camY = o.getY() - ((h * 16) / 2);

		ports = new Rectangle[8];
		ports[0] = new Rectangle(0, 0, h, h);
		ports[1] = new Rectangle(h * 4, 0, h, h);
		ports[2] = new Rectangle(h * 8, 0, h, h);
		ports[3] = new Rectangle(h * 8, h * 4, h, h);
		ports[4] = new Rectangle(h * 8, h * 8, h, h);
		ports[5] = new Rectangle(h * 4, h * 8, h, h);
		ports[6] = new Rectangle(0, h * 8, h, h);
		ports[7] = new Rectangle(0, h * 4, h, h);
		amount = ((King.WIDTH / 2) / (King.HEIGHT / 10) + 1);
		this.s = s;
	}

	public void render(Graphics2D g2) {
		g2.translate(-camX, -camY);
		int temp1 = 0;
		int temp2 = 0;
		temp1 += xoff;
		temp2 += yoff;
		for (int i = 0; i < spot.length; i++) {
			for (int j = 0; j < spot.length; j++) {
				g2.drawImage(Sprite.Hub[spot[i][j]].img, temp1, temp2, King.HEIGHT / 10, King.HEIGHT / 10, null);
				g2.setColor(Color.BLACK);
//				g2.drawRect(temp1, temp2, King.HEIGHT / 10, King.HEIGHT / 10);
				temp2 += King.HEIGHT / 10;
			}
			temp2 = 0;
			temp1 += King.HEIGHT / 10;
		}
		temp1 = 0;
//		for (int i = 0; i < amount; i++) {
//			if (i % 2 == 0) {
//				g2.drawImage(list[7].getImage(), temp1, (King.HEIGHT) - ((King.HEIGHT / 6) + (King.HEIGHT / 10)), King.HEIGHT / 6, King.HEIGHT / 6, null);
//			} else {
//				g2.drawImage(list[8].getImage(), temp1, (King.HEIGHT) - ((King.HEIGHT / 6) + (King.HEIGHT / 10)), King.HEIGHT / 6, King.HEIGHT / 6, null);
//			}
//			temp1 += King.HEIGHT / 6;
//		}
//		v.render(g2);
		o.render(g2);
	}

	public void tick() {
		camX = (o.getX() + (King.HEIGHT / 20)) - ((h * 9) / 2);
		camY = (o.getY() + (King.HEIGHT / 20)) - ((h * 10) / 2);
		if (camX > offsetMaxX) {
			camX = offsetMaxX;
		} else if (camX < offsetMinX) {
			camX = offsetMinX;
		}
		if (camY > offsetMaxY) {
			camY = offsetMaxY;
		} else if (camY < offsetMinY) {
			camY = offsetMinY;
		}
		o.tick();
//		v.tick();
//		mh.tick();
	}
}
