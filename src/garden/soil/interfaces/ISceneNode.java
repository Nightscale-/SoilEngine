package garden.soil.interfaces;

import garden.soil.inprogress.Mat4x4;
import garden.soil.inprogress.RayCast;
import garden.soil.inprogress.Scene;
import garden.soil.inprogress.SceneNodeProperties;

import garden.soil.mathphysics.UnsignedInteger;
import garden.soil.mathphysics.UnsignedLong;

public interface ISceneNode {
	public SceneNodeProperties getProperties();
	public void setTransform(Mat4x4 toWorld, Mat4x4 fromWorld);
	public long preRender(Scene newScene);
	public long render(Scene newScene);
	public long postRender(Scene newScene);
	
	public boolean addChild(ISceneNode child);
	public boolean removeChild(UnsignedInteger actorId);
	public long renderChildren(Scene scene);
	public long onRestore(Scene scene);
	public boolean isVisible(Scene scene);
	public long pick(Scene scene, RayCast rayCast);
	public long onUpdate(Scene scene, UnsignedLong elapsedMs);
	public void close();
}
