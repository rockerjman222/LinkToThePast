package me.rockerjman222.Lttp.utils;


import me.rockerjman222.Lttp.assets.Resources;

import java.awt.*;
import java.util.Calendar;

public class Utils {

	public static void displayTextBox(Graphics2D g, String s, int x, int y) {
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			String character = String.valueOf(chars[i]);
			try {
				g.drawString(character, x * g.getFont().getSize(), 300);
				Resources.sfx.get(Resources.textLetter).play();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		try {
			Thread.sleep(300);
			Resources.sfx.get(Resources.textDone).play();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//TODO: wait for input and continue

	}

	public static String getTimeInString() {
		return "[" + String.valueOf(Calendar.HOUR) + ":" + String.valueOf(Calendar.MINUTE) + ":" + String.valueOf(Calendar.SECOND) + "]:";
	}

	public static void log(String s) {
		System.out.println(getTimeInString() + " " + s);
	}

}
