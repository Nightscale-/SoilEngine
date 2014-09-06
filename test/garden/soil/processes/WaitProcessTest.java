package garden.soil.processes;

import static org.junit.Assert.*;
import garden.soil.mathphysics.UnsignedInteger;

import org.junit.Test;

public class WaitProcessTest {
	
	@Test
	public void testOnUpdate()
	{
		WaitProcess toTest = new WaitProcess(UnsignedInteger.valueOf(10));
		toTest.onUpdate(5);
		assertFalse(toTest.isDead());
		toTest.onUpdate(5);
		assertTrue(toTest.isDead());
	}

}
