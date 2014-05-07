package codeforces._244_2;

import library.io.InputReader;
import library.io.OutputWriter;
import java.util.*;
import java.math.*;
import java.io.*;
public class TaskC {
	public static int n = 0;
	public static int m = 0;

	public static long[] costList = null;
	public static long MOD = 1000000007l;
	public void solve(int testNumber, InputReader in, OutputWriter out) {
	    n= in.nextInt();
	    costList = in.nextLongArray(n);
	    ArrayList<Integer>[] adjList=  new ArrayList[n];
	    for (int i = 0; i < adjList.length; i++){
		    adjList[i] = new ArrayList<Integer>();
	    }
	    m = in.nextInt();
	    for (int i = 0 ; i < m ;i++){
		    int a = in.nextInt() - 1;
		    int b = in.nextInt() - 1;
		    adjList[a].add(b);
	    }
	    SCCTarjan scc = new SCCTarjan();
	    List<List<Integer>> compList = scc.scc(adjList);
	    long ansCost = 0;
	    long ansCount = 1;
	    for (int i = 0 ; i < compList.size(); i++){
		    List<Integer> curComp = compList.get(i);
		    long min = Long.MAX_VALUE;
		    long count = 0;
		    for (int e: curComp){
			    if (costList[e] < min){
				    min = costList[e];
				    count = 1;
			    }
			    else if (costList[e] == min){
				    count++;
			    }
		    }
		    ansCost += min;
		    ansCount *= count;
		    ansCount %= MOD;
	    }
		out.printLine(ansCost, ansCount);


    }
	public class SCCTarjan {

		int time;
		List<Integer>[] graph;
		int[] lowlink;
		boolean[] used;
		List<Integer> stack;
		List<List<Integer>> components;

		public List<List<Integer>> scc(List<Integer>[] graph) {
			int n = graph.length;
			this.graph = graph;
			lowlink = new int[n];
			used = new boolean[n];
			stack = new ArrayList();
			components = new ArrayList();

			for (int u = 0; u < n; u++)
				if (!used[u])
					dfs(u);

			return components;
		}

		void dfs(int u) {
			lowlink[u] = time++;
			used[u] = true;
			stack.add(u);
			boolean isComponentRoot = true;

			for (int v : graph[u]) {
				if (!used[v])
					dfs(v);
				if (lowlink[u] > lowlink[v]) {
					lowlink[u] = lowlink[v];
					isComponentRoot = false;
				}
			}

			if (isComponentRoot) {
				List<Integer> component = new ArrayList();
				while (true) {
					int k = stack.remove(stack.size() - 1);
					component.add(k);
					lowlink[k] = Integer.MAX_VALUE;
					if (k == u)
						break;
				}
				components.add(component);
			}
		}
	}
}
