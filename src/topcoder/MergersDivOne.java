package topcoder;

import java.util.*;
import java.math.*;

public class MergersDivOne {
	public double findMaximum(int[] revenues) {
		if ( revenues.length == 1 ) {
			return revenues[ 0 ];
		}
		Arrays.sort( revenues );
		double f = 0;
		double bot = 2;
		for ( int j = revenues.length - 1 ; j >= 0 ; j-- ) {
			f += 1. * revenues[j] / bot;
			if (j != 1) bot *= 2.;
		}
		return f;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString( objects );
		temp = temp.substring( 1, temp.length() - 1 );
		System.out.println( "DEBUG: " + temp );
	}
}
