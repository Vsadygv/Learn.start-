package Com.learnstart.main;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Com.Graphics.Ogla.Sprite;
import Com.learnstart.Inputs.KeyBoard;
import Com.learnstart.Inputs.Mouse;

public class King extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private boolean running = false;
	private boolean ingame = false;
	private Thread thread;
	public static JFrame f;
	public Screen Scrn;
	public Start s;
	public JPanel Background;
	public JPanel holder;
	public MainMenu mm;
	public CardLayout cl;
	public Mouse m = new Mouse(this);
	public KeyBoard key;

	public King() {
		f = new JFrame();
		f.setUndecorated(true);
		f.pack();
		key = new KeyBoard();
		f.addKeyListener(key);
		start();
		mm = new MainMenu();
		holder = new JPanel();
		Background = new JPanel();
		Background.setLayout(cl = new CardLayout());
		holder.setLayout(new GridLayout(1, 0));
		s = new Start();
		holder.add(Scrn = new Screen(s));
		holder.add(s);
		Background.add(mm, "1");
		Background.add(holder, "2");
		cl.show(Background, "1");
		f.add(Background);
		f.setSize(King.WIDTH, King.HEIGHT);
		f.setLocationRelativeTo(null);
		f.setResizable(true);
		f.setVisible(true);
		f.setIconImage(Sprite.Ogla[0].img);
		f.addMouseListener(m);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.err.println("Exiting Game");
				stop();
			}
		});
	}

	public void show1() {
		cl.show(Background, "1");
		ingame = false;
	}

	public void show2() {
		cl.show(Background, "2");
		ingame = true;
	}

	public boolean ingame() {
		return ingame;
	}

	public void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this, "Main-Thread");
		thread.start();
	}

	public void run() {
		double target = 60.0;
		double nsPerTick = 1000000000.0 / target;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double unprocessed = 0.0;
		int fps = 0;
		int tps = 0;
		boolean canRender = false;
		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;

			if (unprocessed >= 1.0) {
				tick();
				unprocessed--;
				tps++;
				canRender = true;
			} else
				canRender = false;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (canRender) {
				render();
				fps++;
			}
			if (System.currentTimeMillis() - 1000 > timer) {
				timer += 1000;
				System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
				fps = 0;
				tps = 0;
			}
		}
		System.exit(0);
	}

	private void tick() {
		if (ingame) {
			Scrn.tick();
		}
	}

	private void render() {
		if (ingame) {
			Scrn.render();
		}

	}

	public void stop() {
		if (!running)
			return;
		running = false;
	}

	public static void main(String[] args) {

		new King();

	}
}