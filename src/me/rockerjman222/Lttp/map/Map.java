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


		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public void drawMap(Graphics2D g) {
		BufferedImage tile = null;
		for(int i = 0; i < this.tiles.size(); i++) {
			switch(this.tiles.get(i)) {
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

			for(int x = 0; x <= Lttp.width / this.tileWidth; x++) {
				for(int y = 0; y < Lttp.height / this.tileHeight; y++) {
					g.drawImage(tile, this.tileWidth , this.tileHeight, this.tileWidth, this.tileHeight, null);
				}
			}


			//g.drawImage(tile, i * (this.tileWidth * Lttp.scale), i * (this.tileHeight * Lttp.scale), this.tileWidth * Lttp.scale, this.tileHeight * Lttp.scale, null);
		}
	}

}
