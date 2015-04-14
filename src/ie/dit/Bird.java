package ie.dit;

public class Bird {

	float speed, x, y;
	boolean cashed = false;
	Main parent; // The parent PApplet that we will render ourselves onto

	Bird(Main p) {
		parent = p;
		x = 300;
		y = 300;
	}

	void move() {
		y += speed;
		parent.moveBird();
	}

	void jump() {
		speed = -9;
	}

	void drag() {
		speed += 0.4;
	}

	void drawBird() {
		parent.stroke(255);
		parent.fill(255, 240, 85);
		parent.strokeWeight(2);

		parent.fill(255, 240, 85);
		parent.ellipse(x, y, 30, 20);
		parent.ellipse(x + 5, y - 15, 15, 15);

		parent.fill(255, 0, 0);
		parent.ellipse(x + 8, y - 15, 5, 5);
		parent.ellipse(x + 12, y - 10, 15, 5);
	}

	void checkClash() {

		if (y > 500) {
			parent.setStop(true);
		}

		if (y < 0) {
			parent.setStop(true);
		}

		for (int i = 0; i < 3; i++) {

			if ((x < parent.getPipe(i).xPos + 75 
					&& x > parent.getPipe(i).xPos - 15)
					&& (y < parent.getPipe(i).clearance -  (parent.getPipe(i).gap) 
					|| y > parent.getPipe(i).clearance + 80)) {

				parent.setStop(true);
			}

		}

	}
}
