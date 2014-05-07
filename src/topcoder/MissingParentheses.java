package topcoder;
import java.util.*;
import java.math.*;
public class MissingParentheses {
    public int countCorrections(String par) {
	    int l = 0;
	    int ans = 0;
	    for (char e: par.toCharArray() ){
		    if (e == '('){
			    l++;
		    }
		    else {
			    if (l == 0){
				    ans++;
			    }
			    else l--;
		    }
	    }
        return ans + l;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
