//TODO:
//ISSUES:
//NOTES:

import java.util.*;
public class MyHeap {
  public static void main (String[] args) {
    int[] test = {-19, 1, 1, -5, -3};
    buildHeap(test);
    System.out.println(Arrays.toString(test));
  }

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

      else {
        return;
      }
    }
  }

  public static void buildHeap(int[] data) {
    for (int i = data.length - 1; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }
}
