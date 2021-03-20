//TODO: Everyting + exceptions
//ISSUES: TBD
//NOTES: For testing; ensure start and end can wrap around array

public class MyDeque<E> {
private E[] data;
private int size, start, end;

public MyDeque() {
	size = 10;
	start = size / 2;
	end = size / 2;

	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[size];
	data = d;
}

public MyDeque(int initialCapacity) {
	size = initialCapacity;
	start = size / 2;
	end = size / 2;

	@SuppressWarnings("unchecked")
	E[] d = (E[]) new Object[size];
	data = d;
}

public int size() {
	return size;
}

public String toString() {
	return ""; //ph
}

public void addFirst(E element) {

}

public void addLast(E element) {

}

public E removeFirst() {
	return data[0]; //ph
}

public E removeLast() {
	return data[0]; //ph
}

public E getFirst() {
	return data[0]; //ph
}

public E getLast() {
	return data[0]; //ph
}
}
