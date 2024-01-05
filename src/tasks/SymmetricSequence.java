package tasks;

import java.util.Stack;

public class SymmetricSequence {

    public Stack<Character> checkSequence(String sequence) {
        Stack<Character> right = new Stack<>();

        boolean symmetric = true;
        int rightIndex = sequence.length() - 1;

        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);

            if (symmetric) {
                if (c != sequence.charAt(rightIndex--)) {
                    symmetric = false;
                    right.push(c);
                }
            } else if (i < rightIndex+2) {
                right.push(c);
            } else break;
        }

        if (right.empty()) {
            System.out.println(0);
        } else {
            while (!right.empty()){
                System.out.println(right.pop());
            }
        }

        return null;
    }


    public static void main(String[] args) {
        new SymmetricSequence().checkSequence("12345677654321");
    }
}
