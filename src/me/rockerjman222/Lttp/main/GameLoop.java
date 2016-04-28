package me.rockerjman222.Lttp.main;

import me.rockerjman222.Lttp.state.StateManager;

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
	private Graphics2D graphics;

	private StateManager stateManager;

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
		this.image = new BufferedImage(Lttp.width, Lttp.height, BufferedImage.TYPE_INT_ARGB);
		this.graphics = (Graphics2D) this.image.getGraphics();
		this.running = true;
		this.stateManager = new StateManager();
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
		this.stateManager.update();
	}

	private void draw() {
		this.stateManager.draw(this.graphics);
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
		this.stateManager.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.stateManager.keyReleased(e.getKeyCode());
	}
}
