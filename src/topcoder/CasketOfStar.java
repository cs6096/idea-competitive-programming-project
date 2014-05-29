package topcoder;
import java.util.*;
import java.math.*;
public class CasketOfStar {
	int[] l1 = null;
	int n = 0;
    public int maxEnergy(int[] weight) {

	    l1 = weight;
	    n = weight.length;

	    return find(1, n - 2);
    }
	public int[][] store = new int[55][55];
	public int find(int left, int right){
		if (store[left][right] != 0) return store[left][right];
		if (left == right) return l1[left - 1] * l1[right + 1];
		int best = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++){
			int cur = l1[left - 1] * l1[right + 1];
			if (i != left){
				cur += find(left, i - 1);
			}
			if (i != right) cur += find(i + 1, right);
			best = Math.max(best, cur);
		}
		store[left][right] = best;
		return best;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
