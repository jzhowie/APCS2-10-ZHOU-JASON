//TODO: Everyting + exceptions
//ISSUES: TBD
//NOTES: For testing; ensure start and end can wrap around array, check for constant time

public class MyDeque<E> {
private E[] data;
private int size, start, end;

public MyDeque() {
	size = 10;
	start = 5;
	end = 6;

	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[size];
	data = d;
}

public MyDeque(int initialCapacity) {
	size = initialCapacity;
	start = size / 2;
	end = (size / 2) + 1;

	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[size];
	data = d;
}

public int size() {
	return size;
}

public String toString() {
	String value = "{";
	int index = start + 1;
	while (index != end) {
		if (index == size()) {
			index = 0;
		}
		value += data[index];
		if (index != end - 1) {
			value += ", ";
		}
		index++;
	}
	value += "}";
	return value;
}

public void addFirst(E element) { // add resizing
	if (start == -1) {
		start = size() - 1;
	}
	data[start] = element;
	start--;
}

public void addLast(E element) { //add resizing
	if (end == size()) {
		end = 0;
	}
	data[end] = element;
	end++;
}

public E removeFirst() {
	if (start == -1) {
		return data[size() - 1];


	}
	return data[0]; //ph
}

public E removeLast() {
	return data[0]; //ph
}

public E getFirst() {
	// if (start == -1) {
	// 	return data[0];
	// }
	if (start == size() - 1) {
		return data[0];
	}
	return data[start+1]; //ph
}

public E getLast() {
	// if (end == size()) {
	// 	return data[size() - 1];
	// }
	if (end == 0) {
		return data[size() - 1];
	}
	return data[end-1]; //ph
}
}
