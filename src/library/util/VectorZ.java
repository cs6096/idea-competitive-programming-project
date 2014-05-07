package library.util;
public class VectorZ {
		public static int[] add(int[] l1, int[] l2){
			int[] fin = new int[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] + l2[i];
			}
			return fin;
		}
		public static long[] add(long[] l1, long[] l2){
			long[] fin = new long[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] + l2[i];
			}
			return fin;
		}
		public static double[] add(double[] l1, double[] l2){
			double[] fin = new double[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] + l2[i];
			}
			return fin;
		}
		public static int[] diff(int[] l1, int[] l2){
			int[] fin = new int[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] - l2[i];
			}
			return fin;
		}
		public static long[] diff(long[] l1, long[] l2){
			long[] fin = new long[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] - l2[i];
			}
			return fin;
		}
		public static double[] diff(double[] l1, double[] l2){
			double[] fin = new double[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] - l2[i];
			}
			return fin;
		}
		public static void addAll(int[] l1, int n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] += n1;
			}
		}
		public static void addAll(long[] l1, long n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] += n1;
			}
		}
		public static void addAll(double[] l1, double n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] += n1;
			}
		}
		public static void timesAll(int[] l1, int n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] *= n1;
			}
		}
		public static void timesAll(long[] l1, long n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] *= n1;
			}
		}
		public static void timesAll(double[] l1, double n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] *= n1;
			}
		}
	}