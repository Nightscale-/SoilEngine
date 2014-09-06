package garden.soil.processes;

public abstract class AProcess {

	public enum ProcessType
	{
		PROC_NONE,
		PROC_WAIT,
		PROC_CONTROL,
		PROC_SCREEN,
		PROC_MUSIC,
		PROC_SOUNDFX,
		PROC_ACTOR,
		PROC_INTERPOLATOR
	};
	
	protected ProcessType type;
	protected boolean kill;
	protected boolean active;
	protected boolean paused;
	protected boolean amInitialized;
	protected boolean amAttached;
	protected AProcess next;
	
	public abstract void togglePause();
	public abstract void onInitalize();
	public abstract void onUpdate(int deltaMillisec);
	
	public AProcess(ProcessType newType)
	{
		type = newType;
		kill = false;
		active = true;
		amAttached = false;
		paused = false;
		amInitialized = false;
	}
	
	public boolean isDead()
	{
		return kill;
	}
	
	public void killProcess()
	{
		kill = true;
	}
	
	public ProcessType getType()
	{
		return type;
	}
	
	public void setType(ProcessType newType)
	{
		type = newType;
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	public void setActive(boolean newActive)
	{
		active = newActive;
	}
	
	public boolean isAttached()
	{
		return amAttached;
	}
	
	public void setAttached(boolean newAttached)
	{
		amAttached = newAttached;
	}
	
	public boolean isPaused()
	{
		return paused;
	}
	
	public boolean isInitalized()
	{
		return amInitialized;
	}
	
	public AProcess getNext()
	{
		return next;
	}
	
	public void setNext(AProcess newNext)
	{
		next = newNext;
	}
}
