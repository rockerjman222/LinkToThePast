package me.rockerjman222.Lttp.assets;

import me.rockerjman222.Lttp.main.Lttp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class Resources {

	/** Storage **/
	public static HashMap<File, Audio> sfx;

	/** Window **/
	public static final BufferedImage windowIcon = loadImage("/window/icon.png");

	/**
	 * Fonts
	 **/
	//public static final File returnOfGanonFontFile = loadFile("/fonts/ReturnofGanon.ttf");
	public static Font defaultFont = null;

	/** Title **/
	public static final BufferedImage nintendo = loadImage("/titleScreen/nintendo.png");
	public static final BufferedImage copyright = loadImage("/titleScreen/copyright.png");
	public static final BufferedImage triforce = loadImage("/titleScreen/triforce.png");
	public static final BufferedImage triforceSprites = loadImage("/titleScreen/triforceSprites.png");
	public static final BufferedImage background = loadImage("/titleScreen/background.png");
	public static final BufferedImage titleNoSword = loadImage("/titleScreen/title_no_sword.png");
	public static final BufferedImage logo = loadImage("/titleScreen/title.png");
	public static final BufferedImage sword = loadImage("/titleScreen/sword.png");

	/** Intro **/
	public static final BufferedImage introSlides = loadImage("/intro/intro_slides.png");

	/** Maps **/
	//public static final File linksHouse = loadFile("/maps/linksHouse.tmx");

	/** TileSets **/
	//public static final BufferedImage overworldTileSet = loadImage("/tileSets/overworldTileSet.png");
	//public static final BufferedImage interiorTileSet = loadImage("/tileSets/interiorTileSet.png");

	/** Sprites **/

	/** Music **/
	public static final File title = loadFile("/audio/music/Title.wav");

	/** Items **/
	public static final File arrowHit = loadFile("/audio/sfx/items/Arrow_Hit.wav");
	public static final File arrowShoot = loadFile("/audio/sfx/items/Arrow_Shoot.wav");
	public static final File bombBlow = loadFile("/audio/sfx/items/Bomb_Blow.wav");
	public static final File bombDrop = loadFile("/audio/sfx/items/Bomb_Drop.wav");
	public static final File bookOfMudora = loadFile("/audio/sfx/items/Book_Of_Mudora.wav");
	public static final File boomerang = loadFile("/audio/sfx/items/Boomerang.wav");
	public static final File cane = loadFile("/audio/sfx/items/Cane.wav");
	public static final File caneMagic = loadFile("/audio/sfx/items/Cane_Magic.wav");
	public static final File ether = loadFile("/audio/sfx/items/Ether.wav");
	public static final File fireRod = loadFile("/audio/sfx/items/Fire_Rod.wav");
	public static final File flute = loadFile("/audio/sfx/items/Flute.wav");
	public static final File fluteExtended = loadFile("/audio/sfx/items/Flute_Extended.wav");
	public static final File getFairy = loadFile("/audio/sfx/items/Get_Fairy.wav");
	public static final File getHeartContainer = loadFile("/audio/sfx/items/Get_Heart_Container.wav");
	public static final File getHeartPiece = loadFile("/audio/sfx/items/Get_Heart_Piece.wav");
	public static final File getHeartPieceStereoL = loadFile("/audio/sfx/items/Get_Heart_Piece_StereoL.wav");
	public static final File getGetHeartPieceStereoR = loadFile("/audio/sfx/items/Get_Heart_Piece_StereoR.wav");
	public static final File getKey = loadFile("/audio/sfx/items/Get_Key.wav");
	public static final File getKeyStereoL = loadFile("/audio/sfx/items/Get_Key_StereoL.wav");
	public static final File getKeyStereoR = loadFile("/audio/sfx/items/Get_Key_StereoR.wav");
	public static final File hammar = loadFile("/audio/sfx/items/Hammar.wav");
	public static final File hammarPost = loadFile("/audio/sfx/items/Hammar_Post.wav");
	public static final File hookshot = loadFile("/audio/sfx/items/Hookshot.wav");
	public static final File iceRod = loadFile("/audio/sfx/items/Ice_Rod.wav");
	public static final File item = loadFile("/audio/sfx/items/Item.wav");
	public static final File itemFanfare = loadFile("/audio/sfx/items/Item_Fanfare.wav");
	public static final File itemFanfareStereo = loadFile("/audio/sfx/items/Item_Fanfare_Stereo.wav");
	public static final File lamp = loadFile("/audio/sfx/items/Lamp.wav");
	public static final File magicCapeOn = loadFile("/audio/sfx/items/Magic_Cape_On.wav");
	public static final File magicCapeOff = loadFile("/audio/sfx/items/Magic_Cape_Off.wav");
	public static final File magicPowder = loadFile("/audio/sfx/items/Magic_Powder.wav");
	public static final File mushroom = loadFile("/audio/sfx/items/Mushroom.wav");
	public static final File net = loadFile("/audio/sfx/items/Net.wav");
	public static final File rupee1 = loadFile("/audio/sfx/items/Rupee1.wav");
	public static final File rupee2 = loadFile("/audio/sfx/items/Rupee2.wav");
	public static final File shield = loadFile("/audio/sfx/items/Shield.wav");
	public static final File shovel = loadFile("/audio/sfx/items/Shovel.wav");
	public static final File sword1 = loadFile("/audio/sfx/items/Sword1.wav");
	public static final File sword2 = loadFile("/audio/sfx/items/Sword2.wav");
	public static final File sword3 = loadFile("/audio/sfx/items/Sword3.wav");
	public static final File sword4 = loadFile("/audio/sfx/items/Sword4.wav");
	public static final File swordCharge = loadFile("/audio/sfx/items/Sword_Charge.wav");
	public static final File swordMagic = loadFile("/audio/sfx/items/Sword_Magic.wav");
	public static final File swordMagicLoop = loadFile("/audio/sfx/items/Sword_Magic_Loop.wav");
	public static final File swordSpin = loadFile("/audio/sfx/items/Sword_Spin.wav");
	public static final File swordSpinMagic = loadFile("/audio/sfx/items/Sword_Spin_Magic.wav");
	public static final File swordTap = loadFile("/audio/sfx/items/Sword_Tap.wav");

	/** Link **/
	public static final File linkDash = loadFile("/audio/sfx/link/Link_Dash.wav");
	public static final File linkDying = loadFile("/audio/sfx/link/Link_Dying.wav");
	public static final File linkFall = loadFile("/audio/sfx/link/Link_Fall.wav");
	public static final File linkHurt = loadFile("/audio/sfx/link/Link_Hurt.wav");
	public static final File linkJump = loadFile("/audio/sfx/link/Link_Jump.wav");
	public static final File linkLand = loadFile("/audio/sfx/link/Link_Land.wav");
	public static final File linkPickup = loadFile("/audio/sfx/link/Link_Pickup.wav");
	public static final File linkPush = loadFile("/audio/sfx/link/Link_Push.wav");
	public static final File linkShock = loadFile("/audio/sfx/link/Link_Shock.wav");
	public static final File linkShockFast = loadFile("/audio/sfx/link/Link_Shock_Fast.wav");
	public static final File linkThrow = loadFile("/audio/sfx/link/Link_Throw.wav");

	/** Menus **/
	public static final File map = loadFile("/audio/sfx/menus/Map.wav");
	public static final File menuCursor = loadFile("/audio/sfx/menus/Menu_Cursor.wav");
	public static final File menuErase = loadFile("/audio/sfx/menus/Menu_Erase.wav");
	public static final File menuSelect = loadFile("/audio/sfx/menus/Menu_Select.wav");
	public static final File pauseClose = loadFile("/audio/sfx/menus/Pause_Close.wav");
	public static final File pauseOpen = loadFile("/audio/sfx/menus/Pause_Open.wav");
	public static final File saveQuit = loadFile("/audio/sfx/menus/Save_Quit.wav");
	public static final File textDone = loadFile("/audio/sfx/menus/Text_Done.wav");
	public static final File textLetter = loadFile("/audio/sfx/menus/Text_Letter.wav");

	public static void init() {
		/** Font **/
		//try {
			defaultFont = Font.getFont("Arial") ;//Font.createFont(Font.TRUETYPE_FONT, returnOfGanonFontFile);
		//	GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(defaultFont);
		//} catch (FontFormatException | IOException e) {
		//	e.printStackTrace();
		//}

		sfx = new HashMap<>();
		sfx.put(textLetter, new Audio(textLetter));
		sfx.put(textDone, new Audio(textDone));
	}

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
