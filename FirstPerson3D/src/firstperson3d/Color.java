package firstperson3d;

public class Color 
{
	float r, g, b, a;
	
	Color() { r = g = b = a = 255; };
	Color(float grayscale) { r = g = b = grayscale; a = 255; }
	Color(float r, float g, float b) { this.r = r; this.g = g; this.b = b; a = 255; }
	Color(float r, float g, float b, float a) { this.r = r; this.g = g; this.b = b; this.a = a; }
}
