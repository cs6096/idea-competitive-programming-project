package topcoder;
import java.util.*;
import java.math.*;
public class ColorfulWolves {
	char[][] al = null;
	boolean ex = false;
	public int n = 0;
    public int getmin(String[] colormap) {
	    n = colormap.length;
	    al = new char[colormap.length][];
	    for (int i = 0 ; i < colormap.length; i++) al[i] = colormap[i].toCharArray();
	    int[] dist = new int[n];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[0] = 0;
	    HashSet<Integer> q = new HashSet();
	    q.add(0);
	    for (;;){
		    if (q.size() == 0) break;
		    int at = -1;
		    for (int e: q){
			    if (at == -1 || dist[e] < dist[at]) at = e;
		    }
		    q.remove(at);
		    int cost = 0;
		    for (int i = 0 ; i < n; i++){
			    if (al[at][i] == 'Y'){
				    int newDist = dist[at] + cost;
				    if (newDist < dist[i]){
					    dist[i] = newDist;
					    q.add(i);
				    }
				    cost++;
			    }
		    }
	    }
	    if (dist[n - 1] == Integer.MAX_VALUE) return -1;
        return dist[n - 1];
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
