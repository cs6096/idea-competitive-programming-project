package topcoder;
import java.util.*;
import java.math.*;
public class CandidatesSelection {
	public boolean ok = false;
	public int n = 0;
	public int m = 0;
	public int qq = 0;
    public String possible(String[] score, int[] result) {
	    n = score.length;
	    qq = n * (n - 1) /2;
	    m = score[0].length();
	    ArrayList<int[]> partialOrderList = new ArrayList();
	    {
		    int[] p = new int[qq];
		    int ptr = 0;
		    for (int i = 0; i < n; i++){
			    for (int j = i + 1; j < n; j++){
				    p[ptr] = Integer.signum( - result[i] + result[j] );
				    ptr++;
			    }

		    }
		    partialOrderList.add( p );
	    }
	    char[][] grid = new char[m][n];
	    for (int i = 0 ; i < m; i++){
		    for (int j = 0 ; j < n; j++){
			    grid[i][j] = score[result[j]].charAt( i );
		    }
	    }
	    for (char[] curOrder : grid){
		    int[] p = new int[qq];
		    int ptr = 0;
//		    px(curOrder);
		    for (int i = 0; i < n; i++){
			    for (int j = i + 1; j < n; j++){
				    p[ptr] = Integer.signum( - curOrder[i] + curOrder[j] );
				    ptr++;
			    }

		    }
		    partialOrderList.add( p );
	    }
//	    for (int[] e: partialOrderList){
//		    px(e);
//	    }

	    boolean[] hit = new boolean[qq];
	    boolean[] ex = new boolean[partialOrderList.size()];
	    for (;;){
		    int added = 0;
		    boolean[] next = new boolean[qq];
		    A:
		    for (int i = 0 ; i < partialOrderList.size(); i++){
			    if (ex[i]) continue;
			    int[] cur = partialOrderList.get( i );

			    for (int j = 0; j < qq; j++){
				    if (!hit[j] && cur[j]  < 0){
					    continue A;
				    }
			    }
			    ex[i] = true;
			    added++;
			    for (int j = 0; j < qq; j++){
				    if (cur[j] > 0){
					    next[j] = true;
				    }
			    }
		    }
		    for (int i = 0; i < qq; i++){
			    if (next[i]){
				    hit[i] = true;
			    }
		    }
		    if (added == 0) break;
	    }
//	    px(hit);
	    ok = true;
	    for (boolean e: hit) if (!e) ok = false;

        return ok ? "Possible" : "Impossible";
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
