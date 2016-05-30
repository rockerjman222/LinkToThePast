package me.rockerjman222.Lttp.assets;

import me.rockerjman222.Lttp.main.Lttp;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BitmapFont {

	private static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ " +
										  "abcdefghijklmnopqrstuvwxyz " +
										  "0123456789!\"~%|'(),-.:;<>=?" +
										  "*                          ";

	private static final BufferedImage A = getImage(0);
	private static final BufferedImage B = getImage(6);
	private static final BufferedImage C = getImage(12);
	private static final BufferedImage D = getImage(18);
	private static final BufferedImage E = getImage(24);
	private static final BufferedImage F = getImage(30);
	private static final BufferedImage G = getImage(36);
	private static final BufferedImage H = getImage(42);
	private static final BufferedImage I = getImage(48);
	private static final BufferedImage J = getImage(54);
	private static final BufferedImage K = getImage(60);
	private static final BufferedImage L = getImage(66);
	private static final BufferedImage M = getImage(72);
	private static final BufferedImage N = getImage(78);
	private static final BufferedImage O = getImage(84);
	private static final BufferedImage P = getImage(90);
	private static final BufferedImage Q = getImage(96);
	private static final BufferedImage R = getImage(102);
	private static final BufferedImage S = getImage(108);
	private static final BufferedImage T = getImage(114);
	private static final BufferedImage U = getImage(120);
	private static final BufferedImage V = getImage(126);
	private static final BufferedImage W = getImage(132);
	private static final BufferedImage X = getImage(138);
	private static final BufferedImage Y = getImage(144);
	private static final BufferedImage Z = getImage(150);
	private static final BufferedImage SPACE = getImage(156);
	private static final BufferedImage a = getImage(162);
	private static final BufferedImage b = getImage(168);
	private static final BufferedImage c = getImage(174);
	private static final BufferedImage d = getImage(180);
	private static final BufferedImage e = getImage(186);
	private static final BufferedImage f = getImage(192);
	private static final BufferedImage g = getImage(198, 15);
	private static final BufferedImage h = getImage(204);
	private static final BufferedImage i = getImage(210);
	private static final BufferedImage j = getImage(216, 15);
	private static final BufferedImage k = getImage(222);
	private static final BufferedImage l = getImage(228);
	private static final BufferedImage m = getImage(234);
	private static final BufferedImage n = getImage(240);
	private static final BufferedImage o = getImage(246);
	private static final BufferedImage p = getImage(252, 15);
	private static final BufferedImage q = getImage(258, 15);
	private static final BufferedImage r = getImage(264);
	private static final BufferedImage s = getImage(270);
	private static final BufferedImage t = getImage(276);
	private static final BufferedImage u = getImage(282);
	private static final BufferedImage v = getImage(288);
	private static final BufferedImage w = getImage(294);
	private static final BufferedImage x = getImage(300);
	private static final BufferedImage y = getImage(306, 15);
	private static final BufferedImage z = getImage(312);
	private static final BufferedImage zero = getImage(324);
	private static final BufferedImage one = getImage(330);
	private static final BufferedImage two = getImage(336);
	private static final BufferedImage three = getImage(342);
	private static final BufferedImage four = getImage(348);
	private static final BufferedImage five = getImage(354);
	private static final BufferedImage six = getImage(360);
	private static final BufferedImage seven = getImage(366);
	private static final BufferedImage eight = getImage(372);
	private static final BufferedImage nine = getImage(378);
	private static final BufferedImage exclamation = getImage(384, 14);
	private static final BufferedImage quotation = getImage(390);
	private static final BufferedImage tilda = getImage(396, 15);
	private static final BufferedImage percent = getImage(402, 15);
	private static final BufferedImage tinyPersonThing = getImage(408, 15);
	private static final BufferedImage apostrophe = getImage(414);
	private static final BufferedImage openBracket = getImage(420, 15);
	private static final BufferedImage closeBracket = getImage(426, 15);
	private static final BufferedImage comma = getImage(432, 15);
	private static final BufferedImage dash = getImage(438);
	private static final BufferedImage period = getImage(444, 14);
	private static final BufferedImage colon = getImage(450);
	private static final BufferedImage semiColon = getImage(456, 15);
	private static final BufferedImage left = getImage(462);
	private static final BufferedImage right = getImage(468);
	private static final BufferedImage equals = getImage(474);
	private static final BufferedImage question = getImage(480);
	private static final BufferedImage link = Resources.fontSheet.getSubimage(0, 13, 18, 17);

	public static int getStringWidth(String text) {
		return text.length() * 7;
	}

	private static BufferedImage getImage(int x) {
		return getImage(x, 13);
	}

	private static BufferedImage getImage(int x, int height) {
		return Resources.fontSheet.getSubimage(x, 0, 6, height);
	}

	public static void draw(Graphics2D graphics, String msg, int drawX, int drawY) {
		for(int index = 0; index < msg.length(); index++) {
			int letter = letters.indexOf(msg.charAt(index));
			if(letter < 0)
				continue;

			BufferedImage image;

			switch (letter) {
				case 0:
					image = A;
					break;
				case 1:
					image = B;
					break;
				case 2:
					image = C;
					break;
				case 3:
					image = D;
					break;
				case 4:
					image = E;
					break;
				case 5:
					image = F;
					break;
				case 6:
					image = G;
					break;
				case 7:
					image = H;
					break;
				case 8:
					image = I;
					break;
				case 9:
					image = J;
					break;
				case 10:
					image = K;
					break;
				case 11:
					image = L;
					break;
				case 12:
					image = M;
					break;
				case 13:
					image = N;
					break;
				case 14:
					image = O;
					break;
				case 15:
					image = P;
					break;
				case 16:
					image = Q;
					break;
				case 17:
					image = R;
					break;
				case 18:
					image = S;
					break;
				case 19:
					image = T;
					break;
				case 20:
					image = U;
					break;
				case 21:
					image = V;
					break;
				case 22:
					image = W;
					break;
				case 23:
					image = X;
					break;
				case 24:
					image = Y;
					break;
				case 25:
					image = Z;
					break;
				case 26:
					image = SPACE;
					break;
				case 27:
					image = a;
					break;
				case 28:
					image = b;
					break;
				case 29:
					image = c;
					break;
				case 30:
					image = d;
					break;
				case 31:
					image = e;
					break;
				case 32:
					image = f;
					break;
				case 33:
					image = g;
					break;
				case 34:
					image = h;
					break;
				case 35:
					image = i;
					break;
				case 36:
					image = j;
					break;
				case 37:
					image = k;
					break;
				case 38:
					image = l;
					break;
				case 39:
					image = m;
					break;
				case 40:
					image = n;
					break;
				case 41:
					image = o;
					break;
				case 42:
					image = p;
					break;
				case 43:
					image = q;
					break;
				case 44:
					image = r;
					break;
				case 45:
					image = s;
					break;
				case 46:
					image = t;
					break;
				case 47:
					image = u;
					break;
				case 48:
					image = v;
					break;
				case 49:
					image = w;
					break;
				case 50:
					image = x;
					break;
				case 51:
					image = y;
					break;
				case 52:
					image = z;
					break;
				case 54:
					image = zero;
					break;
				case 55:
					image = one;
					break;
				case 56:
					image = two;
					break;
				case 57:
					image = three;
					break;
				case 58:
					image = four;
					break;
				case 59:
					image = five;
					break;
				case 60:
					image = six;
					break;
				case 61:
					image = seven;
					break;
				case 62:
					image = eight;
					break;
				case 63:
					image = nine;
					break;
				case 64:
					image = exclamation;
					break;
				case 65:
					image = quotation;
					break;
				case 66:
					image = tilda;
					break;
				case 67:
					image = percent;
					break;
				case 68:
					image = tinyPersonThing;
					break;
				case 69:
					image = apostrophe;
					break;
				case 70:
					image = openBracket;
					break;
				case 71:
					image = closeBracket;
					break;
				case 72:
					image = comma;
					break;
				case 73:
					image = dash;
					break;
				case 74:
					image = period;
					break;
				case 75:
					image = colon;
					break;
				case 76:
					image = semiColon;
					break;
				case 77:
					image = left;
					break;
				case 78:
					image = right;
					break;
				case 79:
					image = equals;
					break;
				case 80:
					image = question;
					break;
				case 81:
					image = link;
					break;
				default:
					image = SPACE;
					break;

			}

			if(image == link) {
				graphics.drawImage(image, drawX, drawY, 18 * Lttp.scale, 17 * Lttp.scale, null);
				drawX += 18 * Lttp.scale;
			} else {
				graphics.drawImage(image, drawX, drawY, 6 * Lttp.scale, 13 * Lttp.scale, null);
				drawX += 6 * Lttp.scale;
			}


		}

	}


}
