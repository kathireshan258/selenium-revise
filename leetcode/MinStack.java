package leetcode;

/**
 * Problem: Min Stack (Stack Pattern)
 * Interview Question:
 * Design a stack that supports the following operations:
 *  - push(x) → Push element x onto stack.
 *  - pop() → Remove the element on top of the stack.
 *  - top() → Get the top element.
 *  - getMin() → Retrieve the minimum element in the stack.
 * All operations must run in O(1) time.
 *
 * Example 1:
 * Input:
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output:
 * [null,null,null,null,-3,null,0,-2]
 * Explanation:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   // returns -3
 * minStack.pop();
 * minStack.top();      // returns 0
 * minStack.getMin();   // returns -2
 *
 * Important Constraints:
 * -2^31 <= value <= 2^31 - 1
 * Methods pop(), top(), getMin()
 * will always be called on a non-empty stack.
 *
 * At most 3 * 10^4 operations.
 *
 * Guarantees:
 * The stack is never empty when:
 * top()
 * getMin()
 * pop()
 *
 * are called.
 * */

import java.util.Stack;

class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    static void main (String[] args) {

    }

    private void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    private void pop() {
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    private int top() {
        return stack.peek();
    }

    private int getMin() {
        return minStack.peek();
    }
}
