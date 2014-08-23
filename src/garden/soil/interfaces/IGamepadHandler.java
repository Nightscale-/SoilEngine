package garden.soil.interfaces;

public interface IGamepadHandler {
	public boolean onTrigger(boolean left, int pressure);
	public boolean onButtonDown(int button, int pressure);
	public boolean onButtonUp(int button);
	public boolean onDirectionPad(int directionFlags);
	public boolean onThumbstick(int stickNum, float x, float y);
}
