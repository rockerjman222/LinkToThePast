package me.rockerjman222.Lttp.assets.animation;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {

	private int frameCount;
	private int frameDelay;
	private int currentFrame;
	private int animationDirection;
	private int totalFrames;

	private boolean running;

	private boolean hasPlayedOnce = false;

	private List<Frame> frames = new ArrayList<>();

	public Animation(BufferedImage[] frames, int frameDelay) {
		this.frameDelay = frameDelay;
		this.running = false;

		for(int i = 0; i < frames.length; i++) {
			addFrame(frames[i], this.frameDelay);
		}

		this.frameCount = 0;
		this.frameDelay = frameDelay;
		this.currentFrame = 0;
		this.animationDirection = 1;
		this.totalFrames = this.frames.size();

	}

	public void start() {
		if(this.running)
			return;

		if(this.frames.size() == 0)
			return;

		this.running = true;
	}

	public void stop() {
		if(this.frames.size() == 0)
			return;

		this.running = false;
	}

	public void restart() {
		if(this.frames.size() == 0)
			return;

		this.running = true;
		this.currentFrame = 0;
	}

	public void reset() {
		this.running = false;
		this.frameCount = 0;
		this.currentFrame = 0;
	}

	private void addFrame(BufferedImage frame, int duration) {
		if(duration <= 0) {
			System.err.println("Invalid duration: " + duration);
			throw new RuntimeException("Invalid Duration: " + duration);
		}

		this.frames.add(new Frame(frame, duration));
		this.currentFrame = 0;
	}

	public BufferedImage getSprite() {
		return this.frames.get(this.currentFrame).getFrame();
	}

	public void update() {
		if(this.running) {
			this.frameCount++;

			if(this.frameCount > this.frameDelay) {
				this.frameCount = 0;
				this.currentFrame += this.animationDirection;

				if(this.currentFrame > this.totalFrames - 1) {
					this.hasPlayedOnce = true;
					this.currentFrame = 0;
				} else if(this.currentFrame < 0) {
					this.currentFrame = this.totalFrames - 1;
				}
			}
		}

	}

	public boolean hasPlayedOnce() {
		return this.hasPlayedOnce;
	}
}
