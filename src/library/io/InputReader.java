package library.io;

import java.util.*;
import java.io.*;
import java.math.*;

public class InputReader {
	private BufferedReader in = null;
	private StringTokenizer st = null;

	public InputReader(InputStream usingStream) {
		in = new BufferedReader(new InputStreamReader(usingStream));

	}
	public String next(){
		for (;st == null || !st.hasMoreTokens();){
			String currentLine = null;
			try {
				currentLine = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (currentLine == null) return null;
			st = new StringTokenizer(currentLine);
		}
		return st.nextToken();
	}
	public int nextInt(){
		return Integer.parseInt(next());
	}
	public long nextLong(){
		return Long.parseLong(next());
	}
	public double nextDouble(){
		return Double.parseDouble(next());
	}
	public int[] nextIntArray(int len){
		int[] fin = new int[len];
		for (int i = 0 ; i < len; i++){
			fin[i] = nextInt();
		}
		return fin;
	}
	public double[] nextDoubleArray(int len){
		double[] fin = new double[len];
		for (int i = 0 ; i < len; i++){
			fin[i] = nextDouble();
		}
		return fin;
	}
	public long[] nextLongArray(int len){
		long[] fin = new long[len];
		for (int i = 0 ; i < len; i++){
			fin[i] = nextLong();
		}
		return fin;
	}

}
