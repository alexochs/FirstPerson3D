package firstperson3d;

import processing.core.*;

public abstract class Entity 
{
	public static final int BLOCK_NORMAL = 0;
	public static final int BLOCK_GROWABLE = 1;
	public static final int SELL_WEED = 20;
	public static final int BUY_SEEDS = 21;
	public static final int HIRE_DEALER = 22;
	public static final int HIRE_MEXICAN = 23;
	public static final int PLANT = 10;
	
	protected PApplet p;
	public PVector origin;
	public float rotX, rotY, rotZ;
	public BBox bbox;
	public int typeid;
	public boolean hasPlant;
	public boolean inFocus;
	
	public abstract void tick();
	public abstract void draw();
	
	Entity(PApplet p, PVector origin, float rotX, float rotY, float rotZ) { this.p = p; this.origin = origin; this.rotX = rotX; this.rotY = rotY; this.rotZ = rotZ; this.hasPlant = false; this.inFocus = false;}
}
