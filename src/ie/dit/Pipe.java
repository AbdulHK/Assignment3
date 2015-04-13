package ie.dit;

public class Pipe {
	float xPos, clearance;
	boolean cashed = false;
	float gap = 80 ;
	Main parent; // The parent PApplet that we will render ourselves onto

	Pipe(int i, Main p) {
		parent = p;

		xPos = 100 + (i * 200);
		clearance = parent.random(200) + 100;
	}

	void drawPipe() {
		
		if (parent.difficult == 2)
		{
			gap = 30 ;
		}
		parent.fill(122, 48, 0);
		parent.rect(xPos, 0, 50, clearance - gap);
		parent.rect(xPos, clearance + 80, 50, 420);
	}

	void checkPosition() {

		if (xPos < -50) {
			xPos += (200 * 3);
			clearance = parent.random(200) + 100;
			cashed = false;
		}

		if (xPos < 250 && !cashed) {
			cashed = true;

			parent.incScore();
		}

	}

}