package topcoder;

import java.util.*;
import java.math.*;

public class FoxAndMountainEasy {
	public String possible(int n, int h0, int hn, String history) {
		char[] l1 = history.toCharArray();
		int[] val = new int[l1.length + 1];
		int min1 = 0;
		for (int i = 0; i < l1.length; i++) {
			val[i + 1] = val[i] + (l1[i] == 'U' ? 1 : -1);
			min1 = Math.min(min1, val[i + 1]);
		}
		for (int i = 0; i < val.length; i++) {
			val[i] = val[i] - min1;
		}
		px(val);
		int needChange = hn - h0;
		int haveChange = n - history.length() + val[val.length - 1] - val[0];
		if ((needChange + haveChange) % 2 != 0) { return "NO"; }

		for (int i = 0; i < n; i++) {
			if (i + history.length() > n) { break; }
			boolean frontOdd = (i + h0) % 2 != 0;
			int minAllowedStart = 0;
			if (frontOdd) { minAllowedStart++; }
			if (h0 - i >= 0) { minAllowedStart = h0 - i; }
			int minSegStart = val[0];
			if ((minSegStart + h0 + i) % 2 != 0) {
				minSegStart++;
			}
			if (minSegStart > i + h0) {
				continue;
			}
			int minStart = Math.max(minAllowedStart, minSegStart);
			int maxStart = i + h0;
			int minEnd = val[val.length - 1] - val[0] + minStart;
			int maxEnd = val[val.length - 1] - val[0] + maxStart;

			int rest = n - i - history.length();
			if ((maxEnd + rest + hn) % 2 != 0) continue;
			int maxHit = maxEnd + rest;
			int minHit = minEnd - rest;
			if (maxHit >= hn && hn >= minHit) {
				return "YES";
			}

		}
		return "NO";
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
