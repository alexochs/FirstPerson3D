package firstperson3d;

import processing.core.*;

public class Box extends Entity
{
	private float w, h, d;
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
		
		p.fill(255);
		p.textureMode(p.NORMAL);
		p.beginShape(p.QUADS);
		p.texture(tex);
 
		// +Z "front" face
		p.vertex(-w/2, -h/2, d/2, 0, 0);
		p.vertex( w/2, -h/2,  d/2, 1, 0);
		p.vertex( w/2,  h/2,  d/2, 1, 1);
		p.vertex(-w/2,  h/2,  d/2, 0, 1);

		// -Z "back" face
		p.vertex( w/2, -h/2, -d/2, 0, 0);
		p.vertex(-w/2, -h/2, -d/2, 1, 0);
		p.vertex(-w/2,  h/2, -d/2, 1, 1);
		p.vertex( w/2,  h/2, -d/2, 0, 1);
	
		// +Y "bottom" face
		p.vertex(-w/2,  h/2,  d/2, 0, 0);
		p.vertex( w/2,  h/2,  d/2, 1, 0);
		p.vertex( w/2,  h/2, -d/2, 1, 1);
		p.vertex(-w/2,  h/2, -d/2, 0, 1);
	
		// -Y "top" face
		p.vertex(-w/2, -h/2, -d/2, 0, 0);
		p.vertex( w/2, -h/2, -d/2, 1, 0);
		p.vertex( w/2, -h/2,  d/2, 1, 1);
		p.vertex(-w/2, -h/2,  d/2, 0, 1);
		
		// +X "right" face
		p.vertex( w/2, -h/2,  d/2, 0, 0);
		p.vertex( w/2, -h/2, -d/2, 1, 0);
		p.vertex( w/2,  h/2, -d/2, 1, 1);
		p.vertex( w/2,  h/2,  d/2, 0, 1);
	
		// -X "left" face
		p.vertex(-w/2, -h/2, -d/2, 0, 0);
		p.vertex(-w/2, -h/2,  d/2, 1, 0);
		p.vertex(-w/2,  h/2,  d/2, 1, 1);
		p.vertex(-w/2,  h/2, -d/2, 0, 1);
	
		p.endShape();
		
		p.popMatrix();
	}
	
	Box(PApplet p, PVector origin, PImage texture)
	{
		super(p, origin, 0, 0, 0);
		w = h = d = 32f;
		bbox = new BBox(origin, w+1, h+1, d+1);
		this.tex = texture;
	}
}