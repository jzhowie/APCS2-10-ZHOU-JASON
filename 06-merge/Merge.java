public class Merge {
public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	mergesort(data, temp, 0, data.length - 1);
}

public static void mergesort(int[] data, int[] temp, int lo, int hi) {
	System.out.println("(low " + lo + " high " + hi + ")");
	if (lo == hi) {
		return;
	}
	mergesort(temp, data, lo, lo + (hi - lo) / 2);
	mergesort(temp, data, lo + ((hi - lo) / 2) + 1, hi);
	if (lo == 0 && hi == data.length) return;
}
}
