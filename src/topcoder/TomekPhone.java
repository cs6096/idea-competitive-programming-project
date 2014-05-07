package topcoder;
import java.util.*;
import java.math.*;
public class TomekPhone {
	public void rev(int[] a){
		for (int i = 0 ; i < a.length / 2; i++){
			int t = a[i];
			a[i] = a[a.length - 1- i];
			a[a.length - 1- i] = t;
		}
	}
    public int minKeystrokes(int[] frequencies, int[] keySizes) {
	    int t = 0;
	    for (int e: keySizes) t += e;
	    if (frequencies.length > t) return -1;
	    int[] a = new int[keySizes.length];
	    Arrays.sort(frequencies);
	    rev(frequencies);
	    Arrays.sort(a);
	    rev(keySizes);
	    int ff = 0;
	    int ptr = 0;

//	    px(frequencies);
	    for (int e: frequencies){
		    for (;;){
			    if (a[ptr] >= keySizes[ptr]) {
				    ptr = (ptr + 1) % keySizes.length;
				    continue;
			    }
			    a[ptr]++;
			    ff += e * a[ptr];
			    ptr = (ptr + 1) % keySizes.length;
			    break;
		    }
//		    px(a, keySizes);
	    }
        return ff;
    }
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
