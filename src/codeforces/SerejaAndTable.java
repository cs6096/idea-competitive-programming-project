package codeforces;

import library.io.InputReader;
import library.io.OutputWriter;
import library.util.BitZ;

public class SerejaAndTable {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    int n1 = in.nextInt();
	    int m1 = in.nextInt();
	    int k1 = in.nextInt();
	    int[][] grid = new int[n1][];
	    for (int i = 0; i < n1; i++){
		    grid[i] = in.nextIntArray(m1);
	    }
	    if (n1 < m1){
		    int[][] temp = new int[m1][n1];
		    for (int i =0; i < m1; i++){
			    for (int j = 0; j < n1; j++){
				    temp[i][j] = grid[j][i];
			    }
		    }
		    n1 = temp.length;
		    m1 = temp[0].length;
		    grid = temp;
	    }
	    int best = Integer.MAX_VALUE;
	    if (m1 <= 10){
		    for (int mask = 0; mask < (1 << m1); mask++){

			    int need = 0;
			    for (int[] f: grid){
				    int same = 0;
				    for (int i = 0;i <f.length; i++){
					    if (BitZ.hasBitAt(mask, i) && f[i] != 0){
						    same++;
					    }
					    else if (!BitZ.hasBitAt(mask, i) && f[i] == 0){
						    same++;
					    }
				    }
				    need += Math.min(same, f.length - same);
			    }
//			    DebugZ.print(mask,best, BitZ.binString64(mask));
			    if (need < best) best = need;
		    }
	    }
	    else {
		    for (int[] e: grid){
			    int need = 0;
			    for (int[] f: grid){
				    int same = 0;
				    for (int i = 0 ; i<e.length; i ++){
					    if (e[i] == f[i]){
						    same++;
					    }
				    }
				    need += Math.min(same, e.length - same);
			    }
			    if (need < best) best = need;
		    }
	    }

	    if (best > k1){
		    out.printLine("-1");
	    }
	    else {
		    out.printLine(best);
	    }
    }
}
