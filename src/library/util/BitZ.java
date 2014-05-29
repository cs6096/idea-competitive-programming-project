
package library.util;

import java.util.*;


public class BitZ {
	public static long addBitAt(long set, int idx){
		return set | (1l << idx);
	}
	public static long removeBitAt(long set, int idx){
		return set & ~(1l << idx);
	}
	public static boolean hasBitAt(long set, int idx){
		return (set & (1 << idx)) != 0;
	}
	public static int size(long set){
		return Long.bitCount(set);
	}
	public static String binString64(long n1){
		return String.format("%64s", Long.toBinaryString(n1)).replace(' ', '0');
	}
	public static String binString(long n1, int len){
		return String.format("%"+len + "s", Long.toBinaryString(n1)).replace(' ', '0');
	}
}
