package ie.dit;

public class Bird 
{

	float speed, x, y;
	
	Main parent; // The parent PApplet that we will render ourselves onto

	
	void move()
	{
		y += speed;
		parent.moveBird();
	}
	void jump()
	{
		speed = -9;
	}
	}

