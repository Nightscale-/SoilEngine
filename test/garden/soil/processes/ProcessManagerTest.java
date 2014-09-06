package garden.soil.processes;

import static org.junit.Assert.*;
import garden.soil.mathphysics.UnsignedInteger;

import org.junit.Test;

public class ProcessManagerTest {

	@Test
	public void testUpdateProcesses() {
		SpyProcess spy1 = new SpyProcess(AProcess.ProcessType.PROC_ACTOR);
		SpyProcess spy2 = new SpyProcess(AProcess.ProcessType.PROC_CONTROL);
		ProcessManager toTest = new ProcessManager();
		toTest.attach(spy1);
		toTest.updateProcesses(8);
		toTest.attach(spy2);
		toTest.updateProcesses(10);
		assertEquals(18, spy1.getTotalMilli());
		assertEquals(10, spy2.getTotalMilli());
	}

	@Test
	public void testIsProcessActive() {
		WaitProcess dummy = new WaitProcess(UnsignedInteger.valueOf(9));
		ProcessManager toTest = new ProcessManager();
		toTest.attach(dummy);
		assertTrue(toTest.isProcessActive(dummy.getType()));
	}

	@Test
	public void testAttach() {
		WaitProcess dummy = new WaitProcess(UnsignedInteger.valueOf(9));
		ProcessManager toTest = new ProcessManager();
		toTest.attach(dummy);
		assertTrue(dummy.isAttached() && toTest.hasProcesses());
	}

	@Test
	public void testClose() {
		WaitProcess dummy = new WaitProcess(UnsignedInteger.valueOf(9));
		ProcessManager toTest = new ProcessManager();
		toTest.attach(dummy);
		toTest.close();
		assertFalse(dummy.isAttached() || toTest.hasProcesses());
	}
	
	@Test
	public void testDetach()
	{
		WaitProcess dummy = new WaitProcess(UnsignedInteger.valueOf(9));
		ProcessManager toTest = new ProcessManager();
		toTest.attach(dummy);
		toTest.updateProcesses(10);
		toTest.updateProcesses(2);
		assertFalse(dummy.isAttached() || toTest.hasProcesses());
	}

}
