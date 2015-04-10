package ie.dit;

float speed, x, y;
	boolean cashed = false;
	Main parent; // The parent PApplet that we will render ourselves onto
	int diffculties=0;

	Bird(Main p)
	{
		parent = p;
		x = 300;
		y = 300;
	}
	void move()
	{
		y += speed;
		parent.moveBird();
	}
	void jump()
	{
		speed = -9;
	}
	void drag() 
	{
		speed += 0.4;
	}
<<<<<<< HEAD
	
	void drawBird() {
=======
	void drawBird()
	{
>>>>>>> a98b8645aed11f3a8abd6ad02e951d998ef0a60a
		parent.stroke(255);
		parent.fill(255, 240, 85);
		parent.strokeWeight(2);

<<<<<<< HEAD
=======
		parent.fill(255, 240, 85);
		parent.ellipse(x, y, 30, 20);
		parent.ellipse(x + 5, y - 15, 15, 15);

		parent.fill(255, 0, 0);
		parent.ellipse(x + 8, y - 15, 5, 5);
		parent.ellipse(x + 12, y - 10, 15, 5);
	}
>>>>>>> a98b8645aed11f3a8abd6ad02e951d998ef0a60a
	}
}

