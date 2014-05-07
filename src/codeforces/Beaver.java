package codeforces;



import library.datastructures.IntList;
import library.io.InputReader;
import library.io.OutputWriter;
import library.util.ArrayZ;
import library.util.StringZ;

import java.util.ArrayList;
import java.util.Collections;

public class Beaver {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		String l1 = in.next();
		int n1 = in.nextInt();

		ArrayList<int[]> toInsertList = new ArrayList();

		for (int i = 0 ; i < n1; i++){
			String cur = in.next();
			IntList q = StringZ.allSubstringStartingIndex(l1, cur);
//			DebugZ.print(q);
			for (int e: q){
				int[] temp = new int[]{e, e + cur.length() - 1};
				toInsertList.add(temp);
			}

		}
		Collections.sort(toInsertList, new ArrayZ.CustomIntArrayComparator(1));
		int bestLength = 0;
		int bestStart = 0;
//		DebugZ.print(toInsertList);
		int ptr = 0;
		int temp = -1;
		for (int i = 0; i < l1.length(); i++){
			for (;ptr < toInsertList.size();){
				if (toInsertList.get(ptr)[1] <= i){
					temp = Math.max(temp, toInsertList.get(ptr)[0]);
					ptr++;
				}
				else break;
			}
			int curLen = i - temp;
//			DebugZ.print(curLen);
			if (curLen > bestLength){
				bestLength = curLen;
				bestStart = temp + 1;
			}
		}
		out.printLine(bestLength,bestStart);
	}
}
