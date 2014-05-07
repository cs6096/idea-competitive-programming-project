package library.datastructures;

class IntInterval {
	int[] sum = null;
	IntInterval (int[] original){
		sum = new int[original.length+1];
		int cur = 0;
		for (int i = 1; i <= original.length ; i++){
			cur += original[i-1];
			sum[i] = cur;
		}
	}
	int get(int n1){
		return sum[n1];
	}
	int range(int left, int right){
		return get(right) - get(left);
	}
}
