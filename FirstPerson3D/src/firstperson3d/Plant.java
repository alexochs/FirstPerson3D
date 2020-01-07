package firstperson3d;

import processing.core.*;
public class Plant extends Entity
{
	private PApplet p;
	private PShape model;

	public void tick() 
	{
		
	}

	public void draw()
	{
		p.pushMatrix();
		
		p.translate(origin.x, origin.y, origin.z);
		p.rotateX(rotX);
		p.rotateY(rotY);
		p.rotateZ(rotZ);
		
		p.shape(model);
		
		p.popMatrix();
	}
	
	Plant(PApplet p, PVector origin, float rotX, float rotY, float rotZ, PShape model)
	{
		super(p, origin, rotX, rotY, rotZ);
		bbox = new BBox();
		this.model = model;
	}
}
