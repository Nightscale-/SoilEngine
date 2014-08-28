package garden.soil.mathphysics;

public class UnsignedInteger extends Number{
	
	private static final long INT_MASK = 0xffffffffL;
	private static final long serialVersionUID = 964396679758572473L;
	private static final long MOD_MASK = 0x100000000L;
	private long value;

	public UnsignedInteger(long newValue)
	{
		assign(newValue);
	}
	
	public static UnsignedInteger valueOf(long newValue)
	{
		return new UnsignedInteger(newValue);
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
		value = v & INT_MASK;
	}
	
	public void assign(UnsignedInteger v)
	{
		value = v.longValue() & INT_MASK;
	}
	
	public long add(UnsignedInteger v)
	{
		return (value + v.longValue()) % MOD_MASK;
	}
	
	public long add(long v)
	{
		return this.add(UnsignedInteger.valueOf(v));
	}
	
	public long subtract(UnsignedInteger v)
	{
		return (value - v.longValue()) % MOD_MASK;
	}
	
	public long subtract(long v)
	{
		return subtract(UnsignedInteger.valueOf(v));
	}
	
	public long multiply(UnsignedInteger v)
	{
		return (value * v.longValue()) % MOD_MASK;
	}
	
	public long multiply(long v)
	{
		return multiply(UnsignedInteger.valueOf(v));
	}
	
	public long divide(UnsignedInteger v)
	{
		if(v.longValue() != 0)
		{
			return value / v.longValue();
		}
		return 0;
	}
	
	public long divide(long v)
	{
		return divide(UnsignedInteger.valueOf(v));
	}
	
	public long modulus(UnsignedInteger v)
	{
		if(v.longValue() != 0)
		{
			return value % v.longValue();
		}
		return value;
	}
	
	public long modulus(long v)
	{
		return modulus(UnsignedInteger.valueOf(v));
	}
	
	public boolean greaterThan(UnsignedInteger rhs)
	{
		if(value > rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean greaterThan(long rhs)
	{
		return greaterThan(UnsignedInteger.valueOf(rhs));
	}
	
	public boolean greaterThanOrEqual(UnsignedInteger rhs)
	{
		if(value >= rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean greaterThanOrEqual(long rhs)
	{
		return greaterThanOrEqual(UnsignedInteger.valueOf(rhs));
	}
	
	public boolean lessThan(UnsignedInteger rhs)
	{
		if(value < rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean lessThan(long rhs)
	{
		return lessThan(UnsignedInteger.valueOf(rhs));
	}
	
	public boolean lessThanOrEqual(UnsignedInteger rhs)
	{
		if(value <= rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean lessThanOrEqual(long rhs)
	{
		return lessThanOrEqual(UnsignedInteger.valueOf(rhs));
	}
	
	public boolean Equals(UnsignedInteger rhs)
	{
		if(value == rhs.longValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean Equals(long rhs)
	{
		return Equals(UnsignedInteger.valueOf(rhs));
	}
	
	public int shiftRight(int n)
	{
		if(n < 0)
		{
			return shiftLeft(n * -1);
		}
		return (int) (value >>> n);
	}
	
	public int shiftLeft(int n)
	{
		if(n < 0)
		{
			return shiftRight(n * -1);
		}
		return (int) (value << n);
	}
	
	public int logicAND(int mask)
	{
		return (int) (value & mask);
	}
	
	public int logicOR(int mask)
	{
		return (int) (value | mask);
	}
	
	public int logicXOR(int mask)
	{
		return (int) (value ^ mask);
	}
	
	@Override
	public String toString()
	{
		return "" + value;
	}
}
