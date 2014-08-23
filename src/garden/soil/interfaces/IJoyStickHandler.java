package garden.soil.interfaces;

public interface IJoyStickHandler {
	public boolean onButtonDown(int button, int pressure);
	public boolean onButtonUp(int button);
	public boolean onJoystick(float x, float y);
}
