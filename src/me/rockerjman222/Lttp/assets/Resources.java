package me.rockerjman222.Lttp.assets;

import me.rockerjman222.Lttp.main.Lttp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

@SuppressWarnings("ALL")
public class Resources {

	protected Resources(){}

	/** Storage **/
	public static HashMap<File, Audio> sfx;
	public static HashMap<File, Audio> music;
	public static HashMap<File, Audio> link;
	public static HashMap<File, Audio> menu;

	/** Window **/
	public static final BufferedImage windowIcon = loadImage("/window/icon.png");

	/** Fonts **/
	public static final BufferedImage fontSheet = loadImage("/fonts/font.png");

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
	public static final BufferedImage backgroundOne = loadImage("/intro/bg_1.png");
	public static final BufferedImage backgroundTwo = loadImage("/intro/bg_2.png");

	/** Maps **/
	public static final File test = loadFile("/maps/test.tmx");
	//public static final File linksHouse = loadFile("/maps/linksHouse.tmx");

	/** TileSets **/
	public static final BufferedImage overworldTiles = loadImage("/tileSets/overworldTileSet.png");
	//public static final BufferedImage interiorTileSet = loadImage("/tileSets/interiorTileSet.png");

	/** TileSheets **/
	public static final BufferedImage[] overworldTileSet = getSheet(overworldTiles, 16);

	/** Sprites **/

	/** Tiles **/
	public static final BufferedImage grass01 = overworldTileSet[0];
	public static final BufferedImage path01 = overworldTileSet[1];
	public static final BufferedImage bush01 = overworldTileSet[100];
	public static final BufferedImage flower01 = overworldTileSet[101];


	/** Music **/
	public static final File bossBackground = loadFile("/audio/music/Boss_Background.wav");
	public static final File bossClear = loadFile("/audio/music/Boss_Clear_Fanfare.wav");
	public static final File cave = loadFile("/audio/music/Cave.wav");
	public static final File church = loadFile("/audio/music/Church.wav");
	public static final File crystal = loadFile("/audio/music/Crystal.wav");
	public static final File darkMountainForest = loadFile("/audio/music/Dark_Mountain_Forest.wav");
	public static final File darkWorld = loadFile("/audio/music/Dark_World.wav");
	public static final File darkWorldDungeon = loadFile("/audio/music/Dark_World_Dungeon.wav");
	public static final File ending = loadFile("/audio/music/Ending.wav");
	public static final File fallingRain = loadFile("/audio/music/Falling_Rain.wav");
	public static final File forest = loadFile("/audio/music/Forest.wav");
	public static final File fortuneHouse = loadFile("/audio/music/Fortune_Telling_House.wav");
	public static final File ganonBattle = loadFile("/audio/music/Ganon_Battle.wav");
	public static final File ganonsMessage = loadFile("/audio/music/Ganons_Message.wav");
	public static final File goddessAppears = loadFile("/audio/music/Goddess_Appears.wav");
	public static final File guessingGameHouse = loadFile("/audio/music/Guessing_Game_House.wav");
	public static final File hyruleCastle = loadFile("/audio/music/Hyrule_Castle.wav");
	public static final File kakariko = loadFile("/audio/music/Kakariko_Village.wav");
	public static final File kakarikoSoldiers = loadFile("/audio/music/Soldiers_Of_Kakariko.wav");
	public static final File masterSwordDemo = loadFile("/audio/music/Master_Sword_Demo.wav");
	public static final File opening = loadFile("/audio/music/Opening.wav");
	public static final File overworld = loadFile("/audio/music/Overworld.wav");
	public static final File priest = loadFile("/audio/music/Priest.wav");
	public static final File priestTransform = loadFile("/audio/music/Priest_Transformation.wav");
	public static final File rabbitTransform = loadFile("/audio/music/Rabbit_Transformation.wav");
	public static final File sanctuaryDungeon = loadFile("/audio/music/Sanctuary_Dungeon.wav");
	public static final File selectScreen = loadFile("/audio/music/Select_Screen.wav");
	public static final File title = loadFile("/audio/music/Title.wav");
	public static final File triforceChamber = loadFile("/audio/music/Triforce_Chamber.wav");
	public static final File zeldasRescue = loadFile("/audio/music/Zeldas_Rescue.wav");

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

	static {
		sfx = new HashMap<>();
		music = new HashMap<>();
		link = new HashMap<>();
		menu = new HashMap<>();

		sfx.put(arrowHit, new Audio(arrowHit));
		sfx.put(arrowShoot, new Audio(arrowShoot));
		sfx.put(bombBlow, new Audio(bombBlow));
		sfx.put(bombDrop, new Audio(bombDrop));
		sfx.put(bookOfMudora, new Audio(bookOfMudora));
		sfx.put(boomerang, new Audio(boomerang));
		sfx.put(cane, new Audio(cane));
		sfx.put(caneMagic, new Audio(caneMagic));
		sfx.put(ether, new Audio(ether));
		sfx.put(fireRod, new Audio(fireRod));
		sfx.put(flute, new Audio(flute));
		sfx.put(fluteExtended, new Audio(fluteExtended));
		sfx.put(getFairy, new Audio(getFairy));
		sfx.put(getHeartContainer, new Audio(getHeartContainer));
		sfx.put(getHeartPiece, new Audio(getHeartPiece));
		sfx.put(getHeartPieceStereoL, new Audio(getHeartPieceStereoL));
		sfx.put(getGetHeartPieceStereoR, new Audio(getGetHeartPieceStereoR));
		sfx.put(getKey, new Audio(getKey));
		sfx.put(getKeyStereoL, new Audio(getKeyStereoL));
		sfx.put(getKeyStereoR, new Audio(getKeyStereoR));
		sfx.put(hammar, new Audio(hammar));
		sfx.put(hammarPost, new Audio(hammarPost));
		sfx.put(hookshot, new Audio(hookshot));
		sfx.put(iceRod, new Audio(iceRod));
		sfx.put(item, new Audio(item));
		sfx.put(itemFanfare, new Audio(itemFanfare));
		sfx.put(itemFanfareStereo, new Audio(itemFanfareStereo));
		sfx.put(lamp, new Audio(lamp));
		sfx.put(magicCapeOn, new Audio(magicCapeOn));
		sfx.put(magicCapeOff, new Audio(magicCapeOff));
		sfx.put(mushroom, new Audio(mushroom));
		sfx.put(net, new Audio(net));
		sfx.put(rupee1, new Audio(rupee1));
		sfx.put(rupee2, new Audio(rupee2));
		sfx.put(shield, new Audio(shield));
		sfx.put(shovel, new Audio(shovel));
		sfx.put(sword1, new Audio(sword1));
		sfx.put(sword2, new Audio(sword2));
		sfx.put(sword3, new Audio(sword3));
		sfx.put(sword4, new Audio(sword4));
		sfx.put(swordCharge, new Audio(swordCharge));
		sfx.put(swordMagic, new Audio(swordMagic));
		sfx.put(swordMagicLoop, new Audio(swordMagicLoop));
		sfx.put(swordSpin, new Audio(swordSpin));
		sfx.put(swordSpinMagic, new Audio(swordSpinMagic));
		sfx.put(swordTap, new Audio(swordTap));

		music.put(bossBackground, new Audio(bossBackground));
		music.put(bossClear, new Audio(bossClear));
		music.put(cave, new Audio(cave));
		music.put(church, new Audio(church));
		music.put(crystal, new Audio(crystal));
		music.put(darkMountainForest, new Audio(darkMountainForest));
		music.put(darkWorld, new Audio(darkWorld));
		music.put(darkWorldDungeon, new Audio(darkWorldDungeon));
		music.put(ending, new Audio(ending));
		music.put(fallingRain, new Audio(fallingRain));
		music.put(forest, new Audio(forest));
		music.put(fortuneHouse, new Audio(fortuneHouse));
		music.put(ganonBattle, new Audio(ganonBattle));
		music.put(ganonsMessage, new Audio(ganonsMessage));
		music.put(goddessAppears, new Audio(goddessAppears));
		music.put(guessingGameHouse, new Audio(guessingGameHouse));
		music.put(hyruleCastle, new Audio(hyruleCastle));
		music.put(kakariko, new Audio(kakariko));
		music.put(kakarikoSoldiers, new Audio(kakarikoSoldiers));
		music.put(masterSwordDemo, new Audio(masterSwordDemo));
		music.put(opening, new Audio(opening));
		music.put(overworld, new Audio(overworld));
		music.put(priest, new Audio(priest));
		music.put(priestTransform, new Audio(priestTransform));
		music.put(rabbitTransform, new Audio(rabbitTransform));
		music.put(sanctuaryDungeon, new Audio(sanctuaryDungeon));
		music.put(selectScreen, new Audio(selectScreen));
		music.put(title, new Audio(title));
		music.put(triforceChamber, new Audio(triforceChamber));
		music.put(zeldasRescue, new Audio(zeldasRescue));

		link.put(linkDash, new Audio(linkDash));
		link.put(linkDying, new Audio(linkDying));
		link.put(linkFall, new Audio(linkFall));
		link.put(linkHurt, new Audio(linkHurt));
		link.put(linkJump, new Audio(linkJump));
		link.put(linkLand, new Audio(linkLand));
		link.put(linkPickup, new Audio(linkPickup));
		link.put(linkPush, new Audio(linkPush));
		link.put(linkShock, new Audio(linkShock));
		link.put(linkShockFast, new Audio(linkShockFast));
		link.put(linkThrow, new Audio(linkThrow));

		menu.put(map, new Audio(map));
		menu.put(menuCursor, new Audio(menuCursor));
		menu.put(menuErase, new Audio(menuErase));
		menu.put(menuSelect, new Audio(menuSelect));
		menu.put(pauseClose, new Audio(pauseClose));
		menu.put(pauseOpen, new Audio(pauseOpen));
		menu.put(saveQuit, new Audio(saveQuit));
		menu.put(textDone, new Audio(textDone));
		menu.put(textLetter, new Audio(textLetter));
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

	private static BufferedImage[] getSheet(BufferedImage image, int tileSize) {
		int rows = image.getHeight() / tileSize;
		int cols = image.getWidth() / tileSize;
		BufferedImage[] sprites = new BufferedImage[rows * cols];

		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				sprites[(y * rows) + x] = image.getSubimage(x * tileSize, y * tileSize, tileSize, tileSize);
			}
		}

		return sprites;

	}

}
