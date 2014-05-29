package codeforces;

import library.io.InputReader;
import library.io.OutputWriter;
import library.util.DebugZ;

import java.util.*;
import java.math.*;
import java.io.*;

public class PrefixesAndSuffixes {
	public int[] z(char[] l1) {
		int[] fin = new int[l1.length];
		int front = 0;
		for (int i = 0 ; i < l1.length ; i++) {
			for ( ; ; ) {
				if (i + fin[i] >= fin.length) break;
				if (l1[fin[i]] == l1[i + fin[i]]) fin[i]++;
				else break;
			}
			front = Math.max(front, i);
			for ( ; ; ) {
				if (front >= fin.length) break;
				int shift = front - i;
				if (shift > i) break;
				if (shift >= fin[i]) break;
				fin[front] = Math.max(fin[front], Math.min(fin[shift], fin[i] - shift));
				front++;
			}
		}
		return fin;
	}

	public void solve(int testNumber, InputReader in, OutputWriter out) {
		char[] l1 = in.next().toCharArray();
		int[] z = z(l1);
		boolean[] ex = new boolean[l1.length + 1];
		int[] count = new int[l1.length + 1];
//	    DebugZ.print(z);
		for (int i = 0 ; i < l1.length ; i++) {
			if (z[i] + i == l1.length) {
				ex[z[i]] = true;
			}
			count[z[i]]++;
		}
		int[] sum = new int[count.length];
		for (int i = sum.length - 1 ; i >= 0 ; i--) {
			sum[i] += count[i];
			if (i + 1 < sum.length) {
				sum[i] += sum[i + 1];
			}
		}
		int cnt = 0;
		for (boolean e : ex) {
			if (e) {
				cnt++;
			}
		}
		out.printLine(cnt);
		for (int i = 0 ; i < ex.length ; i++) {
			if (ex[i]) {
				out.printLine(i, sum[i]);
			}
		}
	}
}
