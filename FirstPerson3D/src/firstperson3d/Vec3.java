package firstperson3d;

public class Vec3 
{
	float x, y, z;
	
	//Returns v1+v2
	static Vec3 add(Vec3 v1, Vec3 v2)
	{
		float x = v1.x + v2.x;
		float y = v1.y + v2.y;
		float z = v1.z + v2.z;
		return new Vec3(x, y, z);
	}
	
	//Returns v1-v2
	static Vec3 sub(Vec3 v1, Vec3 v2)
	{
		float x = v1.x - v2.x;
		float y = v1.y - v2.y;
		float z = v1.z - v2.z;
		return new Vec3(x, y, z);
	}	
	
	//Returns input vector rotated by pitch and yaw
	static Vec3 rot(Vec3 vec, float pitch, float yaw)
	{
		float pitchY = (float)(vec.y * Math.cos(pitch)) - (float)(vec.z * Math.sin(pitch));
		float pitchZ = (float)(vec.y * Math.sin(pitch)) + (float)(vec.z * Math.cos(pitch));
		float yawX = (float)(vec.x * Math.cos(yaw)) + (float)(vec.z * Math.sin(yaw));
		float yawZ = (float)(vec.x * -Math.sin(yaw)) + (float)(vec.z * Math.cos(yaw));
		float rotX = yawX;
		float rotY = pitchY;
		float rotZ = pitchZ + yawZ; 
		return new Vec3(rotX, rotY, rotZ);
	}
	
	Vec3() { this.x = this.y = this.z = 0; }
	Vec3(float x, float y, float z) { this.x = x; this.y = y; this.z = z; }
}
