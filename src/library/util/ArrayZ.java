package library.util;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayZ {
	public static int[] sortUnique(int[] l1) {
		int[] copy = l1.clone();
		Arrays.sort(copy);
		int size = 0;
		for (int i = 0; i < copy.length; i++) {
			if (i == 0 || copy[i] != copy[i - 1]) {
				copy[size++] = copy[i];
			}
		}
		return Arrays.copyOf(copy, size);
	}

	public static long[] sortUnique(long[] l1) {
		long[] copy = l1.clone();
		Arrays.sort(copy);
		int size = 0;
		for (int i = 0; i < copy.length; i++) {
			if (i == 0 || copy[i] != copy[i - 1]) {
				copy[size++] = copy[i];
			}
		}
		return Arrays.copyOf(copy, size);
	}

	public static int[][] sortUniqueCount(int[] l1) {
		int[] copy = l1.clone();
		Arrays.sort(copy);
		int[] count = new int[l1.length];
		int size = 0;
		for (int i = 0; i < copy.length; i++) {
			if (i == 0 || copy[i] != copy[i - 1]) {
				copy[size] = copy[i];
				count[size] = 1;
				size++;
			}
			else {
				count[size - 1]++;
			}
		}
		return new int[][]{Arrays.copyOf(copy, size), Arrays.copyOf(count, size)};
	}

	public static int max(int[] l1) {
		int fin = Integer.MIN_VALUE;
		for (int e : l1)
			if (e > fin) { fin = e; }
		return fin;
	}

	public static long max(long[] l1) {
		long fin = Integer.MIN_VALUE;
		for (long e : l1)
			if (e > fin) { fin = e; }
		return fin;
	}

	public static double max(double[] l1) {
		double fin = l1[0];
		for (double e : l1)
			if (e > fin) { fin = e; }
		return fin;
	}

	public static int min(int[] l1) {
		int fin = Integer.MAX_VALUE;
		for (int e : l1)
			if (e < fin) { fin = e; }
		return fin;
	}

	public static long min(long[] l1) {
		long fin = Integer.MAX_VALUE;
		for (long e : l1)
			if (e < fin) { fin = e; }
		return fin;
	}

	public static double min(double[] l1) {
		double fin = l1[0];
		for (double e : l1)
			if (e < fin) { fin = e; }
		return fin;
	}

	public static int[] prefixSum(int[] l1) {
		int[] fin = new int[l1.length + 1];
		for (int i = 1; i < l1.length + 1; i++) {
			fin[i] += fin[i - 1] + l1[i - 1];
		}
		return fin;
	}

	public static long[] prefixSum(long[] l1) {
		long[] fin = new long[l1.length + 1];
		for (int i = 1; i < l1.length + 1; i++) {
			fin[i] += fin[i - 1] + l1[i - 1];
		}
		return fin;
	}

	public static double[] prefixSum(double[] l1) {
		double[] fin = new double[l1.length + 1];
		for (int i = 1; i < l1.length + 1; i++) {
			fin[i] += fin[i - 1] + l1[i - 1];
		}
		return fin;
	}

	public static int lowerCount(int[] l1, int n1) {
		if (n1 <= l1[0]) { return 0; }
		if (l1[l1.length - 1] < n1) { return l1.length; }
		int low = 0;
		int high = l1.length - 1;
		for (; high - low > 1; ) {
			int mid = (high + low) >> 1;
			if (l1[mid] >= n1) { high = mid; }
			else if (l1[mid] < n1) { low = mid; }
		}
		return low + 1;
	}

	public static int lowerCount(long[] l1, long n1) {
		if (n1 <= l1[0]) { return 0; }
		if (l1[l1.length - 1] < n1) { return l1.length; }
		int low = 0;
		int high = l1.length - 1;
		for (; high - low > 1; ) {
			int mid = (high + low) >> 1;
			if (l1[mid] >= n1) { high = mid; }
			else if (l1[mid] < n1) { low = mid; }
		}
		return low + 1;
	}

	public static int lowerCount(double[] l1, double n1) {
		if (n1 <= l1[0]) { return 0; }
		if (l1[l1.length - 1] < n1) { return l1.length; }
		int low = 0;
		int high = l1.length - 1;
		for (; high - low > 1; ) {
			int mid = (high + low) >> 1;
			if (l1[mid] >= n1) { high = mid; }
			else if (l1[mid] < n1) { low = mid; }
		}
		return low + 1;
	}

	public static int higherCount(int[] l1, int n1) {
		if (n1 >= l1[l1.length - 1]) { return 0; }
		if (l1[0] > n1) { return l1.length; }
		int low = 0;
		int high = l1.length - 1;
		for (; high - low > 1; ) {
			int mid = (high + low) >> 1;
			if (l1[mid] > n1) { high = mid; }
			else if (l1[mid] <= n1) { low = mid; }
		}
		return l1.length - high;
	}

	public static int higherCount(long[] l1, long n1) {
		if (n1 >= l1[l1.length - 1]) { return 0; }
		if (l1[0] > n1) { return l1.length; }
		int low = 0;
		int high = l1.length - 1;
		for (; high - low > 1; ) {
			int mid = (high + low) >> 1;
			if (l1[mid] > n1) { high = mid; }
			else if (l1[mid] <= n1) { low = mid; }
		}
		return l1.length - high;
	}

	public static int higherCount(double[] l1, double n1) {
		if (n1 >= l1[l1.length - 1]) { return 0; }
		if (l1[0] > n1) { return l1.length; }
		int low = 0;
		int high = l1.length - 1;
		for (; high - low > 1; ) {
			int mid = (high + low) >> 1;
			if (l1[mid] > n1) { high = mid; }
			else if (l1[mid] <= n1) { low = mid; }
		}
		return l1.length - high;
	}

	public int equalCount(int[] l1, int n1) {
		return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
	}

	public int equalCount(long[] l1, long n1) {
		return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
	}

	public int equalCount(double[] l1, double n1) {
		return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
	}

	public Integer[] objectOrder(int n1) {
		Integer[] fin = new Integer[n1];
		for (int i = 0; i < n1; i++) {
			fin[i] = i;
		}
		return fin;
	}

	public int[] intOrder(int n1) {
		int[] fin = new int[n1];
		for (int i = 0; i < n1; i++) {
			fin[i] = i;
		}
		return fin;
	}

	private static final int X = 0;
	private static final int Y = 1;
	public static Comparator<int[]> lexicographicalOrderComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			int ptr1 = 0;
			int ptr2 = 0;
			for (; ; ptr1++, ptr2++) {
				if (ptr1 >= o1.length && ptr2 >= o2.length) { break; }
				if (ptr1 >= o1.length) { return -1; }
				if (ptr2 >= o2.length) { return 1; }
				if (o1[ptr1] != o2[ptr2]) { return o1[ptr1] - o2[ptr2]; }
			}
			return 0;
		}
	};
	public static Comparator<int[]> horizontalComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[X] - o2[X];
		}
	};
	public static Comparator<int[]> verticalComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[Y] - o2[Y];
		}
	};
	public static Comparator<int[]> positiveDiagonalComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[X] + o1[Y]) - (o2[X] + o2[Y]);
		}
	};
	public static Comparator<int[]> negativeDiagonalComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return (o1[X] - o1[Y]) - (o2[X] - o2[Y]);
		}
	};
	public static class CustomIntArrayComparator implements Comparator<int[]> {
		public int[] comparingIndex = null;
		public CustomIntArrayComparator(int ... comparingIndex){
			this.comparingIndex = comparingIndex;
		}
		@Override
		public int compare(int[] o1, int[] o2) {
			for (int e: comparingIndex){
				if (e >= o1.length && e >= o2.length) return 0;
				if (e >= o1.length) return -1;
				if (e >= o2.length) return 1;
				if (o1[e] != o2[e]) return o1[e] - o2[e];
			}
			return 0;
		}
	}
	public static Integer[] indexOrder(int n){
		Integer[] a = new Integer[n];
		for (int i = 0 ; i < a.length; i++){
			a[i] = i;
		}
		return a;
	}
	public static void reorder(int[] a, Integer[] permutation){
		int[] fin = new int[a.length];
		for (int i = 0; i < fin.length; i++) fin[i] = a[permutation[i]];
		for (int i = 0; i < fin.length; i++) a[i] = fin[i];
	}
	public static void reorder(long[] a, Integer[] permutation){
		long[] fin = new long[a.length];
		for (int i = 0; i < fin.length; i++) fin[i] = a[permutation[i]];
		for (int i = 0; i < fin.length; i++) a[i] = fin[i];
	}
	public static void reorder(char[] a, Integer[] permutation){
		char[] fin = new char[a.length];
		for (int i = 0; i < fin.length; i++) fin[i] = a[permutation[i]];
		for (int i = 0; i < fin.length; i++) a[i] = fin[i];
	}
	public static void swap(int[] l1, int a, int b){
		int t = l1[a];
		l1[a] = l1[b];
		l1[b] = t;
	}
	public static void swap(long[] l1, int a, int b){
		long t = l1[a];
		l1[a] = l1[b];
		l1[b] = t;
	}
	public static void swap(char[] l1, int a, int b){
		char t = l1[a];
		l1[a] = l1[b];
		l1[b] = t;
	}
	public static void swap(double[] l1, int a, int b){
		double t = l1[a];
		l1[a] = l1[b];
		l1[b] = t;
	}
	public static void reverse(int[] a){
		for (int i = 0 ; i < a.length / 2; i++){
			swap(a, i , a.length - 1 - i);
		}
	}
	public static void reverse(long[] a){
		for (int i = 0 ; i < a.length / 2; i++){
			swap(a, i , a.length - 1 - i);
		}
	}
	public static void reverse(char[] a){
		for (int i = 0 ; i < a.length / 2; i++){
			swap(a, i , a.length - 1 - i);
		}
	}
	public static void reverse(double[] a){
		for (int i = 0 ; i < a.length / 2; i++){
			swap(a, i , a.length - 1 - i);
		}
	}
	public static void reverse(int[] l, int a, int b){
		int n = b - a;
		for (int i = 0 ; i < n / 2; i++){
			swap(l, i + a , n - 1 - i + a);
		}
	}
	public static long sum(int[] a){
		long fin = 0;
		for (int i = 0 ; i < a.length; i++){
			fin += (long)a[i];
		}
		return fin;
	}
	public static long sum(long[] a){
		long fin = 0;
		for (int i = 0 ; i < a.length; i++){
			fin += a[i];
		}
		return fin;
	}
	public static double sum(double[] a){
		double fin = 0;
		for (int i = 0 ; i < a.length; i++){
			fin += a[i];
		}
		return fin;
	}



}