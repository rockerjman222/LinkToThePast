package me.rockerjman222.Lttp.map;

import org.lwjgl.system.libffi.Closure;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.misc.BASE64Decoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Map {

	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;


	public Map() {

	}

	public void loadMap(File file) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList layerNodes = doc.getElementsByTagName("layer");
			NodeList tileSetNodes = doc.getElementsByTagName("tileset");
			Element eLayer = (Element) layerNodes.item(0);
			Element eTileSets = (Element) tileSetNodes.item(0);

			this.mapWidth = Integer.parseInt(eLayer.getAttribute("width"));
			this.mapHeight = Integer.parseInt(eLayer.getAttribute("height"));
			this.tileWidth = Integer.parseInt(eTileSets.getAttribute("tilewidth"));
			this.tileHeight = Integer.parseInt(eTileSets.getAttribute("tileheight"));



		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
