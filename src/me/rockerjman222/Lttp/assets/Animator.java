package me.rockerjman222.Lttp.assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animator {

	private ArrayList<BufferedImage> frames;
	private BufferedImage sprite;

	private boolean running = false;

	private long previousTime;
	private long speed;
	private int frameAtPause;
	private int currentFrame;

	public Animator(ArrayList<BufferedImage> frames) {
		this.frames = frames;
	}

	public void update() {
		while (this.running) {
			long time = System.currentTimeMillis();
			if (time - this.previousTime >= this.speed) {
				this.currentFrame++;
				try {
					this.sprite = this.frames.get(this.currentFrame);
				} catch (IndexOutOfBoundsException e) {
					this.currentFrame = 0;
					this.sprite = this.frames.get(this.currentFrame);
				}
				this.sprite = this.frames.get(this.currentFrame);
				this.previousTime = time;
			}
		}
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public void start() {
		this.running = true;
		this.previousTime = 0;
		this.frameAtPause = 0;
		this.currentFrame = 0;
	}

	public void stop() {
		this.running = false;
		this.previousTime = 0;
		this.frameAtPause = 0;
		this.currentFrame = 0;
	}

	public void pause() {
		this.frameAtPause = this.currentFrame;
		this.running = false;
	}

	public void resume() {
		this.currentFrame = this.frameAtPause;
		this.running = true;
	}


}
