package me.rockerjman222.Lttp.map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
			this.tileWidth = Integer.parseInt(eTileSets.getAttribute("tilewidth"));
			this.tileHeight = Integer.parseInt(eTileSets.getAttribute("tileheight"));


		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
