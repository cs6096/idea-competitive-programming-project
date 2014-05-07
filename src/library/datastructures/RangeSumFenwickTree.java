
package library.datastructures;


public class RangeSumFenwickTree extends FenwickTree {

	public RangeSumFenwickTree(int n) {
		super(n);
	}
	
	public void rangeUpdate(int startIndex, int endIndex, long incrementValue){
		this.add(startIndex, incrementValue);
		this.add(endIndex + 1, -incrementValue);
	}
	
	public long indexValueForRangeUpdate(int index){
		return this.prefixSum(index + 1);
	}

}
