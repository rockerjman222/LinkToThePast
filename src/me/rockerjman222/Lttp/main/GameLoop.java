package me.rockerjman222.Lttp.main;

import me.rockerjman222.Lttp.assets.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameLoop extends JPanel implements Runnable, KeyListener {

	private long time;

	private Thread mainThread;
	private boolean running = false;
	private int fps = 60;
	private long targetTime = 1000 / fps;

	private BufferedImage image;
	private Graphics graphics;

	public GameLoop() {
		super();
		setPreferredSize(new Dimension(Lttp.width, Lttp.height));
		setFocusable(true);
		requestFocus();
		setVisible(true);
	}

	public void addNotify() {
		super.addNotify();
		if(this.mainThread == null) {
			this.mainThread = new Thread(this);
			addKeyListener(this);
			this.mainThread.start();
		}
	}

	public void init() {
		this.image = new BufferedImage(Lttp.width, Lttp.height, BufferedImage.TYPE_INT_RGB);
		this.graphics = this.image.getGraphics();
		this.running = true;
	}

	@Override
	public void run() {
		init();

		long start = 1;
		long elapsed;
		long wait;

		while(this.running) {
			update();
			draw();
			drawToScreen();

			elapsed = System.nanoTime() - start;

			wait = this.targetTime - elapsed / 100000;
			if(wait < 0)
				wait = 5;

			try {
				Thread.sleep(wait);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void update() {

	}

	private void draw() {
		graphics.drawImage(Resources.windowIcon, 10, 10, 256, 256, null);
		graphics.setFont(new Font("Return of Ganon", Font.PLAIN, 75));
		graphics.drawString("Test", 300, 300);
	}

	private void drawToScreen() {
		Graphics g = getGraphics();
		g.drawImage(this.image, 0, 0, Lttp.width, Lttp.height, null);
		g.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
