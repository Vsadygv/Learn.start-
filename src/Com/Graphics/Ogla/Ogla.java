package Com.Graphics.Ogla;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import Com.learnstart.enums.Levels;
import Com.learnstart.main.King;
import Com.learnstart.main.Screen;
import Com.learnstart.main.Start;

public class Ogla {
	public List<Rectangle> Can, Cant;
	public int x = (King.HEIGHT / 10) * 8;
	public int y = (King.HEIGHT / 10) * 8;
	double last1 = 0;
	public static int dx;
	public static int dy;
	public int time, draw, current, h = King.HEIGHT / 10;
	public static ArrayList<Image> imgs;
	public Screen s;
	long last;
	Rectangle lake;
	Rectangle lake2;
	public static int index;
	public static boolean check;

	public Ogla(Screen s) {
		index = 0;
		lake = new Rectangle((h * 2) - (int) (h * .6), (h * 3) + (int) (h * .5), (h * 6) + (int) (h * .5), (h * 3));
		lake2 = new Rectangle((h * 9) + (int) (h * .1), (h * 3) + (int) (h * .5), (h * 5) + (int) (h * .5), (h * 3));
		Can = new ArrayList<Rectangle>();
		Cant = new ArrayList<Rectangle>();
		Can.add(new Rectangle(0, 0, h, h));
		Cant.add(new Rectangle(0, h * 8, h, h));
		Cant.add(new Rectangle(0, h * 16, h, h));
		Cant.add(new Rectangle(h * 8, 0, h, h));
		Cant.add(new Rectangle(h * 16, 0, h, h));
		Cant.add(new Rectangle(h * 16, h * 8, h, h));
		Cant.add(new Rectangle(h * 16, h * 16, h, h));
		Cant.add(new Rectangle(h * 8, h * 16, h, h));
		imgs = new ArrayList<Image>();
		imgs.add(Sprite.Ogla[0].img);
		this.s = s;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public void render(Graphics2D g2) {
		if (index >= imgs.size() - 1) {
			index = 0;
		}
		if (imgs.size() > 0)
			g2.drawImage(imgs.get(index), x, y, King.HEIGHT / 10, King.HEIGHT / 10, null);
		else
			g2.drawImage(Sprite.Ogla[0].img, x, y, King.HEIGHT / 10, King.HEIGHT / 10, null);
		g2.setColor(Color.RED);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, h - 1, h - 1);
	}

	@SuppressWarnings("unchecked")
	public void tick() {
		long now = System.currentTimeMillis();
		if (s.kb.pressed[0]) {
			dx = -King.WIDTH / 200;
		} else if (s.kb.pressed[2]) {
			dx = King.WIDTH / 200;
		} else {
			dx = 0;
		}
		if (s.kb.pressed[1]) {
			dy = -King.WIDTH / 200;
		} else if (s.kb.pressed[3]) {
			dy = King.WIDTH / 200;
		} else {
			dy = 0;
		}
		if (!s.kb.pressed[0] && !s.kb.pressed[1] && !s.kb.pressed[2] && !s.kb.pressed[3]) {
			imgs.add(Sprite.Ogla[0].img);
		}

		current = Screen.current;
		if (now - last1 >= 5) {
			x = Clamp((King.HEIGHT / 10 * 16), 0, x + dx);
			y = Clamp((King.HEIGHT / 10 * 16), 0, y + dy);
			last1 = now;
		}
		if (now - last >= 200) {
			index++;
			last = now;
		}
		if (check) {
			checkgraph();
		}
		if (index >= imgs.size() - 1) {
			index = 0;
		}
		if (dx > 0) {

		}
		for (int i = 0; i < Cant.size(); i++) {
			if (getBounds().intersects(Cant.get(i))) {
				x = Clamp((King.HEIGHT / 10 * 16), 0, x - dx);
				y = Clamp((King.HEIGHT / 10 * 16), 0, y - dy);
			}
		}
		if (getBounds().intersects(Can.get(0))) {
			Start.editon(true);
			Screen.GameState = Levels.Level1;
			s.s.geth().getL().set(22, true);
			Screen.can = true;
			Start.setTxt("package Com.Create; \n \n public class User { \n \npublic static boolean b;\npublic static int i; \npublic static double db; \npublic static String s; \npublic static char c;\n \t  public static void main(String[] args) { \n \n \t  } \n }");
		}

		if (getBounds().intersects(lake) || getBounds().intersects(lake2)) {
			x = Clamp((King.HEIGHT / 10 * 16), 0, x - dx);
			y = Clamp((King.HEIGHT / 10 * 16), 0, y - dy);
		}
	}

	public void checkgraph() {
		check = false;
		index = 0;
		imgs.removeAll(imgs);
		if (s.kb.pressed[0]) {
			Ogla.imgs.add(Sprite.Hflip((BufferedImage) Sprite.Ogla[14].img));
			Ogla.imgs.add(Sprite.Hflip((BufferedImage) Sprite.Ogla[15].img));
			Ogla.imgs.add(Sprite.Hflip((BufferedImage) Sprite.Ogla[16].img));
			Ogla.imgs.add(Sprite.Hflip((BufferedImage) Sprite.Ogla[17].img));
			Ogla.imgs.add(Sprite.Hflip((BufferedImage) Sprite.Ogla[18].img));
		} else if (s.kb.pressed[2]) {
			Ogla.imgs.add(Sprite.Ogla[14].img);
			Ogla.imgs.add(Sprite.Ogla[15].img);
			Ogla.imgs.add(Sprite.Ogla[16].img);
			Ogla.imgs.add(Sprite.Ogla[17].img);
			Ogla.imgs.add(Sprite.Ogla[18].img);
		}
		if (s.kb.pressed[1]) {
			Ogla.imgs.add(Sprite.Ogla[2].img);
		} else if (s.kb.pressed[3]) {
			Ogla.imgs.add(Sprite.Ogla[0].img);
		}
	}

	public void setArray(URL url, String type, int t) {
		imgs.clear();
		draw = 0;
		try {
			ImageReader reader = ImageIO.getImageReadersByFormatName(type).next();
			File input = new File(url.getPath());
			ImageInputStream stream = ImageIO.createImageInputStream(input);
			reader.setInput(stream);
			int count = reader.getNumImages(true);
			for (int index = 0; index < count; index++) {
				Image frame = reader.read(index);
				imgs.add(frame);
			}
		} catch (IOException ex) {
		}
		time = t;

	}

	public static int Clamp(int Max, int Min, int c) {
		if (c > Max) {
			return Max;
		} else if (c < Min) {
			return Min;
		}
		return c;
	}

	public int Bbounds(int c, int x, int y) {
		if (c > x) {

		}
		return c;
	}

}
