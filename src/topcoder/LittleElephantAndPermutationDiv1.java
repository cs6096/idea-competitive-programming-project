package topcoder;
import library.iterator.FullPermutation;

import java.util.*;

public class LittleElephantAndPermutationDiv1 {
	public static long MOD = (long)1e9 + 7l;
    public int getNumber(int N, int K) {
	    int[] order = new int[5];
	    for (int i = 0 ; i < 5; i++) order[i] = i;
	    int[][] fin = new int[120][];
	    int ptr = 0;
	    for (int[] e: FullPermutation.instance(5)){

		    fin[ptr++] =e.clone();
	    }

	    Arrays.sort(fin, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
			    return val(o1) - val(o2);
		    }
	    });

	    for (int[] e: fin){
//		    px(val(e), order);
		    px(val(e), e);
	    }
	    return 0;

//        return (int) fin;
    }
	public static int val(int[] l1){
		int fin =0 ;
		for (int i = 0; i  <l1.length; i++){
			fin += Math.max(i + 1, l1[i] + 1);
		}
		return fin;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
