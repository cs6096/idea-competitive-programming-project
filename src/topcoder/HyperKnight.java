
package topcoder;
import java.util.*;
import java.math.*;
public class HyperKnight {
	public long[] x = {1,1,-1,-1};
	public long[] y = {-1,1,-1,1};
    public long countCells(int a, int b, int numRows, int numColumns, int k) {
	    int s = Math.min(a, b);
	    int l = Math.max(a, b);
	    ArrayList<Integer> h = new ArrayList();
	    ArrayList<Integer> v = new ArrayList();
	    h.add(-1);
	    h.add(s - 1);
	    h.add(l - 1);
	    h.add(numColumns - 1 - l);
	    h.add(numColumns - 1 - s);
	    h.add(numColumns - 1);
	    v.add(-1);
	    v.add(s - 1);
	    v.add(l - 1);
	    v.add(numRows - 1 - l);
	    v.add(numRows - 1 - s);
	    v.add(numRows - 1);
	    Collections.sort(h);
	    Collections.sort(v);
	    long fin = 0;
	    for (int i = 0; i < v.size() - 1; i++){
		    long v1 = v.get(i) + 1;
		    long v2 = v.get(i + 1);
		    for (int j = 0; j < h.size() - 1; j++){
			    long h1 = h.get(j) + 1;
			    long h2 = h.get(j + 1);
			    long amount = (v2 - v1 + 1l) * (h2 - h1 + 1l);
//			    px(v1,v2,h1,h2);
			    int kk = 0;
			    for (int q = 0 ; q < 4; q++){
				    long vv = v1 + x[q] * (long)s;
				    long hh = h1 + y[q] * (long)l;
				    if (vv < numRows && hh < numColumns && vv >= 0 && hh >= 0){
					    kk++;
				    }
			    }
			    for (int q = 0 ; q < 4; q++){
				    long vv = v1 + x[q] * (long)l;
				    long hh = h1 + y[q] * (long)s;
				    if (vv < numRows && hh < numColumns && vv >= 0 && hh >= 0){
					    kk++;
				    }
			    }
			    if (kk == k) fin += amount;
		    }
	    }
//	    px(h);
//	    px(v);

        return fin;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
