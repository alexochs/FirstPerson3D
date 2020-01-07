package firstperson3d;

import processing.core.*;

public class Box extends Entity
{
	private float w, h, d;
	private Color color;
	private PImage tex;
	
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
		
		p.fill(color.r, color.g, color.b, color.a);
		p.box(w, h, d);
		
		p.popMatrix();
	}
	
	Box(PApplet p, PVector origin, float width, float height, float depth, float rotX, float rotY, float rotZ, Color color)
	{
		super(p, origin, rotX, rotY, rotZ);
		w = width; h = height; d = depth;
		bbox = new BBox(origin, w+1, h+1, d+1, true);
		this.color = color;
	}
}
