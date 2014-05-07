package topcoder;
import library.datastructures.IntList;
import library.util.ArrayZ;
import library.util.BitZ;

import java.util.*;

public class ICPCBalloons {
    public int minRepaintings(int[] balloonCount, String balloonSize, int[] need) {
	    IntList w1 = new IntList();
	    IntList w2 = new IntList();


	    for (int i = 0 ; i < balloonSize.length(); i ++){
		    if (balloonSize.charAt(i) == 'M') w1.add(balloonCount[i]);
		    else w2.add(balloonCount[i]);
	    }

	    w1.sortDescend();
	    w2.sortDescend();
	    long w1t = w1.sum();
	    long w2t = w2.sum();

	    Arrays.sort(need);
	    ArrayZ.reverse(need);

//	    px(w1);
//	    px(w2);

	    int ans = Integer.MAX_VALUE;

	    for (int mask = 0; mask < (1 << need.length); mask++){
		    int[] q1 = new int[16], q2 = new int[16];
		    int s1 = 0 , s2 = 0;
		    for (int i = 0 ; i < need.length; i++) if (BitZ.hasBitAt(mask, i)) q1[s1++] = need[i]; else q2[s2++] = need[i];
		    int t1 = 0, t2 = 0;
		    q1 = Arrays.copyOf(q1, s1); q2 = Arrays.copyOf(q2, s2);
		    if (ArrayZ.sum(q1) > w1t) continue;
		    if (ArrayZ.sum(q2) > w2t) continue;
//		    px(BitZ.binString64(mask));
		    int cur = 0;
		    for (int i = 0; i < s1; i++) if (i >= w1.size()) cur += q1[i]; else if (w1.get(i) < q1[i]) cur += q1[i] - w1.get(i);
		    for (int i = 0 ; i < s2; i++) if (i >= w2.size()) cur += q2[i]; else if (w2.get(i) < q2[i]) cur += q2[i] - w2.get(i);
		    ans = Math.min(ans, cur);
	    }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}


