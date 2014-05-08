package topcoder;
import java.util.*;
import java.math.*;
public class ImportantSequence {
    public int getCount(int[] l1, String operators) {
	    int n1 = l1.length;
	    boolean[] positive = new boolean[n1 + 1];
	    positive[0] = true;
	    long[] surplus = new long[n1 + 1];
	    for (int i = 0; i < n1; i++) {
		    if (operators.charAt(i) == '+'){
			    positive[i + 1] = !positive[i];
			    surplus[i + 1] = (long)l1[i] - surplus[i];
		    }
		    else {
			    positive[i + 1] = positive[i];
			    surplus[i + 1] = surplus[i] - (long)l1[i];
		    }
	    }
	    long min = Long.MIN_VALUE;
	    long max = Long.MAX_VALUE;
	    for (int i = 0 ; i < positive.length; i++){
		    if (positive[i]){
			    min = Math.max(min, - surplus[i] + 1l);
		    }
		    else {
			    max = Math.min(max, surplus[i] - 1l);
			    if (surplus[i] - 1l <= 0){
				    return 0;
			    }
		    }
	    }
	    if (max == Long.MAX_VALUE) return -1;
	    if (max < min) return 0;
	    return Math.max(0, (int)(max - min + 1l) );
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
