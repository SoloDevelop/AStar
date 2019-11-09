package main;

public class Rect {

	public int x;
	public int y;

	public Rect(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Rect getCentre() {
		return new Rect(x + 33, y + 33);
	}

}
