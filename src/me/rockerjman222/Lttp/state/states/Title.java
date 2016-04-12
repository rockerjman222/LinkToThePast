package me.rockerjman222.Lttp.state.states;

import me.rockerjman222.Lttp.assets.Animator;
import me.rockerjman222.Lttp.assets.Audio;
import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.main.Lttp;
import me.rockerjman222.Lttp.state.State;
import me.rockerjman222.Lttp.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Title extends State {

	private StateManager stateManager;

	private HashMap<File, Audio> sfx = new HashMap<>();
	private ArrayList<BufferedImage[]> triforceSprites = new ArrayList<>();

	private Animator triforceAnimation;

	private Timer timer;
	private int count = 0;

	private boolean shouldDrawNintendo = false;
	private boolean shouldDrawCopyright = false;
	private boolean shouldStartTriforceAnimation = false;
	private boolean shouldDrawFinalTriforce = false;

	public Title(StateManager stateManager) {
		this.stateManager = stateManager;
		init();
	}

	@Override
	public void init() {
		sfx = new HashMap<>();
		sfx.put(Resources.rupee1, new Audio(Resources.rupee1));
		sfx.put(Resources.title, new Audio(Resources.title));

		timer = new Timer(100, e -> count++);
		timer.start();

		for (int x = 0; x < 170; x++) {
			BufferedImage[] image = new BufferedImage[170];
			image[x] = Resources.triforceSprites.getSubimage(x * 45, 0, 45, 45);
			triforceSprites.add(image);
		}

		triforceAnimation = new Animator(//TODO:FIX THIS
				// );
	}

	@Override
	public void update() {
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

		if (count == 115) {
			shouldDrawFinalTriforce = true;
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

		if (shouldDrawFinalTriforce) {
			g.drawImage(Resources.triforce, Lttp.width / 2 - (82 * Lttp.scale / 2), Lttp.height / 2 - (81 * Lttp.scale / 2), 82 * Lttp.scale, 81 * Lttp.scale, null);
		}

	}

	@Override
	public void keyPressed(int k) {

	}

	@Override
	public void keyReleased(int k) {

	}
}
