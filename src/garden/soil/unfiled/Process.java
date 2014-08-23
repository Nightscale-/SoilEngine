package garden.soil.unfiled;

public abstract class Process {

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
	
	public static final int PROCESS_FLAG_ATTACHED = 0x00000001;
	
	protected ProcessType type;
	protected boolean kill;
	protected boolean active;
	protected boolean paused;
	protected boolean initalUpdate;
	protected Process next;
	
	private int processFlags;
	
	public Process(ProcessType newType)
	{
		type = newType;
		kill = false;
		active = true;
		processFlags = 0;
		paused = false;
		initalUpdate = true;
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
		if((processFlags & PROCESS_FLAG_ATTACHED) == 1)
		{
			return true;
		}
		return false;
	}
	
	public void setAttached(boolean newAttached)
	{
		if(newAttached)
		{
			processFlags = processFlags | PROCESS_FLAG_ATTACHED;
		}
		else
		{
			processFlags = processFlags & ~PROCESS_FLAG_ATTACHED;
		}
	}
	
	public boolean isPaused()
	{
		return paused;
	}
	
	public abstract void togglePause();
	
	public boolean isInitalized()
	{
		return !initalUpdate;
	}
	
	public Process getNext()
	{
		return next;
	}
	
	public void setNext(Process newNext)
	{
		next = newNext;
	}
	
	public void onUpdate(int deltaMillisec)
	{
		if(initalUpdate)
		{
			onInitalize();
			initalUpdate = false;
		}
	}
	
	public abstract void onInitalize();
}
