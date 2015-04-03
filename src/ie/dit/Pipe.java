package ie.dit;

public class Pipe {
	float xPos, clearance;
	boolean cashed = false;
	Main parent; // The parent PApplet that we will render ourselves onto

	Pipe(int i, Main p) {
		parent = p;

		xPos = 100 + (i * 200);
		clearance = parent.random(200) + 100;
	}
}

