package firstperson3d;

import processing.core.*;

public class Player extends Entity 
{
	private Vec3 fwd, right, up;
	private float pitch, yaw;
	private boolean moveForwards, moveBackwards, moveRight, moveLeft,
					turnUp, turnDown, turnLeft, turnRight;
	
	private void printDebug()
	{
		p.println("Position: " + pos.x + " " + pos.y + " " + pos.z);
		p.println("Pitch: " + pitch*180/PConstants.PI + "  Yaw: " + yaw*180/PConstants.PI);
		//p.println("Aimpoint: " + (pos.x+fwd.x) + " " + (pos.y+fwd.y) + " " + (pos.z+fwd.z));
	}
	
	private void move()
	{
		if(moveForwards) pos = Vec3.add(pos, new Vec3(fwd.x, 0, fwd.z));
		if(moveBackwards) pos = Vec3.sub(pos, new Vec3(fwd.x, 0, fwd.z));
		if(moveRight) pos = Vec3.add(pos, new Vec3(right.x, 0, right.z));
		if(moveLeft) pos = Vec3.sub(pos, new Vec3(right.x, 0, right.z));
	}
	
	private void turn()
	{
		if(turnUp) pitch -= PConstants.HALF_PI/90;
		if(turnDown) pitch += PConstants.HALF_PI/90;
		if(pitch >= PConstants.HALF_PI) pitch = PConstants.HALF_PI*0.99f;
		if(pitch <= -PConstants.HALF_PI) pitch = -PConstants.HALF_PI*0.99f;
		if(turnRight) yaw -= PConstants.TWO_PI/120;
		if(turnLeft) yaw += PConstants.TWO_PI/120;
		if(yaw >= PConstants.TWO_PI) yaw = PConstants.TWO_PI*0.99f;
		if(yaw <= -PConstants.TWO_PI) yaw = -PConstants.TWO_PI*0.99f;
	}
	
	private void calcDirectionVectors()
	{
		fwd = Vec3.rot(new Vec3(0, 0, -1), pitch, yaw);
		right = Vec3.rot(new Vec3(1, 0, 0), 0, yaw);
		//up = Vec3.rot(new Vec3(0, 1, 0), pitch, yaw);
	}
	
	public void tick()
	{
		p.camera(pos.x, pos.y, pos.z, pos.x+fwd.x, pos.y+fwd.y, pos.z+fwd.z, 0, 1, 0);
		turn();
		calcDirectionVectors();
		move();
		printDebug();
	}
	
	public void draw()
	{
		tick();
	}
	
	public void keyPressed()
	{
		if(p.key == 'w') moveForwards = true;
		if(p.key == 's') moveBackwards = true;
		if(p.key == 'd') moveRight = true;
		if(p.key == 'a') moveLeft = true;
		if(p.keyCode == PConstants.UP) turnUp = true;
		if(p.keyCode == PConstants.DOWN) turnDown = true;
		if(p.keyCode == PConstants.RIGHT) turnRight = true;
		if(p.keyCode == PConstants.LEFT) turnLeft = true;
	}
	
	public void keyReleased()
	{
		if(p.key == 'w') moveForwards = false;
		if(p.key == 's') moveBackwards = false;
		if(p.key == 'd') moveRight = false;
		if(p.key == 'a') moveLeft = false;
		if(p.keyCode == PConstants.UP) turnUp = false;
		if(p.keyCode == PConstants.DOWN) turnDown = false;
		if(p.keyCode == PConstants.RIGHT) turnRight = false;
		if(p.keyCode == PConstants.LEFT) turnLeft = false;
	
	}
	
	Player(PApplet p, Vec3 position) 
	{
		super(p, position);
		fwd = new Vec3(0, 0, -1);
		right = new Vec3(1, 0, 0);
		up = new Vec3(0, 1, 0);
		pitch = yaw = 0;
		moveForwards = moveBackwards = moveRight = moveLeft = turnUp = turnDown = turnLeft = turnRight = false;
	}
}
