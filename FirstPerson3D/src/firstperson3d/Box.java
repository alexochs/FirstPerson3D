package firstperson3d;

import processing.core.*;

public class Box extends Entity
{
	private float w, h, d;
	private PImage tex;
	
	public void tick()
	{
		if(inFocus)
		{
			if(typeid == Entity.BLOCK_GROWABLE)
				p.println("Hold E for 2 seconds to plant a tree.");
			
			if(typeid == Entity.SELL_WEED)
				p.println("Hold E to sell your weed.");
			
			if(typeid == Entity.BUY_SEEDS)
				p.println("Hold E to buy new seeds.");
			
			if(typeid == Entity.HIRE_DEALER)
				p.println("Hole E to hire a dealer to sell your weed.\nCost: 10");
			
			if(typeid == Entity.HIRE_MEXICAN)
				p.println("Hold E to hire a mexican to grow your weed.\nCost; 25");
		}
		
		inFocus = false;
	}

	public void draw() 
	{	
		p.pushMatrix();
		
		p.translate(origin.x, origin.y, origin.z);
		p.rotateX(rotX);
		p.rotateY(rotY);
		p.rotateZ(rotZ);
		
		if(inFocus) p.stroke(255, 255, 0); p.strokeWeight(1f);
		p.textureMode(p.NORMAL);
		p.beginShape(p.QUADS);
		p.texture(tex);
		//p.stroke(0); p.strokeWeight(.33f);
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
		
		p.noStroke();
		
		p.popMatrix();
		
		tick();
	}
	
	Box(PApplet p, PVector origin, PImage texture, int typeid)
	{
		super(p, origin, 0, 0, 0);
		w = h = d = 32f;
		this.typeid = typeid;
		if (this.typeid >= 20 && this.typeid <= 29)
			w = h = d = 4f;
		bbox = new BBox(origin, w+5, h+5, d+5);
		this.tex = texture;
	}
}