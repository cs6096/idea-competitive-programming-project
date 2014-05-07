package library.io;

import java.io.*;

public class OutputWriter {
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
