
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author cs6096
 */
public class WolvesAndSheep {
	public char[][] grid = null;
	int r, c;

	public int getmin(String[] field) {
		grid = new char[field.length][];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = field[i].toCharArray();
		}
		r = field.length;
		c = field[0].length();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < (1 << (r - 1)); i++) {

		}

		return ans;
	}

	public int need(int set1) {
		int fin = 0;
		boolean[][] al = new boolean[c - 1][c - 1];
		for (int i = 0; i < r; i++) {
			char[] cur = new char[c];
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 'W') {
					if (cur[j] == 'S') {
						return Integer.MAX_VALUE;
					}
					else {
						cur[j] = 'W';
					}
				}
				if (grid[i][j] == 'S') {
					if (cur[j] == 'W') {
						return Integer.MAX_VALUE;
					}
					else {
						cur[j] = 'S';
					}
				}
			}
			if ((set1 & (1 << i)) != 0) {
				fin++;
				for (int j = 0; j < c; j++) {
					for (int k = j + 1; k < c; k++) {
						if (cur[j] == '.' || cur[k] == '.') { continue; }
						if (cur[j] != cur[k]) {
							al[j][k - 1] = true;
						}
					}
				}
				cur = new char[c];
			}
		}
		int covered = -1;
		for (int i = 0; i < al.length; i++){
			for (int j = 0; j < al.length; j++){
				if (al[j][i]){
					if (i > covered){
						covered = i;
						fin++;
					}
				}
			}
		}
		return fin;
	}
}

