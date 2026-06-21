package abstractClass;

class Main {
    void main() {
      Shape shape = new Triangle();
      shape.greet();
      shape.printName();

      System.out.printf("-".repeat(30) + "%n");

      Shape circle = new Circle();
      circle.greet();
      circle.printName();
  }
}
