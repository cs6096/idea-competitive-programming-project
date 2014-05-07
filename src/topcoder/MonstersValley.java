package topcoder;
import java.util.*;
import java.math.*;
public class MonstersValley {
    public int minimumPrice(long[] dread, int[] price) {
	    int n1 = dread.length;
	    int qq = n1 * 2 + 10;
	    long[] dp1 = new long[qq];
	    long[] dp2 = new long[qq];
	    Arrays.fill(dp1, -1);
	    dp1[0] = 0;
	    for (int i = 0; i < n1; i++){
		    dp2 = new long[qq];
		    Arrays.fill(dp2, -1);

		    for (int j = 0; j < dp1.length; j++){
			    if (dp1[j] < 0) continue;
			    if (dp1[j] >= dread[i]){
				    dp2[j] = Math.max(dp2[j], dp1[j]);
			    }
			    dp2[j + price[i]] = Math.max(dp2[j + price[i]], dp1[j] + dread[i]);
		    }

		    dp1 = dp2;
	    }
	    for (int i = 0 ; i < dp1.length; i++){
		    if (dp1[i] >= 0) return i;
	    }
        return 0;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
