//TODO: Everyting + exceptions
//ISSUES: TBD
//NOTES: For testing; ensure start and end can wrap around array, check for constant time
import java.util.*;
public class MyDeque<E> {
private E[] data;
private int size, start, end;

public MyDeque() {
	size = 0;
	start = 5;
	end = 6;

	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[size];
	data = d;
}

public MyDeque(int initialCapacity) {
	size = 0;
	start = size / 2;
	end = (size / 2) + 1;

	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[initialCapacity];
	data = d;
}

public int size() {
	return size;
}

public String toString() {
	String value = "{";
	int index = start + 1;
	for (int i = 0; i < size(); i++) {
		if (index == data.length) {
			index = 0;
		}
		value += data[index];
		if (i != size() - 1) {
			value += ", ";
		}
		index++;
	}
	value += "}";
	return value;
}

public void addFirst(E element) {
	if (element == null) throw new NullPointerException();
	if ((start - end == -1 && data[end] != null) || size() == 0) {
		resize();
	}
	if (start == -1) {
		start = data.length - 1;
	}
	data[start] = element;
	start--;
}

public void addLast(E element) {
	if (element == null) throw new NullPointerException();
	if ((end - start == 1 && data[end] != null) || size() == 0) {
		resize();
	}
	if (end == data.length) {
		end = 0;
	}
	data[end] = element;
	end++;
}

private void resize() {
	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[size*10];
	int index = start + 1;
	int copyTrack = size() * 10 / 2;
	start = copyTrack - 1;
	for (int i = 0; i < size(); i++) {
		if (index == data.length) {
			index = 0;
		}
		d[copyTrack] = data[index];
		index++;
		copyTrack++;
	}
	end = copyTrack;
	size = size * 10;
	data = d;
}

public E removeFirst() {
	start++;
	if (start == data.length) {
		start = 0;
	}
	E temp = data[start];
	data[start] = null;
	return temp;
}

public E removeLast() {
	end--;
	if (end == -1) {
		end = data.length - 1;
	}
	E temp = data[end];
	data[end] = null;
	return temp;
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
