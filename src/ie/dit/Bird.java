package ie.dit;

public class Bird 
{

	float speed, x, y;
	
	Main parent; // The parent PApplet that we will render ourselves onto

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
void jump() {
		speed = -9;
	}


	}

