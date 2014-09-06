package garden.soil.processes;

import garden.soil.mathphysics.UnsignedInteger;

public class WaitProcess extends AProcess {

	protected UnsignedInteger start;
	protected UnsignedInteger stop;
	
	public WaitProcess(UnsignedInteger waitMill) {
		super(AProcess.ProcessType.PROC_WAIT);
		start = UnsignedInteger.valueOf(0);
		stop = waitMill;
	}

	@Override
	public void togglePause() {
	}

	@Override
	public void onInitalize() {
	}

	@Override
	public void onUpdate(int deltaMillisec) {
		if(this.isActive())
		{
			start.assign(start.longValue() + deltaMillisec);
			if(start.greaterThanOrEqual(stop))
			{
				this.killProcess();
			}
		}
	}
}
