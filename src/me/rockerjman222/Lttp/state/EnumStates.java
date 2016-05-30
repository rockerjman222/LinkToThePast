package me.rockerjman222.Lttp.state;

public enum EnumStates {

	TOTAL_STATES(6), TITLE(0), INTRO(1), MENU(2), LINK_HOUSE(3), OVERWORLD(4), TEST(5);

	private int state;

	public int getState() {
		return this.state;
	}

	EnumStates(int state) {
		this.state = state;
	}
}
