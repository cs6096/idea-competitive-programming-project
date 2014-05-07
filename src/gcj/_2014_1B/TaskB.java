package gcj._2014_1B;

import library.io.InputReader;
import library.io.OutputWriter;
import library.util.BitZ;
import library.util.DebugZ;

import java.util.*;
import java.math.*;
import java.io.*;
public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    long a = in.nextLong();
	    long b = in.nextLong();
	    long c = in.nextLong();
	    DebugZ.print(testNumber);
	    DebugZ.print(BitZ.binString64(a));
	    DebugZ.print(BitZ.binString64(b));
	    DebugZ.print(BitZ.binString64(c));

	    out.printLine("Case #" + testNumber + ": ");
    }

}
