public class MyHeap {
  private static void pushDown(int[] data, int size, int index) {
    while (index * 2 + 1 < size) {
      if (data[index] < data[index*2+1] || (index*2+2 < size && data[index] < data[index*2+2])) {
        if (index*2+2 < size && data[index*2+1] < data[index*2+2]) {
          int temp = data[index*2+2];
          data[index*2+2] = data[index];
          data[index] = temp;
          index = index*2+2;
        }

        else {
          int temp = data[index*2+1];
          data[index*2+1] = data[index];
          data[index] = temp;
          index = index*2+1;
        }
      }

      else return;
    }
  }

  private static void buildHeap(int[] data) {
    for (int i = data.length - 1; i >= 0; i--) pushDown(data, data.length, i);
  }

  private static void remove(int[] data, int size) {
    int temp = data[size];
    data[size] = data[0];
    data[0] = temp;
    pushDown(data, size, 0);
  }

  public static void heapsort(int[] data) {
    buildHeap(data);
    int counter = data.length - 1;
    while (counter > 0) {
      remove(data, counter);
      counter--;
    }
  }
}
