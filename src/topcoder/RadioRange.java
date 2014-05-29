package topcoder;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;
import java.math.*;
public class RadioRange {
	public int n1 = 0;
    public double RadiusProbability(int[] X, int[] Y, int[] R, int Z) {
	    n1 = X.length;
	    double[][] l1 = new double[n1][2];
	    for (int i = 0; i < n1; i++){
		    double dist = Point2D.distance(X[i], Y[i], 0, 0);
		    double far = dist + R[i];
		    double near = dist - R[i];
		    if (near < 0) near = 0;
		    l1[i][0] = near;
		    l1[i][1] = far;
//		    px(l1[i]);
	    }
	    Arrays.sort(l1, new Comparator<double[]>() {
		    @Override
		    public int compare(double[] o1, double[] o2) {
			    if (o1[0] != o2[0]) return (int) Math.signum(o1[0] - o2[0]);
			    if (o1[1] != o2[1]) return (int) Math.signum(o1[1] - o2[1]);
			    return 0;
		    }
	    });
	    double a = l1[0][0];
	    double b = l1[0][1];
	    double bad = 0;
	    for (int i = 1 ; i < n1; i++){
		    if (l1[i][0] >= a && l1[i][0] <= b){
			    b = Math.max(b, l1[i][1]);
		    }
		    else {
			    if (a <= Z){
				    bad += Math.min(b, Z) - a;
			    }
			    a = l1[i][0];
			    b = l1[i][1];
		    }
//		    px(a, b);
//		    px(bad);
	    }
	    if (a <= Z){
		    bad += Math.min(b, Z) - a;
	    }
        return 1.0 - bad / (double)Z;
    }

	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}

