package topcoder;
import java.util.*;

public class TreesAnalysis {
	public class Edge {
		int to = 0;

		public Edge(int to, int edgeId) {
			this.to = to;
			this.edgeId = edgeId;
		}

		int edgeId = 0;
	}
	public ArrayList<Integer>[] al1 = null;
	public ArrayList<Edge>[] al2 = null;
	public int n = 0;
	public int en = 0;
	public int root1 = -1;
	public int root2 = -1;
	public boolean[][] ex = null;
	public int[] count = null;
	public int[][] cost = null;
    public long treeSimilarity(int[] tree1, int[] tree2) {
	    n = tree1.length + 1;
	    en = tree1.length;
	    al1 = new ArrayList[n];
	    al2 = new ArrayList[n];
	    for (int i = 0 ; i < al1.length; i++){
		    al1[i] = new ArrayList();
		    al2[i] = new ArrayList();
	    }
	    for (int i = 0 ; i < en ; i++){
		    al1[i].add(tree1[i]);
		    al1[tree1[i]].add(i);
	    }
	    for (int i = 0 ; i < en ; i++){
		    al2[i].add(new Edge(tree2[i], i));
		    al2[tree2[i]].add(new Edge(i, i));
	    }
	    for (int i = 0;i < n ; i++){
		    if (al1[i].size() == 1){
			    root1 = i;
		    }
	    }
	    for (int i = 0;i < n ; i++){
		    if (al2[i].size() == 1){
			    root2 = i;
		    }
	    }
	    ex = new boolean[n][n];
	    count = new int[en];
	    for (int i = 0; i < en; i++){
		    dfs1(i,i,tree1[i], root1, -1);
		    px(ex[i]);
	    }

	    weight1 = new int[n];
	    weight2 = new int[n];
	    for (int i = 0; i < en ; i++){
		    dfs2(i, root2, -1);
	    }


        return fin;
    }
	public void dfs1(int i, int a, int b,int at, int from){
		ex[i][at] = true;
		count[i]++;
		for (int to: al1[at]){
			if (to == from) continue;
			if (i == a && to == b) continue;
			if (i == b && to == a) continue;
			dfs1(i, a, b, to, at);
		}
	}
	public int[] weight1 = null;
	public int[] weight2 = null;
	public long fin = 0;
	public void dfs2(int i, int at, int from){
		int qq = 0;
		int ww = 1;
		if (ex[i][at]) qq++;
		for (Edge to : al2[at]){
			if (to.to == from) continue;
			dfs2(i, to.to, at);

			int max = -1;
			int r1 = weight1[to.to];
			int r2 = weight2[to.to] - r1;
			int r3 = count[i] - r1;
			int r4 = n - count[i] - r2;
			if (r1 > max) max = r1;
			if (r2 > max) max = r2;
			if (r3 > max) max = r3;
			if (r4 > max) max = r4;
//			cost[i][to.edgeId] = max;
//			cost[to.edgeId][i] = max;
			fin += (long)max;
			qq += weight1[to.to];
			ww += weight2[to.to];

		}
		weight1[at] = qq;
		weight2[at] = ww;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
