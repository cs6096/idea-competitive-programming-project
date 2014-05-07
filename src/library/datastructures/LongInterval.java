package library.datastructures;

class LongInterval {
	long[] sum = null;
	LongInterval (int[] original){
		sum = new long[original.length+1];
		long cur = 0;
		for (int i = 1; i <= original.length ; i++){
			cur += (long)original[i-1];
			sum[i] = cur;
		}
	}
	long get(int n1){
		return sum[n1];
	}
	long range(int left, int right){
		return get(right) - get(left);
	}
}
