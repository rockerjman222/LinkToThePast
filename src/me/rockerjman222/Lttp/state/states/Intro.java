package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.state.EnumStates;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import java.awt.*;

public class Intro extends State {

	private StateManager stateManager;

	public Intro(StateManager stateManager) {
		this.stateManager = stateManager;
		init();
	}

	@Override
	public void init() {

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics2D g) {
		g.setFont(Resources.defaultFont.deriveFont(Font.PLAIN, 72));
		g.setStroke(new BasicStroke(2));
		g.drawString("TITLE", Lttp.width / 2 - g.getFontMetrics().stringWidth("title") / 2, 100);
	}

	@Override
	public void keyPressed(int k) {
		//if(k == 32)
		//stateManager.setState(EnumStates.TITLE.getState());
	}

	@Override
	public void keyReleased(int k) {

	}
}