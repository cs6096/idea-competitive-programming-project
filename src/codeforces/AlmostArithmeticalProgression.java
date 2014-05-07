package codeforces;


import library.io.InputReader;
import library.io.OutputWriter;
import library.util.ArrayZ;

import java.util.Arrays;

public class AlmostArithmeticalProgression {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int n1 = in.nextInt();
		int[] l1 = new int[n1];
		for (int i = 0; i < n1; i++) {
			l1[i] = in.nextInt();
		}
		int[] vals = ArrayZ.sortUnique(l1);
		for (int i = 0; i < l1.length; i++) {
			l1[i] = Arrays.binarySearch(vals, l1[i]);
		}

		int[][] dp = new int[vals.length][vals.length];
		for (int i = 0; i < n1; i++) {
			int cur = l1[i];
			for (int from = 0; from < vals.length; from++) {
				int temp = dp[cur][from] + 1;
				dp[from][cur] = temp;
			}
		}
		int ans = 1;
		for (int[] e : dp) for (int f : e) if (f > ans) { ans = f; }
		out.printLine(ans);
	}
}
