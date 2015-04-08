package ie.dit;

import processing.core.*;
import de.bezier.data.sql.*;

import java.io.*;

public class Main extends PApplet {
	
	Bird bird = new Bird(this);
	Pipe[] pipe = new Pipe[3];

	boolean start = false;
	boolean stop = true;
	boolean chdifficult = false;
	int score = 0;
	int max = 0, count = 0;
	boolean binsert = true;

	boolean Pause = false;
	int menuPause = 0;

	int difficult = 0;

	SQLite db;


	public void setup()
	{
		size(500, 500);

		for (int i = 0; i < 3; i++)
			{
			pipe[i] = new Pipe(i, this);
		}
		textAlign(CENTER);
		textFont(createFont("Arial", 16, true), 16);

		
	}

	public void draw()
	
	{

		background(175, 220, 255);
	background(175, 220, 255);

		// clouds
		fill(255, 255, 255);
		ellipse(40, 100, 50, 50);
		ellipse(100, 100, 100, 100);
		ellipse(150, 100, 50, 50);
		ellipse(180, 100, 30, 30);
		ellipse(220, 100, 10, 10);

		fill(255, 255, 255);
		ellipse(340, 100, 50, 50);
		ellipse(380, 60, 80, 80);
		ellipse(400, 100, 80, 80);
		ellipse(450, 120, 50, 50);
		ellipse(480, 100, 30, 30);
		if (start) {

			if (chdifficult) {

				if (!Pause) {
					Game();
				} else {
					// Back
					if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 200
							&& mouseY <= 200 + 100) {

						menuPause = 1;
						rect(200, 240, 10, 10);
					}

		

	}
	

	}

	

	
}
