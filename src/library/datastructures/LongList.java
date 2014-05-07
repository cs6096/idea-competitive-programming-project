package library.datastructures;
import library.util.ShuffleZ;

import java.util.Arrays;
import java.util.Iterator;


public class LongList implements Iterable<Long> {
		public long[] cont = null;
		public int size = 0;

		public LongList(int initialCapacity) {
			this.cont = new long[initialCapacity];
		}

		public static LongList empty(int n1) {
			LongList fin = new LongList(n1);
			fin.size = n1;
			return fin;
		}
		
		public static LongList wrap(long[] l1){
			LongList fin = new LongList();
			fin.cont = l1;
			fin.size = l1.length;
			return fin;
		}

		public LongList() {
			this(5);
		}

		public void add(long e) {
			if (size == cont.length) {
				cont = Arrays.copyOf(cont, ((cont.length * 3) >> 1) + 1);
			}
			cont[size++] = e;
		}

		public long get(int id) {
			if (id >= 0)
				return cont[id];
			else
				return cont[size + id];
		}

		public void inc(int id, long v1) {
			if (id >= 0)
				cont[id] += v1;
			else
				cont[size + id] += v1;
		}

		public void set(int id, long v1) {
			if (id >= 0)
				cont[id] = v1;
			else
				cont[size + id] = v1;
		}

		public long last() {
			return cont[size - 1];
		}

		public long pop() {
			size--;
			return cont[size];
		}

		public void pop(int n1) {
			size -= n1;
			if (size < 0) size = 0;
		}
		
		public void sort(){
			ShuffleZ.longs(cont, 0, size);
			Arrays.sort(cont, 0, size);
		}
		public int binarySearch(long v1){
			return Arrays.binarySearch(cont, 0, size, v1);
		}
		
		public int smallerNo(long n1){
			if (cont[0] >= n1) return 0;
			if (cont[size - 1] < n1) return size;
			int low = 0;
			int high = size - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (cont[mid] >= n1) high = mid;
				else if (cont[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public int greaterNo(long n1){
			if (cont[size - 1] <= n1){
				return 0;
			}
			int low = 0;
			int high = size - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (cont[mid] > n1) high = mid;
				else if (cont[mid] <= n1) low = mid;
			}
			return size - high;
		}
		

		public long[] arrayForm() {
			return Arrays.copyOf(cont, size);
		}
		
		public void reverse(){
			for (int i =0; i < size/2; i++){
				long temp = cont[i];
				cont[i] = cont[size - 1 -i];
				cont[size - 1 -i] = temp;
			}
		}
		public String toSpacedString(){
			StringBuilder fin = new StringBuilder();
			for (int i = 0; i < size; i++) {
				if (i != 0) fin.append(' ');
				fin.append(cont[i]);
			}
			return fin.toString();
		}

		@Override
		public String toString() {
			StringBuilder fin = new StringBuilder();
			fin.append('{');
			for (int i = 0; i < size; i++) {
				if (i != 0) fin.append(", ");
				fin.append(cont[i]+"l");
			}
			fin.append('}');
			return fin.toString();
		}
		
		public int contains(int n1){
			for (int i = 0; i < size; i++){
				if (cont[i] == n1){
					return i;
				}
			}
			return -1;
		}
		
		public int size(){
			return size;
		}

		@Override
		public Iterator<Long> iterator() {
			return new It();
		}

		public class It implements Iterator<Long> {
			int ptr = 0;

			@Override
			public boolean hasNext() {
				if (ptr < size) return true;
				return false;
			}

			@Override
			public Long next() {
				long fin = cont[ptr];
				ptr++;
				return fin;
			}

			@Override
			public void remove() {

			}
		}
	}