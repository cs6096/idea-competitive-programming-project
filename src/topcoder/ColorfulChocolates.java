package topcoder;
import java.util.*;
import java.math.*;
public class ColorfulChocolates {
    public int maximumSpread(String chocolates, int maxSwaps) {
	    int ans = 0;
	    char[] l1 = chocolates.toCharArray();
	    ArrayList<Integer> g = new ArrayList<Integer>();
	    for (int ww = 'A'; ww <= 'Z'; ww++){
 		    g.clear();
		    for (int i = 0 ;  i< l1.length; i++){
			    if (l1[i] == ww){
				    g.add(i);
			    }
		    }
//		    px(g);
		    for (int s = 1; s <= g.size(); s++){
			    for (int k = 0; k < g.size() - s + 1; k++){
				    for (int i = 0 ; i < l1.length - s + 1; i++){
					    int cost = 0;
					    for (int j = 0 ; j < s; j++){
						    cost += Math.abs(g.get(k + j) - (i + j));
					    }
					    if (cost <= maxSwaps) ans = Math.max(ans, s);
				    }
			    }
		    }
	    }
        return ans;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}

