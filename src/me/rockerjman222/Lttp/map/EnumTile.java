package me.rockerjman222.Lttp.map;

import me.rockerjman222.Lttp.assets.Resources;

import java.awt.image.BufferedImage;

public enum EnumTile {

	GRASS01(1, Resources.grass01);

	private int id;
	private BufferedImage tile;

	EnumTile(int id, BufferedImage tile) {
		this.id = id;
		this.tile = tile;
	}

	public int getId() {
		return id;
	}

	public BufferedImage getTile() {
		return tile;
	}
}
