package topcoder;
import java.util.*;
import java.math.*;
public class PairGame {
    public int maxSum(int a, int b, int c, int d) {
	    HashSet<Long> s1 = new HashSet();
	    HashSet<Long> s2 = new HashSet();
	    insert(a, b, s1);
	    insert(c, d, s2);
	    long ans = -1;
//	    px(s1);
//	    px(s2);
	    for (long e: s1){
		    if (s2.contains( e )){
			    long high = e >> 30;
			    long low = e & ((1l << 30) - 1l);
			    ans = Math.max( ans , high + low );
		    }
	    }
	    return ans == -1 ? -1 : (int) ans;
    }
	public void insert(int a, int b, HashSet<Long> s){
		int[] l = {a,b};
		for (;;){
			long k = l[1];
			k <<= 30;
			k += (long) l[0];
			s.add( k );
//			px(l);
			if (l[0] == 1 && l[1] == 1 ) break;
			if (l[0] == 0 || l[0] == 0) break;
			if (l[1] > l[0]) l[1] -= l[0];
			else l[0] -= l[1];
//			px(l);
		}

	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
