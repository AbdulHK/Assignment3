package ie.dit;

import de.bezier.data.sql.*;
import processing.core.PApplet;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;


public class Main extends PApplet
 {

	Bird bird = new Bird(this);
	Pipe[] pipe = new Pipe[3];

	boolean start = false;
	boolean stop = true;
	boolean chdifficult = false;
	boolean langChois = false ;
	int score = 0;
	int max = 0, count = 0, languge = 0, flag = 0;
	int languge2 = 0 ;
	boolean binsert = true;

	boolean Pause = false;
	int menuPause = 0;

	int difficult = 0;
	
	

	SQLite db;
	
	Minim minim; 

    AudioPlayer Arabic;
    AudioPlayer English ;
    AudioPlayer Jimp ;
    AudioPlayer Stop ;
    AudioPlayer Back ;
    AudioPlayer Main_menu ;
    AudioPlayer Background ;
  
	
	public void setup() 
	{
		size(500, 500);

		// Sounds
		
		minim = new Minim(this); 
		       
		Arabic = minim.loadFile("res/arabic.mp3");
		English = minim.loadFile("res/English.mp3");
		Jimp = minim.loadFile("res/Jimp.wav");
		Main_menu = minim.loadFile("res/main_menu.wav");
		Background = minim.loadFile("res/background.mp3");
		Stop = minim.loadFile("res/stop.wav");
			
		// Initialize array
		for (int i = 0; i < 3; i++) 
		{
			pipe[i] = new Pipe(i, this);
		}
		textAlign(CENTER);
		textFont(createFont("Arial", 16, true), 16);

		// Database
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
			while (db.next()) 
			{
				count = db.getInt("count");
			}
		}

	}

	int place = 220;
	boolean bplace = false;

	public void draw() {

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
				
				if(!Main_menu.isPlaying())
				{
					Main_menu.rewind();
				}
				Main_menu.play();
				
			}else{
				Main_menu.pause();
			
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
					
					Arabic.play();
					//midiPlayer[4].start();
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
					
					English.play();
					//midiPlayer[0].start();
				}
			}
		}
	      // System.out.println(languge2);
	       //System.out.println(flag);
	       
		
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
			score += 3 ;
			}
		}

	}

	void Difficult() {
		// Medium
		if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 200
				&& mouseY <= 200 + 100) {
			difficult = 0;

			rect(200, 240, 10, 10);
		}

		// Medium
		if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 250
				&& mouseY <= 250 + 100) {
			difficult = 1;

			rect(200, 290, 10, 10);
		}
		// Hard
		if (mouseX >= 200 && mouseX <= 200 + 100 && mouseY >= 350
				&& mouseY <= 350 + 100) {
			difficult = 2;

			rect(200, 340, 10, 10);
		}
		
		if(languge2 == 1)
		{
			text("سهل", 250, 250);
			text("متوسط", 250, 300);
			text("صعب", 250, 350);
		}else{
			text("Easy", 250, 250);
			text("Medium", 250, 300);
			text("Hard", 250, 350);
		}
		
	}

	void Game() {
		
		
		//System.out.println(languge2);
		
		if(languge2 == 1)
		{
			Arabic.pause();
		}else{
			English.pause();
		}
		
		if(!Background.isPlaying())
		{
			Background.rewind();
		}
		
		Background.play();

		bird.drawBird();
		bird.checkClash();

		if (!stop) {

			bird.move();
			bird.drag();
			
			// Medium
			if (mouseX >= 20 && mouseX <= 20 + 20 && mouseY >= 20
					&& mouseY <= 20 + 20) {
				menuPause=3;
				
				text("Pause", 40, 20);

			}
			else{
				
				rect(20, 20, 10, 20);
				rect(40, 20, 10, 20);
			}

		} else {

			if (binsert) {
				db.query("INSERT INTO tablescore (score) VALUES ('" + score
						+ "')");
				binsert = !binsert;
			}
		}

		for (int i = 0; i < 3; i++) {
			pipe[i].checkPosition();
			pipe[i].drawPipe();
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

	public void mousePressed() {
		bird.jump();
		
		if (start) 
		{
			chdifficult = true;
			
		}
		if(flag == 1)
		{
			languge = 0 ;
			flag = 0 ;
		}
		
		if (menuPause == 1) {
			Pause = false;
			menuPause=0;
		}

		if (menuPause == 2) {
			Pause = false;
			start = false;
			stop = true;
			chdifficult = false;
			langChois = false ;
			menuPause=0;
			Background.pause();
			Arabic.rewind();
			English.rewind();
			
		}
		
		else{
			start = true;
		}
		
		if (menuPause == 3) 
		{
			Pause = true;
			menuPause=0;
		}
		if (languge == 1)
		{
			languge2 = 1 ;
			langChois = true ;
			start = false;
		}
		if (languge == 2)
		{
			languge2 = 2 ;
			langChois = true ;
			start = false;
			//playBackSound = true ;
			
		}
		
		
		
		
		
		Jimp.play();
		Jimp.rewind();
		

		if (stop) {
			reset();
		}

	}

	public void incScore() {
		score++;
	}

	public void moveBird() {
		for (int i = 0; i < 3; i++) {
			
			if (difficult == 1) {
				pipe[i].xPos -= 4;
			} else {
				pipe[i].xPos -= 3;
			}

		}
	}

	public Pipe getPipe(int i) {

		return pipe[i];
	}

	public void setStop(boolean bStop) {
		if (!stop) {
			Stop.play();
			Stop.rewind();
		}

		stop = bStop;
	}

	public void keyPressed() {
		Pause=true;
	}
}
