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
	
	
}

