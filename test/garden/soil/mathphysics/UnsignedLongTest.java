package garden.soil.mathphysics;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnsignedLongTest {

	@Test
	public void testMaxIntValue()
	{
		UnsignedLong toTest = new UnsignedLong(0xffffffffffL);
		assertEquals("Max positive int value expected", 
				0x7fffffff, toTest.intValue());
	}

	@Test
	public void testMaxLongValue() {
		UnsignedLong toTest = new UnsignedLong(0xffffffffffffffffL);
		assertEquals("Max positive long value expected", 
				0x7fffffffffffffffL, toTest.longValue());
	}
	
	@Test
	public void testAssignPositiveNumber()
	{
		UnsignedLong toTest = new UnsignedLong(0);
		toTest.assign(789);
		assertEquals("Error in positive assignment", 789, toTest.longValue());
	}
	
	@Test public void testAssignNegativeNumber()
	{
		UnsignedLong toTest = new UnsignedLong(0);
		toTest.assign(-1);
		assertEquals("Error assigning negative number", 
				0x7fffffffffffffffL, toTest.longValue());
	}

	@Test
	public void testAdd() {
		UnsignedLong lhs = new UnsignedLong(465);
		UnsignedLong rhs = new UnsignedLong(789);
		assertEquals("Error in adding two positive numbers", 
				465 + 789, lhs.add(rhs));
	}
	
	@Test
	public void testAddOverflow()
	{
		UnsignedLong toTest = new UnsignedLong(0x7fffffffffffffffL);
		toTest.assign(toTest.add(1));
		assertEquals(0, toTest.longValue());
	}

	@Test
	public void testSubtract() {
		UnsignedLong rhs = new UnsignedLong(465);
		UnsignedLong lhs = new UnsignedLong(789);
		assertEquals("Error in subtracting two positive numbers", 
				789 - 465, lhs.subtract(rhs));
	}
	
	@Test
	public void testSubtractUnderflow()
	{
		UnsignedLong lhs = new UnsignedLong(0);
		assertEquals(0x7fffffffffffffffL, lhs.subtract(1));
	}

	@Test
	public void testMultiply() {
		UnsignedLong lhs = new UnsignedLong(465);
		UnsignedLong rhs = new UnsignedLong(789);
		assertEquals("Error in multiplying two positive numbers",
				465 * 789, lhs.multiply(rhs));
	}
	
	@Test
	public void testMultiplyOverflow()
	{
		UnsignedLong lhs = new UnsignedLong(0x7fffffffffffffffL);
		UnsignedLong rhs = new UnsignedLong(2);
		assertEquals(0x7ffffffffffffffeL, lhs.multiply(rhs));
	}

	@Test
	public void testDivide() {
		UnsignedLong top = new UnsignedLong(45*98);
		UnsignedLong bottom = new UnsignedLong(45);
		assertEquals(98, top.divide(bottom));
	}
	
	@Test
	public void testDivideBy0()
	{
		UnsignedLong top = new UnsignedLong(45*98);
		assertEquals(0, top.divide(0));
	}

	@Test
	public void testModulus() {
		UnsignedLong top = new UnsignedLong(10);
		assertEquals(1, top.modulus(3));
	}
	
	@Test
	public void testModulusWith0()
	{
		UnsignedLong top = new UnsignedLong(45);
		assertEquals(45, top.modulus(0));
	}

	@Test
	public void testLHSisGreaterThan() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertTrue(toTest.greaterThan(5));
	}
	
	@Test
	public void testLHSisNotGreaterThan()
	{
		UnsignedLong toTest = new UnsignedLong(123);
		assertFalse(toTest.greaterThan(500));
		assertFalse(toTest.greaterThan(123));
	}

	@Test
	public void testLHSisGreaterThanOrEqual() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertTrue(toTest.greaterThanOrEqual(2));
		assertTrue(toTest.greaterThanOrEqual(123));
	}
	
	@Test
	public void testLHSisNotGreaterThanOrEqual() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertFalse(toTest.greaterThan(500));
	}

	@Test
	public void testLHSisLessThan() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertTrue(toTest.lessThan(500));
	}
	
	@Test
	public void testLHSisNotLessThan() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertFalse(toTest.lessThan(123));
		assertFalse(toTest.lessThan(0));
	}

	@Test
	public void testLHSisLessThanOrEqual() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertTrue(toTest.lessThanOrEqual(500));
		assertTrue(toTest.lessThanOrEqual(123));
	}
	
	@Test
	public void testLHSisNotLessThanOrEqual() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertFalse(toTest.lessThanOrEqual(3));
	}

	@Test
	public void testLHSdoesEqual() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertTrue(toTest.Equals(123));
	}
	
	@Test
	public void testLHSdoesNotEqual() {
		UnsignedLong toTest = new UnsignedLong(123);
		assertFalse(toTest.Equals(-55));
		assertFalse(toTest.Equals(500));
	}

	@Test
	public void testShiftRightWithPositiveNumber() {
		UnsignedLong toTest = new UnsignedLong(15);
		assertEquals(3, toTest.shiftRight(2));
	}
	
	@Test
	public void testShiftRightWithNegativeNumber() {
		UnsignedLong toTest = new UnsignedLong(15);
		assertEquals(60, toTest.shiftRight(-2));
	}

	@Test
	public void testShiftLeftWithPositiveNumber() {
		UnsignedLong toTest = new UnsignedLong(15);
		assertEquals(60, toTest.shiftLeft(2));
	}
	
	@Test
	public void testShiftLeftWithNegativeNumber() {
		UnsignedLong toTest = new UnsignedLong(15);
		assertEquals(3, toTest.shiftLeft(-2));
	}

	@Test
	public void testLogicAND() {
		UnsignedLong toTest = new UnsignedLong(0xffffffff);
		assertEquals("Logic AND error",
				0xffff, toTest.logicAND(0xffff));
	}

	@Test
	public void testLogicOR() {
		UnsignedLong toTest = new UnsignedLong(0x0);
		assertEquals("Logic AND error",
				0xffff, toTest.logicOR(0xffff));
	}

	@Test
	public void testLogicXOR() {
		UnsignedLong toTest = new UnsignedLong(0x101);
		assertEquals("Logic AND error",
				0x1010, toTest.logicXOR(0x1111));
	}

	@Test
	public void testToString() {
		UnsignedLong toTest = new UnsignedLong(123456);
		assertEquals("toString error", "123456", toTest.toString());
	}
}