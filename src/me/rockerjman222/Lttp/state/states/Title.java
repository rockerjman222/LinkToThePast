package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.Audio;
import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.assets.animation.Animation;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.state.EnumStates;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class Title extends State {

	private StateManager stateManager;

	private HashMap<File, Audio> sfx = new HashMap<>();
	private BufferedImage[] triforceSprites = new BufferedImage[170];

	private Timer timer;
	private int count = 0;

	private boolean shouldDrawNintendo = false;
	private boolean shouldDrawCopyright = false;
	private boolean shouldDrawTriforce = false;
	private boolean shouldDrawBackground = false;
	private boolean shouldDrawTitle = false;
	private boolean shouldDrawSword = false;
	private boolean allowInput = false;

	private Animation triforceOne;
	private Animation triforceTwo;
	private Animation triforceThree;

	private int oneX = 0;
	private int oneY = Lttp.height;
	private int twoX = Lttp.width;
	private int twoY = Lttp.height;
	private int threeX = Lttp.width / 2 - (45 / 2 * Lttp.scale);
	private int threeY = -(45 * Lttp.scale);

	public Title(StateManager stateManager) {
		this.stateManager = stateManager;
		init();
	}

	@Override
	public void init() {
		this.sfx = new HashMap<>();
		this.sfx.put(Resources.rupee1, new Audio(Resources.rupee1));
		this.sfx.put(Resources.title, new Audio(Resources.title));

		this.timer = new Timer(100, e -> this.count++);
		this.timer.start();

		for (int x = 0; x < 170; x++) {
			BufferedImage[] image = new BufferedImage[170];
			image[x] = Resources.triforceSprites.getSubimage(x * 45, 0, 45, 45);
			this.triforceSprites[x] = image[x];
		}

		this.triforceOne = new Animation(this.triforceSprites, 4);
		this.triforceTwo = new Animation(this.triforceSprites, 4);
		this.triforceThree = new Animation(this.triforceSprites, 4);

	}

	@Override
	public void update() {

		this.triforceOne.update();
		this.triforceTwo.update();
		this.triforceThree.update();

		if(shouldDrawTriforce) {

			this.oneX += 1;
			this.oneY -= 1;
			this.twoX -= 2;
			this.twoY -= 1;
			this.threeY += 1;

			if (oneX >= Lttp.width / 2 - (45 * Lttp.scale))
				oneX = Lttp.width / 2 - (45 * Lttp.scale);

			if (oneY <= Lttp.height / 2)
				oneY = Lttp.height / 2;

			if (twoX <= Lttp.width / 2)
				twoX = Lttp.width / 2;

			if (twoY <= Lttp.height / 2)
				twoY = Lttp.height / 2;

			if (threeY >= Lttp.height / 2 - (45 * Lttp.scale))
				threeY = Lttp.height / 2 - (45 * Lttp.scale);

		}

		if (count == 15) {
			shouldDrawNintendo = true;
			sfx.get(Resources.rupee1).play();
		}

		if (count == 35)
			shouldDrawNintendo = false;

		if (count == 40) {
			shouldDrawCopyright = true;
		}

		if (count == 60) {
			sfx.get(Resources.title).play();
		}

		if (count == 45) {
			shouldDrawTriforce = true;
		}

		if (count == 130) {
			shouldDrawBackground = true;
		}

		if (count == 140) {
			shouldDrawTitle = true;
		}

		if (count == 145) {
			shouldDrawSword = true;
		}

		if(count == 200) {
			allowInput = true;
		}

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Lttp.width, Lttp.height);

		if (shouldDrawNintendo)
			g.drawImage(Resources.nintendo, Lttp.width / 2 - (56 * Lttp.scale / 2), Lttp.height / 2 - (16 * Lttp.scale / 2), 56 * Lttp.scale, 16 * Lttp.scale, null);

		if (shouldDrawCopyright)
			g.drawImage(Resources.copyright, Lttp.width / 2 - (103 * Lttp.scale / 2), Lttp.height - 100, 103 * Lttp.scale, 8 * Lttp.scale, null);

		if (shouldDrawTriforce) {
			this.triforceOne.start();
			this.triforceTwo.start();
			this.triforceThree.start();
			g.drawImage(triforceOne.getSprite(), oneX, oneY, 45 * Lttp.scale, 45 * Lttp.scale, null);
			g.drawImage(triforceTwo.getSprite(), twoX, twoY, 45 * Lttp.scale, 45 * Lttp.scale, null);
			g.drawImage(triforceThree.getSprite(), threeX, threeY, 45 * Lttp.scale, 45 * Lttp.scale, null);
		}

		if (this.triforceOne.hasPlayedOnce() && this.triforceTwo.hasPlayedOnce() && this.triforceThree.hasPlayedOnce()) {
			this.triforceOne.stop();
			this.triforceTwo.stop();
			this.triforceThree.stop();
			g.drawImage(Resources.triforce, Lttp.width / 2 - (82 * Lttp.scale / 2), Lttp.height / 2 - (81 * Lttp.scale / 2), 82 * Lttp.scale, 81 * Lttp.scale, null);
		}

		if (shouldDrawBackground) {
			g.drawImage(Resources.background, Lttp.width / 2 - (256 * Lttp.scale / 2), Lttp.height / 2 - (144 * Lttp.scale / 2), 256 * Lttp.scale, 144 * Lttp.scale, null);
			g.drawImage(Resources.triforce, Lttp.width / 2 - (82 * Lttp.scale / 2), Lttp.height / 2 - (81 * Lttp.scale / 2), 82 * Lttp.scale, 81 * Lttp.scale, null);
		}

		if (shouldDrawTitle) {
			g.drawImage(Resources.logo, Lttp.width / 2 - (174 * Lttp.scale / 2), Lttp.height / 2 - (128 * Lttp.scale / 2), 174 * Lttp.scale, 128 * Lttp.scale, null);
		}

		if (shouldDrawSword) {
			int swordY;
			for (swordY = -128; swordY < Lttp.height / 2; swordY++) {
				//g.drawImage(Resources.sword, Lttp.width / 4, swordY, 31 * Lttp.scale, 128 * Lttp.scale, null);
				if (swordY == Lttp.height / 4)
					break;
			}
		}

	}

	@Override
	public void keyPressed(int k) {
		if(allowInput) {
			switch (k) {
				case KeyEvent.VK_SPACE:
					this.stateManager.setState(EnumStates.INTRO.getState());
					break;
			}
		}
	}

	@Override
	public void keyReleased(int k) {

	}
}
