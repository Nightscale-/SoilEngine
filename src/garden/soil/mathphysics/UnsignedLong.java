package garden.soil.mathphysics;

import java.math.BigInteger;

public class UnsignedLong extends Number {

	/**
	 * Sorry, Will only handle up to max positive long value in java.
	 */
	private static final long serialVersionUID = -5973770936950536914L;
	private static final long LONG_MASK = 0x7fffffffffffffffL;
	private static final int INT_MASK = 0x7fffffff;
	private long value;

	public UnsignedLong(long newValue)
	{
		assign(newValue);
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
		return (int) (value & INT_MASK);
	}

	@Override
	public long longValue() {
		return value;
	}
	
	public void assign(long v)
	{
		value = v & LONG_MASK;
	}
	
	public void assign(UnsignedLong v)
	{
		value = v.longValue();
	}
	
	public long add(UnsignedLong v)
	{
		BigInteger left = BigInteger.valueOf(value);
		left = left.add(BigInteger.valueOf(v.longValue()));
		left = left.mod(BigInteger.valueOf(0x7fffffffffffffffL)
				.add(BigInteger.valueOf(1)));
		return left.longValue();
	}
	
	public long add(long v)
	{
		return this.add(UnsignedLong.valueOf(v));
	}
	
	public long subtract(UnsignedLong v)
	{
		BigInteger left = BigInteger.valueOf(value);
		left = left.subtract(BigInteger.valueOf(v.longValue()));
		left = left.mod(BigInteger.valueOf(0x7fffffffffffffffL)
				.add(BigInteger.valueOf(1)));
		return left.longValue();
	}
	
	public long subtract(long v)
	{
		return subtract(UnsignedLong.valueOf(v));
	}
	
	public long multiply(UnsignedLong v)
	{
		BigInteger left = BigInteger.valueOf(value);
		left = left.multiply(BigInteger.valueOf(v.longValue()));
		left = left.mod(BigInteger.valueOf(0x7fffffffffffffffL)
				.add(BigInteger.valueOf(1)));
		return left.longValue();
	}
	
	public long multiply(long v)
	{
		return multiply(UnsignedLong.valueOf(v));
	}
	
	public long divide(UnsignedLong v)
	{
		if(v.longValue() != 0)
		{
			BigInteger left = BigInteger.valueOf(value);
			left = left.divide(BigInteger.valueOf(v.longValue()));
			return left.longValue();
		}
		return 0;
	}
	
	public long divide(long v)
	{
		return divide(UnsignedLong.valueOf(v));
	}
	
	public long modulus(UnsignedLong v)
	{
		if(v.longValue() != 0)
		{
			BigInteger left = BigInteger.valueOf(value);
			left = left.mod(BigInteger.valueOf(v.longValue()));
			return left.longValue();
		}
		return value;
	}
	
	public long modulus(long v)
	{
		return modulus(UnsignedLong.valueOf(v));
	}
	
	public boolean greaterThan(UnsignedLong rhs)
	{
		if(value > rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean greaterThan(long rhs)
	{
		return greaterThan(UnsignedLong.valueOf(rhs));
	}
	
	public boolean greaterThanOrEqual(UnsignedLong rhs)
	{
		if(value >= rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean greaterThanOrEqual(long rhs)
	{
		return greaterThanOrEqual(UnsignedLong.valueOf(rhs));
	}
	
	public boolean lessThan(UnsignedLong rhs)
	{
		if(value < rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean lessThan(long rhs)
	{
		return lessThan(UnsignedLong.valueOf(rhs));
	}
	
	public boolean lessThanOrEqual(UnsignedLong rhs)
	{
		if(value <= rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean lessThanOrEqual(long rhs)
	{
		return lessThanOrEqual(UnsignedLong.valueOf(rhs));
	}
	
	public boolean Equals(UnsignedLong rhs)
	{
		if(value == rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean Equals(long rhs)
	{
		return Equals(UnsignedLong.valueOf(rhs));
	}
	
	public long shiftRight(int n)
	{
		if(n < 0)
		{
			return shiftLeft(n * -1);
		}
		return value >>> n;
	}
	
	public long shiftLeft(int n)
	{
		if(n < 0)
		{
			return shiftRight(n * -1);
		}
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
	
	@Override
	public String toString()
	{
		return "" + value;
	}
}