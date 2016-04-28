package me.rockerjman222.Lttp.assets.animation;

import java.awt.image.BufferedImage;

/**
 * Used to get an Animation to specified coordinates
 * */
@SuppressWarnings("ALL")
public class AnimationPath {

	private int workingX;
	private int workingY;
	private int motionX;
	private int motionY;
	private int intendedX;
	private int intendedY;

	private Animation animation;

	public AnimationPath(Animation animation, int startingX, int startingY, int motionX, int motionY, int intendedX, int intendedY) {
		this.workingX = startingX;
		this.workingY = startingY;
		this.motionX = motionX;
		this.motionY = motionY;
		this.intendedX = intendedX;
		this.intendedY = intendedY;
		this.animation = animation;
	}

	public void update(){
		if(this.animation.hasStarted()){
			this.animation.update();

			this.workingX += this.motionX;
			this.workingY += this.motionY;

			if(this.motionX > 0)
				if(this.workingX >= this.intendedX)
					this.workingX = this.intendedX;
			else if(this.motionX < 0)
				if(this.workingX <= this.intendedX)
					this.workingX = this.intendedX;

			if(this.motionY > 0)
				if(this.workingY >= this.intendedY)
					this.workingY = this.intendedY;
			else if(this.motionY < 0)
				if(this.workingY <= this.intendedY)
					this.workingY = this.intendedY;

			if(this.workingX == this.intendedX)
				this.motionX = 0;

			if(this.workingY == this.intendedY)
				this.motionY = 0;

		}

	}

	public int getX() {
		return workingX;
	}

	public int getY() {
		return workingY;
	}

	public void start(){

		this.animation.start();

	}

	public Animation getAnimation() {
		return animation;
	}

	public BufferedImage getSprite(){
		return this.getAnimation().getSprite();
	}
}
