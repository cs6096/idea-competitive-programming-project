package topcoder;
import java.util.*;
import java.math.*;
public class KingdomAndTrees {
    public int minLevel(int[] heights) {
	    int low = 0;
	    int high = 1000000000+ 100000;
	    for (;high - low > 1;){
		    int mid = (low + high) >> 1;
		    if (ok(heights, mid)){
			    high = mid;
		    }
		    else {
			    low = mid;
		    }
	    }

        return ok(heights, low) ? low : high;
    }
	public boolean ok(int[] l1, int n){
		int[] l = l1.clone();
		for (int i = 0; i < l.length; i++){
			if (i == 0){
				l[0] = Math.max(1, l1[0] - n);
			}
			else {
				if (l[i] + n <= l[i - 1]){
					return false;
				}
				l[i] = Math.max(l[i - 1] + 1, l1[i] - n);
			}
		}
		return true;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
