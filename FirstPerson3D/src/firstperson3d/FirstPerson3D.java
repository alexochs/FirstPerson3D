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
		fullScreen();
	}
	
	public void setup() 
	{
		game = new GameManager(this);
	}

	public void draw() 
	{
		println(frameRate);
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
