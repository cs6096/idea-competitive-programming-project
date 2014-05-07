package library.util;
public class ModZ {
		public static long mod(long n1, long mod) {
			long fin = n1 % mod;
			if (fin < 0) fin += mod;
			return fin;
		}

		public static long add(long n1, long n2, long mod) {
			long k1 = (n1 + n2) % mod;
			if (k1 < 0) k1 += mod;
			return k1;
		}

		public static long subtract(long n1, long n2, long mod) {
			long k1 = (n1 - n2) % mod;
			if (k1 < 0) k1 += mod;
			return k1;
		}

		public static long times(long n1, long n2, long mod) {
			long k1 = (n1 * n2) % mod;
			if (k1 < 0) k1 += mod;
			return k1;
		}

		public static long divides(long divided, long dividing, long mod) {
			return (times(divided, moduloInverse(mod, dividing), mod)) % mod;
		}

		public static long moduloInverse(long n1, long mod){
			long top = mod;
			long bot = n1;

			long top1 = 1;
			long bot1 = 0;

			long top2 = 0;
			long bot2 = 1;

			for (;;){
				if (bot == 1) break;
				long times = top / bot;
				long rmd = top % bot;
				long top3 = top1 - times * top2;
				long bot3 = bot1 - times * bot2;

				top1 = top2;
				bot1 = bot2;

				top2 = top3;
				bot2 = bot3;

				top = bot;
				bot = rmd;

			}

			return mod(bot2, mod);
		}

		public static long pow(long base, long pow, long mod) {
			if (pow == 0)
				return 1l % mod;
			else if (pow == 1)
				return times(1l, base, mod);
			else if ((pow & 1) == 0) {
				long half = pow(base, pow >> 1, mod);
				return times(half, half, mod);
			}
			else {
				long half = pow(base, pow >> 1, mod);
				return times(half, times(half, base, mod), mod);
			}
		}
	}