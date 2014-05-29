package topcoder;
import library.util.NumberTheoryZ;

import java.util.*;
import java.math.*;
public class FoxAndGCDLCM {
    public long get(long G, long L) {
	    if (L % G != 0) return -1;
	    long a = L / G;
	    long ans = Long.MAX_VALUE;
	    for (long i = 1; i * i <= a; i++){
		    if (a % i == 0){
			    long k = a / i;
			    if (NumberTheoryZ.gcd(i ,k) == 1l) ans = Math.min(ans, i + k);
		    }
	    }
        return ans * G;
    }

	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
