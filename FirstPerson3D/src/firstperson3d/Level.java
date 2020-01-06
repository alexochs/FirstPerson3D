package firstperson3d;

import java.util.ArrayList;
import processing.core.*;

public class Level 
{
	private PApplet p;
	private ArrayList<Entity> entityList;
	private PShape s;
	
	public void draw()
	{
		for (Entity ent : entityList)
			ent.draw();
		p.lights();
		
		p.translate(0, 0, 0);
		p.shape(s);
	}
	
	Level(PApplet p)
	{
		this.p = p;
		entityList = new ArrayList<Entity>();
		s = p.loadShape("firstperson3d/low-poly-fox-by-pixelmannen.obj");
		entityList.add(new Wall(p, new PVector(0, 0, 0), 320f, 64f, 16f, 0f, 0f, 0f));
		entityList.add(new Wall(p, new PVector(0, 0, 320), 320f, 64f, 16f, 0f, 0f, 0f));
		entityList.add(new Wall(p, new PVector(-160, 0, -160), 320f, 64f, 16f, 0f, PConstants.HALF_PI, 0f));
		entityList.add(new Wall(p, new PVector(160, -100, -160), 320f, 64f, 16f, 0f, PConstants.HALF_PI, 0f));
	}
}
