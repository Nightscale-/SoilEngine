package garden.soil.interfaces;

import java.util.Vector;

import garden.soil.inprogress.Mat4x4;
import garden.soil.mathphysics.UnsignedInteger;

public interface IGamePhysics {
	public enum PhysicsMaterial
	{
		PhysMat_Playdough,
		PhysMat_Normal,
		PhysMat_Bouncy,
		PhysMat_Slippery,
		PhysMat_MaxMaterials
	}
	
	public boolean initalize();
	public void syncVisibleScene();
	public void onUpdate(float deltaSeconds);
	
	public void addSphere(float radius, IActor actor, float specificGraphic, PhysicsMaterial mat);
	public void addBox(Vector<Double> dimensions, IActor actor, float specificGravity, PhysicsMaterial mat);
	public void addPointCloud(Vector<Double> verts, IActor actor, float specificGravity, PhysicsMaterial mat);
	public void removeActor(UnsignedInteger actorId);
	
	public void renderDiagnostics();
	
	public void createTrigger(Vector<Double> pos, float dim, int triggerId);
	public void applyForce(Vector<Double> dir, float newtons, UnsignedInteger actorId);
	public void applyTorque(Vector<Double> dir, float newtons, UnsignedInteger actorId);
	public boolean kinematicMove(Mat4x4 mat, UnsignedInteger actorId);
	
	public void rotateY(UnsignedInteger actorId, float angleRadians, float time);
	public void getOrientationY(UnsignedInteger actorId);
	public void stopActor(UnsignedInteger actorId);
	public void setVelocity(UnsignedInteger actorId, Vector<Double> velocity);
	public void translate(UnsignedInteger actorId, Vector<Double> vector);
	
	public void close();
	
}
