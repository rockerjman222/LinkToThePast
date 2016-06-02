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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Map {

	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;

	private HashMap<Integer, Integer> tiles = new HashMap<>();

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
					this.tiles.put(i, Integer.parseInt(eTile.getAttribute("gid")));
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
	}

	public void drawMap(Graphics2D g) {
		BufferedImage tile = null;

		int y = 0;
		int x = 0;
		for(Iterator<java.util.Map.Entry<Integer, Integer>> i = this.tiles.entrySet().iterator(); i.hasNext(); ){
			java.util.Map.Entry<Integer, Integer> mapEntry = i.next();

			//TODO: Fix this to work with all tilesets.
			switch(mapEntry.getValue()) {
				case 1:
					tile = Resources.grass01;
					break;

			}

			g.drawImage(tile, x * this.tileWidth, y * this.tileHeight, this.tileWidth, this.tileHeight, null);
			if(++x >= 16){
				y++;
				x = 0;
			}
		}

	}


}
