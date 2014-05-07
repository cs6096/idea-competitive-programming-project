package library.util;
import java.util.Random;

public class ShuffleZ {
		private static Random r1 = new Random();

		public static void ints(int[] l1) {
			for (int i = 0; i < l1.length; i++) {
				int k1 = i + r1.nextInt(l1.length - i);
				int temp = l1[i];
				l1[i] = l1[k1];
				l1[k1] = temp;
			}
		}

		public static void ints(int[] l1, int n1, int n2) {
			for (int i = 0; i < n2 - n1; i++) {
				int k1 = i + r1.nextInt(n2 - n1 - i);
				int temp = l1[i + n1];
				l1[i + n1] = l1[k1 + n1];
				l1[k1 + n1] = temp;
			}
		}

		public static void longs(long[] l1) {
			for (int i = 0; i < l1.length; i++) {
				int k1 = i + r1.nextInt(l1.length - i);
				long temp = l1[i];
				l1[i] = l1[k1];
				l1[k1] = temp;
			}
		}
		
		public static void longs(long[] l1, int n1, int n2) {
			for (int i = 0; i < n2 - n1; i++) {
				int k1 = i + r1.nextInt(n2 - n1 - i);
				long temp = l1[i + n1];
				l1[i + n1] = l1[k1 + n1];
				l1[k1 + n1] = temp;
			}
		}

		public static void doubles(double[] l1) {
			for (int i = 0; i < l1.length; i++) {
				int k1 = i + r1.nextInt(l1.length - i);
				double temp = l1[i];
				l1[i] = l1[k1];
				l1[k1] = temp;
			}
		}
		public static void doubles(double[] l1, int n1, int n2) {
			for (int i = 0; i < n2 - n1; i++) {
				int k1 = i + r1.nextInt(n2 - n1 - i);
				double temp = l1[i + n1];
				l1[i + n1] = l1[k1 + n1];
				l1[k1 + n1] = temp;
			}
		}
	}