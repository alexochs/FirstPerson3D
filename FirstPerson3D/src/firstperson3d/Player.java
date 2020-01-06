package firstperson3d;

import processing.core.*;

public class Player extends QueasyCam 
{
	public void tick()
	{
		super.draw();
		p.lights();
		p.pointLight(255, 255, 255, origin.x, origin.y, origin.z);
	}
	
	public void draw()
	{
		tick();
	}
	
	public void keyPressed()
	{
		
	}
	
	public void keyReleased()
	{
	
	
	}
	
	Player(PApplet p, PVector origin) 
	{
		super(p, origin);
		speed = .2f;
		sensitivity = .75f;
	}
}
