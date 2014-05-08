package topcoder;

import library.util.DebugZ;

import java.util.*;
import java.math.*;

public class Over9000Rocks {
	public int countPossibilities(int[] lowerBound, int[] upperBound) {
		int n1 = lowerBound.length;
		ArrayList<int[]> l1 = new ArrayList();
		for (int i = 0; i < (1 << n1); i++) {
			int low = 0;
			int high = 0;
			for (int j = 0; j < n1; j++) {
				if (haveBit(i, j)) {
					low += lowerBound[j];
					high += upperBound[j];
				}

			}
			l1.add(new int[]{low, high});
		}
		Collections.sort(l1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) { return o1[0] - o2[0]; }
				return o1[1] - o2[1];
			}
		});
//		DebugZ.print(l1);
		ArrayList<int[]> l2 = new ArrayList<int[]>();
		for (int[] e : l1) {
			if (l2.size() <= 0) {
				l2.add(e);
			}
			else {
				int[] last = l2.get(l2.size() - 1);
				if (e[0] >= last[0] && e[0] <= last[1]) {
					last[1] = Math.max(e[1], last[1]);
				}
				else { l2.add(e); }
			}
		}
//		DebugZ.print(l2);
		int fin = 0;
		for (int[] e : l2) {
			if (e[0] >= 9001) {
				fin += e[1] - e[0] + 1;
			}
			else if (e[1] >= 9001) {
				fin += e[1] - 9001 + 1;
			}
		}
		return fin;
	}

	public static boolean haveBit(int mask, int idx) {
		return (mask & (1 << idx)) != 0;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
