package me.rockerjman222.Lttp.map;

import me.rockerjman222.Lttp.main.Lttp;

import java.awt.*;

public class Camera {

	private float xOffset = 0;
	private float yOffset = 0;

	public Camera(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void move(float dx, float dy) {
		this.xOffset += dx;
		this.yOffset += dy;
	}

	public void centerOnPoint(Point point) {
		this.xOffset = (float) point.getX() - (Lttp.width / 2);
		this.yOffset = (float) point.getY() - (Lttp.height / 2);
	}

	public float getXOffset() {
		return xOffset;
	}

	public void setXOffset(float xOffset) {
		this.xOffset += xOffset;
	}

	public float getYOffset() {
		return yOffset;
	}

	public void setYOffset(float yOffset) {
		this.yOffset += yOffset;
	}
}
