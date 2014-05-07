package library.datastructures;

public class DisjointUnionSet {
	int[] parent;
	int[] rank;
	DisjointUnionSet (int length){
		parent = new int[length];
		rank = new int[length];
		for (int i= 0 ; i < length; i++) parent[i] = i;
	}
	/*
	 * Return the partition number.
	 */
	int getPartitionId(int x){
		if (parent[x] != x) parent[x] = getPartitionId(parent[x]);
		return parent[x];
	}
	/*
	 * Join the two partion that "x" and "y" are in.
	 */
	void unionElement(int x, int y){
		int k1 = getPartitionId(x);
		int k2 = getPartitionId(y);
		if (k1 == k2) return;
		if (rank[k1] < rank[k2]) parent[k1] = k2;
		else if (rank[k1] > rank[k2]) parent[k2] = k1;
		else{
			parent[y] = k1;
			rank[k1]++;
		}
	}
}
