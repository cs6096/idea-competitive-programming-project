package topcoder;

import java.util.*;

public class MayTheBestPetWin {
	public int n1 = 0;
	public ArrayList<int[]> pairList = new ArrayList<int[]>();
	int MAX_VAL = 10000 * 50 + 100;
	public int total = 0;

	public int calc(int[] A, int[] B) {
		n1 = A.length;
		for (int e : A) total += e;
		for (int e : B) total += e;
		boolean[] dp1 = new boolean[MAX_VAL];
		boolean[] dp2 = new boolean[MAX_VAL];
		dp1[0] = true;
		for (int i = 0; i < n1; i++) {
			int cur = A[i] + B[i];
			for (int j = 0; j < dp1.length; j++) {
				if (dp1[j]) {
					if (j + cur < MAX_VAL) {
						dp2[j + cur] = true;
					}
				}

			}
			for (int j = 0; j < dp1.length; j++) {
				if (dp2[j]) {
					dp1[j] = true;
					dp2[j] = false;
				}
			}
		}
		int totalA = 0;
		for (int e : A) totalA += e;
		int totalB = 0;
		for (int e : B) totalB += e;
		int fin = Integer.MAX_VALUE;
		for (int i = 0; i < MAX_VAL; i++) {
			if (dp1[i]) {
				int k1 = -totalA + i;
				int k2 = totalB - i;
				fin = Math.min(fin, Math.max(k1, k2));
			}
		}

		return fin;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
