package firstperson3d;

import java.util.ArrayList;
import processing.core.*;

public class Level 
{
	private PApplet p;
	private WorldManager world;
	
	private PImage texFloor;
	private PImage texWall;
	
	public ArrayList<Entity> entityList;
	
	public void draw()
	{
		p.background(0);
		p.lights();
		for (Entity ent : entityList)
			ent.draw();
	}
	
	Level(PApplet p, WorldManager world)
	{
		this.p = p;
		this.world = world;
		
		texFloor = p.loadImage("textures/carpet.jpg");
		texWall = p.loadImage("textures/wooden_wall.jpg");
		
		entityList = new ArrayList<Entity>();
		
		//North Wall
		entityList.add(new Box(p, new PVector(32*0, 0, 0), texWall));
		entityList.add(new Box(p, new PVector(32*1, 0, 0), texWall));
		entityList.add(new Box(p, new PVector(32*2, 0, 0), texWall));
		entityList.add(new Box(p, new PVector(32*3, 0, 0), texWall));
		
		//South Wall
		entityList.add(new Box(p, new PVector(32*0, 0, -32*5), texWall));
		entityList.add(new Box(p, new PVector(32*1, 0, -32*5), texWall));
		entityList.add(new Box(p, new PVector(32*2, 0, -32*5), texWall));
		entityList.add(new Box(p, new PVector(32*3, 0, -32*5), texWall));
		
		//West Wall
		entityList.add(new Box(p, new PVector(-32, 0, -32*0), texWall));
		entityList.add(new Box(p, new PVector(-32, 0, -32*1), texWall));
		entityList.add(new Box(p, new PVector(-32, 0, -32*2), texWall));
		entityList.add(new Box(p, new PVector(-32, 0, -32*3), texWall));
		entityList.add(new Box(p, new PVector(-32, 0, -32*4), texWall));
		entityList.add(new Box(p, new PVector(-32, 0, -32*5), texWall));
		
		//West Wall
		entityList.add(new Box(p, new PVector(32*4, 0, -32*0), texWall));
		entityList.add(new Box(p, new PVector(32*4, 0, -32*1), texWall));
		entityList.add(new Box(p, new PVector(32*4, 0, -32*2), texWall));
		entityList.add(new Box(p, new PVector(32*4, 0, -32*3), texWall));
		entityList.add(new Box(p, new PVector(32*4, 0, -32*4), texWall));
		entityList.add(new Box(p, new PVector(32*4, 0, -32*5), texWall));
		
		//Floor
		for (int row = 0; row < 4; row++)
		{
			for (int col = 0; col < 6; col++)
			{
				entityList.add(new Box(p, new PVector(32*row, 32, -32*col), texFloor));
			}
		}
	}
}
