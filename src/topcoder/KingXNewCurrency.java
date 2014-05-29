package topcoder;

import java.util.*;
import java.math.*;

public class KingXNewCurrency {
	public int howMany(int A, int B, int X) {
		if ( A % X == 0 && B % X == 0 ) {
			return -1;
		}
		HashSet< Integer > s1 = new HashSet();
		for ( int i = 0 ; i <= 200 ; i++ ) {
			for ( int j = 0 ; j <= 200 ; j++ ) {
				if (i == 0 && j == 0) continue;
				s1.add( i * A + j * B );
			}
		}
//		px(s1);
		int fin = 0;
		B:
		for ( int i = 1 ; i <= 200 ; i++ ) {
			if ( i == X ) {
				continue;
			}
			A:
			for ( int e : s1 ) {
				if (e % i == 0) continue A;
				for (int j = 0; j < e; j += i){
					if ( (e - j) % X == 0){
						continue A;
					}
				}
				continue B;
			}
//			px(i);
			fin++;
		}
		return fin;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString( objects );
		temp = temp.substring( 1, temp.length() - 1 );
		System.out.println( "DEBUG: " + temp );
	}
}
