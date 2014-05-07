package topcoder;

import library.util.DebugZ;

import java.util.*;
import java.math.*;

public class RotatingBot {


	public static class P {
		int x, y;

		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public P add(P a){
			return new P(x + a.x, y + a.y);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) { return true; }
			if (!(o instanceof P)) { return false; }

			P p = (P) o;

			if (x != p.x) { return false; }
			if (y != p.y) { return false; }

			return true;
		}

		@Override
		public int hashCode() {
			int result = x;
			result = 31 * result + y;
			return result;
		}

		public boolean bound(int xx, int yy){
			if (x < 0 || y < 0) return false;
			if (x >= xx || y >= yy) return false;
			return true;
		}

		@Override
		public String toString() {
			return "P{" +
					       "x=" + x +
					       ", y=" + y +
					       '}';
		}
	}

	public static P[] dir = {new P(0, 1), new P(-1,0), new P(0,-1), new P(1,0)};

	public int minArea(int[] moves) {
		ArrayList<P> pointList = new ArrayList();
		int d1 = 0;
		P cur = new P(0,0);
		int xlow = 0;
		int ylow = 0;
		pointList.add(cur);
		for (int e: moves){
			for (int i = 0; i < e; i++){
				cur = cur.add(dir[d1]);
				pointList.add(cur);
				xlow = Math.min(xlow, cur.x);
				ylow = Math.min(ylow, cur.y);
			}
			d1 = (d1 + 1) % 4;
		}
		int xx = 0;
		int yy = 0;
		for (P e: pointList){
			e.x -= xlow;
			e.y -= ylow;
			xx = Math.max(xx , e.x + 1);
			yy = Math.max(yy , e.y + 1);
		}
		ArrayList<P> generatedList = new ArrayList();
		boolean[][] ex = new boolean[xx][yy];
		P at = pointList.get(0);
		int d2 = 0;
		boolean turned = false;
		ex[at.x][at.y] = true;
		generatedList.add(at);
		for (;;){
			if (generatedList.size() >= pointList.size()) break;
			P next = at.add(dir[d2]);
			if (!next.bound(xx, yy) || ex[next.x][next.y]){
				if (turned) break;
				else {
					d2 = (d2 + 1) % 4;
					turned = true;
					continue;
				}
			}
			if (ex[next.x][next.y]) break;
			at = next;
			generatedList.add(at);
			ex[at.x][at.y] = true;
			turned = false;
		}
//		DebugZ.print(generatedList);
//		DebugZ.print(pointList);

		return generatedList.equals(pointList) ? xx * yy : -1;
	}


	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}

