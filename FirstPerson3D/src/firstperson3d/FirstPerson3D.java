package firstperson3d;

import processing.core.PApplet;
import processing.core.PConstants;

public class FirstPerson3D extends PApplet 
{
	private GameManager game;
	
	public static void main(String[] args)
	{
		String[] name = {""};
		FirstPerson3D game =  new FirstPerson3D();
		PApplet.runSketch(name, game);
	}
	
	public void settings()
	{
		size(800, 600, P3D);
	}
	
	public void setup() 
	{
		//perspective(PConstants.HALF_PI, width/height, 1, 1000000);
		game = new GameManager(this);
	}

	public void draw() 
	{
		game.draw();
	}
	
	public void keyPressed()
	{
		game.keyPressed();
	}
	
	public void keyReleased()
	{
		game.keyReleased();
	}
}
