package practiceTest.java.generics;

/**
 * 8. Generics (Theory + Examples)
 * Assignment:
 * Create a generic class Box<T> that can store any type of object.
 * Demonstrate storing and retrieving different types.
 * Sample Input Values:
 * Type     Sample Input Value    Description
 * Integer    123                 Demonstrates storing a number
 * String     "Hello Generics"    Demonstrates storing a string
 * Student     new Student(101, "Alice")    Demonstrates storing a custom object
 *
 * Expected Output:
 * Integer value: 123
 * String value: Hello Generics
 * Student value: Student[ID=101, Name=Alice]
 * */

class Box<T> {
    private String value;
    private int intValue;

    void setValue(String value) {
        this.value = value;
    }

    void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    String getValue() {
        return this.value;
    }

    int getIntValue() {
        return this.intValue;
    }

    static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setValue("Hello Generics");
        System.out.println(box.getValue());

    }
}

class Student {
    private final String name;
    private final int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }
}
