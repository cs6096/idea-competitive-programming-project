package library.datastructures;




class SumSegT {
		int size = -1;
		long[] cont = null;
		long[] excess = null;
		long[] lengths = null;
		public SumSegT(int n1){
			cont = new long[n1*4+4];
			excess = new long[n1*4+4];
			lengths = new long[n1*4+4];
			size = n1;
			genLength();
		}
		public void genLength(){
			genLengthRec(0, size);
		}
		public void genLengthRec(int at, long curLength){
			lengths[at] = curLength;
			if (curLength == 1) return;
			long bound = curLength - (curLength>>1);
			genLengthRec((at<<1)+1, bound);
			genLengthRec((at<<1)+2, curLength>>1);
		}
		public long valueAt(int n1){
			return cont[n1]+excess[n1];
		}
		public void propagate(int idx){
			if (excess[idx] != 0) if (lengths[idx] != 1){
				long unit = excess[idx] / lengths[idx];
				excess[(idx<<1)+1]+=unit * lengths[(idx<<1)+1];
				excess[(idx<<1)+2]+=unit * lengths[(idx<<1)+2];
				cont[idx] += excess[idx];
				excess[idx] = 0;
			}
		}
		public int loc(int n1){
			return loc(n1, 0, size-1, 0);
		}
		public int loc(int n1, int left, int right,int cur){
			if (left == right) return cur;
			int range = right - left + 1;
			int half = range >> 1;
			int bound = right - half;
			if (n1 <= bound) return loc(n1, left, bound, (cur << 1)+1);
			else return loc(n1, bound+1, right, (cur << 1)+2);
		}
		public void refresh(int n1){
			cont[n1] =  valueAt((n1 << 1) + 1) + valueAt((n1 << 1) + 2);
		}
		public void add(int n1){
			add(n1,1);
		}
		public void add(int n1, long k1){
			int ptr = loc(n1);
			cont[ptr] += k1;
			for (;;){
				if (ptr == 0) break;
				ptr = (ptr - 1)>>1;
				refresh(ptr);
			}
		}
		public void lazyAdd(int idx, long length, long val){
			if (length == 1){
				cont[idx] += val*length;
				refreshUp(idx);
			}
			else {
				excess[idx] += val*length;
				refreshUp(idx);
			}
		}
		public void rangeAdd(int left, int right, long val){
			IntList intervals = getIntervals(left, right);
			for (int i = 0; i< intervals.size>>1; i++){
				lazyAdd(intervals.get(i<<1), intervals.get((i<<1)+1), val);
			}
		}
		public void refreshUp(int idx){
			int ptr = idx;
			for (;;){
				if (ptr == 0) break;
				ptr = (ptr - 1)>>1;
				refresh(ptr);
			}
		}
		
		public long sum(int left, int right){
			IntList intervals = getIntervals(left, right);
			long fin = 0;
			for (int i = 0; i < intervals.size >> 1;i++){
				fin += valueAt(intervals.get(i<<1));
			}
			return fin;
		}
		
		public IntList getIntervals(int left, int right){
			IntList fin = new IntList();
			getIntervals(left, right, 0, 0, size-1, fin);
			return fin;
		}
		public void getIntervals(int left, int right, int at, int atLeft, int atRight, IntList bag){
			int length =atRight-atLeft+1;
			if (length > 1) propagate(at);
			if (atLeft > right || atRight < left) return;
			if (atLeft >= left && atRight <= right){
				bag.add(at);
				bag.add(length);
				return;
			}
			int bound = atRight - ((atRight-atLeft+1)>>1);
			getIntervals(left, right, (at<<1)+1, atLeft, bound, bag);
			getIntervals(left, right, (at<<1)+2, bound+1, atRight, bag);
		}
		public String toString(){
			StringBuilder fin = new StringBuilder();
			for (int i =0; i< size; i++){
				fin.append(sum(i,i)+" ");
			}
			return fin.toString();
		}
	}