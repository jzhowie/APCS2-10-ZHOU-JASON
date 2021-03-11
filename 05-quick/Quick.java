// DEVELOPMENT TIME:
// QUICKSELECT -
// QUICKSORT -
// TODO:
// ISSUES:
public class Quick {
public static int quickselect(int[] data, int k) {
	int start = 0;
	int end = data.length - 1;

	int index = -1;
	while (index != k) {
		index = partition(data, start, end);
		if (index > k) {
			end = index - 1;
		}
		else {
			start = index + 1;
		}
	}
	return data[index];
}

public static void quicksort(int[] data) {

}

private static int partition (int[] data, int start, int end) {
	int pivot = 0;
	if (end - start == 0) {
		return start;
	}
	else if (end - start == 1) {
		pivot = start;
	}
	else {
		pivot = (int) (Math.random() * (end - start - 2)) + start + 1;
		if ((data[pivot] < data[end] && data[end] < data[start]) || (data[start] < data[end] && data[end] < data[pivot])) {
			pivot = end;
		}
		else if ((data[pivot] < data[start] && data[start] < data[end]) || (data[end] < data[start] && data[start] < data[pivot])) {
			pivot = start;
		}
	}

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
		else if (data[first] < data[start]) {
			first++;
		}
		else {
			if (Math.random() < 0.5) {
				temp = data[last];
				data[last] = data[first];
				data[first] = temp;
				last--;
			}
			else {
				first++;
			}
		}
	}

	if (data[first] > data[start]) {
		temp = data[first-1];
		data[first-1] = data[start];
		data[start] = temp;
		return first-1;
	}
	else {
		temp = data[first];
		data[first] = data[start];
		data[start] = temp;
	}

	return first;
}
}
