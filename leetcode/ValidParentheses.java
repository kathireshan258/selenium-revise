package leetcode;

import java.util.Stack;

/**
 * Problem 2: Valid Parentheses (Stack)
 * This is one of the most asked Easy problems.
 * Problem Statement
 * Given a string containing:
 * ( ) { } [ ]
 * Determine if the brackets are valid.
 * Example:
 * Input: "()"
 * Output: true
 * */

class ValidParentheses {
    static void main (String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[(]}"));
    }

    static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') { stack.push(ch);}
            else {
                if (stack.isEmpty()) {
                    return false;
                }
//            if (ch == ')' && stack.peek() != '(') return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
