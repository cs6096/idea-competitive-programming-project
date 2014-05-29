package testing;

import library.io.InputReader;
import library.io.OutputWriter;
import library.util.BitZ;
import library.util.DebugZ;
import library.util.StringZ;

import java.util.ArrayList;
import java.util.Arrays;

public class MainTest {
	public static InputReader in = new InputReader(System.in);
	public static OutputWriter out = new OutputWriter(System.out);
	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 10; i++){
			System.out.println(fib(i));
		}


	}
	public static long[] dp = new long[100];
	public static long fib(int n1){
		if (n1 == 1) return 1;
		if (n1 == 2) return 1;
		if (dp[n1] != 0) return dp[n1];
		long fin = fib(n1 -1 ) + fib(n1 - 2);
		dp[n1] = fin;
		return fin;
	}
}

