package topcoder;

import java.util.*;
import java.math.*;

public class AntsMeet {
	public int countAnts(int[] x, int[] y, String direction) {
		for (int i = 0; i < x.length; i++){
			x[i] = x[i] * 2;
		}
		for (int i = 0; i < y.length; i++){
			y[i] = y[i] * 2;
		}
		char[] dl = direction.toCharArray();
		int n = x.length;
		boolean[] gone = new boolean[x.length];
		for (int qq = 0; qq < 100000; qq++) {

			boolean[] del = new boolean[n];
			for (int i = 0; i < n; i++){
				if (gone[i]) { continue; }
				for (int j = i + 1; j < n; j++){
					if (gone[j]) { continue; }
					if (x[i] == x[j] && y[i] == y[j]){
						del[i] = true;
						del[j] = true;
					}
				}
			}

			for (int i = 0; i < n; i++){
				if (del[i]) gone[i] = true;
			}

			for (int i = 0; i < n; i++) {
				if (gone[i]) { continue; }
				if (dl[i] == 'E') { x[i]++; }
				if (dl[i] == 'W') { x[i]--; }
				if (dl[i] == 'N') { y[i]++; }
				if (dl[i] == 'S') { y[i]--; }
			}

//			px(x);
//			px(y);
//			px(gone);
		}

		int count = 0;
		for (boolean e: gone) if (!e) count++;
		return count;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
