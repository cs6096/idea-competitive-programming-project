
package library.datastructures;


public abstract class SegmentTree {
	public static class MinTree extends SegmentTree {

		public MinTree(int size) {
			super(size);
		}

		@Override
		public long mergedProductValue(long value1, long value2) {
			
			return Math.min(value1, value2);
		}

		@Override
		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = mergedProductValue(nodeValue[(nodeIndex << 1) + 1], nodeValue[(nodeIndex << 1) + 2]);
		}
	}
	public static class MaxTree extends SegmentTree {

		public MaxTree(int size) {
			super(size);
		}

		@Override
		public long mergedProductValue(long value1, long value2) {
			return Math.max(value1, value2);
		}

		@Override
		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = mergedProductValue(nodeValue[(nodeIndex << 1) + 1], nodeValue[(nodeIndex << 1) + 2]);
		}
	}
	public static class SumTree extends SegmentTree {

		public SumTree(int size) {
			super(size);
		}

		@Override
		public long mergedProductValue(long value1, long value2) {
			
			return value1 + value2;
		}

		@Override
		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = mergedProductValue(nodeValue[(nodeIndex << 1) + 1], nodeValue[(nodeIndex << 1) + 2]);
		}
	}
	
	public abstract long mergedProductValue(long value1, long value2);
	
	public abstract void refreshNodeValue(int nodeIndex);
	
	public long[] nodeValue;
	public int arraySize;
	public SegmentTree(int size){
		nodeValue = new long[(size + 4) * 4];
		arraySize = size;
	}
	
	public void setArrayValueAtIndex(int arrayIndex, long value){
		setArrayValueAtIndex(arrayIndex, value, 0, arraySize - 1, 0);
	}
	public void setArrayValueAtIndex(int arrayIndex, long newValue,int currentLeft, int currentRight, int currentNodeIndex){
		if (currentLeft == currentRight){
			nodeValue[currentNodeIndex] = newValue;
			return;
		}
		
		int leftChildRangeEnd = ((currentRight + currentLeft) >> 1);
		if (arrayIndex <= leftChildRangeEnd){
			setArrayValueAtIndex(arrayIndex, newValue, currentLeft, leftChildRangeEnd, (currentNodeIndex << 1) + 1);
		}
		else {
			setArrayValueAtIndex(arrayIndex, newValue, leftChildRangeEnd + 1, currentRight, (currentNodeIndex << 1) + 2);
		}
		refreshNodeValue(currentNodeIndex);
	}
	
	public long rangeProduct(int queryLeft, int queryRight){
		return rangeProduct(queryLeft, queryRight, 0, arraySize - 1, 0);
	}
	public long rangeProduct(int queryLeft, int queryRight, int currentLeft, int currentRight, int currentNodeIndex){
		if (currentLeft >= queryLeft && currentRight <= queryRight){
			return nodeValue[currentNodeIndex];
		}
		
		int leftChildRangeEnd = ((currentRight + currentLeft) >> 1);
		if (queryLeft <= leftChildRangeEnd && queryRight > leftChildRangeEnd){
			return mergedProductValue(
					rangeProduct(queryLeft, queryRight, currentLeft, leftChildRangeEnd, (currentNodeIndex << 1) + 1),
					rangeProduct(queryLeft, queryRight, leftChildRangeEnd + 1, currentRight, (currentNodeIndex << 1) + 2)
					);
		}
		else if (queryRight <= leftChildRangeEnd){
			return rangeProduct(queryLeft, queryRight, currentLeft, leftChildRangeEnd, (currentNodeIndex << 1) + 1);
		}
		else {
			return rangeProduct(queryLeft, queryRight, leftChildRangeEnd + 1, currentRight, (currentNodeIndex << 1) + 2);
		}
	}
	
	public String prefixProductString(){
		StringBuilder fin = new StringBuilder();
		fin.append("{");
		for (int i = 0 ;  i < arraySize; i++){
			if (i != 0) fin.append(", ");
			fin.append(rangeProduct(0, i));
		}
		fin.append("}");
		return fin.toString();
	}
	
	public String toString(){
		StringBuilder fin = new StringBuilder();
		fin.append("{");
		for (int i = 0 ;  i < arraySize; i++){
			if (i != 0) fin.append(", ");
			fin.append(rangeProduct(i, i));
		}
		fin.append("}");
		return fin.toString();
	}
}
