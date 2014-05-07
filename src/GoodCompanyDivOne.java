import java.io.PrintStream;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Sheng Cao
 */
public class GoodCompanyDivOne {
	public int vertexNumber = 0;
	public int colorNumber = 0;
	public ArrayList<Integer>[] adjList = null;
	public int[] bastCostList = null;
	public int[][] nodeCostList = null;
    public int minimumCost(int[] superiorList, int[] trainingList) {
	    Arrays.sort(trainingList);
	    vertexNumber = superiorList.length;
	    colorNumber = trainingList.length;
	    adjList = new ArrayList[vertexNumber];
	    for (int i = 0 ; i < vertexNumber; i++) adjList[i] = new ArrayList();
	    for (int i = 0 ; i < superiorList.length; i++){
		    int parent = superiorList[i];
		    if (parent == -1) continue;
		    adjList[parent].add(i);
	    }
	    px(adjList);
	    for (ArrayList<Integer> e: adjList) if (e.size() + 1 > trainingList.length) return -1;
	    bastCostList = new int[colorNumber];
	    for (int i = 0; i < colorNumber; i++)if (i == 0) bastCostList[i] = trainingList[i] + trainingList[i + 1]; else bastCostList[i] = trainingList[i] + trainingList[0];
	    nodeCostList = new int[vertexNumber][colorNumber];
	    for (int[] e: nodeCostList) Arrays.fill(e, Integer.MAX_VALUE);
	    dfs(0);

	    px("bestCostList",bastCostList);
	    for (int[] e: nodeCostList){
		    px(e);
	    }
		int ans = Integer.MAX_VALUE;
	    for (int e: nodeCostList[0]) ans = Math.min(ans, e);
        return ans;
    }
	public void dfs(int at){
		for (int e: adjList[at]){
			dfs(e);
		}
		nodeCostList[at] = bastCostList.clone();
		int childrenNumber = adjList[at].size();
		for (int not = 0; not < colorNumber; not++){

			int[] dp1 = new int[colorNumber];

			int[] dp2 = new int[colorNumber];
			for (int i = 0; i < childrenNumber; i++){
				int child = adjList[at].get(i);
				int[] childCost = nodeCostList[child];
				Arrays.fill(dp2, Integer.MAX_VALUE);
				if (i == 0){
					dp2 = childCost.clone();
				}
				else {
					for (int from = 0; from < dp1.length; from++){
						if (from == not) continue;
						if (dp1[from]== Integer.MAX_VALUE) continue;
						for (int to = from + 1; to < dp1.length; to++){
							if (to == not) continue;
							int nval = dp1[from] + childCost[to];
							dp2[to]= Math.min(dp2[to], nval);
						}
					}
				}
				dp2[not] = Integer.MAX_VALUE;
				dp1 = dp2.clone();
			}
			int min = Integer.MAX_VALUE;
			for (int e: dp1){
				if (e != Integer.MAX_VALUE) min = Math.min(min, e);
			}
			nodeCostList[at][not] += min;
		}
		px("DFS", at, nodeCostList[at]);


	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}

