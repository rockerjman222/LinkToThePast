package me.rockerjman222.Lttp.assets;

import me.rockerjman222.Lttp.main.Lttp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class Resources {

	/** Window **/
	public static final BufferedImage windowIcon = loadImage("/window/icon.png");

	/** Maps **/
	//public static final File linksHouse = loadFile("/maps/linksHouse.tmx");

	/** TileSets **/
	//public static final BufferedImage overworldTileSet = loadImage("/tileSets/overworldTileSet.png");
	//public static final BufferedImage interiorTileSet = loadImage("/tileSets/interiorTileSet.png");

	/** Sprites **/

	/** Music **/

	/** SFX **/
	public static final File textLetter = loadFile("/audio/sfx/menus/Text_Letter.wav");
	public static final File textDone = loadFile("/audio/sfx/menus/Text_Done.wav");


	private static BufferedImage loadImage(String s) {
		URL url = Lttp.class.getResource(s);
		BufferedImage image = null;

		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

	private static File loadFile(String s) {
		return new File(Lttp.class.getResource(s).getFile());
	}

}
