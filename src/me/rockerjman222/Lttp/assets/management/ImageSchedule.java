package me.rockerjman222.Lttp.assets.management;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class ImageSchedule {

	private BufferedImage resourceFile;
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	private ImageObserver observer = null;

	public ImageSchedule(BufferedImage resourceFile, int positionX, int positionY, int width, int height) {
		this.resourceFile = resourceFile;
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
	}

	public ImageSchedule(BufferedImage resourceFile, int positionX, int positionY, int width, int height, ImageObserver observer){
		this(resourceFile, positionX, positionY, width, height);
		this.observer = observer;
	}

	public void drawImage(Graphics2D graphics){

		graphics.drawImage(this.resourceFile, positionX, positionY, width, height, observer);
	}
}
