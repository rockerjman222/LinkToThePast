package me.rockerjman222.Lttp.main;

import me.rockerjman222.Lttp.assets.Audio;
import me.rockerjman222.Lttp.assets.Resources;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Lttp {

	public static final int scale = 4;
	public static final int height = 224 * scale;
	public static final int width = 256 * scale;

	public static HashMap<String, Audio> sfx;

	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Link to the Past");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setIconImage(Resources.windowIcon);
			frame.setPreferredSize(new Dimension(height, width));
			frame.setBackground(Color.BLACK);
			frame.setResizable(false);
			frame.pack();
			frame.setVisible(true);
		});

		sfx = new HashMap<>();

		sfx.put("textLetter", new Audio(Resources.textLetter));
		sfx.put("textDone", new Audio(Resources.textDone));

		String message = "Hello World, This is a test";
		char[] chars = message.toCharArray();


		for(int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
			sfx.get("textLetter").play();
			Thread.sleep(100);
		}

		Thread.sleep(300);
		sfx.get("textDone").play();





	}

}
