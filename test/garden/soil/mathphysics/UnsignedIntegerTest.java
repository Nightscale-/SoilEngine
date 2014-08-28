package garden.soil.mathphysics;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnsignedIntegerTest {

	@Test
	public void testMaxIntValue()
	{
		UnsignedInteger toTest = new UnsignedInteger(0xffffffffffL);
		assertEquals("Max positive int value expected", 
				0x7fffffff, toTest.intValue());
	}
	
	@Test
	public void testMaxLongValue()
	{
		UnsignedInteger toTest = new UnsignedInteger(0xffffffffffL);
		assertEquals("Max positive long value expected", 
				0xffffffffL, toTest.longValue());
	}
	
	@Test
	public void testAssignPositiveNumber()
	{
		UnsignedInteger toTest = new UnsignedInteger(0);
		toTest.assign(789);
		assertEquals("Error in positive assignment", 
				789, toTest.intValue());
	}
	
	@Test public void testAssignNegativeNumber()
	{
		UnsignedInteger toTest = new UnsignedInteger(0);
		toTest.assign(-1);
		assertEquals("Error assigning negative number", 
				0x7fffffff, toTest.intValue());
	}

	@Test
	public void testAdd() {
		UnsignedInteger lhs = new UnsignedInteger(465);
		UnsignedInteger rhs = new UnsignedInteger(789);
		assertEquals("Error in adding two positive numbers", 
				465 + 789, lhs.add(rhs));
	}
	
	@Test
	public void testAddOverflow()
	{
		UnsignedInteger toTest = new UnsignedInteger(0xffffffff);
		toTest.assign(toTest.add(1));
		assertEquals(0, toTest.longValue());
	}

	@Test
	public void testSubtract() {
		UnsignedInteger rhs = new UnsignedInteger(465);
		UnsignedInteger lhs = new UnsignedInteger(789);
		assertEquals("Error in subtracting two positive numbers", 
				789 - 465, lhs.subtract(rhs));
	}
	
	@Test
	public void testSubtractUnderflow()
	{
		UnsignedInteger lhs = new UnsignedInteger(0);
		assertEquals(0xffffffff, lhs.subtract(1));
	}

	@Test
	public void testMultiply() {
		UnsignedInteger lhs = new UnsignedInteger(465);
		UnsignedInteger rhs = new UnsignedInteger(789);
		assertEquals("Error in multiplying two positive numbers",
				465 * 789, lhs.multiply(rhs));
	}
	
	@Test
	public void testMultiplyOverflow()
	{
		UnsignedInteger lhs = new UnsignedInteger(0xffffffff);
		UnsignedInteger rhs = new UnsignedInteger(2);
		assertEquals(0xfffffffeL, lhs.multiply(rhs));
	}

	@Test
	public void testDivide() {
		UnsignedInteger top = new UnsignedInteger(45*98);
		UnsignedInteger bottom = new UnsignedInteger(45);
		assertEquals(98, top.divide(bottom));
	}
	
	@Test
	public void testDivideBy0()
	{
		UnsignedInteger top = new UnsignedInteger(45*98);
		assertEquals(0, top.divide(0));
	}

	@Test
	public void testModulus() {
		UnsignedInteger top = new UnsignedInteger(10);
		assertEquals(1, top.modulus(3));
	}
	
	@Test
	public void testModulusWith0()
	{
		UnsignedInteger top = new UnsignedInteger(45);
		assertEquals(45, top.modulus(0));
	}

	@Test
	public void testLHSisGreaterThan() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertTrue(toTest.greaterThan(5));
	}
	
	@Test
	public void testLHSisNotGreaterThan()
	{
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertFalse(toTest.greaterThan(500));
		assertFalse(toTest.greaterThan(123));
	}

	@Test
	public void testLHSisGreaterThanOrEqual() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertTrue(toTest.greaterThanOrEqual(2));
		assertTrue(toTest.greaterThanOrEqual(123));
	}
	
	@Test
	public void testLHSisNotGreaterThanOrEqual() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertFalse(toTest.greaterThan(500));
	}

	@Test
	public void testLHSisLessThan() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertTrue(toTest.lessThan(500));
	}
	
	@Test
	public void testLHSisNotLessThan() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertFalse(toTest.lessThan(123));
		assertFalse(toTest.lessThan(0));
	}

	@Test
	public void testLHSisLessThanOrEqual() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertTrue(toTest.lessThanOrEqual(500));
		assertTrue(toTest.lessThanOrEqual(123));
	}
	
	@Test
	public void testLHSisNotLessThanOrEqual() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertFalse(toTest.lessThanOrEqual(3));
	}

	@Test
	public void testLHSdoesEqual() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertTrue(toTest.Equals(123));
	}
	
	@Test
	public void testLHSdoesNotEqual() {
		UnsignedInteger toTest = new UnsignedInteger(123);
		assertFalse(toTest.Equals(-55));
		assertFalse(toTest.Equals(500));
	}

	@Test
	public void testShiftRightWithPositiveNumber() {
		UnsignedInteger toTest = new UnsignedInteger(15);
		assertEquals(3, toTest.shiftRight(2));
	}
	
	@Test
	public void testShiftRightWithNegativeNumber() {
		UnsignedInteger toTest = new UnsignedInteger(15);
		assertEquals(60, toTest.shiftRight(-2));
	}

	@Test
	public void testShiftLeftWithPositiveNumber() {
		UnsignedInteger toTest = new UnsignedInteger(15);
		assertEquals(60, toTest.shiftLeft(2));
	}
	
	@Test
	public void testShiftLeftWithNegativeNumber() {
		UnsignedInteger toTest = new UnsignedInteger(15);
		assertEquals(3, toTest.shiftLeft(-2));
	}

	@Test
	public void testLogicAND() {
		UnsignedInteger toTest = new UnsignedInteger(0xffffffff);
		assertEquals("Logic AND error",
				0xffff, toTest.logicAND(0xffff));
	}

	@Test
	public void testLogicOR() {
		UnsignedInteger toTest = new UnsignedInteger(0x0);
		assertEquals("Logic AND error",
				0xffff, toTest.logicOR(0xffff));
	}

	@Test
	public void testLogicXOR() {
		UnsignedInteger toTest = new UnsignedInteger(0x101);
		assertEquals("Logic AND error",
				0x1010, toTest.logicXOR(0x1111));
	}

	@Test
	public void testToString() {
		UnsignedInteger toTest = new UnsignedInteger(1236);
		assertEquals("toString error", "1236", toTest.toString());
	}
}
