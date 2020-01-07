package firstperson3d;

import processing.core.*;

public class Player extends QueasyCam 
{
	private WorldManager world;
	
	public void tick()
	{
		super.draw(world.level.entityList);	
		p.lights();
	}
	
	public void draw()
	{
		tick();
		
		p.println(campos.x + " " + campos.y + " " + campos.z);
	}
	
	public void keyPressed()
	{
		
	}
	
	public void keyReleased()
	{
	
	
	}
	
	Player(PApplet p, WorldManager world, PVector origin) 
	{
		super(p, origin);
		this.world = world;
		speed = .2f;
		sensitivity = .75f;
	}
}
