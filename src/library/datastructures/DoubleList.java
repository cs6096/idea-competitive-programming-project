
package library.datastructures;

import library.util.ShuffleZ;

import java.util.Arrays;
import java.util.Iterator;




public class DoubleList implements Iterable<Double>{
	public double[] cont;
	public int size = 0;
	public DoubleList(){
		cont = new double[8];
	}
	public DoubleList(int initialCapacity){
		cont = new double[initialCapacity];
	}
	public void add(double v1){
		if (size == cont.length) cont = Arrays.copyOf(cont, size << 1);
		cont[size++] = v1;
	}
	public double get(int idx){
		if (idx >= 0) return cont[idx];
		return cont[size + idx];
	}
	public double last(){
		return cont[size - 1];
	}
	public double pop(){
		size--;
		return cont[size];
	}
	public void sort(){
		ShuffleZ.doubles(cont, 0, size);
		Arrays.sort(cont, 0, size);
	}
	public int binarySearch(double v1){
		return Arrays.binarySearch(cont, 0, size, v1);
	}
	public void reverse(){
		for (int i = 0; i < size / 2; i++) {
			double temp = cont[i];
			cont[i] = cont[size - 1 - i];
			cont[size - 1 - i] = temp;
		}
	}
	public double[] toPrimitiveArray(){
		return Arrays.copyOf(cont, size);
	}
	
	public boolean contains(double v1){
		for (double e: cont){
			if (e == v1) return true;
		}
		return false;
	}
	
	public int size(){
		return size;
	}
	public String toString() {
		StringBuilder fin = new StringBuilder();
		fin.append('{');
		for (int i = 0; i < size; i++) {
			if (i != 0) fin.append(", ");
			fin.append(String.format("%.6f", cont[i]));
		}
		fin.append('}');
		return fin.toString();
	}
	
	@Override
	public Iterator<Double> iterator() {
		return new It();
	}
	public class It implements Iterator<Double> {
		private int ptr = 0;
		@Override
		public boolean hasNext() {
			if (ptr < size) return true;
			return false;
		}

		@Override
		public Double next() {
			return cont[ptr++];
		}

		@Override
		public void remove() {}
		
	}
}
