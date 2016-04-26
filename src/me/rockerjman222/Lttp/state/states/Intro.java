package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.EnumSprites;
import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.main.Lttp;
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
		Resources.init();
		Resources.music.get(Resources.opening).play();
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Lttp.width, Lttp.height);





		g.drawImage(Resources.introSlides.getSubimage(EnumSprites.INTRO_SLIDE_ONE.getX(), EnumSprites.INTRO_SLIDE_ONE.getY(), EnumSprites.INTRO_SLIDE_ONE.getWidth(), EnumSprites.INTRO_SLIDE_ONE.getHeight()),
				Lttp.width / 2 - (EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale / 2),
				Lttp.height / 2 - (EnumSprites.INTRO_SLIDE_FOUR.getHeight() * Lttp.scale / 2),
				EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale,
				EnumSprites.INTRO_SLIDE_ONE.getHeight() * Lttp.scale,
				null
		);
	}

	@Override
	public void keyPressed(int k) {
	}

	@Override
	public void keyReleased(int k) {

	}
}