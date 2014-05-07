package topcoder;
import java.util.*;
import java.math.*;
public class FoxAndHandle {
    public String lexSmallestName(String S) {
	    char[] l1 = S.toCharArray();
	    int[] count = new int[26];
	    for (char e: l1) count[e - 'a']++;

	    int[] half = new int[26];
	    for (int i = 0 ; i  <count.length; i++) half[i] = count[i] / 2;
	    StringBuilder fin = new StringBuilder();
	    int[] need = half.clone();
	    int[] left = count.clone();

	    int ptr = 0;
	    B:
	    for (;;){

		    A:
		    for (int i = 0; i < 26; i++){
			    int cur = 'a' + i;
			    if (need[i] > 0){
				    int first = 0;
				    int[] newLeft = left.clone();
				    for (int j = ptr; j < l1.length; j++){
					    first = j;
					    if (l1[j] == cur) break;
					    newLeft[l1[j] -'a']--;
				    }
				    for (int j = 0; j < newLeft.length; j++){
					    if (newLeft[j] < need[j]) continue A;
				    }
				    need[cur - 'a']--;
				    newLeft[cur - 'a']--;
				    left = newLeft;
				    fin.append((char)cur);
				    ptr = first + 1;
				    continue B;
			    }
		    }
		    break;
	    }
        return fin.toString();
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
