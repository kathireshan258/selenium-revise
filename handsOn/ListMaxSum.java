package handsOn;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

class ListMaxSum {
  static void main() {
        List<Integer> numb = new ArrayList<>();
        numb.add(10);
        numb.add(20);
        numb.add(30);
        numb.add(40);
        numb.add(50);

        margin("Execution Begin");
        System.out.printf("ArrayList: " + numb + "%n");
        System.out.printf("Removed element from index position %d: %d%n", 2, numb.remove(2));
        System.out.printf("Adding element %d at index %d%n", 25, 2);
        numb.add(2, 25);
        System.out.printf("New ArrayList: " + numb + "%n");

        System.out.printf("Max integer from the ArrayList: %d%n", getMaxInt(numb));
        System.out.printf("Sum of all the integers from the ArrayList: %d%n", getSum(numb));
        margin("Execution End");
  }

  static void margin(String message) {
    int remainingLen = 30 - message.length();
    System.out.printf("%n" + "=".repeat(remainingLen/2) + " " +
        message + " " + "=".repeat(remainingLen/2) + "%n%n");
  }

  static int getMaxInt(List<Integer> list) {
    Iterator<Integer> iterator = list.iterator();
    int maxNum = Integer.MIN_VALUE;
    while (iterator.hasNext()) {
      int value = iterator.next();
      maxNum = Math.max(value, maxNum);
    }
    return maxNum;
  }

  static int getSum(List<Integer> list) {
    Iterator<Integer> iterator = list.iterator();
    int sum = 0;
    while (iterator.hasNext()) {
      sum += iterator.next();
    }
    return sum;
  }
}
