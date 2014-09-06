package garden.soil.processes;

import garden.soil.processes.AProcess.ProcessType;

import java.util.ArrayList;

public class ProcessManager {

	protected ArrayList<AProcess> processList;
	
	public ProcessManager()
	{
		processList = new ArrayList<AProcess>();
	}
	
	public void updateProcesses(int deltaMillisec)
	{
		int index = 0;
		AProcess current;
		while(index < processList.size())
		{
			current = processList.get(index);
			if(current.isDead())
			{
				AProcess next = current.getNext();
				if(next != null)
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
			AProcess toTest = processList.get(index);
			if(toTest.getType() == type && (!toTest.isDead() || toTest.getNext() != null))
			{
				return true;
			}
		}
		return false;
	}
	
	public void attach(AProcess newProcess)
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
	
	private void detach(AProcess toRemove)
	{
		processList.remove(toRemove);
		toRemove.setAttached(false);
	}
}
