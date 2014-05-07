package library.algorithm;

		import library.util.ModZ;

		import java.math.*;




public class PolynomialHash {
	public static long[] backupBases = {277, 281, 4721, 283,3413, 293, 307,2879,3533,1229};
	public long usingBase = 269;
	public long[] hashes;
	public long mod = 1000000007l;
	public long inverse = -1;
	public PolynomialHash (String s1, long customBase){
		usingBase = customBase;
		this.initialize(s1);
	}
	public PolynomialHash (String s1, int off){
		int idx = (int)(Math.random() * backupBases.length);
		if (off == 1) idx %= backupBases.length / 2;
		else {
			idx %= (backupBases.length - backupBases.length / 2);
			idx += backupBases.length / 2;
		}
		usingBase = backupBases[idx];
		this.initialize(s1);
	}
	public void initialize(String s1){
		hashes = new long[s1.length() + 1];
		long cur = 0;
		long pow = 1;
		for (int i =0; i < s1.length(); i++){
			pow *= usingBase;
			pow %= mod;
			cur += (long)s1.charAt(i) * pow;
			cur %= mod;
			hashes[i + 1] = cur;
		}
		inverse = BigInteger.valueOf(usingBase)
				          .modInverse(BigInteger.valueOf(mod)).longValue();
	}

	public long hashForPrefix(int n1){
		return hashes[n1];
	}

	public long hashForSubString(int inclusiveStart, int exclusiveEnd){
		long temp = ModZ.subtract(hashes[exclusiveEnd], hashes[inclusiveStart], mod);
		long pow = ModZ.pow(inverse, inclusiveStart, mod);
		return ModZ.times(temp, pow, mod);
	}
}

