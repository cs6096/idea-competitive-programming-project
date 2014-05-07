package library.graphs;

import library.datastructures.IntList;
import library.datastructures.LongList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class LongWeightedDirectedGraph {
	public IntList[] adjacencyList;
	public IntList fromList = new IntList();
	public IntList toList = new IntList();
	public LongList weightList = new LongList();
	int nodeNo;
	int edgeNo = 0;

	public LongWeightedDirectedGraph(int nodeNo) {
		this.nodeNo = nodeNo;
		adjacencyList = new IntList[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new IntList();
		}
	}

	public void addEdge(int from, int to, long weight) {
		int edgeId = edgeNo;
		fromList.add(from);
		toList.add(to);
		weightList.add(weight);
		adjacencyList[from].add(edgeId);
		edgeNo++;
	}

	public long[] dijkstra(int source) {
		final long[] fin = new long[nodeNo];
		boolean[] poped = new boolean[nodeNo];
		Arrays.fill(fin, Long.MAX_VALUE);
		TreeSet<Integer> q1 = new TreeSet(new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				long diff1 = fin[n1] - fin[n2];
				if (diff1 > 0) return 1;
				if (diff1 < 0) return -1;
				return n1 - n2;
			}
		});
		q1.add(source);
		fin[source] = 0;
		for (;;) {
			if (q1.size() <= 0) break;
			int cur = q1.pollFirst();
			poped[cur] = true;
			long baseDist = fin[cur];
			for (int edgeId : adjacencyList[cur]) {
				int to = toList.get(edgeId);
				if (poped[to]) continue;
				long newDist = baseDist + weightList.get(edgeId);
				if (newDist < fin[to]) {
					if (q1.contains(to)) {
						q1.remove(to);
					}
					fin[to] = newDist;
					q1.add(to);
				}
			}
		}
		return fin;
	}
	public long[] bellmanFord(int source) {
		long[] fin = new long[nodeNo];
		Arrays.fill(fin, Long.MAX_VALUE >> 1);
		fin[source] = 0;
		for (int i = 0; i < nodeNo - 1; i++) {
			for (IntList e : adjacencyList) {
				for (int edgeId : e) {
					int from = fromList.get(edgeId);
					int to = toList.get(edgeId);
					long weight = weightList.get(edgeId);
					if (fin[from] + weight < fin[to]) {
						fin[to] = weight + fin[from];
					}
				}
			}
		}
		for (IntList e : adjacencyList) {
			for (int edgeId : e) {
				int from = fromList.get(edgeId);
				int to = toList.get(edgeId);
				long weight = weightList.get(edgeId);
				if (fin[from] + weight < fin[to]) { return null; }
			}
		}
		return fin;
	}
	public long[][] floydWarshall(){
		long[][] fin = new long[nodeNo][nodeNo];
		for (long[] e: fin){
			Arrays.fill(e, Long.MAX_VALUE / 8l * 3l);
		}
		for (IntList e: adjacencyList){
			for (int edgeId: e){
				fin[fromList.get(edgeId)][toList.get(edgeId)] = weightList.get(edgeId);
			}
		}
		for (int i = 0; i < nodeNo; i++){
			for (int j = 0; j <nodeNo; j++){
				for (int k = 0; k < nodeNo; k++){
					long newDist = fin[j][i] + fin[i][k];
					if (newDist < fin[j][k]){
						fin[j][k] = newDist;
					}
				}
			}
		}
		return fin;
	}
}
