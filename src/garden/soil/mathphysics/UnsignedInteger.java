package garden.soil.mathphysics;

public class UnsignedInteger extends Number{
	
	private static long INT_MASK = 0xffffffff;
	private static final long serialVersionUID = 964396679758572473L;
	private long value;

	public UnsignedInteger(long newValue)
	{
		this.assign(newValue);
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
		value = value & INT_MASK;
	}
	
	public long add(UnsignedInteger v)
	{
		return (value + v.longValue()) % 0xffffffff;
	}
	
	public long subtract(UnsignedInteger v)
	{
		return (value - v.longValue()) & INT_MASK;
	}
	
	public long multiply(UnsignedInteger v)
	{
		return (value * v.longValue()) & INT_MASK;
	}
	
	public long divide(UnsignedInteger v)
	{
		if(v.longValue() != 0)
		{
			return value / v.longValue();
		}
		return -1;
	}
	
	public long modulus(UnsignedInteger v)
	{
		if(v.longValue() != 0)
		{
			return value % v.longValue();
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
	
	public int shiftRight(int n)
	{
		int shift = this.intValue();
		shift = shift >>> n;
		return shift;
	}
	
	public int shiftLeft(int n)
	{
		int shift = this.intValue();
		shift = shift << n;
		return shift;
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
}
