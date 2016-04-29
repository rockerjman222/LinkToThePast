package me.rockerjman222.Lttp.state;

import javax.swing.*;
import java.awt.*;

public abstract class State {

	private Timer timer;
	protected int count = 0;

	protected StateManager stateManager;

	private State state;

	public void init(){

		this.timer = new Timer(100, e -> this.count++);
		this.timer.start();

	}

	public abstract void update();

	public abstract void draw(Graphics2D g);

	public abstract void keyPressed(int k);

	public abstract void keyReleased(int k);


}
