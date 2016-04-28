package me.rockerjman222.Lttp.assets;

import java.awt.image.BufferedImage;

public class LttpFont {

	public static BufferedImage[] images = new BufferedImage[77];

	public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ " +
			"abcdefghijklmnopqrstuvwxyz " +
			"0123456789!\"~$%'(),-.:;<>=?" +
			"@                          ";

	public LttpFont() {

	}

	public static void init() {
		for (int i = 0; i < images.length; i++) {
			images[i] = Resources.text.getSubimage(i * 6, 0, 6, 15);
		}
	}

}
