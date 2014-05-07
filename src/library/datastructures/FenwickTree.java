package library.datastructures;
import java.util.*;
public class FenwickTree {
	long[] valueList;
	public FenwickTree (int n){
		valueList = new long[n + 1];
	}
	/*
	 * Add "n1" to the index "idx".
	 */
	public void add(int idx, long n1){
		for (int i = idx + 1; i < valueList.length; i += i & -i){
			valueList[i] += n1;
		}
	}
	public long prefixSum(int t){
		return prefixSum(0, t);
	}
	/*
	 * Sum of first t index minus prefixSum of first s index.
	 */
	public long prefixSum(int s, int t){
		if (s > 0) return prefixSum(0, t)- prefixSum(0, s);
		long res = 0;
		for (int i = t; i > 0; i -= i & -i){
			res += valueList[i];
		}
		return res;
	}
	@Override
	public String toString(){
		List<Long> fin = new ArrayList();
		for (int i =0; i < valueList.length-1; i++){
			fin.add(prefixSum(0, i + 1)- prefixSum(0, i));
		}
		return fin.toString();
	}
	public String sumString(){
		List<Long> fin = new ArrayList();
		for (int i =0; i < valueList.length-1; i++){
			fin.add(prefixSum(0, i + 1));
		}
		return fin.toString();
	}
}
