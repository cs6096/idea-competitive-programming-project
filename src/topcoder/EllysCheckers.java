package topcoder;
import library.util.BitZ;

import java.util.*;
import java.math.*;
public class EllysCheckers {
	int WIN = 1;
	int LOSE = 2;
	int n = 0;
    public String getWinner(String board) {
	    n = board.length();
	    state[0] = LOSE;
	    int start = 0;
	    for (int i = 0;  i < board.length() - 1; i++){
		    if (board.charAt(i) == 'o'){
			    start |= (1 << i);
		    }
	    }
        return find(start) == WIN ? "YES" : "NO";
    }
	public int[] state = new int[(1 << 20) + 10];
	public int find(int toFind){
		if (state[toFind] != 0) return state[toFind];
		int fin = LOSE;
		for (int i = 0; i < n - 1; i++){
			if (i == n - 2){
				if (BitZ.hasBitAt(toFind, i)){
					int cur = (int) BitZ.removeBitAt(toFind, i);
					if (find(cur) == LOSE){
						fin = WIN;
					}
				}
			}
			else if (BitZ.hasBitAt(toFind, i) && !BitZ.hasBitAt(toFind, i + 1)){
				int cur = (int) BitZ.removeBitAt(toFind, i);
				cur = (int)BitZ.addBitAt(cur, i + 1);
				if (find(cur) == LOSE){
					fin = WIN;
				}
			}
		}
		for (int i = 0; i < n - 1 - 2; i++){
			if (BitZ.hasBitAt(toFind, i) && BitZ.hasBitAt(toFind, i + 1) && BitZ.hasBitAt(toFind, i + 2) ){
				if (i == n - 4){
					if (find((int) BitZ.removeBitAt(toFind, i)) == LOSE){
						fin = WIN;
					}
				}
				else {
					if (!BitZ.hasBitAt(toFind, i + 3)){
						long cur = BitZ.removeBitAt(toFind, i);
						cur = BitZ.addBitAt(cur, i + 3);
						if (find((int) cur) == LOSE) fin = WIN;
					}
				}
			}
		}
		state[toFind] = fin;
		return fin;
	}

	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
