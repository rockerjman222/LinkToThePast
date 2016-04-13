package me.rockerjman222.Lttp.assets;

import java.awt.image.BufferedImage;

public enum EnumSprites {

	INTRO_SLIDE_ONE(Resources.introSlides, 0, 0, 168, 48),
	INTRO_SLIDE_TWO(Resources.introSlides, 0, 48, 168, 48),
	INTRO_SLIDE_THREE(Resources.introSlides, 0, 96, 158, 48),
	INTRO_SLIDE_FOUR(Resources.introSlides, 0, 144, 168, 48);

	private BufferedImage image;
	private int x;
	private int y;
	private int width;
	private int height;

	EnumSprites(BufferedImage image, int x, int y, int width, int height) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
