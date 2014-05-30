import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Sheng Cao
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		PashaAndHamsters solver = new PashaAndHamsters();
		solver.solve(1, in, out);
		out.close();
	}
}

class PashaAndHamsters {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n1 = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] l1 = in.nextIntArray(a);
        int[] l2 = in.nextIntArray(b);
        int[] fin = new int[n1];
        for (int e: l1){
            if (fin[e - 1] == 0){
                fin[e - 1] = 1;
            }
        }
        for (int e: l2) if (fin[e - 1] == 0) fin[e - 1] = 2;

        for (int e: fin) out.print(e + " ");
        out.printLine();
    }
}

class InputReader {
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

    public int[] nextIntArray(int len){
		int[] fin = new int[len];
		for (int i = 0 ; i < len; i++){
			fin[i] = nextInt();
		}
		return fin;
	}

}

class OutputWriter {
	private PrintWriter usingPrintWriter = null;

	public OutputWriter(OutputStream usingStream){
		usingPrintWriter = new PrintWriter(usingStream);
	}
	public OutputWriter(Writer usingWriter){
		usingPrintWriter = new PrintWriter(usingWriter);
	}
	public void print(Object... l1){
		for (int i = 0;i < l1.length; i++){
			if (i != 0) usingPrintWriter.print(" ");
			usingPrintWriter.print(l1[i]);
		}
	}
	public void printLine(Object... l1){
		for (int i = 0;i < l1.length; i++){
			if (i != 0) usingPrintWriter.print(" ");
			usingPrintWriter.print(l1[i]);
		}
		usingPrintWriter.println();
	}
	public void flush(){
		usingPrintWriter.flush();
	}
	public void close(){
		flush();
		usingPrintWriter.close();
	}
}

