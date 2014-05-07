package library.datastructures;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Heavily object-oriented implementation (and hence slow when
 * compared with the primitive-array-based implementation).
 * Good for situations where alternative solutions are 
 * complicated/long to code and the problem constraint is loose.
 */
public class GeneralDisjoinUnionSet<E> {
		public HashMap<E, Integer> mapping = new HashMap();
		public ArrayList<E> value = new ArrayList();
		public IntList p = new IntList();
		public IntList size = new IntList();
		public int n = 0;

		public void add(E k1) {
			if (!mapping.containsKey(k1)) {
				mapping.put(k1, n);
				value.add(k1);
				p.add(n);
				size.add(1);
				n++;
			}
		}

		public int find(int x) {
			if (p.get(x) == x)
				return x;
			else
				return find(p.get(x));
		}

		public void union(E k1, E k2) {
			if (!mapping.containsKey(k1)) add(k1);
			if (!mapping.containsKey(k2)) add(k2);
			int s1 = mapping.get(k1);
			int s2 = mapping.get(k2);
			int r1 = find(s1);
			int r2 = find(s2);
			if (r1 == r2) return;
			if (size.get(r1) >= size.get(r2)) {
				size.set(r1, size.get(r1) + size.get(r2));
				p.set(r2, r1);
			}
			else {
				size.set(r2, size.get(r1) + size.get(r2));
				p.set(r1, r2);
			}
		}

		public void debugPrint() {
			System.out.println("value\n" + value);
			System.out.println("p\n" + p);
			System.out.println("size\n" + size);
		}

		
		public HashMap<Integer, ArrayList<E>> partitions() {
			HashMap<Integer, ArrayList<E>> temp1 = new HashMap();
			for (int i = 0; i < p.size(); i++) {
				int classNo = find(i);
				if (!temp1.containsKey(classNo))
					temp1.put(classNo, new ArrayList());
				ArrayList curList = temp1.get(classNo);
				curList.add(value.get(i));
			}
			return temp1;
		}
	}