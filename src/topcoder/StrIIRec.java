package topcoder;

import java.util.*;
import java.math.*;

public class StrIIRec {
	public String recovstr(int n, int minInv, String minStr) {
		int[] minList = new int[minStr.length()];
		for (int i = 0; i < minStr.length(); i++) {
			minList[i] = minStr.charAt(i) - 'a';
		}
		int cur = 0;
		boolean same = true;
		String f = "";
		ArrayList<Integer> ex = new ArrayList();
		for (int i = 0 ; i < n; i++) ex.add(i);
		for (int i = 0; i < n; i++) {
			if (i >= minList.length) same = false;
			for (int curIndex = 0; curIndex < ex.size(); curIndex++) {
				int curVal = ex.get(curIndex);
				if (!(same && curVal < minList[i]) ){
//					px(i,e, cur + j + total(n - 1 - i));
					if (cur + curIndex + total(n - 1 - i) >= minInv) {
						f += (char) ('a' + curVal);
						ex.remove((Integer)curVal);
						cur += curIndex;
						if (same) if (curVal != minList[i]) { same = false; }
						break;
					}
				}
			}
		}


		return f;
	}

	public int total(int a) {
		return (a - 1) * a / 2;
	}

	public static void px(Object... objects) {
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
