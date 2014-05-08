package topcoder;
import java.util.*;
import java.math.*;
public class Pillars {
    public double getExpectedLength(int w, int x, int y) {
	    if (x > y){
		    int t = x;
		    x = y;
		    y = t;
	    }
	    double[] l1 = new double[y + 1];
	    for (int i = 0; i < l1.length; i++){
		    double a = 1. * w * w;
		    double b = 1. * i * i;
//		    px(a + b);
		    l1[i] = Math.sqrt(a + b);
	    }
//	    px(l1);
	    for (int i = 1; i < l1.length; i++){
		    l1[i] += l1[i - 1];
	    }
//	    px(l1);
//	    px(w, x, y);
	    double fin = 0;
	    for (int i = 1; i <= x; i++){
		    int a = y - i;
		    int b = i - 1;
		    double v = l1[a] + l1[b] - l1[0];
		    fin += v;
//		    px(i,a,b,v);
	    }
	    fin /= 1. * x * y;
//	    fin = 0;
//	    for (int i = 1; i <= x; i++){
//		    for (int j = 1; j<= y; j++){
//
//			    double a = w * w;
//			    double b = i - j;
//			    b = b * b;
//			    fin += 1. /(x * y) * Math.sqrt(a + b);
//			    px(i, j, 1. /(x * y) * Math.sqrt(a + b));
//		    }
//	    }
        return fin;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
