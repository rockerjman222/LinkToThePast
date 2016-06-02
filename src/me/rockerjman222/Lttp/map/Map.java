package me.rockerjman222.Lttp.map;

import me.rockerjman222.Lttp.assets.Resources;
import me.rockerjman222.Lttp.main.Lttp;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Map {

	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;

	private HashMap<Integer, Integer> tiles = new HashMap<>();
	private List<Integer> tileSet = new LinkedList<>();
	private int[][] tileArray;

	public Map() {

	}

	public void loadMap(File file) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList layerNodes = doc.getElementsByTagName("layer");
			NodeList tileSetNodes = doc.getElementsByTagName("tileset");
			NodeList dataNodes = doc.getElementsByTagName("tile");
			Element eLayer = (Element) layerNodes.item(0);
			Element eTileSets = (Element) tileSetNodes.item(0);

			for(int i = 0; i < dataNodes.getLength(); i++) {
				Node tile = dataNodes.item(i);
				if(tile.getNodeType() == Node.ELEMENT_NODE) {
					Element eTile = (Element) tile;
					this.tileSet.add(Integer.parseInt(eTile.getAttribute("gid")));
				}
			}

			this.mapWidth = Integer.parseInt(eLayer.getAttribute("width"));
			this.mapHeight = Integer.parseInt(eLayer.getAttribute("height"));
			this.tileWidth = Integer.parseInt(eTileSets.getAttribute("tilewidth")) * Lttp.scale;
			this.tileHeight = Integer.parseInt(eTileSets.getAttribute("tileheight")) * Lttp.scale;

			System.out.println("Map Width  : " + this.mapWidth);
			System.out.println("Map Height : " + this.mapHeight);
			System.out.println("Tile Width : " + this.tileWidth);
			System.out.println("Tile Height: " + this.tileHeight);
			System.out.println("Total Tiles: " + this.tiles.size());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		this.tileArray = new int[this.mapHeight][this.mapWidth];
		int counterX = 0;
		int counterY = 0;
		for (Integer i : this.tileSet) {
			tileArray[counterY][counterX] = i;
			if (++counterX >= this.mapWidth) {
				counterX = 0;
				counterY++;
			}
		}

	}

	public void drawMap(Graphics2D g, Point playerCenter) {

		//Drew Notes
		/*
		The closest the map can ever be drawn is 0,0
		load all tiles into a 2d array
		player center is a pixel offset. offset x = 500 then we start drawing at (i * this.tileWidth * Lttp.scale) - 500
		Keeping in mind that if(startDrawing < 0) continue;
		It's worth noting that this is SUPER inefficient!

		This is just the starting point and a more efficient algorithm can be developed off of this

		 */
		//JOSH DON'T TOUCH PLX
		//unless you finish enumerating all the tiles
		//then touch
		BufferedImage tile = null;

		for (int height = 0; height < this.tileArray.length; height++) {
			int[] row = this.tileArray[height];
			for (int width = 0; width < row.length; width++) {

				switch (row[width]) {
					case 1:
						tile = Resources.grass01;
						break;
					case 2:
						tile = Resources.path01;
						break;
					case 101:
						tile = Resources.bush01;
						break;
					case 102:
						tile = Resources.flower01;
						break;

				}

				double attemptedX = (width * this.tileWidth * Lttp.scale) - playerCenter.getX();
				double attemptedY = (height * this.tileHeight * Lttp.scale) - playerCenter.getY();

				//this is wrong, I'll fix it later
				//if (Math.abs(attemptedX) > 16 || Math.abs(attemptedY) > 16)
				//continue;

				if (this.isOnScreen(new Rectangle2D.Double(attemptedX, attemptedY, this.tileWidth, this.tileHeight))) {

					g.drawImage(tile, (int) attemptedX, (int) attemptedY, this.tileWidth, this.tileHeight, null);
				}
			}

		}
	}

	private boolean isOnScreen(Rectangle.Double rectangle) {
		return rectangle.intersects(new Rectangle(0, 0, Lttp.width, Lttp.height));
	}

}
