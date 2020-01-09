package firstperson3d;

import processing.core.*;

public class Plant extends Entity
{
	private PShape mdl;
	private PImage tex;
	public Box box;
	private boolean mature;
	private float growProgress;
	private float scale;
	
	public void tick()
	{
		if(!mature)
		{
			growProgress += 1/p.frameRate;
			scale = growProgress/5;
			if(scale >= 1) { scale = 1; mature = true; }
		}
		
		if(inFocus)
		{
			if(!mature)
				p.println("Wait for me, I'm still growing.");
			else
				p.println("Hold E for 2 seconds to harvest me.");
		}
		
		inFocus = false;
	}

	public void draw() 
	{	
		tick();
		
		p.pushMatrix();
		
		p.translate(origin.x, origin.y, origin.z);
		p.scale(scale*5f, 5f, scale*5f);
		p.rotateX(rotX);
		p.rotateY(rotY);
		p.rotateZ(rotZ);
		
		p.shape(mdl);
		
		p.popMatrix();
	}
	
	Plant(PApplet p, PVector origin, Box box, PShape mdl)
	{
		super(p, origin, PConstants.PI, (float)(Math.random()*PConstants.TWO_PI), 0f);
		bbox = new BBox(new PVector(origin.x, origin.y - 16, origin.z), 16, 32, 16);
		origin.y -= 24;
		this.box = box;
		this.mdl = mdl;
		this.typeid = Entity.PLANT;
		this.mature = false;
		this.scale = 0;
		this.growProgress = 0;
	}
}
