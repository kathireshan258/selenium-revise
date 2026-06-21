package VectorCollection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class Enumerator {
  static void main() {
    Vector v = new Vector();
    for (int i =0; i < 5; i++)
      v.addElement(String.valueOf(i));
    for (int i = 5; i < 10; i++)
      v.addElement(i);

    System.out.printf(v +"%n");
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      int i = Integer.parseInt(String.valueOf(e.nextElement()));

      System.out.printf(i + " ");
    }
    System.out.printf("%n");


  }
}
