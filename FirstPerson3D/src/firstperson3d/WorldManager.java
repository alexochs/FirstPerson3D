package firstperson3d;

import processing.core.PApplet;

public class WorldManager
{
	private PApplet p;
	private Player player;
	
	void tick()
	{
		
	}
	
	void draw()
	{
		tick();
		player.draw();
		p.background(255, 255, 0);
		p.translate(0, 0, 0);
		p.box(64);
	}
	
	void keyPressed()
	{
		player.keyPressed();
	}
	
	void keyReleased()
	{
		player.keyReleased();
	}
	
	WorldManager(PApplet p)
	{
		this.p = p;
		this.player = new Player(p, new Vec3(0, 0, 125));
	}
}
