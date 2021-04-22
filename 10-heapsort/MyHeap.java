//NOTES: Scenarios, two elements out of size, one element outside of size (we need to get function to continue as this), none
import java.util.*;
public class MyHeap {
  public static void main (String[] args) {
    int[] test = {-19, 1, 1, -5, -3};
    pushDown(test, 4, 0);
    System.out.println(Arrays.toString(test));
  }

  private static void pushDown(int[] data, int size, int index) {
    while (index * 2 + 2 < size) {
      if (data[index] < data[index*2+1] || data[index] < data[index*2+2]) {
        if (data[index*2+1] < data[index*2+2]) {
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
    }
  }
}
