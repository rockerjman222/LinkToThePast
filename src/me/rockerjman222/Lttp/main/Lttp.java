package me.rockerjman222.Lttp.main;

import me.rockerjman222.Lttp.assets.Resources;

import javax.swing.*;
import java.awt.*;

public class Lttp {

	public static final int scale = 2;
	public static final int height = 224 * scale;
	public static final int width = 256 * scale;

	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Link to the Past");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setContentPane(new GameLoop());
			frame.setIconImage(Resources.windowIcon);
			frame.setPreferredSize(new Dimension(width, height));
			frame.setBackground(Color.BLACK);
			frame.setResizable(false);
			frame.pack();
			frame.setVisible(true);
		});

		Resources.init();

	}

}
