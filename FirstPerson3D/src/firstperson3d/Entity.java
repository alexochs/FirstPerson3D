package firstperson3d;

import processing.core.*;

public abstract class Entity 
{
	protected PApplet p;
	Vec3 pos;
	
	public abstract void tick();
	public abstract void draw();
	
	Entity(PApplet p, Vec3 position) { this.p = p; this.pos = position; }
}
