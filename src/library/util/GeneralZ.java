package library.util;

import java.util.Arrays;

public class GeneralZ {
	public static char[][] toGrid(String[] a){
		char[][] fin = new char[a.length][];
		for (int i = 0; i < a.length; i++){
			fin[i] = a[i].toCharArray();
		}
		return fin;
	}
	public static int[] toNumberArray(String a){
		int[] fin = new int[a.length()];
		for (int i = 0; i  < a.length(); i++){
			fin[i] = a.charAt(i) - '0';
		}
		return fin;
	}
	public static int[] toNumberArray(char[] a){
		int[] fin = new int[a.length];
		for (int i = 0; i  < a.length; i++){
			fin[i] = a[i] - '0';
		}
		return fin;
	}
	public static void px(Object ... objects){
		System.out.println(Arrays.deepToString(objects));
	}
}
