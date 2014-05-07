package topcoder;

import java.util.*;
import java.math.*;

public class FoxPaintingBalls {
	public long theMax(long R, long G, long B, int N) {
		if (N == 1){
			return R + G + B;
		}
		long n = N;
		long t = n * (n + 1l) / 2l;
		long r = t / 3l;
		if (t % 3l == 0){

			return Math.min(R /r, Math.min(G / r, B / r));
		}

		long[] w = {R,G,B};
		Arrays.sort(w);
		long low = 0;
		long high = (R + G + B) / r + 10l;
		for (;high - low > 1;){
			long mid = (low + high ) >> 1;
			if (ok(w,mid,r)){
				low = mid;
			}
			else {high = mid;}
		}

		return low;
	}
	public static boolean ok(long[] w, long mid, long r){
		long qq = r * mid;
		if (w[0] < qq || w[1] < qq || w[2] < qq) return false;
		long rest = w[0] + w[1] + w[2] - 3 * qq;
		return rest >= mid;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}


