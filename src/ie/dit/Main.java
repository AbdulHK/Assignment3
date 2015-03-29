package ie.dit;

import processing.core.*;

public class Main extends PApplet {

	Bird bird = new Bird(this);
	Pipe[] pipe = new Pipe[3];

	boolean start = false;
	boolean stop = true;
	int score = 0;
	int max = 0, count = 0;


	public void setup() {
		size(500, 500);

		for (int i = 0; i < 3; i++) {
			pipe[i] = new Pipe(i, this);
		}
		textAlign(CENTER);
		textFont(createFont("Arial", 16, true), 16);

		
	}

	public void draw() {

		background(175, 220, 255);

		if (start) {

			bird.drawBird();
			if (!stop) {

				bird.move();
				bird.drag();

			} 
			
		}
		} else {
			text("Click to Start", 250, 250);
			textAlign(RIGHT);
			text("Max Score: " + max, 200, 300);
			text("Amount of Games: " + count, 200, 320);
			textAlign(CENTER);
		}

		text("Score: " + score, 250, 450);
		if (score % 10 == 0 && score != 0) {
			text("B O N U S    +3", 250, 250);
		}

	}


	

	
}
