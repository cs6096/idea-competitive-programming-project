package gcj._2014_1B;

import library.io.InputReader;
import library.io.OutputWriter;
import library.util.DebugZ;
import library.util.GeneralZ;

import java.util.*;
import java.math.*;
import java.io.*;
public class TaskA {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int n = in.nextInt();
		char[][] a = new char[n][];
		for (int i = 0 ; i < n; i++){
			a[i] = in.next().toCharArray();
		}
		boolean ok = true;
		char[] canon = null;
		for (int i = 0 ; i < a.length; i++){
			GeneralZ.px(unique(a[i]));
			if (canon == null) canon = unique(a[i]);
			else {
				char[] cand = unique(a[i]);

				if (!Arrays.equals(cand, canon)){
					ok = false;
				}
			}
		}
		int min = 0;
		if (ok){
			int[][] q=  new int[n][];
			for (int i = 0 ; i < n; i++){
				q[i] = count(a[i]);
			}
			for (int i = 0 ; i < canon.length; i++){
				int best = Integer.MAX_VALUE;
				for (int j = 0 ; j <= 100; j++){
					int cur = 0;
					for (int k = 0 ; k < n; k++){
						cur += Math.abs(q[k][i] - j);
					}
					if (cur < best) best = cur;
				}
				min += best;
			}
		}

		out.print("Case #" + testNumber + ": ");
		if (!ok){
			out.printLine("Fegla Won");
		}
		else {
			out.printLine(min);
		}
	}
	public char[] unique(char[] l1){
		char[] fin = new char[l1.length];
		int size = 0;

		for (int i = 0 ; i <l1.length; i++){
			if(i == 0 || l1[i] != l1[i - 1]){
				fin[size++] = l1[i];
			}
		}
		return Arrays.copyOf(fin, size);
	}
	public int[] count(char[] l1){
		int[] fin = new int[l1.length];
		int size = 0;
		int cnt = 0;
		for (int i = 0 ; i < l1.length; i++){
			cnt++;
			if (i == fin.length - 1 || l1[i] != l1[i + 1]){
				fin[size++]  = cnt;
				cnt = 0;
			}
		}
		return fin;
	}
}
