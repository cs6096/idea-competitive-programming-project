package topcoder;
import java.util.*;
import java.math.*;
public class PatrolRoute {
	public long MOD = (long)1e9 + 7l;
    public int countRoutes(int X, int Y, int minT, int maxT) {
	    long[] xc = new long[X * 2 + 5];
	    for (int i = 0 ; i < X; i++){
		    for (int j = i + 2; j < X; j++){
			    int diff = j - i;
			    int len = diff * 2;
			    long count = diff - 1;
			    xc[len] += count;
			    xc[len] %= MOD;
		    }
	    }
	    long[] yc = new long[Y * 2 + 5];
	    for (int i = 0; i < Y; i++){
		    for (int j = i + 2; j < Y; j++){
			    int diff = j - i;
			    int len = diff * 2;
			    long count = diff - 1;
			    yc[len] += count;
			    yc[len] %= MOD;
		    }
	    }
	    long fin = 0;
	    for (int i = 4; i < xc.length; i += 2){
		    for (int j = 4; j < yc.length; j += 2){
			    int len = i + j;
			    if (len < minT) continue;
			    if (len > maxT) break;
			    long count = xc[i] * yc[j];
			    count %= MOD;

			    fin += xc[i] * yc[j];
			    fin %= MOD;
		    }
	    }
	    fin *= 6l;
	    fin %= MOD;


	    return (int) fin;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
