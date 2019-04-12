package Com.Graphics.Ogla;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheets {
	private String path;
	public final int SIZE;
	public int[] pixels;
	public BufferedImage image;
	public static SpriteSheets Ogla = new SpriteSheets("/Com/Graphics/Ogla/Twiggy_spritesheet_2.png", 192, 384);
	public static SpriteSheets land = new SpriteSheets("/Com/Graphics/Ogla/Land_TitleSheet.png", 32, 224);
	public static SpriteSheets Mount = new SpriteSheets("/Com/Graphics/land/Background2.png", 160, 160);
	public static SpriteSheets Hub = new SpriteSheets("/Com/Graphics/land/Land_TitleSheet_Hub2.png", 96, 256);

	public SpriteSheets(String path, int h, int w) {
		this.path = path;
		SIZE = h * w;
		pixels = new int[h * w];
		load();
	}

	public void load() {
		try {
			image = ImageIO.read(SpriteSheets.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			image = Ogla.image;
		}
	}

}
