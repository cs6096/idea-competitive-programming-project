package library.util;
import java.util.HashMap;

import library.datastructures.IntList;

public class NumberTheoryZ {

	public static IntList sieve(int n1) {
		IntList fin = new IntList();
		boolean[] l1 = new boolean[n1 + 1];
		int last = 0;
		for (int m = 2; m * m <= n1; m++) {
			if (!l1[m]) {
				fin.add(m);
				for (int k = m * m; k <= n1; k += m)
					l1[k] = true;
			}
			last = m;
		}
		for (int m = last + 1; m <= n1; m++) {
			if (!l1[m])
				fin.add(m);
		}
		return fin;
	}
	

	public static IntList factor(int n1) {
		IntList l1 = new IntList();
		for (int i = 1; i * i <= n1; i++) {
			if (n1 % i == 0) {
				l1.add(i);
				if (i != n1 / i)
					l1.add(n1 / i);
			}
		}
		return l1;
	}

	public static long gcd(long n1, long n2) {
		return n2 == 0 ? n1 : gcd(n2, n1 % n2);
	}

	public static long modInverse(long n1, long mod){
		long top = mod;
		long bot = n1;
		
		long bot1 = 0;
		long bot2 = 1;

		for (;;){
			if (bot == 1) break;
			long times = top / bot;
			long rmd = top % bot;
			long bot3 = bot1 - times * bot2;
			bot1 = bot2;
			bot2 = bot3;
			top = bot;
			bot = rmd;
		}

		return ModZ.mod(bot2, mod);
	}

	public static int[] xgcd(int a, int b) {
		if (b == 0)
			return new int[] { 1, 0, a };
		int[] last = xgcd(b, a % b);
		int temp = last[0];
		last[0] = last[1];
		last[1] = temp;
		last[1] -= last[0] * (a / b);
		return last;
	}

	public static int chineseRemainder(int[] a, int[] m, int n) {
		int M = 1;
		for (int i = 0; i < n; ++i)
			M *= m[i];
		int ret = 0;
		for (int i = 0; i < n; ++i) {
			int tm = M / m[i];
			int[] l1 = xgcd(tm, m[i]);
			ret = (ret + tm * l1[0] * a[i]) % M;
		}
		return (ret + M) % M;
	}

	public static long lcm(long a, long b){
		return a * b / gcd(a,b);
	}

	public static int phi(int n1) {
		int fin = n1;
		for (int i = 2; i * i <= n1; i++) {
			if (n1 % i == 0) {
				while (n1 % i == 0)
					n1 /= i;
				fin -= fin / i;
			}
		}
		if (n1 > 1)
			fin -= fin / n1;
		return fin;
	}

	static int[] allPhi(int n1) {
		int[] fin = new int[n1 + 1];
		for (int i = 1; i <= n1; i++)
			fin[i] = i;
		for (int i = 2; i <= n1; i += 2)
			fin[i] >>= 1;
		for (int i = 3; i <= n1; i += 2) {
			if (fin[i] == i) {
				for (int j = i; j <= n1; j += i) {
					fin[j] = fin[j] / i * (i - 1);
				}
			}
		}
		return fin;
	}

	public static long discLog(long base, long right, long mod) {
		long gcd = NumberTheoryZ.gcd(base, mod);
		if (right % gcd != 0)
			return -1;
		HashMap<Long, Long> m1 = new HashMap();
		long k1 = 0;
		for (long i = 0, ptr = 1 % mod; i * i <= mod;) {
			long val = ptr * right % mod;
			m1.put(val, i);
			ptr = ptr * base % mod;
			i++;
			k1 = i;
		}
		long pow = ModZ.pow(base, k1, mod);
		for (long i = k1, ptr = pow; i <= mod; i += k1) {
			if (m1.containsKey(ptr)) {
				return i - m1.get(ptr);
			}
			ptr = ptr * pow % mod;
		}
		return -1;
	}

	public static boolean millerRabinX(long x1, long n1) {
		long y = n1 - 1l;
		while (!((y & 1) == 1))
			y >>= 1;
		x1 = ModZ.pow(x1, y, n1);
		while (y < n1 - 1l && x1 != 1 && x1 != n1 - 1l) {
			x1 = (x1 * x1) % n1;
			y <<= 1;
		}
		return x1 == n1 - 1l || (y & 1l) == 1l;
	}

	public static boolean millerRabin(long n1) {
		if (n1 == 2 || n1 == 7 || n1 == 61)
			return true;
		if (n1 == 1 || (n1 & 1l) == 0)
			return false;
		if (!millerRabinX(2, n1))
			return false;
		if (!millerRabinX(7, n1))
			return false;
		if (!millerRabinX(61, n1))
			return false;
		return true;
	}
}