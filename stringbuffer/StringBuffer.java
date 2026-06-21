package stringbuffer;

public class StringBuffer {
  static void main() {
    java.lang.StringBuffer buffer = new java.lang.StringBuffer("Hello");
    char[] arr = {'1', '2', '3', '4', '5'};
    buffer.append(arr, 1, 2);
    System.out.printf(buffer+"%n");

    CharSequence sequence = "Sequence";
    buffer.append(sequence, 2, 4);
    System.out.printf(buffer+"%n");

    buffer.insert(2, "123");
    System.out.printf(buffer + "%n");

    System.out.printf("His name was john and he is a man".replace("is", "was")+"%n");
    "".subSequence(0,1);



  }
}
