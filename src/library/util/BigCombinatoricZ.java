package library.util;
import java.math.BigInteger;

class BigCombinatoricZ {
		public static BigInteger bi(long n1) {
			return BigInteger.valueOf(n1);
		}

		public static BigInteger factorial(long n1, long k1) {
			BigInteger fin = bi(1);
			BigInteger mult = bi(n1);
			for (int i = 0; i < k1; i++) {
				fin = fin.multiply(mult);
				mult = mult.subtract(bi(1));
			}
			return fin;
		}
		
		public static BigInteger factorial(long n1) {
			return factorial(n1, n1);
		}

		public static BigInteger choose(long n1, long k1) {
			return factorial(n1, k1).divide(factorial(k1));
		}
		
		public static BigInteger chooseRep(long n1, long k1){
			return choose(k1 + n1 -  1, n1 - 1);
		}
		public static BigInteger[][] pascal(int depth){
			BigInteger[][] fin = new BigInteger[depth+1][];
			fin[0] = new BigInteger[]{BigInteger.ONE};
			for (int i = 1 ; i <= depth; i++){
				BigInteger[] temp = new BigInteger[i+1];
				temp[0] = BigInteger.ONE;
				temp[temp.length-1] = BigInteger.ONE;
				for (int j = 1;j<i; j++){
					temp[j] = fin[i-1][j].add(fin[i-1][j-1]);
				}
				fin[i] = temp;
			}
			return fin;
		}
	}