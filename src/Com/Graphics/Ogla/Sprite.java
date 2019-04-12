package Com.Graphics.Ogla;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Sprite {
	private final int SIZE;
	public int x, y;
	public int[] pixels;
	public Image img;
	private SpriteSheets sheet;
	public static Sprite[] Ogla = new Sprite[] { new Sprite(32, 1, 2, SpriteSheets.Ogla), new Sprite(32, 2, 2, SpriteSheets.Ogla), new Sprite(32, 3, 2, SpriteSheets.Ogla), new Sprite(32, 4, 2, SpriteSheets.Ogla), new Sprite(32, 5, 2, SpriteSheets.Ogla), new Sprite(32, 6, 2, SpriteSheets.Ogla), new Sprite(32, 7, 2, SpriteSheets.Ogla), new Sprite(32, 8, 2, SpriteSheets.Ogla), new Sprite(32, 9, 2, SpriteSheets.Ogla), new Sprite(32, 10, 2, SpriteSheets.Ogla), new Sprite(32, 11, 2, SpriteSheets.Ogla), new Sprite(32, 1, 3, SpriteSheets.Ogla), new Sprite(32, 2, 2, SpriteSheets.Ogla), new Sprite(32, 3, 3, SpriteSheets.Ogla), new Sprite(32, 4, 3, SpriteSheets.Ogla), new Sprite(32, 5, 3, SpriteSheets.Ogla), new Sprite(32, 6, 3, SpriteSheets.Ogla), new Sprite(32, 7, 3, SpriteSheets.Ogla), new Sprite(32, 8, 3, SpriteSheets.Ogla), new Sprite(32, 9, 3, SpriteSheets.Ogla), new Sprite(32, 10, 3, SpriteSheets.Ogla), new Sprite(32, 11, 3, SpriteSheets.Ogla), new Sprite(32, 1, 4, SpriteSheets.Ogla),
			new Sprite(32, 2, 4, SpriteSheets.Ogla), new Sprite(32, 3, 4, SpriteSheets.Ogla), new Sprite(32, 4, 4, SpriteSheets.Ogla), new Sprite(32, 5, 4, SpriteSheets.Ogla), new Sprite(32, 6, 4, SpriteSheets.Ogla), new Sprite(32, 7, 1, SpriteSheets.Ogla) };
	public static Sprite[] s = new Sprite[] { new Sprite(32, 0, 0, SpriteSheets.land), new Sprite(32, 1, 0, SpriteSheets.land), new Sprite(32, 2, 0, SpriteSheets.land), new Sprite(32, 3, 0, SpriteSheets.land), new Sprite(32, 4, 0, SpriteSheets.land), new Sprite(32, 5, 0, SpriteSheets.land), new Sprite(32, 6, 0, SpriteSheets.land) };
	public static Sprite[] mount = new Sprite[] { new Sprite(32, 0, 0, SpriteSheets.Mount), new Sprite(32, 1, 0, SpriteSheets.Mount), new Sprite(32, 2, 0, SpriteSheets.Mount), new Sprite(32, 3, 0, SpriteSheets.Mount), new Sprite(32, 4, 0, SpriteSheets.Mount), new Sprite(32, 0, 1, SpriteSheets.Mount), new Sprite(32, 1, 1, SpriteSheets.Mount), new Sprite(32, 2, 1, SpriteSheets.Mount), new Sprite(32, 3, 1, SpriteSheets.Mount), new Sprite(32, 4, 1, SpriteSheets.Mount), new Sprite(32, 0, 2, SpriteSheets.Mount), new Sprite(32, 1, 2, SpriteSheets.Mount), new Sprite(32, 2, 2, SpriteSheets.Mount), new Sprite(32, 3, 2, SpriteSheets.Mount), new Sprite(32, 4, 2, SpriteSheets.Mount), new Sprite(32, 0, 3, SpriteSheets.Mount), new Sprite(32, 1, 3, SpriteSheets.Mount), new Sprite(32, 2, 3, SpriteSheets.Mount), new Sprite(32, 3, 3, SpriteSheets.Mount), new Sprite(32, 4, 3, SpriteSheets.Mount), new Sprite(32, 0, 4, SpriteSheets.Mount), new Sprite(32, 1, 4, SpriteSheets.Mount),
			new Sprite(32, 2, 4, SpriteSheets.Mount), new Sprite(32, 3, 4, SpriteSheets.Mount), new Sprite(32, 4, 4, SpriteSheets.Mount) };
	public static Sprite[] Hub = new Sprite[] { new Sprite(32, 0, 0, SpriteSheets.Hub), new Sprite(32, 1, 0, SpriteSheets.Hub), new Sprite(32, 2, 0, SpriteSheets.Hub), new Sprite(32, 3, 0, SpriteSheets.Hub), new Sprite(32, 4, 0, SpriteSheets.Hub), new Sprite(32, 5, 0, SpriteSheets.Hub), new Sprite(32, 6, 0, SpriteSheets.Hub), new Sprite(32, 7, 0, SpriteSheets.Hub), new Sprite(32, 0, 1, SpriteSheets.Hub), new Sprite(32, 1, 1, SpriteSheets.Hub), new Sprite(32, 2, 1, SpriteSheets.Hub), new Sprite(32, 3, 1, SpriteSheets.Hub), new Sprite(32, 4, 1, SpriteSheets.Hub), new Sprite(32, 5, 1, SpriteSheets.Hub), new Sprite(32, 6, 1, SpriteSheets.Hub), new Sprite(32, 7, 1, SpriteSheets.Hub), new Sprite(32, 0, 2, SpriteSheets.Hub), new Sprite(32, 1, 2, SpriteSheets.Hub), new Sprite(32, 2, 2, SpriteSheets.Hub), new Sprite(32, 3, 2, SpriteSheets.Hub) };

	public Sprite(int size, int x, int y, SpriteSheets sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	private void load() {
		img = sheet.image.getSubimage(x, y, SIZE, SIZE);
	}

	public static Image Vflip(BufferedImage image) {
		AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
		tx.translate(0, -image.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);

//		 Flip the image horizontally
		tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);

		return image;
	}

	public static Image Hflip(BufferedImage image) {
		AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
		tx.translate(0, -image.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);

		// Flip the image vertically and horizontally; equivalent to rotating the image
		// 180 degrees
		tx = AffineTransform.getScaleInstance(-1, -1);
		tx.translate(-image.getWidth(null), -image.getHeight(null));
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
}
