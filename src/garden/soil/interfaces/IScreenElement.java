package garden.soil.interfaces;

public interface IScreenElement {
	public long onRestore();
	public long onRender(double time, float elapsedTime);
	public void onUpdate(int deltaMilliseconds);
	public int getZOrder();
	public void setZOrder(int newOrder);
	public boolean isVisible();
	public void setVisible(boolean visible);
	
	public int onMsgProc(String msg);
	public int close();
	public boolean zOrderLessThan(IScreenElement rhs);
}
