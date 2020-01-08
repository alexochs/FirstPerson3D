package firstperson3d;

import processing.core.*;

public class Plant extends Entity
{
	private PShape mdl;
	
	public void tick()
	{
		
	}

	public void draw() 
	{	
		p.pushMatrix();
		
		p.translate(origin.x, origin.y, origin.z);
		p.scale(.5f);
		p.rotateX(rotX);
		p.rotateY(rotY);
		p.rotateZ(rotZ);
		
		p.shape(mdl);
		
		p.popMatrix();
	}
	
	Plant(PApplet p, PVector origin, float rotX, float rotY, float rotZ)
	{
		super(p, origin, rotX, rotY, rotZ);
		bbox = new BBox();
		this.mdl = p.loadShape("models/marijuanna.obj");
		origin.y += 32;
	}
}
