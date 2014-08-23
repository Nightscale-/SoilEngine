package garden.soil.interfaces;

import garden.soil.inprogress.Point;


public interface IMouseHandler {
	public boolean onMouseMove(Point mousePos);
	public boolean onLButtonDown(Point mousePos);
	public boolean onLButtonUp(Point mousePos);
	public boolean onRButtonDown(Point mousePos);
	public boolean onRButtonUp(Point mousePos);
}
