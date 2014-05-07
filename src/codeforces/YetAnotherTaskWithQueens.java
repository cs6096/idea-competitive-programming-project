package codeforces;

import library.io.InputReader;
import library.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class YetAnotherTaskWithQueens {
	public static final int X = 0;
	public static final int Y = 1;
	public static final int COUNT = 2;

	public void count(int[][] pointList, Comparator<int[]> c) {
		Arrays.sort(pointList, c);
		int start = 0;
		for (int i = 0; i < pointList.length; i++) {

			if (i == pointList.length - 1 || c.compare(pointList[i], pointList[i + 1]) != 0) {
				int len = i + 1 - start;
				Arrays.sort(pointList, start, start + len, orderComparator);
//				DebugZ.print(Arrays.copyOfRange(pointList, start, start + len));
				if (len > 1) {
					pointList[start][COUNT]++;
					for (int j = 1; j < len - 1; j++) {
						pointList[start + j][COUNT] += 2;
					}
					pointList[i][COUNT]++;
				}

				start = i + 1;
			}
		}
	}

	public static Comparator<int[]> orderComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[X] != o2[X]) { return o1[X] - o2[X]; }
			return o1[Y] - o2[Y];
		}
	};

	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] pointList = new int[m][3];
		for (int i = 0; i < m; i++) {
			pointList[i][0] = in.nextInt();
			pointList[i][1] = in.nextInt();
		}
		Comparator<int[]> horizontalComparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[X] - o2[X];
			}
		};
		Comparator<int[]> verticalComparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[Y] - o2[Y];
			}
		};
		Comparator<int[]> positiveDiagonalComparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int k1 = (o1[X] + o1[Y]) - (o2[X] + o2[Y]);
				return k1;
			}
		};
		Comparator<int[]> negativeDiagonalComparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int k1 = (o1[X] - o1[Y]) - (o2[X] - o2[Y]);
				return k1;
			}
		};
		count(pointList, horizontalComparator);
//		DebugZ.print(pointList);
		count(pointList, verticalComparator);
//		DebugZ.print(pointList);
		count(pointList, positiveDiagonalComparator);
//		DebugZ.print(pointList);
		count(pointList, negativeDiagonalComparator);
//		DebugZ.print(pointList);
		int[] fin = new int[9];
		for (int[] e: pointList){
			fin[e[COUNT]]++;
		}
		for (int e: fin){
			out.print(e + " ");
		}
		out.printLine();

	}
}
