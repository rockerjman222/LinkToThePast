package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.BitmapFont;
import me.rockerjman222.Lttp.assets.EnumSprites;
import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.assets.management.ImageSchedule;
import me.rockerjman222.Lttp.assets.management.ResourceSchedule;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.UUID;

public class Intro extends State {

	private StateManager stateManager;

	public Intro(StateManager stateManager) {
		this.stateManager = stateManager;
		init();
	}

	private UUID introOne;
	private UUID introTwo;
	private UUID introThree;
	private UUID introFour;

	private UUID currentSlide;

	@Override
	public void init() {
		super.init();
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(1, Resources.music.get(Resources.opening), -1));
		this.introOne = this.stateManager.scheduler.scheduleResource(new ResourceSchedule(1,
				new ImageSchedule(Resources.introSlides.getSubimage(EnumSprites.INTRO_SLIDE_ONE.getX(), EnumSprites.INTRO_SLIDE_ONE.getY(), EnumSprites.INTRO_SLIDE_ONE.getWidth(), EnumSprites.INTRO_SLIDE_ONE.getHeight()),
						Lttp.width / 2 - (EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale / 2),
						Lttp.height / 2 - (EnumSprites.INTRO_SLIDE_FOUR.getHeight() * Lttp.scale / 2) - 30 * Lttp.scale,
						EnumSprites.INTRO_SLIDE_ONE.getWidth() * Lttp.scale,
						EnumSprites.INTRO_SLIDE_ONE.getHeight() * Lttp.scale), -1));
		this.introTwo = this.stateManager.scheduler.scheduleResource(new ResourceSchedule(-1,
				new ImageSchedule(Resources.introSlides.getSubimage(EnumSprites.INTRO_SLIDE_TWO.getX(), EnumSprites.INTRO_SLIDE_TWO.getY(), EnumSprites.INTRO_SLIDE_TWO.getWidth(), EnumSprites.INTRO_SLIDE_TWO.getHeight()),
						Lttp.width / 2 - (EnumSprites.INTRO_SLIDE_TWO.getWidth() * Lttp.scale / 2),
						Lttp.height / 2 - (EnumSprites.INTRO_SLIDE_FOUR.getHeight() * Lttp.scale / 2) - 30 * Lttp.scale,
						EnumSprites.INTRO_SLIDE_TWO.getWidth() * Lttp.scale,
						EnumSprites.INTRO_SLIDE_TWO.getHeight() * Lttp.scale), -1));
		this.introThree = this.stateManager.scheduler.scheduleResource(new ResourceSchedule(-1,
				new ImageSchedule(Resources.introSlides.getSubimage(EnumSprites.INTRO_SLIDE_THREE.getX(), EnumSprites.INTRO_SLIDE_THREE.getY(), EnumSprites.INTRO_SLIDE_THREE.getWidth(), EnumSprites.INTRO_SLIDE_THREE.getHeight()),
						Lttp.width / 2 - (EnumSprites.INTRO_SLIDE_THREE.getWidth() * Lttp.scale / 2),
						Lttp.height / 2 - (EnumSprites.INTRO_SLIDE_FOUR.getHeight() * Lttp.scale / 2) - 30 * Lttp.scale,
						EnumSprites.INTRO_SLIDE_THREE.getWidth() * Lttp.scale,
						EnumSprites.INTRO_SLIDE_THREE.getHeight() * Lttp.scale), -1));
		this.introFour = this.stateManager.scheduler.scheduleResource(new ResourceSchedule(-1,
				new ImageSchedule(Resources.introSlides.getSubimage(EnumSprites.INTRO_SLIDE_FOUR.getX(), EnumSprites.INTRO_SLIDE_FOUR.getY(), EnumSprites.INTRO_SLIDE_FOUR.getWidth(), EnumSprites.INTRO_SLIDE_FOUR.getHeight()),
						Lttp.width / 2 - (EnumSprites.INTRO_SLIDE_FOUR.getWidth() * Lttp.scale / 2),
						Lttp.height / 2 - (EnumSprites.INTRO_SLIDE_FOUR.getHeight() * Lttp.scale / 2) - 30 * Lttp.scale,
						EnumSprites.INTRO_SLIDE_FOUR.getWidth() * Lttp.scale,
						EnumSprites.INTRO_SLIDE_FOUR.getHeight() * Lttp.scale), -1));

		this.currentSlide = this.introOne;


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
				g.drawImage(Resources.backgroundTwo, x * (15 * Lttp.scale), y * (15 * Lttp.scale), 15 * Lttp.scale, 15 * Lttp.scale, null);
			}
		}

		g.setColor(new Color(0, 0, 0, 130));
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

		BitmapFont.draw(g, "This is me testing the font! *", 20, 180);

	}

	@Override
	public void keyPressed(int k) {

		ResourceSchedule current = this.stateManager.scheduler.getResource(this.currentSlide);
		ResourceSchedule next;

		if (k == KeyEvent.VK_SPACE && current != null) {
			if (this.currentSlide == introOne) {
				next = this.stateManager.scheduler.getResource(this.introTwo);
				if (next != null) {
					current.setIntendedStop(this.count);
					next.setIntendedStart(this.count);
					this.currentSlide = this.introTwo;
				}
			} else if (this.currentSlide == introTwo) {
				next = this.stateManager.scheduler.getResource(this.introThree);
				if (next != null) {
					current.setIntendedStop(this.count);
					next.setIntendedStart(this.count);
					this.currentSlide = this.introThree;
				}
			} else if (this.currentSlide == introThree) {
				next = this.stateManager.scheduler.getResource(this.introFour);
				if (next != null) {
					current.setIntendedStop(this.count);
					next.setIntendedStart(this.count);
					this.currentSlide = this.introFour;
				}
			} else if (this.currentSlide == introFour) {
				next = this.stateManager.scheduler.getResource(this.introOne);
				if (next != null) {
					current.setIntendedStop(this.count);

				}
			}
		}


	}

	@Override
	public void keyReleased(int k) {

	}
}