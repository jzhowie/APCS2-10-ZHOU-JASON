//TODO: Everyting + exceptions
//ISSUES: TBD
//NOTES: For testing; ensure start and end can wrap around array, check for constant time
import java.util.*;
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
	// if (start == -1) {
	// 	index = size() - 1;
	// }
	System.out.println(index);
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

public void addFirst(E element) {
	System.out.println("first " + start + ", last" + end);
	if (start - end == -1 && data[end] != null) {
		resize();
	}
	if (start == -1) {
		start = size() - 1;
	}
	data[start] = element;
	start--;
}

public void addLast(E element) {
	if (end - start == 1 && data[end] != null) {
		resize();
	}
	if (end == size()) {
		end = 0;
	}
	data[end] = element;
	end++;
}

private void resize() {
	int temp = size();
	size = size() * 10;
	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[size()];
	boolean wrap = false;
	int index = start + 1;
	int copyTrack = size() / 2;
	start = copyTrack - 1;
	while (index != end || !(wrap)) {
		if (index == temp) {
			index = 0;
			wrap = true;
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
	if (start == size()) {
		start = 0;
	}
	E temp = data[start];
	data[start] = null;
	return temp;
}

public E removeLast() {
	end--;
	if (end == -1) {
		end = size() - 1;
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
