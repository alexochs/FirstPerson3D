package firstperson3d;

import processing.core.*;

public class BBox 
{
	float left, right; //X
	float top, bottom; //Y
	float front, back; //Z
	boolean ignore;
	
	public boolean isInBounds(PVector pos)
	{	
		if(ignore)
			return false;
		
		if ((pos.x >= left && pos.x <= right) &&
			(pos.y <= top && pos.y >= bottom) &&
			(pos.z <= front && pos.z >= back))
			return true;
		
		return false;
	}
	
	BBox()
	{
		ignore = true;
		this.left = 0;
		this.right = 0;
		this.top = 0;
		this.bottom = 0;
		this.front = 0;
		this.back = 0;
	}
	
	BBox(PVector midpoint, float w, float h, float d, boolean ignore)
	{
		this.ignore = ignore;
		this.left = midpoint.x - w/2;;
		this.right = midpoint.x + w/2;
		this.top = midpoint.y + h/2;
		this.bottom = midpoint.y - h/2;
		this.front = midpoint.z + d/2;
		this.back = midpoint.z - d/2;
	}
	
	BBox(PVector midpoint, float w, float h, float d)
	{
		ignore = false;
		this.left = midpoint.x - w/2;;
		this.right = midpoint.x + w/2;
		this.top = midpoint.y + h/2;
		this.bottom = midpoint.y - h/2;
		this.front = midpoint.z + d/2;
		this.back = midpoint.z - d/2;
	}
}
