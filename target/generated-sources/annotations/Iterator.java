package ArrayListCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Iterator {
  static void main() {
    Iterator iterator = new Iterator();
    List<Integer> list = new ArrayList<>();

    for (int i = 0 ; i < 10; i++)
      list.add(i*=2);

    System.out.printf(list + "%n");
    iterator.iterateAndPrint(list);
    System.out.printf( iterator.addItemToList(list,11) +"%n");
    System.out.printf( iterator.addItemToList(list,12) +"%n");
    System.out.printf( iterator.addItemToList(list,11) +"%n");
    System.out.printf( iterator.addItemToList(list,13) +"%n");
    System.out.printf( iterator.addItemToList(list,11) +"%n");
    System.out.printf( iterator.removeItemFromList(list,11) +"%n");
    System.out.printf(iterator.removeItemAtIndexPos(list, 4) + "%n");
  }

  void iterateAndPrint(List<Integer> list) {
    java.util.Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.printf( iterator.next() + " ");
    }
    System.out.printf("%n");
  }

  List<Integer> addItemToList(List<Integer> list, int num) {
    list.add(num);
    return list;
  }

  List<Integer> removeItemFromList(List<Integer> list, int num) {
    java.util.Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (Objects.equals(iterator.next(), (Integer) num)) {
        iterator.remove();
      }
    }
    return list;
  }

  List<Integer> removeItemAtIndexPos(List<Integer> list, int index) {
    if (index < list.size())
      System.out.printf("Removed integer %d at index %d%n", list.remove(index), index);
    else
      System.out.printf("Provide index within list range%n");
    return list;
  }
}
