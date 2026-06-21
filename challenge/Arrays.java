package challenge;

class Arrays {
  static void main() {
    int[] arr = {10, 30, 50, 60, 90, 40, 100};
    Arrays arrays = new Arrays();
    arrays.printArr(arr);
    arrays.reverseArr(arr);
    arrays.printMaxMin(arr);
    arrays.printSumAverage(arr);
    arrays.searchElement(arr, 90);
    arrays.sortArray(arr);
    arrays.arrayMethodPrint(arr);
    arrays.arrayMethodSort(arr);
  }

  void printArr(int[] arr) {
//    System.out.printf("Elements in array:%n");
//    for (int i = 0; i < arr.length; i++) {
//      System.out.printf("%d,",arr[i]);
//    }
//
//    System.out.printf("%n");
//
//    System.out.printf("-".repeat(30) + "%n");
    System.out.printf("Print using enhanced for%n");
    for (int val: arr) {
      System.out.printf("%d,", val);
    }
    System.out.printf("%n");
  }

  void reverseArr(int[] arr) {
    System.out.printf("-".repeat(30)+"%n");
    System.out.printf("Original array:%n");
    printArr(arr);
    for (int i = 0; i < arr.length/2; i++) {
      int temp = arr[i];
//      System.out.printf("value in temp: %d%n", temp);

      arr[i] = arr[arr.length - (i+1)];
//      System.out.printf("value at arr[%d]:%d%n",i, arr[i]);

      arr[arr.length - (i+1)] = temp;
//      System.out.printf("value in last index %d:%d%n", arr.length - (i+1), arr[arr.length - (i+1)]);
    }

    System.out.printf("Reversed array:%n");
    printArr(arr);
  }

  void printMaxMin(int[] arr) {
    System.out.printf("-".repeat(30)+"%n");
    System.out.printf("Max value using stream %d%n",
    java.util.Arrays.stream(arr).max().isPresent() ?
        java.util.Arrays.stream(arr).max().getAsInt(): 0);

    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    System.out.printf("using for loop%n");

    for (int i = 0; i < arr.length; i++) {

      max = arr[i] > max ? arr[i] : max;

      min = arr[i] < min ? arr[i] : min;
    }

    System.out.printf("Min: %d, Max: %d%n", min, max);

    System.out.printf("Using Math.min() Math.max()%n");
    for (int val: arr) {
      min = Math.min(val, min);
      max = Math.max(val, max);
    }

    System.out.printf("Min: %d,Max: %d%n", min, max);
  }

  void printSumAverage(int[] arr) {
    System.out.printf("-".repeat(30) + "%n");
    int sum = 0, avg = 0;
    for (int val : arr) {
      sum += val;
    }

    System.out.printf("Sum of array %d:%n", sum);
    System.out.printf("Average of array %d:%n", sum / arr.length);
  }

  void searchElement(int[] arr, int num) {
    System.out.printf("-".repeat(30)+"%n");
    int indexOf = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        indexOf = i;
      }
    }

    System.out.printf("Index of %d in arr is: %d%n", num, indexOf);
  }

  void sortArray(int[] arr) {
    System.out.printf("-".repeat(30) + "%n");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.printf("arr-i[%d]:%d%n", i, arr[i]);
        System.out.printf("arr-j[%d]:%d%n",j,arr[j]);
        System.out.printf("*".repeat(30)+"%n");
        if (arr[i] > arr[j] && i < j) {
          System.out.printf("-".repeat(5)+"Swap"+"-".repeat(5) +"%n");
          int temp = arr[i];
          System.out.printf("temp:%d%n", temp);

          arr[i] = arr[j];
          System.out.printf("arr-i[%d]:%d%n", i, arr[i]);

          arr[j] = temp;
          System.out.printf("arr-j[%d]:%d%n", j, arr[j]);
          System.out.printf("=".repeat(30)+"%n");
        }
      }
    }
    System.out.printf("Sorted array:%n");
    for (int val: arr) {
      System.out.printf("%d ", val);
    }
    System.out.printf("%n");
  }


  //using Arrays method
  void arrayMethodPrint(int[] arr) {
    System.out.printf("-".repeat(30)+"%n");
    System.out.printf("using java.util.Arrays.toString()%n");
    System.out.printf(java.util.Arrays.toString(arr)+"%n");
  }

  void arrayMethodSort(int[] arr) {
    System.out.printf("-".repeat(30)+"%n");
    reverseArr(arr);
    System.out.printf("using java.util.Arrays.sort()%n");
    java.util.Arrays.sort(arr);
    arrayMethodPrint(arr);
  }
}
