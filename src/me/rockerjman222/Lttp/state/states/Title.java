package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.assets.animation.Animation;
import me.rockerjman222.Lttp.assets.animation.AnimationPath;
import me.rockerjman222.Lttp.assets.management.ImageSchedule;
import me.rockerjman222.Lttp.assets.management.ResourceSchedule;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.state.EnumStates;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Title extends State {

	private StateManager stateManager;

	private BufferedImage[] triforceSprites = new BufferedImage[170];

	private boolean allowInput = false;

	public Title(StateManager stateManager) {
		this.stateManager = stateManager;
		init();
	}

	@Override
	public void init() {

		super.init();

		for (int x = 0; x < 170; x++) {
			BufferedImage[] image = new BufferedImage[170];
			image[x] = Resources.triforceSprites.getSubimage(x * 45, 0, 45, 45);
			this.triforceSprites[x] = image[x];
		}

		final ResourceSchedule triOneTemp = new ResourceSchedule(24, new AnimationPath(new Animation(this.triforceSprites, 5), 0, Lttp.height, 1, -1, Lttp.width / 2 - (45 * Lttp.scale), Lttp.height / 2), 111);
		triOneTemp.setDrawerAdditional(() -> {
			if (triOneTemp.hasStarted()) {
				AnimationPath triOne = triOneTemp.getAnimationPath();
				triOneTemp.getGraphics().drawImage(triOne.getSprite(), triOne.getX(), triOne.getY(), 45 * Lttp.scale, 45 * Lttp.scale, null);
			}
		});
		final ResourceSchedule triTwoTemp = new ResourceSchedule(24, new AnimationPath(new Animation(this.triforceSprites, 5), Lttp.width - (45 * Lttp.scale), Lttp.height, -1, -1, Lttp.width / 2, Lttp.height / 2), 111);
		triTwoTemp.setDrawerAdditional(() -> {
			if (triTwoTemp.hasStarted()) {
				AnimationPath triTwo = triTwoTemp.getAnimationPath();
				triTwoTemp.getGraphics().drawImage(triTwo.getSprite(), triTwo.getX(), triTwo.getY(), 45 * Lttp.scale, 45 * Lttp.scale, null);
			}

		});
		final ResourceSchedule triThreeTemp = new ResourceSchedule(24, new AnimationPath(new Animation(this.triforceSprites, 5), Lttp.width / 2 - (45 / 2 * Lttp.scale), -(45 * Lttp.scale), 0, 1, Lttp.width / 2 - (45 / 2 * Lttp.scale), Lttp.height / 2 - (45 * Lttp.scale)), 111);
		triThreeTemp.setDrawerAdditional(() -> {
			if (triThreeTemp.hasStarted()) {
				AnimationPath triThree = triThreeTemp.getAnimationPath();
				triThreeTemp.getGraphics().drawImage(triThree.getSprite(), triThree.getX(), triThree.getY(), 45 * Lttp.scale, 45 * Lttp.scale, null);

			}
		});


		this.stateManager.scheduler.scheduleResource(triOneTemp);
		this.stateManager.scheduler.scheduleResource(triTwoTemp);
		this.stateManager.scheduler.scheduleResource(triThreeTemp);
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(15, Resources.sfx.get(Resources.rupee1), -1));
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(15, new ImageSchedule(Resources.nintendo, Lttp.width / 2 - (56 * Lttp.scale / 2), Lttp.height / 2 - (16 * Lttp.scale / 2), 56 * Lttp.scale, 16 * Lttp.scale), 35));
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(40, new ImageSchedule(Resources.copyright, Lttp.width / 2 - (103 * Lttp.scale / 2), Lttp.height - 100, 103 * Lttp.scale, 8 * Lttp.scale), -1));

		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(60, Resources.music.get(Resources.title), -1));
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(130, new ImageSchedule(Resources.background, Lttp.width / 2 - (256 * Lttp.scale / 2), Lttp.height / 2 - (144 * Lttp.scale / 2), 256 * Lttp.scale, 144 * Lttp.scale), -1));
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(112, new ImageSchedule(Resources.triforce, Lttp.width / 2 - (82 * Lttp.scale / 2), Lttp.height / 2 - (81 * Lttp.scale / 2), 82 * Lttp.scale, 81 * Lttp.scale), -1));
		this.stateManager.scheduler.scheduleResource(new ResourceSchedule(140, new ImageSchedule(Resources.logo, Lttp.width / 2 - (174 * Lttp.scale / 2), Lttp.height / 2 - (128 * Lttp.scale / 2), 174 * Lttp.scale, 128 * Lttp.scale), -1));

	}

	@Override
	public void update() {

		this.stateManager.scheduler.updateResources(this.count);

		if(count == 200) {
			this.allowInput = true;
		}

	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Lttp.width, Lttp.height);

		this.stateManager.scheduler.drawResources(g);

		this.stateManager.scheduler.drawAdditionalResources(g);

	}

	@Override
	public void keyPressed(int k) {
		if(this.allowInput) {
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
