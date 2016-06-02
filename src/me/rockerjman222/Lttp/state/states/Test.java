package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.map.Map;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test extends State {

	private StateManager stateManager;

	private Map map;
	Point testingPoint = new Point(0, 0);

	public Test(StateManager stateManager) {
		this.stateManager = stateManager;
		this.map = new Map();
		this.map.loadMap(Resources.test);

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Lttp.width, Lttp.height);

		this.map.drawMap(g, testingPoint);


		//g.drawImage(Resources.bush01, 100, 100, 96, 96, null);

		for(int x = 0; x <= Lttp.width; x++) {
			for(int y = 0; y <= Lttp.height; y++) {
				//g.drawImage(Resources.overworldTileSet[105], 64 * x, 64 * y, 64, 64, null);
			}
		}

		//g.drawImage(Resources.overworldTileSheet[1], 100, 100, 64, 64, null);
	}

	@Override
	public void keyPressed(int k) {

		switch (k) {
			case KeyEvent.VK_UP:
				testingPoint.translate(0, -2);
				break;
			case KeyEvent.VK_DOWN:
				testingPoint.translate(0, 2);
				break;
			case KeyEvent.VK_LEFT:
				testingPoint.translate(-2, 0);
				break;
			case KeyEvent.VK_RIGHT:
				testingPoint.translate(2, 0);
				break;
		}

	}

	@Override
	public void keyReleased(int k) {

	}
}
