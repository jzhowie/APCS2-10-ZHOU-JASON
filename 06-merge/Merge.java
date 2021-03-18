import java.util.*;
public class Merge {
public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	mergesort(data, temp, 0, data.length - 1);
}

public static void mergesort(int[] data, int[] temp, int lo, int hi) {
	if (lo == hi) return;
	mergesort(data, temp, lo, lo + (hi - lo) / 2);
	mergesort(data, temp, lo + ((hi - lo) / 2) + 1, hi);
	merge(data, temp, lo, lo + ((hi - lo) / 2) + 1, hi);

	if (lo == 0 && hi == data.length) return;
}

public static void merge(int[] data, int[] temp, int stack1, int stack2, int upper) {
	int tempTrack = stack1;
	int stack1Track = stack1;
	int stack2Track = stack2;

	while (stack1Track < stack2 && stack2Track <= upper) {
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
