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
		quicksort(data, 0, data.length - 1);
	}

	private static void quicksort(int[] data, int start, int end) {
		if (start == end) return;
		else {
			int index = partition(data, start, end);
			if (index == start) {
				quicksort(data, index + 1, end);
			}
			else if (index == end) {
				quicksort(data, start, index - 1);
			}
			else {
				quicksort(data, start, index - 1);
				quicksort(data, index + 1, end);
			}
			return;
		}
	}

	private static int partition (int[] data, int start, int end) {
		int pivot = (int) (Math.random() * (end + 1 - start)) + start;
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
