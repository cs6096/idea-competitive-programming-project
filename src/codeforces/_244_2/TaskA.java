package codeforces._244_2;

import library.io.InputReader;
import library.io.OutputWriter;
import java.util.*;
import java.math.*;
import java.io.*;
public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    int n1 = in.nextInt();
	    int[] l1 = in.nextIntArray(n1);
	    int crime = 0;
	    int rec = 0;

	    int ans = 0;
	    for (int e: l1){
		    if (e < 0){
			    if (rec > 0){
				    rec--;
			    }
			    else ans++;
		    }
		    else {
			    rec+= e;
		    }
	    }
	    out.printLine(ans);
    }
}
