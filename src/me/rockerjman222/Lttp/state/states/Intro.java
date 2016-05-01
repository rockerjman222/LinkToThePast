package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.BitmapFont;
import me.rockerjman222.Lttp.assets.EnumSprites;
import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.assets.management.ResourceSchedule;
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
		super.init();
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(1, Resources.music.get(Resources.opening), -1));
	}

	@Override
	public void update() {

		this.stateManager.scheduler.updateResources(count);

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Lttp.width, Lttp.height);

		this.stateManager.scheduler.drawResources(g);

		for(int x = 0; x < 500; x++) {
			for(int y = 0; y < 500; y++) {
				g.drawImage(Resources.backgroundOne, x * (16 * Lttp.scale), y * (16 * Lttp.scale), 16 * Lttp.scale, 16 * Lttp.scale, null);
				//g.drawImage(Resources.backgroundTwo, x * (15 * Lttp.scale), y * (15 * Lttp.scale), 15 * Lttp.scale, 15 * Lttp.scale, null);
			}
		}

		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0, 0, Lttp.width, Lttp.height / 6);
		g.fillRect(0, Lttp.height - (Lttp.height / 6), Lttp.width, Lttp.height / 6);
		g.fillRect(0, Lttp.height / 6, Lttp.width / 8, Lttp.height - (Lttp.height / 6) * 2);
		g.fillRect(Lttp.width - (Lttp.width / 8), Lttp.height / 6, Lttp.width / 8, Lttp.height - (Lttp.height / 6) * 2);

		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(Lttp.width / 2 - (EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale / 2) + 5 * Lttp.scale, Lttp.height / 2 - (EnumSprites.INTRO_SLIDE_ONE.getHeight() * Lttp.scale / 2) - 25 * Lttp.scale, EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale, EnumSprites.INTRO_SLIDE_ONE.getHeight() * Lttp.scale);

		g.drawImage(Resources.introSlides.getSubimage(EnumSprites.INTRO_SLIDE_ONE.getX(), EnumSprites.INTRO_SLIDE_ONE.getY(), EnumSprites.INTRO_SLIDE_ONE.getWidth(), EnumSprites.INTRO_SLIDE_ONE.getHeight()),
				Lttp.width / 2 - (EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale / 2),
				Lttp.height / 2 - (EnumSprites.INTRO_SLIDE_FOUR.getHeight() * Lttp.scale / 2) - 30 * Lttp.scale,
				EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale,
				EnumSprites.INTRO_SLIDE_ONE.getHeight() * Lttp.scale,
				null
		);

		//g.drawImage(Resources.fontSheet, 20, 20, 24, 52, null);

		//BitmapFont.draw(g, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 20, 100);
		//BitmapFont.draw(g, "abcdefghijklmnopqrstuvwxyz", 20, 20);

		BitmapFont.draw(g, "lmnopqr", 20, 180);



	}

	@Override
	public void keyPressed(int k) {
	}

	@Override
	public void keyReleased(int k) {

	}
}