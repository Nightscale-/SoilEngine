package garden.soil.interfaces;

import garden.soil.unfiled.ActorParameters;
import garden.soil.mathphysics.UnsignedInteger;
import garden.soil.inprogress.Mat4x4;

public interface IGameLogic {
	public enum BaseGameState
	{
		BGS_Initializing,
		BGS_LoadingGameEnvironment,
		BGS_MainMenu,
		BGS_WaitingForPlayers,
		BGS_SpawnAI,
		BGS_Running
	};
	public IActor getActor(UnsignedInteger actorId);
	public boolean addActor(IActor newActor, ActorParameters params);
	public boolean moveActor(UnsignedInteger actorId, Mat4x4 mat);
	public boolean removeActor(UnsignedInteger actorId);
	public boolean loadGame(String gameName);
	public void onUpdate(float time, float elapsedTime);
	public void changeState(BaseGameState newState);
	public void setProxy(boolean proxy);
	public IGamePhysics getGamePhysics();
	public void buildInitalScene();
	public void close();
}
