package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import java.awt.*;

public class Test extends State {

	private StateManager stateManager;

	public Test(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Lttp.width, Lttp.height);

		for(int x = 0; x <= Lttp.width; x++) {
			for(int y = 0; y <= Lttp.height; y++) {
				g.drawImage(Resources.overworldTileSheet[105], 64 * x, 64 * y, 64, 64, null);
			}
		}

		//g.drawImage(Resources.overworldTileSheet[1], 100, 100, 64, 64, null);
	}

	@Override
	public void keyPressed(int k) {

	}

	@Override
	public void keyReleased(int k) {

	}
}
