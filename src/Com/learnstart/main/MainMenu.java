package Com.learnstart.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	public Polygon text1, text2, text3;
	private ImageIcon Learnstart;

	public MainMenu() {
		Learnstart = new ImageIcon(getClass().getResource("/Com/Main/Main.png"));
		int textx[] = new int[4];
		int text1y[] = new int[4];
		int text2y[] = new int[4];
		int text3y[] = new int[4];
		textx[0] = 0;
		textx[1] = King.WIDTH;
		textx[2] = King.WIDTH;
		textx[3] = 0;
		text1y[0] = King.HEIGHT * 39 / 80;
		text1y[1] = King.HEIGHT * 39 / 80;
		text1y[2] = King.HEIGHT * 23 / 40;
		text1y[3] = King.HEIGHT * 23 / 40;
		text1 = new Polygon(textx, text1y, 4);
		text2y[0] = King.HEIGHT * 47 / 80;
		text2y[1] = King.HEIGHT * 47 / 80;
		text2y[2] = King.HEIGHT * 27 / 40;
		text2y[3] = King.HEIGHT * 27 / 40;
		text2 = new Polygon(textx, text2y, 4);
		text3y[0] = King.HEIGHT * 55 / 80;
		text3y[1] = King.HEIGHT * 55 / 80;
		text3y[2] = King.HEIGHT * 31 / 40;
		text3y[3] = King.HEIGHT * 31 / 40;
		text3 = new Polygon(textx, text3y, 4);
	}

	public void paint(Graphics g) {
		g.setColor(new Color(75, 105, 131));
		g.fillRect(0, 0, King.WIDTH, King.HEIGHT);
		g.drawImage(Learnstart.getImage(), (King.WIDTH - King.HEIGHT) / 2, 0, King.HEIGHT, King.HEIGHT, null);
		Graphics2D g2 = (Graphics2D) g;
		Composite c1 = g2.getComposite();
		Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f);
		g2.setComposite(c);
		g2.setColor(Color.BLACK);
		if (isMouse(text1)) {
			g2.fillPolygon(text1);
		} else if (isMouse(text2)) {
			g2.fillPolygon(text2);
		} else if (isMouse(text3)) {
			g2.fillPolygon(text3);
		}
		g2.setComposite(c1);
		g.setFont(new Font("Arial", 1, King.HEIGHT / 20));
		g.setColor(new Color(179, 255, 214));
		g.drawString("New Game", WIDTH / 100, King.HEIGHT * 11 / 20);
		g.drawString("Load Game", WIDTH / 100, King.HEIGHT * 13 / 20);
		g.drawString("Quit", WIDTH / 100, King.HEIGHT * 15 / 20);
		repaint();
	}

	public boolean isMouse(Polygon P) {
		Point Mousepos = MouseInfo.getPointerInfo().getLocation();
		return P.contains(Mousepos);
	}
}
