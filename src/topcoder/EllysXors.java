package topcoder;
import java.util.*;
import java.math.*;
public class EllysXors {
    public long getXor(long L, long R) {

	    long[] top = count(R);
	    long[] bot = count(L - 1);
	    long fin = 0;
//	    px(top);
//	    px(bot);
	    for (int i = 0; i < top.length; i++){
		    if (top[i] != bot[i]){
			    fin += 1l << i;
		    }
	    }
	    return fin;
    }
	public long[] count(long a){
		long[] fin = new long[40];
		if (a < 0) return fin;
		for (int i = 0 ; i < fin.length; i++){
			if (i == 0){
				if ((a + 1l) % 4l == 2l || (a + 1l) % 4l == 3l){
					fin[i] = 1l;
				}
			}
			else {
				long k = (a + 1l) / (1l << i);
				long rmd = (a + 1l) % (1l << i) % 2l;
				if (k % 2l != 0) fin[i] = rmd;
			}
		}
		return fin;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
