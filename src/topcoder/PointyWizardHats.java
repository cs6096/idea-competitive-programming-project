package topcoder;
import java.util.*;
import java.math.*;
public class PointyWizardHats {
    public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius) {
	    ArrayList<Integer>[] al = new ArrayList[topHeight.length];
	    for (int i = 0 ; i < topHeight.length; i++) al[i] = new ArrayList();
	    for (int i = 0 ; i < topHeight.length; i++){
		    for (int j = 0; j < bottomHeight.length; j++){
			    if (topRadius[i] >= bottomRadius[j]) continue;
			    int a = topHeight[i] * bottomRadius[j];
			    int b = topRadius[i] * bottomHeight[j];
			    if (a > b) al[i].add(j);
		    }
	    }
        return maxMatching(al, bottomHeight.length);
    }
	static boolean findPath(List<Integer>[] g, int u1, int[] matching, boolean[] vis) {
		vis[u1] = true;
		for (int v : g[u1]) {
			int u2 = matching[v];
			if (u2 == -1 || !vis[u2] && findPath(g, u2, matching, vis)) {
				matching[v] = u1;
				return true;
			}
		}
		return false;
	}

	public static int maxMatching(List<Integer>[] g, int n2) {
		int n1 = g.length;
		int[] matching = new int[n2];
		Arrays.fill(matching, -1);
		int matches = 0;
		for (int u = 0; u < n1; u++) {
			if (findPath(g, u, matching, new boolean[n1]))
				++matches;
		}
		return matches;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
