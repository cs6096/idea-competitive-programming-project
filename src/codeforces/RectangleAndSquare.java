package codeforces;

import library.io.InputReader;
import library.io.OutputWriter;
import library.iterator.FullPermutation;
import library.util.VectorZ;

import java.awt.geom.Point2D;

public class RectangleAndSquare {
	public static boolean eq(double a, double b){
		return Math.abs(a - b) < 1e-8;
	}
	public static boolean parallel(Point2D a, Point2D aa, Point2D b, Point2D bb){
		double x1 = aa.getX() - a.getX();
		double y1 = aa.getY() - a.getY();
		double x2 = bb.getX() - b.getX();
		double y2 = bb.getY() - b.getY();
		return eq(x1 * y2, x2 * y1);
	}
	public static boolean eqDist(Point2D a, Point2D aa, Point2D b, Point2D bb){
		double dist1 = a.distance(aa);
		double dist2 = b.distance(bb);
		return eq(dist1, dist2);
	}
	public static boolean isRightAngle(Point2D a, Point2D b, Point2D mid){
		double q = a.distance(mid);
		double w = b.distance(mid);
		double e = b.distance(a);
		q *= q;
		w*= w;
		e*=e;
		return eq(q + w, e);

	}
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    Point2D.Double[] l1 = new Point2D.Double[8];
	    for (int i = 0;i < 8; i++){
		    double x = in.nextInt();
		    double y = in.nextInt();
		    l1[i] = new Point2D.Double(x,y);
	    }
	    double[] q = new double[4];
	    double[] w = new double[4];
	    int[] pat = null;
	    A:
	    for (int[] e: FullPermutation.instance(8)){
		    for (int i = 0; i < 4; i++){
			    Point2D.Double a = l1[e[i]];
			    Point2D.Double b = l1[e[(i + 1) % 4]];
			    q[i] = a.distance(b);
		    }
		    for (int i = 0; i < 4; i++){
//			    DebugZ.print("aa",q[i] ,q[(i + 1) % 4]);
			    if (!eq(q[i] ,q[(i + 1) % 4]) ) continue A;
		    }

		    if (!isRightAngle(l1[e[0]],l1[e[2]], l1[e[1]])) continue A;


		    if (!parallel(l1[e[4]], l1[e[5]], l1[e[6]], l1[e[7]])) continue A;
		    if (!parallel(l1[e[5]], l1[e[6]], l1[e[4]], l1[e[7]] )) continue A;

		    if (!eqDist(l1[e[4]], l1[e[5]], l1[e[6]], l1[e[7]])) continue A;
		    if (!eqDist(l1[e[5]], l1[e[6]], l1[e[4]], l1[e[7]])) continue A;
//		    if (eq(l1[e[4]].distance(l1[e[5]]) + l1[e[5]].distance(l1[e[6]]),
//				          l1[e[4]].distance(l1[e[6]])
//				          )){
//			    continue A;
//		    }
//		    if (eq(l1[e[5]].distance(l1[e[6]]) + l1[e[6]].distance(l1[e[7]]),
//				          l1[e[5]].distance(l1[e[7]])
//		    )){
//			    continue A;
//		    }
		    if (!isRightAngle(l1[e[4]],l1[e[6]], l1[e[5]])) continue A;

//		    for (int i = 0; i < 4; i++){
//			    DebugZ.print("aa",q[i] ,q[(i + 1) % 4]);
//		    }
//
//		    DebugZ.print(l1[e[4]].distance(l1[e[5]]),l1[e[6]].distance(l1[e[7]]));
//		    DebugZ.print(l1[e[5]].distance(l1[e[6]]),l1[e[7]].distance(l1[e[4]]));
//		    DebugZ.print(l1[e[4]].distance(l1[e[5]]) + l1[e[5]].distance(l1[e[6]]) - l1[e[4]].distance(l1[e[6]]));
//		    DebugZ.print(l1[e[5]].distance(l1[e[6]]) + l1[e[6]].distance(l1[e[7]]) - l1[e[5]].distance(l1[e[7]]));

		    pat = e.clone();
	    }
	    if (pat != null){
		    out.printLine("YES");
		    VectorZ.addAll(pat, 1);
		    out.printLine(pat[0], pat[1], pat[2], pat[3]);
		    out.printLine(pat[4], pat[5], pat[6], pat[7]);
	    }
	    else {
		    out.printLine("NO");
	    }

    }
}


