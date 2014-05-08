package topcoder;
import java.util.*;
import java.math.*;
public class KleofasTail {
    public long countGoodSequences(long K, long A, long B) {
	    if (K == 0) return B - A + 1l;
	    BigInteger k = bi(K);
	    BigInteger a = bi(A);
	    BigInteger b = bi(B);
	    long fin = 0;
	    for (int i = 0;  i <= 70; i++){
		    BigInteger extra = bi(1).shiftLeft(i).subtract(bi(1));
		    BigInteger bot = k.shiftLeft(i);
		    BigInteger top = bot.add(extra);
		    BigInteger small = a.compareTo(bot) > 0 ? a : bot;
		    BigInteger large = b.compareTo(top) < 0 ? b : top;

		    if (small.compareTo(large) <= 0){
			    fin += large.subtract(small).longValue() + 1l;
		    }
//		    px(i, bot, top, small, large, fin);
	    }
	    if (K % 2l == 0){
//		    px("HIT");
		    k = k.add(bi(1));
		    for (int i = 0;  i <= 70; i++){
			    BigInteger extra = bi(1).shiftLeft(i).subtract(bi(1));
			    BigInteger bot = k.shiftLeft(i);
			    BigInteger top = bot.add(extra);
			    BigInteger small = a.compareTo(bot) > 0 ? a : bot;
			    BigInteger large = b.compareTo(top) < 0 ? b : top;

			    if (small.compareTo(large) <= 0){
				    fin += large.subtract(small).longValue() + 1l;
			    }
//			    px(i, bot, top, small, large, fin);
		    }
	    }

        return fin;
    }
	public static BigInteger bi(long n1){
		return BigInteger.valueOf(n1);
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
