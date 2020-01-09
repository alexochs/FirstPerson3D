package firstperson3d;

import java.util.ArrayList;
import processing.core.*;

public class Level 
{
	private PApplet p;
	private WorldManager world;
	
	private PImage texFloor;
	private PImage texWall;
	private PImage texGrass;
	private PImage texSellweed, texBuyseeds, texHiredealer, texHireMexican;
	public PShape mdlPlant, mdlBlunt, mdlTV;
	
	public ArrayList<Entity> entityList;
	
	public void draw()
	{
		p.background(135, 206, 235);
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
		texGrass = p.loadImage("textures/grass.jpg");
		texSellweed = p.loadImage("textures/sellweed.jpeg");
		texBuyseeds = p.loadImage("textures/buyseeds.jpeg");
		texHiredealer = p.loadImage("textures/hiredealer.jpeg");
		texHireMexican = p.loadImage("textures/hiremexican.jpeg");
		mdlPlant = p.loadShape("models/lowpolytree.obj");
		mdlTV = p.loadShape("models/MI SMART TV.obj");
		
		entityList = new ArrayList<Entity>();
		
		//Floor
		for (int row = 0; row <= 5; row++)
		{
			for (int col = 0; col <= 5; col++)
			{
				entityList.add(new Box(p, new PVector(32*col, 32, -32*row), texFloor, Entity.BLOCK_NORMAL));
			}
		}
		
		//Walls
		for (int row = -3; row <= 5; row++)
		{
			for (int col = -3; col <= 5; col++)
			{
				if(row == 0 && col == 2)
					continue;
				
				if ((row == 0 || row == 5 || row == -3) || (col == 0 || col == 5 || col == -3))
					entityList.add(new Box(p, new PVector(32*col, 0, -32*row), texWall, Entity.BLOCK_NORMAL));
			}
		}
		
		//Roof
		for (int row = 0; row <= 5; row++)
		{
			for (int col = 0; col <= 5; col++)
			{
				entityList.add(new Box(p, new PVector(32*col, -32, -32*row), texWall, Entity.BLOCK_NORMAL));
			}
		}
		
		//Yard
		for (int row = -1; row >= -3; row--)
		{
			for (int col = 0; col <= 5; col++)
			{
				entityList.add(new Box(p, new PVector(32*col, 32, -32*row), texGrass, Entity.BLOCK_GROWABLE));
				
				if(row == -3 || col == 0 || col == 5)
					entityList.add(new Box(p, new PVector(32*col, 0, -32*row), texWall, Entity.BLOCK_NORMAL));
			}
		}
		
		//Buttons
		entityList.add(new Box(p, new PVector(32, 0, -32), texSellweed, Entity.SELL_WEED));
		entityList.add(new Box(p, new PVector(32, 0, -32*2), texBuyseeds, Entity.BUY_SEEDS));
		entityList.add(new Box(p, new PVector(32, 0, -32*3), texHiredealer, Entity.HIRE_DEALER));
		entityList.add(new Box(p, new PVector(32, 0, -32*4), texHireMexican, Entity.HIRE_MEXICAN));
	}
}
