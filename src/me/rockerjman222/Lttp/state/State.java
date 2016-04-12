package me.rockerjman222.Lttp.state;

import java.awt.*;

public abstract class State {

	protected StateManager stateManager;

	private State state;

	public abstract void init();

	public abstract void update();

	public abstract void draw(Graphics2D g);

	public abstract void keyPressed(int k);

	public abstract void keyReleased(int k);

}
