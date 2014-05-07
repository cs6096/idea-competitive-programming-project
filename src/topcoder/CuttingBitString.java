package topcoder;
import java.util.*;
import java.math.*;
public class CuttingBitString {
	public boolean pow5(BigInteger n1){
		for (;;){
			if (n1.equals(BigInteger.ONE)) return true;
			else if (n1.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO)){
				n1 = n1.divide(BigInteger.valueOf(5));
			}
			else return false;
		}
	}
    public int getmin(String S) {
	    char[] l1 = S.toCharArray();
	    ArrayList<Integer>[] al = new ArrayList[S.length() + 1];
	    for (int i = 0; i < al.length; i++){
		    al[i] = new ArrayList();
	    }
	    for (int i = 0 ; i < S.length(); i++){
		    for (int j = i + 1; j<= S.length(); j++){
			    String temp = S.substring(i, j);
			    if (temp.charAt(0) == '1'){
				    BigInteger cur = new BigInteger(temp, 2);
				    if (pow5(cur)){
					    al[i].add(j);
				    }
			    }
		    }
	    }
//	    px(al);
	    int[] dp = new int[S.length() + 1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;
	    for (int i = 0 ; i < S.length(); i++){
		    if (dp[i] == Integer.MAX_VALUE) continue;
		    for (int e: al[i]){
			    dp[e] = Math.min(dp[e], dp[i] + 1);
		    }
//		    px(dp);
	    }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
