package garden.soil.unfiled;

import garden.soil.unfiled.Process.ProcessType;

import java.util.ArrayList;

public class ProcessManager {

	protected ArrayList<Process> processList;
	
	public ProcessManager()
	{
		processList = new ArrayList<Process>();
	}
	
	public void updateProcesses(int deltaMillisec)
	{
		int index = 0;
		Process current;
		while(index < processList.size())
		{
			current = processList.get(index);
			if(current.isDead())
			{
				Process next = current.getNext();
				if(next == null)
				{
					current.setNext(null);
					attach(next);
				}
				detach(current);
			}
			else if(current.isActive() && !current.isPaused())
			{
				current.onUpdate(deltaMillisec);
				index++;
			}
		}
	}
	
	public boolean isProcessActive(ProcessType type)
	{
		for(int index = 0; index< processList.size(); index++)
		{
			Process toTest = processList.get(index);
			if(toTest.getType() == type && (!toTest.isDead() || toTest.getNext() != null))
			{
				return true;
			}
		}
		return false;
	}
	
	public void attach(Process newProcess)
	{
		processList.add(newProcess);
		newProcess.setAttached(true);
	}
	
	public boolean hasProcesses()
	{
		return !processList.isEmpty();
	}
	
	public void close()
	{
		while(!processList.isEmpty())
		{
			detach(processList.get(0));
		}
	}
	
	private void detach(Process toRemove)
	{
		processList.remove(toRemove);
		toRemove.setAttached(false);
	}
}
