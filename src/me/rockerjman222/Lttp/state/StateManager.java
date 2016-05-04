package me.rockerjman222.Lttp.state;

import me.rockerjman222.Lttp.assets.management.AnimationScheduler;
import me.rockerjman222.Lttp.state.states.Intro;
import me.rockerjman222.Lttp.state.states.Title;

import java.awt.*;

public class StateManager {

	public State[] states;

	private int currentState;
	public AnimationScheduler scheduler = new AnimationScheduler();

	public StateManager() {
		this.states = new State[EnumStates.TOTAL_STATES.getState()];
		this.currentState = EnumStates.INTRO.getState();
		loadState(this.currentState);
	}

	private void loadState(int state) {
		this.scheduler.getScheduleList().clear();
		if (state == EnumStates.TITLE.getState())
			this.states[state] = new Title(this);
		else if (state == EnumStates.INTRO.getState())
			this.states[state] = new Intro(this);
	}

	private void unloadState(int state) {
		this.states[state] = null;
	}

	public void setState(int state) {
		unloadState(this.currentState);
		this.currentState = state;
		loadState(this.currentState);
	}

	public int getCurrentState() {
		return this.currentState;
	}

	public void update() {
		if (this.states[this.currentState] != null)
			this.states[this.currentState].update();
	}

	public void draw(Graphics2D g) {
		if (this.states[this.currentState] != null) {
			this.states[this.currentState].draw(g);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
		}
	}

	public void keyPressed(int k) {
		this.states[this.currentState].keyPressed(k);
	}

	public void keyReleased(int k) {
		this.states[this.currentState].keyReleased(k);
	}
}