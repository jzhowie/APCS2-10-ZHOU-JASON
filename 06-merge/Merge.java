import java.util.*;
public class Merge {
public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	mergesort(data, temp, 0, data.length - 1);
}

public static void mergesort(int[] data, int[] temp, int lo, int hi) {
	//System.out.println("(low " + lo + " high " + hi + ")");
	if (lo == hi) return;
	mergesort(data, temp, lo, lo + (hi - lo) / 2);
	mergesort(data, temp, lo + ((hi - lo) / 2) + 1, hi);
	//System.out.println("(low " + lo +  " mid " +  (lo + ((hi - lo) / 2) + 1) + " high " + hi + ")");
	merge(data, temp, lo, lo + ((hi - lo) / 2) + 1, hi);
	//System.out.println(Arrays.toString(temp));

	if (lo == 0 && hi == data.length) return;
}

public static void merge(int[] data, int[] temp, int stack1, int stack2, int upper) {
	int tempTrack = stack1;
	int stack1Track = stack1;
	int stack2Track = stack2;

	while (stack1Track < stack2 && stack2Track <= upper) {
		// System.out.println("(A " + stack1Track + " B " + stack2Track + ")");
		// System.out.println(Arrays.toString(temp));
		if (data[stack1Track] >= data[stack2Track]) {
			temp[tempTrack] = data[stack2Track];
			stack2Track++;
		}
		else {
			temp[tempTrack] = data[stack1Track];
			stack1Track++;
		}
		tempTrack++;
	}

	if (stack1Track == stack2) {
		for (int i = stack2Track; i <= upper; i++) {
			temp[tempTrack] = data[i];
			tempTrack++;
		}
	}
	else if (stack2Track > upper) {
		for (int i = stack1Track; i < stack2; i++) {
			temp[tempTrack] = data[i];
			tempTrack++;
		}
	}

	for (int i = stack1; i <= upper; i++) {
		data[i] = temp[i];
	}
	return;
}
}
