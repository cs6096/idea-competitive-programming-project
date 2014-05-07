package codeforces._244_2;

import library.datastructures.IntList;
import library.io.InputReader;
import library.io.OutputWriter;

public class TaskD {
	public static char[] sa = null;
	public static char[] sb = null;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    sa = in.next().toCharArray();
	    sb = in.next().toCharArray();
	    Trie ta = new Trie();
	    for (int i = 0; i < sa.length; i++){
		    ta.add(sa, i, 0);
	    }
	    Trie tb = new Trie();
	    for (int i = 0; i < sb.length; i++){
		    tb.add(sb, i, 0);
	    }
	    int ans = Integer.MAX_VALUE;
//	    DebugZ.print(Arrays.toString(sb));
	    IntList temp1 = new IntList();
	    IntList temp2 = new IntList();
//	    DebugZ.print(ta.countList);
//	    DebugZ.print(tb.countList);
	    for (int i = 0; i < sb.length; i++){
		    temp1.size = 0;
		    temp2.size = 0;
		    ta.walkMin(sb, i, temp1);
		    tb.walkMin(sb, i, temp2);
//		    DebugZ.print(i);
//		    DebugZ.print(temp1);
//		    DebugZ.print(temp2);

		    for (int e: temp1){
			    if (temp2.binarySearch(e) >= 0){
				    ans = Math.min(e, ans);
			    }
		    }
//		    ans = Math.min(ans, Math.max(k1, k2));
//		    DebugZ.print(ans, k1, k2);
//		    DebugZ.print(i, ans, ta.walkMin(sb, i));
	    }


	    out.printLine(ans == Integer.MAX_VALUE ? -1 : ans);

    }
	public static class Trie {
		public IntList nodeList = new IntList();
		public Trie(){
			for (int i = 0; i < 27; i++){
				nodeList.add(0);
			}
		}
		public void add(char[] l1, int idx, int at){
			if (idx >= l1.length) return;

			if (nodeList.get(at + l1[idx] - 'a') == 0){
				nodeList.set(at + l1[idx] - 'a', nodeList.size);
				for (int i = 0; i < 27; i++){
					nodeList.add(0);
				}
			}
			int nextPtrIdx = nodeList.get(at + l1[idx] - 'a');
			nodeList.inc(nextPtrIdx + 26, 1);
			add(l1, idx + 1, nextPtrIdx);
//			DebugZ.print("aaa", l1[idx], idx,at, countList.get(at));
		}
		public void walkMin(char[] l1, int start, IntList fin){
			int at = 0;
			int size = 0;
			for (int i = 0; i + start < l1.length; i++){
				int to = l1[start + i] -'a';
				int nextNode = nodeList.get(at + to);
				if (nextNode == 0) break;
//				DebugZ.print(i, l1[start + i], to, countList.get(at) );
				at = nextNode;
				if (nodeList.get(at + 26) == 1){
					fin.add(i + 1);
				}
			}
		}
	}

}

