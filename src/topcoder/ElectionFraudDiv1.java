package topcoder;

import java.util.*;
import java.math.*;

public class ElectionFraudDiv1 {
	public int MinimumVoters(int[] percentages) {
		Arrays.sort(percentages);
//		px(percentages);

		int best = Integer.MAX_VALUE;
		A:
		for (int total = 1; total <= 20000; total++) {
			int low = 0;
			int high = 0;
			for (int e : percentages) {
				int q = (int)(1. * e * total / 100);
//				px(total,e,q);
				int curLow = -1;
				int curHigh = -1;
				for (int j = q - 100; j <= q + 100; j++) {
					if (good(j, total, e)) {
						if (curLow == -1) {
							curLow = j;
						}
						else { curLow = Math.min(curLow, j); }
						if (curHigh == -1) {
							curHigh = j;
						}
						else { curHigh = Math.max(j, curHigh); }
					}
				}
//				px("low high", curLow, curHigh);
				if (curLow == -1){
					continue A;
				}
				low += curLow;
				high += curHigh;
			}

			if (low <= total && high >= total){
				best = total;
				break;
			}
		}

		return best == Integer.MAX_VALUE ? -1 : best;
	}

	public static boolean good(int k, int total, int e) {
		if (k < 0) { return false; }
		if (k > total) { return false; }
		if (total * (2 * e - 1) > k * 200) { return false; }
		if (200 * k >= (2 * e + 1) * total) { return false; }
		return true;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
