package practiceTest.java;

/**
 * 3. Garbage Collection
 * Assignment:
 *  •Create a class with a finalize() method.
 *  •Create objects of that class and make them eligible for garbage collection by: Nullifying references.
 *  •Calling System.gc() to suggest garbage collection.
 *  •Observe the invocation of the finalize() method.
 *  Note: The output of finalize() is not guaranteed to appear every time,
 *  as garbage collection is managed by the JVM and may not run immediately or
 *  at all during the program's execution.
 * */

class GarbageCollection {

    // finalize is deprecated with java 9

//    @Override
//    protected void finalize() throws Throwable {
//        System.out.println("GarbageCollection finalize");
//    }

    static void main(String[] args) {
        GarbageCollection gc = new GarbageCollection();
        gc = null;
        System.gc();
    }
}
