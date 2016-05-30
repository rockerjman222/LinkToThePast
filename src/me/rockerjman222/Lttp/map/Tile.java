package me.rockerjman222.Lttp.map;

import java.awt.image.BufferedImage;

public class Tile {

	private int x;
	private int y;
	private int width;
	private int height;

	private boolean solid;

	private BufferedImage tile;

	public Tile(int x, int y, int width, int height, boolean solid, BufferedImage tile) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.solid = solid;
		this.tile = tile;
	}

	public Tile(int x, int y, int width, int height, BufferedImage tile) {
		this(x, y, width, height, true, tile);
	}

	public Tile(int x, int y, BufferedImage tile) {
		this(x, y, 16, 16, tile);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public boolean isSolid() {
		return this.solid;
	}

	public BufferedImage getTile() {
		return this.tile;
	}
	
}
