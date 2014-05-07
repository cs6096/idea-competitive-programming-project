package topcoder;
import java.util.*;
import java.math.*;
public class KnightCircuit2 {
    public int maxSize(int w, int h) {
	    if (w == 3 && h == 3){
		    return 8;
	    }
	    if (w >= 3 && h >= 3){
		    return w * h;
	    }
	    if (w > h){
		    int temp = w;
		    w =h;
		    h= temp;
	    }
	    if (w == 1){
		    return 1;
	    }
        return 1 + (h - 1) / 2;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
