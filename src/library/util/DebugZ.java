package library.util;

import java.util.Arrays;
import java.util.Collection;

public class DebugZ {
	public static String collectionStringRepresentation(Collection c){
		StringBuilder fin = new StringBuilder();
		fin.append("[");
		boolean first = true;
		for (Object e: c){
			if (first) first = false;
			else fin.append(", ");
			fin.append(stringRepresentation(e) );
		}
		fin.append("]");
		return fin.toString();

	}
	public static String stringRepresentation(Object a){
		return stringRepresentation(new Object[]{a});
	}
	public static String stringRepresentation(Object[] objects){
		StringBuilder fin = new StringBuilder();
		for (int i = 0; i < objects.length; i++){
			if (i != 0) fin.append(", ");
			Object cur = objects[i];
			if (cur instanceof int[]){
				int[] q = (int[])cur;
				fin.append(Arrays.toString(q) );
			}
			else if (cur instanceof long[]){
				long[] q = (long[])cur;
				fin.append(Arrays.toString(q) );
			}
			else if (cur instanceof double[]){
				double[] q = (double[])cur;
				fin.append(Arrays.toString(q) );
			}
			else if (cur instanceof boolean[]){
				boolean[] q = (boolean[])cur;
				fin.append(booleanArrayToString(q) );
			}
			else if (cur instanceof char[]){
				char[] q = (char[])cur;
				fin.append(Arrays.toString(q) );
			}
			else if (cur instanceof float[]){
				float[] q = (float[])cur;
				fin.append(Arrays.toString(q) );
			}
			else if (cur instanceof short[]){
				short[] q = (short[])cur;
				fin.append(Arrays.toString(q) );
			}
			else if (cur instanceof byte[]){
				byte[] q = (byte[])cur;
				fin.append(Arrays.toString(q) );
			}
			else if (cur instanceof Object[]){
//				System.out.println("hit " + Arrays.deepToString((Object[])cur));
				fin.append("[" + stringRepresentation((Object[]) cur)+"]" );
			}
			else if (cur instanceof Collection){
				fin.append(collectionStringRepresentation((Collection) cur));
			}
			else {
				fin.append(cur.toString());
			}
		}
		return fin.toString();
	}
	public static String booleanArrayToString(boolean[] l1){
		StringBuilder fin = new StringBuilder();
		fin.append("[");
		for (int i = 0 ; i < l1.length; i++){
			if (i != 0) fin.append(", ");
			if (l1[i]){
				fin.append("T");
			}
			else {
				fin.append("F");
			}
		}
		fin.append("]");
		return fin.toString();
	}
	public static String doubleArrayToString(double[] l1){
		StringBuilder fin = new StringBuilder();
		fin.append("[");
		for (int i = 0 ; i < l1.length; i++){
			if (i != 0) fin.append(", ");
			fin.append(String.format("%.5f", l1[i]));
		}
		fin.append("]");
		return fin.toString();
	}
	public static void print(Object ... objects){
//		System.out.println(Arrays.deepToString(objects));
//		Object[] l = new Object[objects.length];
		String temp = stringRepresentation(objects);
		System.out.println("___DEBUG: " + temp);
	}

}
