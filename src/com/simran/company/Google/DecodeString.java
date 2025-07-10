package com.simran.company.Google;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        decodeStringUsingOneStack("3[a]2[bc]");
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // to have multiple digits at once
            } else if(ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                k = 0;
                currentString = new StringBuilder();
            } else if(ch == ']') {
                int size = countStack.pop();
                StringBuilder prevString = stringStack.pop();
                for(int i = 1 ; i <= size ; i++) {
                    prevString.append(currentString);
                }
                currentString = prevString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static String decodeStringUsingOneStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
            } else {
                // Step 1: Pop to build the substring inside brackets
                StringBuilder decoded = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    decoded.insert(0, stack.pop());
                }

                // Step 2: Pop the '['
                stack.pop();

                // Step 3: Pop digits to build the repeat count
                StringBuilder kBuilder = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    kBuilder.insert(0, stack.pop());
                }
                int k = Integer.parseInt(kBuilder.toString());

                // Step 4: Repeat the substring and push back to stack
                String repeated = decoded.toString().repeat(k);
                for (char c : repeated.toCharArray()) {
                    stack.push(c);
                }
            }
        }

        // Build final result from stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
