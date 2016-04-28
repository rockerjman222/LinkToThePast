package me.rockerjman222.Lttp.assets;

public enum Letter {

	A(0, 0), B(6, 0), C(12, 0), D(18, 0), E(24, 0), F(30, 0), G(36, 0), H(42, 0), I(58, 0), J(64, 0), K(70, 0), L(76, 0), M(82, 0), N(88, 0), O(94, 0), P(100, 0), Q(106, 0), R(112, 0), S(118, 0), T(124, 0), U(130, 0), V(136, 0), W(142, 0), X(158, 0), Y(164, 0), Z(170, 0),
	a(0, 15), b(6, 15), c(12, 15), d(18, 15), e(24, 15), f(30, 15), g(36, 15), h(42, 15), i(58, 15), j(64, 15), k(70, 15), l(76, 15), m(82, 15), n(88, 15), o(94, 15), p(100, 15), q(106, 15), r(112, 15), s(118, 15), t(124, 15), u(130, 15), v(136, 15), w(142, 15), x(158, 15), y(164, 15), z(170, 15),
	ONE(0, 30), TWO(6, 30), THREE(12, 30), FOUR(18, 30), FIVE(24, 30), SIX(30, 30), SEVEN(36, 30), EIGHT(42, 30), NINE(58, 30), EXCLAMATION(64, 30), QUOTATION(70, 30), TILDA(76, 30), SNAKE(82, 30), PERSON(88, 30), APOSTROPHE(94, 30), OPENBRACKET(100, 30), CLOSEBRACKET(106, 30), COMMA(112, 30), DASH(118, 30), PERIOD(124, 30), COLON(130, 30), SEMICOLON(136, 30), LESSTHAN(142, 30), GREATERTHAN(158, 30), EQUALS(164, 30), QUESTION(170, 30),
	LINK(0, 45, 18, 16);


	private int posX;
	private int posY;
	private int width;
	private int height;

	Letter(int x, int y, int width, int height) {
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
	}

	Letter(int x, int y) {
		this(x, y, 6, 15);
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
