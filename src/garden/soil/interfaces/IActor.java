package garden.soil.interfaces;

import java.util.Map;

import garden.soil.inprogress.Mat4x4;
import garden.soil.mathphysics.UnsignedInteger;

public interface IActor {
	//TODO: shouldn't be public
	public void setMatrix(Mat4x4 newMat);
	public void setId(UnsignedInteger newId);
	
	
	public void close();
	public Mat4x4 getMat();
	public int getType();
	public UnsignedInteger getId();
	public Map<String, Object> getParams();
	public boolean isPhysical();
	public boolean isGeometrical();
	public void onUpdate(int deltaMilliseconds);
	public void rotateY(float angleRadians);
}
