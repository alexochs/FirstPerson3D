package firstperson3d;

import processing.core.*;

public class Wall extends Entity
{
	private float w, h, d;
	
	public void tick()
	{
		
	}

	public void draw() 
	{	
		p.translate(origin.x, origin.y, origin.z);
		p.rotateX(rotX);
		p.rotateY(rotY);
		p.rotateZ(rotZ);
		p.box(w, h, d);
	}
	
	Wall(PApplet p, PVector origin, float width, float height, float depth, float rotX, float rotY, float rotZ)
	{
		super(p, origin, rotX, rotY, rotZ);
		w = width; h = height; d = depth; 
	}
}
