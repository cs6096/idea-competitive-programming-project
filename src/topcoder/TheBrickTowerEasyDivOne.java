package topcoder;
import java.util.*;
import java.math.*;
public class TheBrickTowerEasyDivOne {
    public int find(int redCount, int redHeight, int blueCount, int blueHeight) {
	    int fin = 0;
	    fin += Math.min(redCount, blueCount);
	    int k = 0;
	    k = Math.min(redCount, blueCount + 1);
	    int f = Math.min(blueCount, redCount + 1);
	    if (redHeight == blueHeight){
		    fin += Math.max(k,f);
	    }
	    else {
		    fin += k;
		    fin += f;
	    }

        return fin;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
