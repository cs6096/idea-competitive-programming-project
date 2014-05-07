package library.datastructures;



class OldSegmentTree{
		public static long assoc(long n1, long n2){
			return n1 + n2;
		}
		
		int size = -1;
		long[] nodeValue = null;
		public OldSegmentTree(int n1){
			nodeValue = new long[n1*4+4];
			size = n1;
		}
		
		public IntList getComposingIntervals(int left, int right){
			IntList fin = new IntList();
			getComposingIntervals(left, right, 0, 0, size-1, fin);
			return fin;
		}
		public void getComposingIntervals(int left, int right, int at, int currentLeft, int currentRight, IntList bag){
			if (currentLeft > right || currentRight < left) return;
			if (currentLeft >= left && currentRight <= right){
				bag.add(at);
				return;
			}
			int bound = currentRight - ((currentRight-currentLeft+1)>>1);
			getComposingIntervals(left, right, (at<<1)+1, currentLeft, bound, bag);
			getComposingIntervals(left, right, (at<<1)+2, bound+1, currentRight, bag);
		}
		
		public int locateIndexSource(int n1){
			return locateIndexSource(n1, 0, size-1, 0);
		}
		public int locateIndexSource(int n1, int left, int right,int cur){
			if (left == right) return cur;
			int range = right - left + 1;
			int half = range >> 1;
			int bound = right - half;
			if (n1 <= bound) return locateIndexSource(n1, left, bound, (cur << 1)+1);
			else return locateIndexSource(n1, bound+1, right, (cur << 1)+2);
		}
		
		public void update(int index, long value){
			int ptr = locateIndexSource(index);
			nodeValue[ptr] = value;
			for (;;){
				if (ptr == 0) break;
				ptr = (ptr - 1)>>1;
				refreshNodeValue(ptr);
			}
		}
		public long rangeProduct(int left, int right){
			IntList intervals = getComposingIntervals(left, right);
			long fin = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++){
				fin = mergedProductValue(fin, nodeValue[intervals.get(i)]);
			}
			return fin;
		}

		public long mergedProductValue(long value1, long value2) {
			return value1 + value2;
		}

		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = nodeValue[(nodeIndex << 1) + 1] + nodeValue[(nodeIndex << 1) + 2];
		}
	}