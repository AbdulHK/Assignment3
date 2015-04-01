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
			
		}

		

	}
	
	public void mousePressed() {
		bird.jump();
		start = true;

		if (stop) {
			reset();
		}
	}

	

	
}
