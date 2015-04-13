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
			db = new SQLite(this, "Database.db"); // open database file

		if (db.connect()) 
		{
			// read all in table "tablescore"
			db.query("SELECT MAX(score) as max FROM tablescore");

			while (db.next())
				{
				max = db.getInt("max");
			}

			db.query("SELECT COUNT(score) as count FROM tablescore");
			while (db.next()) {
				count = db.getInt("count");
			}
		}
		
	}
	int place = 220;
	boolean bplace = false;
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

					// Main Menu
					if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 250
							&& mouseY <= 250 + 100) {
						menuPause = 2;

						rect(200, 290, 10, 10);
					}
					
					if (languge2 == 1)
					{
						text("عوده للعب", 250, 250);
						text("القاىمه الرئيسية", 250, 300);
					}else{
						text("Back", 250, 250);
						text("Main Menu", 250, 300);
					}
					

				}

			} else {

				Difficult();

			}

		} else {

			stroke(255);
			fill(255, 240, 85);
			strokeWeight(2);

			if (!bplace) {
				place += 1;
				if (place > 280) {
					bplace = true;
				}
			} else 
			{
				place -= 1;
				if (place < 221) {
					bplace = false;
				}
			}
			
			
				// birdie
				fill(255, 240, 85);
				ellipse(place, 200, 30, 20);
				ellipse(place + 5, 200 - 15, 15, 15);

				fill(255, 0, 0);
				ellipse(place + 8, 200 - 15, 5, 5);
				ellipse(place + 12, 200 - 10, 15, 5);

				fill(255, 255, 255);
				
				
				if(!langChois)
				{
				if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 200
						&& mouseY <= 200 + 100) {

					languge = 1;
					rect(200, 240, 10, 10);
				}

				// Main Menu
				if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 250
						&& mouseY <= 250 + 100) {
					languge = 2;

					rect(170, 290, 10, 10);
				}

				text("إضغط للعربيه", 250, 250);
				text("Press For English", 250, 300);
				
				
			}else{
			
			if(languge2 == 1)
			{
				text("إضغط لبدا اللعبه", 250, 250);
				textAlign(RIGHT);
				text("أعلى نقاط: " + max, 200, 300);
				text("عداد الالعاب: " + count, 200, 320);
				textAlign(CENTER);
				
				
				
				if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 250
						&& mouseY <= 250 + 100)
				{
					flag = 1 ;
					
				}
			}
			if(languge2 == 2)
			{
				text("Click  to Start", 250, 250);
				textAlign(RIGHT);
				text("Max Score: " + max, 200, 300);
				text("Amount of Games: " + count, 200, 320);
				textAlign(CENTER);
				
				if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 300
						&& mouseY <= 300 + 100)
				{
					flag = 1 ;
					
				}
			}
			}
		}
	       System.out.println(mouseY);
	       System.out.println(flag);
	       
		
		if (languge2 == 1)
		{
			text("النقاط: " + score, 250, 450);
			if (score % 10 == 0 && score != 0) {
			text("زيااااادة    +3", 250, 250);
			}
		}else
		{
			text("Score: " + score, 250, 450);
			if (score % 10 == 0 && score != 0) {
			text("B O N U S    +3", 250, 250);
			}
		}

	}
	void reset() {
		stop = false;
		score = 0;
		bird.y = 400;

		for (int i = 0; i < 3; i++) {
			pipe[i].xPos += 550;
			pipe[i].cashed = false;
		}
	}

	}
	

	}

	

	
}
