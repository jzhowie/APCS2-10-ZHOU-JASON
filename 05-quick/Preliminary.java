//TODO: PLS TEST ME
import java.util.*;

public class Preliminary {
public static int partition (int[] data, int start, int end) {
	int pivot = 2;
	int first = start + 1;
	int last = end;


	int temp = data[start];
	data[start] = data[pivot];
	data[pivot] = temp;

	while (first != last) {
		if (data[first] > data[start]) {
			temp = data[last];
			data[last] = data[first];
			data[first] = temp;
			last--;
		}
		else {
			first++;
		}
	}

	if (data[first] > data[start]) {
		temp = data[first-1];
		data[first-1] = data[start];
		data[start] = temp;
	}
	else {
		temp = data[first];
		data[first] = data[start];
		data[start] = temp;
	}

	return first;
}
}
