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
	void drawPipe() {

		parent.fill(122, 48, 0);
		parent.rect(xPos, 0, 50, clearance - 80);
		parent.rect(xPos, clearance + 80, 50, 500);
	}
	void checkPosition() {

		if (xPos < 0)
			{
			
		}
	if (xPos < 250 && !cashed) {
			
		}

}

