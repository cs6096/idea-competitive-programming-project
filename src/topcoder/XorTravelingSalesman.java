package topcoder;
import java.util.*;
import java.math.*;
public class XorTravelingSalesman {
    public int maxProfit(int[] cityValues, String[] roads) {

	    int n1 = cityValues.length;
	    boolean[][] al = new boolean[n1][n1];
	    for (int i = 0 ; i < roads.length; i++){
		    for (int j = 0 ; j < roads[i].length(); j++){
			    if (roads[i].charAt(j) == 'Y'){
				    al[i][j] = true;
				    al[j][i] = true;
			    }
		    }
	    }
	    int nodeNo = n1 * 1100;
	    boolean[] ex = new boolean[nodeNo];
	    ex[cityValues[0]] = true;
	    ArrayDeque<Integer> q = new ArrayDeque<Integer>();
	    q.add(cityValues[0]);
	    for (;q.size() > 0;){
		    int cur = q.poll();
		    int at = cur / 1100;
		    int val = cur % 1100;
		    for (int i = 0 ; i < al.length; i++){
			    if (al[at][i]){
				    int nval = val ^ cityValues[i];
				    int id = i * 1100 + nval;
				    if (!ex[id]){
					    ex[id] = true;
					    q.add(id);
				    }
			    }
		    }
	    }
//	    canWin(id(0,cityValues[0]), ex, al, cityValues);
	    int max = cityValues[0];
	    for (int i = 0 ; i < ex.length; i++){
		    if (ex[i]){
			    max = Math.max(max, i % 1100);
		    }
	    }
        return max;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
