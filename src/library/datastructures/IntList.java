package library.datastructures;

import library.util.ShuffleZ;

import java.util.Arrays;
import java.util.Iterator;

public class IntList implements Iterable<Integer> {
	public static IntList empty(int n1) {
		IntList fin = new IntList(n1);
		fin.size = n1;
		return fin;
	}

	public static IntList wrap(int ... l1) {
		IntList fin = new IntList();
		fin.cont = l1;
		fin.size = l1.length;
		return fin;
	}

	public int[] cont = null;
	public int size = 0;

	public IntList(int initialCapacity) {
		this.cont = new int[initialCapacity];
	}

	public IntList() {
		this(5);
	}

	public void add(int e) {
		if (size == cont.length) {
			cont = Arrays.copyOf(cont, ((cont.length << 1) - (cont.length >> 1) ) + 1);
		}
		cont[size++] = e;
	}

	public int get(int id) {
		if (id >= 0) return cont[id];
		else return cont[size + id];
	}

	public void inc(int id, int v1) {
		if (id >= 0) cont[id] += v1;
		else cont[size + id] += v1;
	}

	public void set(int id, int v1) {
		if (id >= 0) cont[id] = v1;
		else cont[size + id] = v1;
	}

	public int last() {
		return cont[size - 1];
	}

	public int pop() {
		size--;
		return cont[size];
	}

	public void pop(int n1) {
		size -= n1;
		if (size < 0) size = 0;
	}

	public void sort() {
		ShuffleZ.ints(cont, 0, size);
		Arrays.sort(cont, 0, size);
	}

	public int binarySearch(int v1) {
		return Arrays.binarySearch(cont, 0, size, v1);
	}

	public int smallerNo(int n1) {
		if (cont[0] >= n1) return 0;
		if (cont[size - 1] < n1) return size;
		int low = 0;
		int high = size - 1;
		for (; high - low > 1;) {
			int mid = (high + low) >> 1;
			if (cont[mid] >= n1) high = mid;
			else if (cont[mid] < n1) low = mid;
		}
		return low + 1;
	}

	public int greaterNo(int n1) {
		if (cont[size - 1] <= n1) return 0;
		if (cont[0] > n1) return size;
		int low = 0;
		int high = size - 1;
		for (; high - low > 1;) {
			int mid = (high + low) >> 1;
			if (cont[mid] > n1) high = mid;
			else if (cont[mid] <= n1) low = mid;
		}
		return size - high;
	}

	public int equalNo(int n1) {
		return size - smallerNo(n1) - greaterNo(n1);
	}

	public int[] toPrimitiveArray() {
		return Arrays.copyOf(cont, size);
	}

	public void reverse() {
		for (int i = 0; i < size / 2; i++) {
			int temp = cont[i];
			cont[i] = cont[size - 1 - i];
			cont[size - 1 - i] = temp;
		}
	}

	public void sortDescend(){
		this.sort();
		this.reverse();
	}

	public long sum(){
		long fin = 0;
		for (int i = 0 ; i < size; i++) fin += (long)cont[i];
		return fin;
	}

	@Override
	public String toString() {
		StringBuilder fin = new StringBuilder();
		fin.append('{');
		for (int i = 0; i < size; i++) {
			if (i != 0) fin.append(", ");
			fin.append(cont[i]);
		}
		fin.append('}');
		return fin.toString();
	}
	
	public String toSpacedString(){
		StringBuilder fin = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i != 0) fin.append(' ');
			fin.append(cont[i]);
		}
		return fin.toString();
	}

	public int contains(int n1) {
		for (int i = 0; i < size; i++) {
			if (cont[i] == n1) { return i; }
		}
		return -1;
	}

	public int size() {
		return size;
	}
	
	public int max (){
		int fin = Integer.MIN_VALUE;
		for (int e: cont) if (e > fin) fin = e;
		return fin;
	}
	public int min (){
		int fin = Integer.MAX_VALUE;
		for (int e: cont) if (e < fin) fin = e;
		return fin;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new It();
	}

	public class It implements Iterator<Integer> {
		private int ptr = 0;

		@Override
		public boolean hasNext() {
			if (ptr < size) return true;
			return false;
		}

		@Override
		public Integer next() {
			return cont[ptr++];
		}

		@Override
		public void remove() {

		}
	}
}