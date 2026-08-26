package practiceTest.java;

/**
 * 2. Wrapper Classes
 * Assignment:
 * Write a program that takes primitive data types and converts them into their corresponding
 * wrapper classes. Demonstrate auto-boxing and unboxing.
 * */

class WrapperClass {
    static void main(String[] args) {
        int i = 1;
        Integer j = 21;

        float b = 20f;
        Float f = 32f;

        System.out.println("-----Autoboxing-----");
        System.out.println("i= " + i);
        System.out.println("j= " + j);
        System.out.println("b= " + b);
        System.out.println("f= " + f);

        // Unboxing: Wrapper to primitive
        int intVal = j;
        float floatVal = f;
        System.out.println("intVal= " + intVal);
        System.out.println("floatVal= " + floatVal);

        // Autoboxing in collections
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list= " + list);
        System.out.println("values in list:");
        for (int value : list) {
            System.out.println(value);
        }
    }
}
