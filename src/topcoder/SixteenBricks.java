package topcoder;
import java.util.*;
import java.math.*;
public class SixteenBricks {
	int n = 0;
	int[] l1= null;
    public int maximumSurface(int[] height) {
	    l1 = height;
	    n = height.length;
	    int total = 16;
	    for (int e: l1) total += e * 4;
	    Arrays.sort(l1);
	    total -= 2 * l1[0] * 4;
	    total -= 2 * l1[1] * 4;
	    total -= 2 * l1[2] * 3;
	    total -= 2 * l1[3] * 3;
	    total -= 2 * l1[4] * 3;
	    total -= 2 * l1[5] * 3;
	    total -= 2 * l1[6] * 2;
	    total -= 2 * l1[7] * 2;

        return total;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
