
package library.iterator;

import java.util.Iterator;


public class Order implements Iterable<Integer>{
	
	public static Order order(int n1){
		Order fin = new Order();
		fin.cur = 0;
		fin.lim = n1;
		fin.inc = 1;
		return fin;
	}
	
	public static Order order(int n1, int inc1){
		Order fin = new Order();
		fin.cur = 0;
		fin.lim = n1;
		fin.inc = inc1;
		return fin;
	}
	
	public static Order arithmetic(int start, int inc1,int bound){
		Order fin = new Order();
		fin.cur = start;
		fin.lim = bound;
		fin.inc = inc1;
		return fin;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new It();
	}
	
	public int lim = 0;
	public int cur = 0;
	public int inc = 1;
	public int temp = 0;
	public class It implements Iterator<Integer> {
		@Override
		public boolean hasNext() {
			return cur < lim;
		}

		@Override
		public Integer next() {
			temp = cur;
			cur += inc;
			return temp;
		}

		@Override
		public void remove() {}
		
	}

}
