package garden.soil.mathphysics;

import java.math.BigInteger;

public class UnsignedLong extends Number {

	/**
	 * Sorry, Will only handle up to max positive long value in java.
	 */
	private static final long serialVersionUID = -5973770936950536914L;
	private static long LONG_MASK = 0x7fffffffffffffffL;
	private long value;

	public UnsignedLong(long newValue)
	{
		value = newValue;
	}
	
	public static UnsignedLong valueOf(long newValue)
	{
		return new UnsignedLong(newValue);
	}
	
	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public int intValue() {
		return (int) (value & 0x7fffffff);
	}

	@Override
	public long longValue() {
		return value;
	}
	
	public void assign(long v)
	{
		value = v & LONG_MASK;
	}
	
	public long add(UnsignedLong v)
	{
		BigInteger left = BigInteger.valueOf(value);
		left.add(BigInteger.valueOf(v.longValue()));
		left.mod(BigInteger.valueOf(0x7fffffffffffffffL));
		return left.longValue();
	}
	
	public long subtract(UnsignedLong v)
	{
		return value - v.longValue();
	}
	
	public long multiple(UnsignedLong v)
	{
		return value * v.longValue();
	}
	
	public long divide(UnsignedLong v)
	{
		if(v.longValue() != 0)
		{
			BigInteger left = BigInteger.valueOf(value);
			left = left.divide(BigInteger.valueOf(v.longValue()));
			return left.longValue();
		}
		return -1;
	}
	
	public long modulus(UnsignedLong v)
	{
		if(v.longValue() != 0)
		{
			BigInteger left = BigInteger.valueOf(value);
			left = left.mod(BigInteger.valueOf(v.longValue()));
			return left.longValue();
		}
		return -1;
	}
	
	public boolean greaterThan(UnsignedInteger rhs)
	{
		if(value > rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean greaterThanOrEqual(UnsignedInteger rhs)
	{
		if(value >= rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean lessThan(UnsignedInteger rhs)
	{
		if(value < rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean lessThanOrEqual(UnsignedInteger rhs)
	{
		if(value <= rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean Equals(UnsignedInteger rhs)
	{
		if(value == rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public long shiftRight(int n)
	{
		return value >>> n;
	}
	
	public long shiftLeft(int n)
	{
		return value << n;
	}
	
	public long logicAND(long mask)
	{
		return value & mask;
	}
	
	public long logicOR(long mask)
	{
		return value | mask;
	}
	
	public long logicXOR(long mask)
	{
		return value ^ mask;
	}
}