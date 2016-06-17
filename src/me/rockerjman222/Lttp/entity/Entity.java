package me.rockerjman222.Lttp.entity;

import java.awt.*;

public abstract class Entity {

	private float x;
	private float y;
	private int width;
	private int height;

	private float health;

	private boolean active;

	private Rectangle bounds;

	public Entity(float x, float y, int width, int height, float health) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
		this.active = true;
	}

	public Entity(float x, float y, int width, int height) {
		this(x, y, width, height, 1.0F);
	}

	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void die();

	public void hurt(float damage) {
		this.health -= damage;
		if(this.health <= 0) {
			this.active = false;
			die();
		}
	}

	public boolean checkCollisions(Rectangle rect) {
		if(this.getBounds().intersects(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight()))
			return true;
		return false;
	}



	public Rectangle getBounds() {
		return new Rectangle((int) (this.x + this.bounds.getX()), (int) (this.y + this.bounds.getY()), (int) this.bounds.getWidth(), (int) this.bounds.getHeight());
	}

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
