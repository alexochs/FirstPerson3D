package firstperson3d;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.HashMap;
import processing.core.*;
import processing.event.KeyEvent;

public class QueasyCam
{
	public final static String VERSION = "##library.prettyVersion##";

	public boolean controllable;
	public float speed;
	public float sensitivity;
	public PVector campos;
	public PVector origin;
	public float pan;
	public float tilt;
	public PVector velocity;
	public float friction;
	public float eyeheight;

	protected PApplet p;
	private Robot robot;
	private PVector center;
	private PVector up;
	private PVector right;
	private PVector forward;
    private PVector target;
	private Point mouse;
	private Point prevMouse;
	private HashMap<Character, Boolean> keys;

	public QueasyCam(PApplet p, PVector origin)
	{
		this.p = p;
		p.registerMethod("draw", this);
		p.registerMethod("keyEvent", this);
		
		try 
		{
			robot = new Robot();
		}
		catch (Exception e) {}

		controllable = true;
		speed = 3f;
		sensitivity = 2f;
		this.origin = origin;
		campos = new PVector(origin.x, origin.y+eyeheight, origin.z);
		up = new PVector(0f, 1f, 0f);
		right = new PVector(1f, 0f, 0f);
		forward = new PVector(0f, 0f, 1f);
		velocity = new PVector(0f, 0f, 0f);
		pan = 0f;
		tilt = 0f;
		friction = 0.75f;
		keys = new HashMap<Character, Boolean>();

		p.perspective(PConstants.HALF_PI, (float)p.width/(float)p.height, 0.01f, 1000f);
	}

	public void draw(ArrayList<Entity> entityList)
	{
		if (!controllable) return;
		
		mouse = MouseInfo.getPointerInfo().getLocation();
		if (prevMouse == null) prevMouse = new Point(mouse.x, mouse.y);
		
		int w = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
		int h = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		
		if (mouse.x < 1 && (mouse.x - prevMouse.x) < 0){
			robot.mouseMove(w-2, mouse.y);
			mouse.x = w-2;
			prevMouse.x = w-2;
		}
				
		if (mouse.x > w-2 && (mouse.x - prevMouse.x) > 0){
			robot.mouseMove(2, mouse.y);
			mouse.x = 2;
			prevMouse.x = 2;
		}
		
		if (mouse.y < 1 && (mouse.y - prevMouse.y) < 0){
			robot.mouseMove(mouse.x, h-2);
			mouse.y = h-2;
			prevMouse.y = h-2;
		}
		
		if (mouse.y > h-1 && (mouse.y - prevMouse.y) > 0){
			robot.mouseMove(mouse.x, 2);
			mouse.y = 2;
			prevMouse.y = 2;
		}
		
		pan += PApplet.map(mouse.x - prevMouse.x, 0, p.width, 0, PConstants.TWO_PI) * sensitivity;
		tilt += PApplet.map(mouse.y - prevMouse.y, 0, p.height, 0, PConstants.PI) * sensitivity;
		tilt = clamp(tilt, -PConstants.PI/2.01f, PConstants.PI/2.01f);
		
		if (tilt == PConstants.PI/2) tilt += 0.001f;

		forward = new PVector(PApplet.cos(pan), PApplet.tan(tilt), PApplet.sin(pan));
		forward.normalize();
		right = new PVector(PApplet.cos(pan - PConstants.PI/2), 0, PApplet.sin(pan - PConstants.PI/2));
        
        target = PVector.add(campos, forward);
		
		prevMouse = new Point(mouse.x, mouse.y);
		
		if (keys.containsKey('a') && keys.get('a')) velocity.add(PVector.mult(right, speed));
		if (keys.containsKey('d') && keys.get('d')) velocity.sub(PVector.mult(right, speed));
		if (keys.containsKey('w') && keys.get('w')) velocity.add(PVector.mult(new PVector(forward.x, 0, forward.z), speed));
		if (keys.containsKey('s') && keys.get('s')) velocity.sub(PVector.mult(new PVector(forward.x, 0, forward.z), speed));

		velocity.mult(friction);
		boolean newPosValid = true;
		for(Entity ent : entityList)
		{
			if(ent.bbox.isInBounds(PVector.add(campos, velocity)))
				newPosValid = false; 
		}
		if (newPosValid) campos.add(velocity);
		origin = PVector.sub(campos, new PVector(0f, -eyeheight, 0f));
		center = PVector.add(campos, forward);
		p.camera(campos.x, campos.y, campos.z, center.x, center.y, center.z, up.x, up.y, up.z);
	}
	
	public void keyEvent(KeyEvent event)
	{
		char key = event.getKey();
		
		switch (event.getAction()){
			case KeyEvent.PRESS: 
				keys.put(Character.toLowerCase(key), true);
				break;
			case KeyEvent.RELEASE:
				keys.put(Character.toLowerCase(key), false);
				break;
		}
	}
    
    /*public void beginHUD()
    {
        g.pushMatrix();
        g.hint(DISABLE_DEPTH_TEST);
        g.resetMatrix();
        g.applyMatrix(originalMatrix);
    }
    
    public void endHUD()
    {
        g.hint(ENABLE_DEPTH_TEST);
        g.popMatrix();
    }*/
	
	private float clamp(float x, float min, float max){
		if (x > max) return max;
		if (x < min) return min;
		return x;
	}
	
	public PVector getForward(){
		return forward;
	}
	
	public PVector getUp(){
		return up;
	}
	
	public PVector getRight(){
		return right;
	}
    
    public PVector getTarget(){
        return target;
    }
    
}
