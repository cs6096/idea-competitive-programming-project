package codeforces;



import library.datastructures.IntList;
import library.io.InputReader;
import library.io.OutputWriter;
import library.util.DebugZ;
import library.util.NumberTheoryZ;

import java.util.*;
import java.math.*;
import java.io.*;

public class PrimeSwaps {
	int n1 = 0;
	int[] l1 = null;
	int[] at = null;
	IntList primes = NumberTheoryZ.sieve( 100000 );
	IntList resLeft = new IntList(  );
	IntList resRight = new IntList(  );
	void swap(int i, int j){
		if (i > j){
			int t = j;
			j = i;
			i = t;
		}
		int val1 = l1[j];
		int val2 = l1[i];
		l1[i] = val1;
		l1[j] = val2;
		at[l1[i]] = i;
		at[l1[j]] = j;
		resLeft.add( i );
		resRight.add( j );
	}
	public int dist(int i, int j){
		return Math.abs(  i - j  ) + 1;
	}
	public void part(int dist){
		for (int e: primes){
			if (primes.binarySearch( dist - e ) >= 0){
				aa = e;
				bb = dist - e;
				break;
			}
		}
	}
	int aa = 0;
	int bb = 0;
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		n1 = in.nextInt();
		l1 = new int[n1];
		at = new int[n1];
		for (int i = 0 ; i < n1; i++){
			l1[i] = in.nextInt() - 1;
			at[l1[i]] = i;
		}
		for (int i = 0 ; i < n1; i++){
//			DebugZ.print(l1);
			if (at[i] == i) continue;
			if (primes.binarySearch( dist(at[i], i) ) >= 0  || dist(at[i], i) == 1){
				swap(i, at[i]);
			}
			else {
				for (; ;){
					if ((dist(at[i],i) + 1) % 2 == 0) break;
					if (at[i] + 1 >= 0 && at[i] + 1 < n1){
						swap(at[i], at[i] + 1);
					}
					else {
						swap(at[i], at[i] - 1);
					}
				}
				part((dist(at[i],i) + 1));
				swap(at[i] - (aa - 1), at[i]);
				swap(at[i] - (bb - 1), at[i]);
			}

		}
//		DebugZ.print(l1);

		out.printLine( resLeft.size() );
		for (int i = 0;  i< resLeft.size(); i++){
			out.printLine( resLeft.get( i )  + 1, resRight.get( i ) + 1 );
		}
	}
}
