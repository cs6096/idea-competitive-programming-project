package topcoder;

import java.util.*;
import java.math.*;

public class BinaryCards {
	public long largestNumber(long A, long B) {
		long fin = 0;
		for ( int i = 62 ; i >= 0 ; i-- ) {
			if (haveBit( A, i ) && haveBit( B, i )){
				if (haveBit( A, i )) fin |= 1l << i;
			}
			else {
				if (!haveBit( A, i ) && haveBit( B, i )){
					for (int j = i; j >= 0; j--){
						fin |= 1l << j;
					}
				}
			}
		}
		return fin;
	}
	public boolean haveBit(long mask, long idx){
		return (mask & (1l << idx)) != 0;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString( objects );
		temp = temp.substring( 1, temp.length() - 1 );
		System.out.println( "DEBUG: " + temp );
	}
}
