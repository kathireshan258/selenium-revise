package practiceTest.java;

/**
 * 4. Stack and Heap MemoryAssignment:
 * Write a program that creates multiple objects and local variables.
 * Use comments and print statements to explain which variables are stored in
 * stack vs heap.
 * */


class StackHeapMemory {

// Class variable (Static variable)
// Stored in Method Area (MetaSpace in Java9+) and shared among all objects
    static String company = "abc";

// Instance Variables stored inside the object in heap memory
    int empId;
    String empName;

    StackHeapMemory(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    void display() {
        System.out.println("Employee ID: " + this.empId);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Company: " + company);
    }
}

class MemoryDemo {
    static void main(String[] args) {
// Local variables stored in stack memory
        int age = 25;
        double salary = 613000.0f;

        System.out.println("Local variable 'age' is stored in stack memory.");
        System.out.println("Local variable 'salary' is stored in stack memory.");

// Reference variable is stored in stack memory
// Actual object is stored in heap memory
        StackHeapMemory emp1 = new  StackHeapMemory(101, "Emp1");
        StackHeapMemory emp2 = new  StackHeapMemory(102, "Emp2");

        System.out.println("emp1 and emp2 references are stored in stack memory.");
        System.out.println("Employee objects are stored in heap memory.");

        emp1.display();
        emp2.display();

        System.out.println("Static variable 'company' is shared by all objects");
        System.out.println("Static variables are stored in Method Area (Class Area, MetaSpace in Java9+.");
    }
}
