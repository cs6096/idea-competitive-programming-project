package library.util;
import library.datastructures.IntList;

import java.util.*;
import java.io.*;
import java.math.*;

public class StringZ {
	public static boolean isSubsequence(CharSequence checking, CharSequence pattern){
		int ptr = 0;
		for (int i =0; i < checking.length(); i++){
			if (ptr >= pattern.length()) break;
			if (checking.charAt(i) == pattern.charAt(ptr)){
				ptr++;
			}
		}
		return ptr == pattern.length();
	}
	public static IntList allSubstringStartingIndex(String original, String checking){
		IntList fin = new IntList();
		int ptr = 0;
		for (;ptr < original.length();){
			int cur = original.indexOf(checking, ptr);
			if (cur < 0) break;
			fin.add(cur);
			ptr = cur + 1;
		}
		return fin;
	}

	public static int[] z(char[] l1){
		int[] fin = new int[l1.length];
		int front = 0;
		for (int i = 0 ; i < l1.length; i++){
			for (;;){
				if (i + fin[i] >= fin.length) break;
				if (l1[fin[i]] == l1[i + fin[i]]){
					fin[i]++;
				}
				else break;
			}
			front = Math.max( front, i );
			for (;;){
				if (front >= fin.length) break;
				int shift = front - i;
				if (shift > i) break;
				if (shift >= fin[i]) break;
				fin[front] = Math.max( fin[front], Math.min(fin[shift], fin[i] - shift) );
				front++;
			}
		}
		return fin;
	}
}
