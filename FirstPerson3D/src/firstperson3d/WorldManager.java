package firstperson3d;

import processing.core.*;

public class WorldManager
{
	private PApplet p;
	private Player player;
	private Level level;
	
	void tick()
	{
		p.noCursor();
		p.noStroke();
	}
	
	void draw()
	{
		tick();
		player.draw();
		
		p.background(0);
		level.draw();
	}
	
	void keyPressed()
	{
		//player.keyPressed();
	}
	
	void keyReleased()
	{
		//player.keyReleased();
	}
	
	WorldManager(PApplet p)
	{
		this.p = p;
		this.player = new Player(p, new PVector(0, 0, 0));
		this.level = new Level(p);
	}
}
