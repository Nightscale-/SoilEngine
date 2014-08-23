package garden.soil.interfaces;

import java.util.List;

import garden.soil.mathphysics.UnsignedInteger;

public interface IGameView {
	
	public enum GameViewType
	{
		GameView_Human,
		GameView_Remote,
		GameView_AI,
		GameView_Recorder,
		GameView_Other
	}
	
	public long onRestore();
	public void onRender(double time, float elapsedTime);
	public void onLostDevice();
	public GameViewType getType();
	public UnsignedInteger getId();
	public void onAttach(UnsignedInteger vID, List<UnsignedInteger> actorIDs);
	
	public int onMsgProc(String msg);
	public void onUpdate(int deltaMilliseconds);
	public void close();
}
