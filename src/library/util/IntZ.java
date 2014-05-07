
package library.util;
import java.util.*;
public class IntZ {
	public static int decDigitNo(int n1){
		if (n1 == 0) return 1;
		int cnt = 0;
		for (;n1 != 0;){
			n1 /= 10;
			cnt++;
		}
		return cnt;
	}
}
