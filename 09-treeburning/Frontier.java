import java.util.*;
public class Frontier<E> {
private Queue<E> frontier;
private int size;
public Frontier() {
	frontier = new ArrayDeque<E>();
	size = 0;
}

public int size() {
	return size;
}

public void add(E location) {
	size++;
	frontier.add(location);
}

public E remove() {
	size--;
	return frontier.remove();
}
}
