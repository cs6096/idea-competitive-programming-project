package codeforces._244_2;

import library.io.InputReader;
import library.io.OutputWriter;
import java.util.*;
import java.math.*;
import java.io.*;
public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    int n = in.nextInt();
	    int t = in.nextInt();
	    int c = in.nextInt();
	    int [] l1 = in.nextIntArray(n);
	    int[] count = new int[n + 1];
	    for (int i = 0 ; i < n; i++){
		    if (l1[i] > t){
			    count[i + 1] = 1;
		    }
	    }
	    for (int i = 0 ; i < count.length; i++){
		    if (i > 0)count[i] +=count[i - 1];
	    }
	    int ans = 0;
	    for (int i = 0; i < n - c + 1; i++){
		    int temp = count[i + c] - count[i];
		    if (temp == 0){
			    ans ++;
		    }
	    }

	    out.printLine(ans);
    }

}
