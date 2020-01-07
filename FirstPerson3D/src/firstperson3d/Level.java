package firstperson3d;

import java.util.ArrayList;
import processing.core.*;

public class Level 
{
	private PApplet p;
	private WorldManager world;
	private PShape plantModel;
	public ArrayList<Entity> entityList;
	
	public void draw()
	{
		p.background(0);
		p.lights();
		p.pointLight(255, 255, 255, world.player.campos.x, world.player.campos.y, world.player.campos.z);
		for (Entity ent : entityList)
			ent.draw();
	}
	
	Level(PApplet p, WorldManager world)
	{
		this.p = p;
		this.world = world;
		
		plantModel = p.loadShape("models/marijuanna.obj");
		
		entityList = new ArrayList<Entity>();
		entityList.add(new Box(p, new PVector(0, 0, 0), 300f, 64f, 8f, 0f, 0f, 0f, new Color(200, 12, 66)));
		entityList.add(new Box(p, new PVector(0, 0, -300), 300f, 64f, 8f, 0f, 0f, 0f, new Color(200, 12, 66)));
		entityList.add(new Box(p, new PVector(150, 0, -150), 8f, 64f, 300f, 0f, 0f, 0f, new Color(200, 12, 66)));
		entityList.add(new Box(p, new PVector(-150, 0, -150), 8f, 64f, 300f, 0f, 0f, 0f, new Color(200, 12, 66)));
		entityList.add(new Box(p, new PVector(0, 32, -150), 300f, 8f, 300f, 0f, 0f, 0f, new Color(0, 40, 220)));
		entityList.add(new Box(p, new PVector(0, -32, -150), 300f, 8f, 300f, 0f, 0f, 0f, new Color(220)));
		entityList.add(new Plant(p, new PVector(0, 0, -150), 0, 0, 0, plantModel));
	}
}
