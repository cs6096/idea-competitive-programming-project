
package library.datastructures;

import java.util.ArrayList;


public class TreeDFSOrder {
	public ArrayList<Integer>[] adjacencyList;
	public int rootIndex = 0;
	public int[] startList;
	public int[] subtreeSizeList;
	public TreeDFSOrder(ArrayList<Integer>[] adjacencyList, int rootIndex){
		this.adjacencyList = adjacencyList;
		this.rootIndex = rootIndex;
		startList = new int[adjacencyList.length];
		subtreeSizeList = new int[adjacencyList.length];
		dfs(0, -1);
	}
	private void dfs(int at, int from){
		for (int e: adjacencyList[at]){
			if (e == from) continue;
			dfs(e, at);
			subtreeSizeList[at]+= subtreeSizeList[e];
		}
		subtreeSizeList[at]+= 1;
	}
	public int startIndex(int v1){
		return startList[v1];
	}
	public int endIndex(int v1){
		return startList[v1] + subtreeSizeList[v1] - 1;
	}
}
