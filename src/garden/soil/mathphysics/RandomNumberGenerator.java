package garden.soil.mathphysics;

public class RandomNumberGenerator {
	
	private static final int CMATH_N = 624;
	private static final int CMATH_M = 397;
	private static final long CMATH_UPPER_MASK = 0x80000000;
	private static final int CMATH_LOWER_MASK = 0x7fffffff;
	private static final long CMATH_MATRIX_A = 0x9908b0df;
	private static final long CMATH_TEMPERING_MASK_B = 0x9d2c5680;
	private static final long CMATH_TEMPERING_MASK_C = 0xefc60000;
	
	private UnsignedInteger rSeed;
	private UnsignedLong[] mt;
	private int mti;
	
	
	public RandomNumberGenerator()
	{
		rSeed = new UnsignedInteger(1);
		mt = new UnsignedLong[CMATH_N];
		mti = CMATH_N+1;
	}
	
	public UnsignedInteger Random(UnsignedInteger n)
	{	
		UnsignedInteger toReturn = new UnsignedInteger(0);
		if(n.intValue() <= 0)
		{
			return toReturn;
		}
		
		UnsignedLong y = new UnsignedLong(0);
		UnsignedLong[] mag01 = {new UnsignedLong(0x0), new UnsignedLong(CMATH_MATRIX_A)};//TODO: want static?
		UnsignedLong temp1 = new UnsignedLong(0);
		UnsignedLong temp2 = new UnsignedLong(0);
		
		if(mti >= CMATH_N)
		{
			int kk;
			
			if(mti == CMATH_N + 1)
			{
				this.SetRandomSeed(UnsignedInteger.valueOf(4357));//TODO: why this?
			}
			for(kk=0; kk< CMATH_N - CMATH_M; kk++)
			{
				temp1.assign(mt[kk].logicAND(CMATH_UPPER_MASK));
				temp2.assign(mt[kk+1].logicAND(CMATH_LOWER_MASK));
				y.assign(temp1.logicOR(temp2.longValue()));
				
				temp1.assign(mt[kk + CMATH_M].longValue());
				y.assign(y.shiftRight(1));
				temp2.assign(mag01[(int) y.logicAND(0x1)].longValue());
				temp1.assign(temp1.logicXOR(y.longValue()));
				mt[kk].assign(temp1.logicXOR(temp2.longValue()));
			}
			for (;kk<CMATH_N-1;kk++) {
				
				temp1.assign(mt[kk].logicAND(CMATH_UPPER_MASK));
				temp2.assign(mt[kk+1].logicAND(CMATH_LOWER_MASK));
				y.assign(temp1.logicOR(temp2.longValue()));
				
				temp1.assign(mt[kk + CMATH_M - CMATH_N].longValue());
				y.assign(y.shiftRight(1));
				temp2.assign(mag01[(int) y.logicAND(0x1)].longValue());
				temp1.assign(temp1.logicXOR(y.longValue()));
				mt[kk].assign(temp1.logicXOR(temp2.longValue()));
	        }
			
			temp1.assign(mt[CMATH_N - 1].logicAND(CMATH_UPPER_MASK));
			temp2.assign(mt[0].logicAND(CMATH_LOWER_MASK));
			y.assign(temp1.logicOR(temp2.longValue()));
			
			temp1.assign(mt[CMATH_M - 1].longValue());
			y.assign(y.shiftRight(1));
			temp2.assign(mag01[(int) y.logicAND(0x1)].longValue());
			temp1.assign(temp1.logicXOR(y.longValue()));
			mt[CMATH_N - 1].assign(temp1.logicXOR(temp2.longValue()));
			
	        mti = 0;
		}
		
		y.assign(mt[mti].longValue());
		mti++;
		y.assign(y.logicXOR(y.shiftRight(11)));// y = y ^ (y >> 11)
		y.assign(y.logicXOR(y.shiftLeft(7) & CMATH_TEMPERING_MASK_B));// y = y ^ ((y << 7) & mask B)
		y.assign(y.logicXOR(y.shiftLeft(15) & CMATH_TEMPERING_MASK_C));
		y.assign(y.logicXOR(y.shiftRight(18)));// y = y ^ (y >> 18)
	    
		toReturn.assign(y.longValue() % n.intValue());
	    return toReturn;
	}
	
	public float Random()
	{
		int r = Random(new UnsignedInteger(0xffffffff)).intValue();
		float divisor = (float)0xffffffff;
		return (r / divisor) + 0.5f;
	}
	
	public void SetRandomSeed(UnsignedInteger n)
	{
		/* setting initial seeds to mt[N] using         */
		/* the generator Line 25 of Table 1 in          */
		/* [KNUTH 1981, The Art of Computer Programming */
		/*    Vol. 2 (2nd Ed.), pp102]                  */
		mt[0].assign(n.longValue());
		for (mti=1; mti<CMATH_N; mti++)
			mt[mti].assign((69069 * mt[mti-1].longValue()) & 0xffffffff);

		rSeed.assign(n.longValue());
	}
	
	public UnsignedInteger getRandomSeed()
	{
		return rSeed;
	}
	
	public void Randomize()
	{
		SetRandomSeed(UnsignedInteger.valueOf(System.currentTimeMillis()));
	}
}
