package library.graphs;
import java.util.*;

//Maximum matching for bipartite graph. Kuhn's algorithm in O(E*V)
public class BipartiteMatching {

	private static boolean findPath(List<Integer>[] g, int u1, int[] matching,
			boolean[] vis) {
		vis[u1] = true;
		for (int v : g[u1]) {
			int u2 = matching[v];
			if (u2 == -1 || !vis[u2] && findPath(g, u2, matching, vis)) {
				matching[v] = u1;
				return true;
			}
		}
		return false;
	}

	public static int maxMatching(List<Integer>[] firstPartitionAdjacencyList, int secondPartitionNodeCount) {
		int n1 = firstPartitionAdjacencyList.length;
		int[] matching = new int[secondPartitionNodeCount];
		Arrays.fill(matching, -1);
		int matches = 0;
		for (int u = 0; u < n1; u++) {
			if (findPath(firstPartitionAdjacencyList, u, matching, new boolean[n1]))
				++matches;
		}
		return matches;
	}

}