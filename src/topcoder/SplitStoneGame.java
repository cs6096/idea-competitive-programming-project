package topcoder;
import java.util.*;

public class SplitStoneGame {
    public String winOrLose(int[] number) {
	    int dead = 0;
	    int alive = 0;
	    for (int e: number) if (e == 1) dead++; else alive++;
        return canWin(dead, alive) ? "WIN" : "LOSE";
    }
	public int[][] canWinResult = new int[100][100];
	public boolean canWin(int dead, int alive){
		if (canWinResult[dead][alive] != 0) return canWinResult[dead][alive] == 1;

		if (alive <= 0)  return false;
		boolean canWin = false;
		int newAliveNumber = alive - 1;
		{
			int a = dead - 2;
			int b = newAliveNumber + 2;
			if (a >= 0) if (canWin(a, b) == false) canWin = true;
		}
		if (newAliveNumber >= 1){
			int a = dead - 1;
			int b = newAliveNumber + 1;
			if (a >= 0) if (canWin(a, b) == false) canWin = true;
		}
		if (newAliveNumber >= 2){
			int a = dead;
			int b = newAliveNumber;
			if (canWin(a, b) == false) canWin = true;
		}
		if (canWin) canWinResult[dead][alive] = 1;
		else canWinResult[dead][alive] = -1;
		return canWin;
	}
	public static void px(Object ... objects){
		String temp = Arrays.deepToString(objects);
		temp = temp.substring(1, temp.length() - 1);
		System.out.println("DEBUG: " + temp);
	}
}
