package garden.soil.processes;

public class SpyProcess extends AProcess {

	private int totalMillisec;
	
	public SpyProcess(ProcessType newType) {
		super(newType);
		totalMillisec = 0;
	}

	@Override
	public void togglePause() {
	}

	@Override
	public void onInitalize() {
	}

	@Override
	public void onUpdate(int deltaMillisec) {
		totalMillisec += deltaMillisec;
	}

	public int getTotalMilli()
	{
		return totalMillisec;
	}
}
