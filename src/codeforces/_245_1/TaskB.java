package codeforces._245_1;

import library.io.InputReader;
import library.io.OutputWriter;
import library.util.DebugZ;

import java.util.*;
import java.math.*;
import java.io.*;

public class TaskB {
	int[][] grid, upLeft, botLeft, upRight, botRight;
	int n, m;
	public void update(int[][] qq, int i, int j, int ki, int kj){
		int vi = i + ki;
		int vj = j + kj;
		if (!ok(vi, vj)) return;
		qq[i][j] = Math.max( qq[i][j], grid[i][j] + qq[vi][vj] );
	}
	void genGrid(int[][] to, int si, int sj, int di, int dj){
		for (int i = si; ok(i, 0); i += di){
			for (int j = sj; ok(0, j); j += dj){
				to[i][j] = grid[i][j];
				update(to, i, j, -di, 0);
				update(to, i, j, 0, -dj);
			}
		}
	}
	boolean ok(int i , int j){
		if (i < 0 || j < 0) return false;
		if (i >= n || j >= m) return false;
		return true;
	}
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		n = in.nextInt();
		m = in.nextInt();
		grid = new int[n][m];
		for ( int i = 0 ; i <  n; i++ ) {
			for ( int j = 0 ; j < m ; j++ ) {
				grid[i][j] = in.nextInt();
			}
		}
		upLeft = new int[n][m];
		botRight = new int[n][m];
		upRight = new int[n][m];
		botLeft = new int[n][m];
		genGrid( upLeft, 0, 0, 1, 1 );
		genGrid( upRight, 0, m - 1, 1, -1 );
		genGrid( botLeft, n - 1, 0, -1, 1 );
		genGrid( botRight, n - 1, m - 1, -1, -1 );

		int fin = Integer.MIN_VALUE;
		for (int i = 1; i < n - 1; i++){
			for (int j = 1; j < m - 1; j++){
				fin = Math.max( fin, upLeft[i - 1][j] + botLeft[i][j - 1] + upRight[i][j + 1] + botRight[i + 1][j] );
				fin = Math.max( fin, upLeft[i][j - 1] + botLeft[i + 1][j] + upRight[i - 1][j] + botRight[i][j + 1] );
			}
		}
		out.printLine( fin );
	}
}


