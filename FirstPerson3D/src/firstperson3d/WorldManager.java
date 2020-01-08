package firstperson3d;

import processing.core.*;

public class WorldManager
{
	private PApplet p;
	public Player player;
	public Level level;
	
	void tick()
	{
		p.noCursor();
		p.noStroke();
	}
	
	void draw()
	{
		tick();
		player.draw();
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
		this.player = new Player(p, this, new PVector(64, 0, -64));
		this.level = new Level(p, this);
	}
}
