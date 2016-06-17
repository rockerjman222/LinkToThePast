package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.map.Camera;
import me.rockerjman222.Lttp.map.Map;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test extends State {

	private StateManager stateManager;

	private Camera camera;

	private Map map;
	Point testingPoint = new Point(0, 0);

	public Test(StateManager stateManager) {
		this.stateManager = stateManager;
		this.map = new Map();
		this.map.loadMap(Resources.test);

		this.camera = new Camera(0, 0);

	}

	@Override
	public void update() {
		this.camera.centerOnPoint(this.testingPoint);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Lttp.width, Lttp.height);

		this.map.drawMap(g, this.camera.getXOffset(), this.camera.getYOffset());

		g.setColor(Color.RED);
		g.fillOval((int) (testingPoint.getX() - this.camera.getXOffset()), (int) (testingPoint.getY() - this.camera.getYOffset()), 50, 50);
	}

	@Override
	public void keyPressed(int k) {
		int speed = 8;

		switch (k) {
			case KeyEvent.VK_UP:
				testingPoint.translate(0, -speed);
				break;
			case KeyEvent.VK_DOWN:
				testingPoint.translate(0, speed);
				break;
			case KeyEvent.VK_LEFT:
				testingPoint.translate(-speed, 0);
				break;
			case KeyEvent.VK_RIGHT:
				testingPoint.translate(speed, 0);

				break;
		}

	}

	@Override
	public void keyReleased(int k) {

	}
}
