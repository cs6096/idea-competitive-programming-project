package library.util;
import java.util.Arrays;

public class CombinationZ {
		private static int greyCode(int n1){
			return n1 ^ (n1 >> 1);
		}

		public static boolean nextComb(int[] l1, int cap){
			for (int ptr = l1.length-1;;){
				if (ptr < 0) return false;
				if (l1[ptr] == cap - 1){
					l1[ptr] = 0;
					ptr--;
				}
				else {
					l1[ptr]++;
					break;
				}
			}
			return true;
		}

		public static void swap(int[] l1, int a, int b){
			int k1 = l1[a];l1[a]=l1[b];l1[b]=k1;
		}
		public static void rev(int[] l1, int a, int b){
			for (int i = 0; i < (b-a+1)/2;i++) swap(l1,a+i,b-i);
		}
		public static boolean nextPerm(int[] l1) {
			for (int i = l1.length- 2; i >=0; i--) {
				if (l1[i] < l1[i + 1]){
					for (int k = l1.length - 1; k>=0;k--){
						if (l1[k]>=l1[i]){
							swap(l1,i,k);
							rev(l1,i+1,l1.length-1);
							return true;
						}
					}
				}
			}
			rev(l1,0,l1.length-1);
			return false;
		}

		public static int[] permInv(int[] l1){
			int[] fin = new int[l1.length];
			for (int i = 0; i< l1.length;i++){
				fin[l1[i]]=i;
			}
			return fin;
		}
		
	}