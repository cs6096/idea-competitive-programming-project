package library.datastructures;

public class RangeMinimalQueryNodeVer {
	
	public static int assoc(int n1, int n2){
		return Math.min(n1, n2);
	}
	public static int NULLVAL = Integer.MAX_VALUE;
	public class N {
		N parent = null;
		N q1 = null, q2 = null;
		int left = 0;
		int right = 0;
		int val = 0;

		void generate() {
			if (left == right) {
				unit[left] = this;
				return;
			}
			int len = right - left + 1;
			int half = len >> 1;
			q1 = new N();
			q1.left = left;
			q1.right = left + half - 1;
			q1.parent = this;
			q2 = new N();
			q2.left = left + half;
			q2.right = right;
			q2.parent = this;
			q1.generate();
			q2.generate();
		}

		void refresh() {
			val = assoc(q1.val,q2.val);
			if (parent != null) parent.refresh();
		}
		

		public int find(int fleft, int fright) {
			// px("find",left,right,fleft,fright);
			if (fleft <= left && fright >= right) return val;
			int res = NULLVAL;
			if (fleft <= q1.right) res = assoc(res, q1.find(fleft, fright));
			if (fright >= q2.left) res = assoc(res, q2.find(fleft, fright));
			return res;
		}
	}
	
	N root = null;
	int size = 0;
	N[] unit = null;
	public RangeMinimalQueryNodeVer(int n1) {
		size = n1;
		root = new N();
		root.left = 0;
		root.right = size - 1;
		unit = new N[size];
		root.generate();
	}
	void set(int idx, int k1){
		unit[idx].val = k1;
		if (unit[idx].parent != null)unit[idx].parent.refresh();
	}
	public int find(int fleft, int fright) {
		return root.find(fleft, fright);
	}
}