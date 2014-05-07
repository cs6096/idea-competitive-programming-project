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
}
