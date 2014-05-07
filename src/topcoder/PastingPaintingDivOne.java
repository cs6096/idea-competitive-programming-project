package topcoder;
import library.util.GeneralZ;

import java.util.*;

public class PastingPaintingDivOne {
    public long[] countColors(String[] clipboard, int T) {
	    char[][] grid = GeneralZ.toGrid(clipboard);
	    char[][] cur = GeneralZ.toGrid(clipboard);
	    char[][] last = null;
	    long[] count = new long[3];
	    A:
	    for (int i = 0; i < T; i++){
		    if (i > 0){
			    if (eq(cur, last)){
				    long left = T - i;
				    for (int j = 0; j < cur.length; j++){
					    for (int k =0 ; k < cur[0].length; k++){
						    long add = 1;
						    char qq = cur[j][k];
						    if (j == 0 || k == 0){
							    add = left;
						    }
						    if (qq == 'R'){
							    count[0] += add;
						    }
						    else if (qq == 'G'){
							    count[1] += add;
						    }
						    else if (qq == 'B'){
							    count[2] += add;
						    }
					    }
				    }
				    break A;
			    }
		    }
		    for (char qq: cur[0]){
			    long add = 1;
			    if (qq == 'R'){
				    count[0] += add;
			    }
			    else if (qq == 'G'){
				    count[1] += add;
			    }
			    else if (qq == 'B'){
				    count[2] += add;
			    }
		    }
		    for (int j = 1; j < cur.length; j++){
			    char qq = cur[j][0];
			    long add = 1;
			    if (qq == 'R'){
				    count[0] += add;
			    }
			    else if (qq == 'G'){
				    count[1] += add;
			    }
			    else if (qq == 'B'){
				    count[2] += add;
			    }
		    }
		    if (i == T - 1){
			    for (int j = 0; j < cur.length; j++){
				    for (int k =0 ; k < cur[0].length; k++){
					    long add = 1;
					    char qq = cur[j][k];
					    if (j == 0 || k == 0){
						    add = 0;
					    }
					    if (qq == 'R'){
						    count[0] += add;
					    }
					    else if (qq == 'G'){
						    count[1] += add;
					    }
					    else if (qq == 'B'){
						    count[2] += add;
					    }
				    }
			    }
		    }
		    last = cur;
		    cur = nextGrid(last, grid);
//		    for (char[] e: cur){
//			    DebugZ.print(e);
//		    }
	    }
        return count;
    }
	public static char[][] nextGrid(char[][] old, char[][] pat){
		char[][] fin = new char[old.length][old[0].length];
		for (int i = 0 ; i < old.length; i++){
			for (int j =0; j < old[0].length; j++){
				if (i >= old.length - 1 || j >= old[0].length - 1){
					fin[i][j] = pat[i][j];
				}
				else {
					if (pat[i][j] != '.'){
						fin[i][j] = pat[i][j];
					}
					else {
						fin[i][j] = old[i + 1][j + 1];
					}
				}
			}
		}
		return fin;
	}
	public boolean eq(char[][] a, char[][] b){
		for (int i = 0;  i < a.length; i++){
			if (!Arrays.equals(a[i], b[i])) return false;
		}
		return true;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
