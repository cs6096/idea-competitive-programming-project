package library.algorithm;

class DynamicProgramming {
	public static int lcsNo(char[] l1, char[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int max = 0;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = 0;
				}
				else if (l1[i-1] == l2[j-1]){
					dp1[i][j] = dp1[i-1][j-1]+1;
				}
				else {
					dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);
				}
				max = Math.max(max, dp1[i][j]);
			}
		}
		return max;
	}
	static int UP = 1;
	static int LEFT = 2;
	static int UPLEFT = 3;
	static int END = 0;
	public static String lcs(char[] l1, char[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int[][] from = new int[l1.length+1][l2.length+1];
		int max = 0;
		int kx = -1;
		int ky = -1;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = 0;
				}
				else if (l1[i-1] == l2[j-1]){
					dp1[i][j] = dp1[i-1][j-1]+1;
					from[i][j] = UPLEFT;
				}
				else {
					dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);
					from[i][j] = dp1[i-1][j] >= dp1[i][j-1] ? UP : LEFT;
				}
				if (dp1[i][j] > max){
					max = dp1[i][j];
					kx = i;
					ky = j;
				}
			}
		}
		char[] fin = new char[max];
		for (int ptr = 0;;){
			int type = from[kx][ky];
			if (type == UPLEFT){
				fin[max - 1 - ptr++] = l1[kx-1];
				kx--;
				ky--;
			}
			else if (type == UP) kx--;
			else if (type == LEFT) ky--;
			else break; 
		}
		return String.valueOf(fin);
	}
	public static int lcsNo(int[] l1, int[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int max = 0;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = 0;
				}
				else if (l1[i-1] == l2[j-1]){
					dp1[i][j] = dp1[i-1][j-1]+1;
				}
				else {
					dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);
				}
				max = Math.max(max, dp1[i][j]);
			}
		}
		return max;
	}
	public static int maxSubarraySum(int[] l1){
		int temp = l1[0];
		int max = l1[0];
		for (int i = 1; i < l1.length ;i++){
			if (temp < 0) temp = l1[i];
			else temp += l1[i];
			max = Math.max(max, temp);
		}
		return max;
	}
	public static int levenshtein(char[] l1, char[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int min = 0;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = Math.max(i, j);
				}
				else {
					int res = Integer.MAX_VALUE;
					res = Math.min(res, dp1[i-1][j]+1);
					res = Math.min(res, dp1[i][j-1]+1);
					
					if (l1[i-1] == l2[j-1]){
						res = Math.min(res, dp1[i-1][j-1]);
					}
					else {
						res = Math.min(res, dp1[i-1][j-1] + 1);
					}
					dp1[i][j] = res;
				}
			}
		}
		return dp1[l1.length][l2.length];
	}
}

