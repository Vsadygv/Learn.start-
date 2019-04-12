package Com.learnstart.main;

import Com.Graphics.Level;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Com.Graphics.Hub;
import Com.Graphics.Ogla.Sprite;
import Com.learnstart.Inputs.KeyBoard;
import Com.learnstart.Inputs.Mouse2;
import Com.learnstart.enums.Levels;

public class Screen extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextArea msg;
	double last1 = 0;
	public static int current;
	double last = 0;
	public boolean move = true;
	public Start s;
	public JPanel jp;
//	public ImageIcon Ogla;
	public static boolean next = true;
	public static Levels GameState = Levels.Intro;
//	public ImageIcon OChar;
	public static Canvas c;
	public BufferedImage img;
	public Hub gh;
	public Intro intro;
	public Mouse2 m;
	public KeyBoard kb;
	public Level level1;
	public static boolean can = true;

	public Screen(Start s) {
		kb = new KeyBoard();
		level1 = new Level(this);
		intro = new Intro(this);
		gh = new Hub(this);
		this.s = s;
		img = new BufferedImage(King.WIDTH, King.HEIGHT, BufferedImage.TYPE_INT_RGB);
		c = new Canvas();
		c.addKeyListener(kb);
//		c.addMouseListener(m = new Mouse2(gh));
		current = 0;
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		msg = new JTextArea(0, 3);
		msg.setEditable(false);
		msg.setLineWrap(true);
		msg.setWrapStyleWord(true);
		msg.setBackground(new Color(51, 51, 51));
		msg.setForeground(new Color(180, 254, 215));
		msg.setFont(new Font("Arial", 1, King.HEIGHT / 40));
		JScrollPane jsp = new JScrollPane(msg);
		jp.setBackground(Color.blue);
		jp.setMaximumSize(new Dimension((King.WIDTH / 2) - (King.HEIGHT / 10), King.HEIGHT / 10));
		jp.setMinimumSize(new Dimension((King.WIDTH / 2) - (King.HEIGHT / 10), King.HEIGHT / 10));
		jp.setPreferredSize(new Dimension((King.WIDTH / 2) - (King.HEIGHT / 10), King.HEIGHT / 10));
		jp.add(jsp, BorderLayout.EAST);
		jsp.setPreferredSize(new Dimension((King.WIDTH / 2) - (King.HEIGHT / 10), King.HEIGHT / 10));
		c.setPreferredSize(new Dimension((King.WIDTH / 2), King.HEIGHT));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(c, BorderLayout.EAST);
		add(jp, BorderLayout.PAGE_END);
		msg.requestFocus();
	}

	public void start() {

	}

	public void render() {
		BufferStrategy bs = c.getBufferStrategy();
		if (bs == null) {
			c.createBufferStrategy(3);
			return;
		}
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		Graphics g = bs.getDrawGraphics();
		if (GameState == Levels.Intro) {
			intro.render(g2);
		} else if (GameState == Levels.Hub) {
			gh.render(g2);
		} else if (GameState == Levels.Level1)
			level1.render(g2);
		g.drawImage(img, 0, 0, this);

		g.dispose();
		bs.show();
	}

	public void paint(Graphics g) {
		g.drawImage(Sprite.Ogla[28].img, 1, King.HEIGHT - (King.HEIGHT / 10) + 1, King.HEIGHT / 10 - 1, King.HEIGHT / 10 - 3, this);
	}

	public static void setNext(boolean b) {
		next = b;
	}

	public void tick() {
		double now = System.currentTimeMillis();
//		if (current == 4) {

//		} else if (current == 5) {
//			Start.editon(false);
//		}
		if ((now - last >= 100 && current < s.geth().getL().size() && !(s.geth().getL().get(current).equals(false))) && can) {
			if (s.geth().getL().get(current).equals(true))
				current++;
			msg.setText((String) s.geth().getL().get(current));
			last = now;
			current++;
			next = false;
			can = false;
		}
		if (GameState == Levels.Hub) {
			gh.tick();
			c.requestFocus();
		} else if (GameState == Levels.Intro)
			intro.tick();
		else if (GameState == Levels.Level1)
			level1.tick();
//		m.tick();
	}

	public static List<Image> setArray(URL url, String type) {
		List<Image> imgs = new ArrayList<Image>();
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
		return imgs;
	}
}

/* kevin's a dummy lol */
