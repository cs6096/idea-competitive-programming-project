package library.datastructures;
import java.util.*;
public class CountingSet <E> {
	Map<E, Integer> m1 = new HashMap();
	void add(E o1, int n1){
		m1.put(o1, m1.containsKey(o1) ? m1.get(o1)+n1 : n1);
	}
	int get(E o1){
		return m1.get(o1) == null ? 0 : m1.get(o1);
	}
	Map<Integer, ArrayList<E>> reverse(){
		Map<Integer,ArrayList<E>> fin = new HashMap();
		for (E e: m1.keySet()){
			int cur = m1.get(e);
			ArrayList<E> cur2 = fin.get(cur);
			if (cur2 == null) cur2 = new ArrayList();
			cur2.add(e);
			fin.put(cur, cur2);
		}
		return fin;
	}
}
