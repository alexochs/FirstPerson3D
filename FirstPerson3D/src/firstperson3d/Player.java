package firstperson3d;

import processing.core.*;

public class Player extends QueasyCam 
{
	private WorldManager world;
	private Entity selectedEntity;
	private boolean inUse;
	private float actionProgress;
	private float deltaTime;
	private float money, seeds, weed, dealers, mexicans;
	private int dealerTimer, mexicanTimer;
	
	public void saveGame()
	{
		p.saveStrings("savegame.txt", new String[] {Float.toString(money), Float.toString(seeds), Float.toString(weed), Float.toString(dealers), Float.toString(mexicans)});
	}
	
	public void loadGame()
	{
		String[] gamestate = p.loadStrings("savegame.txt");
		money = Float.parseFloat(gamestate[0]);
		seeds = Float.parseFloat(gamestate[1]);
		weed = Float.parseFloat(gamestate[2]);
		dealers = Float.parseFloat(gamestate[3]);
		mexicans = Float.parseFloat(gamestate[4]);
	}
	
	public Entity getSelectedEntity()
	{
		for (float r = 1f; r <= 32f; r++)
		{
			for (Entity ent : world.level.entityList)
			{	
				if(PVector.dist(ent.origin, campos) > 64f)
					continue;
			
				PVector fwd = new PVector(getForward().x*r, getForward().y*r, getForward().z*r);
				PVector point = PVector.add(campos, fwd);
				if(ent.bbox.isInBounds(point))
					return ent;
			}
		}
		
		return null;
	}
	
	public void tick()
	{
		deltaTime = 1/p.frameRate;
		if(!inUse) actionProgress = 0;
		if(dealers > 0) dealerTimer++;
		if(mexicans > 0) mexicanTimer++;
		
		super.draw(world.level.entityList);	
		
		if(weed > 0 && dealerTimer >= p.frameRate*5) { weed -= 1*dealers; money += 1.5*dealers; dealerTimer = 0;}
		if(mexicanTimer >= p.frameRate*30) { weed += 5*mexicans; mexicanTimer = 0; }
		
		selectedEntity = getSelectedEntity();
		if(selectedEntity != null) selectedEntity.inFocus = true;
		if (selectedEntity != null && inUse)
		{
			if (selectedEntity.typeid == Entity.BLOCK_GROWABLE && !selectedEntity.hasPlant && seeds > 0)
			{
				actionProgress++;
				if(actionProgress < p.frameRate*2)
					return;
				
				selectedEntity.hasPlant = true;
				world.level.entityList.add(new Plant(p, new PVector(selectedEntity.origin.x, selectedEntity.origin.y, selectedEntity.origin.z), (Box)selectedEntity, world.level.mdlPlant));
				actionProgress = 0;
				seeds--;
			}
			
			if (selectedEntity.typeid == Entity.PLANT)
			{
				actionProgress++;
				if(actionProgress < p.frameRate*2)
					return;
				
				Plant pl = (Plant)selectedEntity;
				pl.box.hasPlant = false;
				world.level.entityList.remove(selectedEntity);
				actionProgress = 0;
				weed++;
			}
			
			if (selectedEntity.typeid == Entity.SELL_WEED)
			{
				actionProgress++;
				if(actionProgress < p.frameRate)
					return;
				
				actionProgress = 0;
				if(weed > 0) { weed--; money++; }
			}
			
			if (selectedEntity.typeid == Entity.BUY_SEEDS)
			{
				actionProgress++;
				if(actionProgress < p.frameRate)
					return;
				
				actionProgress = 0;
				if(money > 0) { money--; seeds+=2; }
			}
			
			if (selectedEntity.typeid == Entity.HIRE_DEALER)
			{
				if(money < 10)
					return;
				
				actionProgress++;
				if(actionProgress < p.frameRate)
					return;
				
				actionProgress = 0;
				money -= 10;
				dealers++;
			}
			
			if (selectedEntity.typeid == Entity.HIRE_MEXICAN)
			{
				if(money < 25)
					return;
				
				actionProgress++;
				if(actionProgress < p.frameRate)
					return;
				
				actionProgress = 0;
				money -= 25;
				mexicans++;
			}
		}
	}
	
	public void draw()
	{
		tick();
		p.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		p.println("Money: $" + money + "\nWeed: " + weed + "g | Seeds: " + seeds + "\nDealers: " + dealers + " | Mexicans: " + mexicans);
	}
	
	public void keyPressed()
	{
		if(p.key == 'e') inUse = true;
		if(p.key == 'o') money++;
		//if(p.key == 'l') loadGame();
	}
	
	public void keyReleased()
	{
		if(p.key == 'e') inUse = false;
	}
	
	Player(PApplet p, WorldManager world, PVector origin) 
	{
		super(p, origin);
		this.world = world;
		this.selectedEntity = null;
		this.inUse = false;
		speed = .125f;
		sensitivity = .5f;
		money = 0;
		seeds = 1;
		weed = 0;
		dealers = 0;
		dealerTimer = 0;
	}
}
