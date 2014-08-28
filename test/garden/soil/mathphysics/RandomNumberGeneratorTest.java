package garden.soil.mathphysics;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomNumberGeneratorTest {

	private static final int TEST_COUNT = 10000;
	
	@Test
	public void testRandomReproducesNumWithSameSeed() {
		RandomNumberGenerator toTest = new RandomNumberGenerator();
		RandomNumberGenerator toConfirm = new RandomNumberGenerator();
		boolean correct = true;
		UnsignedInteger num = UnsignedInteger.valueOf(789);
		
		toTest.SetRandomSeed(num);
		toConfirm.SetRandomSeed(num);
		for(int count = 0; count < TEST_COUNT; count++)
		{
			if(toTest.Random(num).longValue() != toConfirm.Random(num).longValue())
			{
				correct = false;
			}
		}
		assertTrue(correct);
	}
	
	@Test
	public void testRandomGeneratesDifferentNumsWithDiffSeeds()
	{
		RandomNumberGenerator toTest = new RandomNumberGenerator();
		RandomNumberGenerator toConfirm = new RandomNumberGenerator();
		boolean correct = false;
		UnsignedInteger num = UnsignedInteger.valueOf(789);
		
		toTest.SetRandomSeed(num);
		toConfirm.SetRandomSeed(UnsignedInteger.valueOf(456));
		for(int count = 0; count < TEST_COUNT; count++)
		{
			if(toTest.Random(num).longValue() != toConfirm.Random(num).longValue())
			{
				correct = true;
			}
		}
		assertTrue(correct);
	}

	@Test
	public void testRandomFloatDoesNotExcede1() {
		RandomNumberGenerator toTest = new RandomNumberGenerator();
		boolean correct = true;
		UnsignedInteger num = UnsignedInteger.valueOf(789);
		
		toTest.SetRandomSeed(num);
		for(int count = 0; count < TEST_COUNT; count++)
		{
			if(toTest.Random() > 1.0f)
			{
				correct = false;
			}
		}
		assertTrue(correct);
	}

	@Test
	public void testGetAndSetRandomSeed() {
		RandomNumberGenerator toTest = new RandomNumberGenerator();
		toTest.SetRandomSeed(UnsignedInteger.valueOf(456));
		assertEquals(456L, toTest.getRandomSeed().longValue());
	}

	@Test
	public void testRandomize() {
		RandomNumberGenerator toTest = new RandomNumberGenerator();
		toTest.Randomize();
		assertTrue(toTest.getRandomSeed().longValue() > 0L);
	}

}
