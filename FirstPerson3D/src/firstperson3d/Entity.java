package firstperson3d;

import processing.core.*;

public abstract class Entity 
{
	protected PApplet p;
	public PVector origin;
	public float rotX, rotY, rotZ;
	
	public abstract void tick();
	public abstract void draw();
	
	Entity(PApplet p, PVector origin, float rotX, float rotY, float rotZ) { this.p = p; this.origin = origin; this.rotX = rotX; this.rotY = rotY; this.rotZ = rotZ; }
}
