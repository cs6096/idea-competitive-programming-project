package topcoder;
import library.util.DebugZ;

import java.util.*;
import java.math.*;
public class Suminator {
    public int findMissing(int[] program, int wantedResult) {
	    int[] copy = program.clone();
	    for (int i = 0 ; i  < copy.length; i++){
		    if (copy[i] == -1) copy[i] = 0;
	    }
	    {
		    ArrayDeque<Long> q = new ArrayDeque<Long>();
		    for (long e: copy){
			    if (e == 0){
				    if (q.size() >= 2){
					   long a = q.removeLast();
					    long b=  q.removeLast();
					    q.add(a + b);
				    }
			    }
			    else q.add(e);
		    }
		    if (q.size() == 0){
			    if (wantedResult == 0){
				    return 0;
			    }
		    }
		    else {
			    if (wantedResult == q.removeLast()) return 0;
		    }
	    }
	    ArrayDeque<long[]> stk = new ArrayDeque();
	    for (int i = 0 ; i < program.length; i++){
		    if (program[i] == 0){
			    if (stk.size() >= 2){
				    long[] a = stk.removeLast();
				    long[] b = stk.removeLast();
				    long[] c = add(a, b);
				    stk.add(c);
			    }
		    }
		    else {
			    if (program[i] == -1){
				    stk.add(new long[]{0, 1});
			    }
			    else {
				    stk.add(new long[]{program[i], 0});
			    }
		    }
//		    DebugZ.print(stk);
	    }

	    if (stk.size() == 0){
		    if (wantedResult == 0){
			    return 0;
		    }
		    else {
			    return -1;
		    }
	    }
	    else {
		    long[] last = stk.removeLast();
		    if (last[1] == 0){
			    if (last[0] == wantedResult){
				    return 1;
			    }
			    return -1;
		    }
		    else {
			    if (last[0] + 1l <= wantedResult){
				    return wantedResult - (int)last[0];
			    }
			    else return -1;
		    }
	    }
    }
	public long[] add(long[] a, long[] b){
		return new long[]{a[0] + b[0], b[1] + a[1]};
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
