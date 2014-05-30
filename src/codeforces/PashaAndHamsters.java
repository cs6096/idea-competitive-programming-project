package codeforces;

import library.io.InputReader;
import library.io.OutputWriter;
import java.util.*;
import java.math.*;
import java.io.*;
public class PashaAndHamsters {
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
