package stack;

import java.util.Stack;

public class BracesValidation {

    public void checkBraces(String s) {
        String openBraces = "({[<";
        String closesBraces = ")}]>";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            int pos;
            if ((pos = openBraces.indexOf(c)) != -1) {
                stack.push(closesBraces.charAt(pos));
            } else {
                if (stack.peek().equals(c)) {
                    stack.pop();
                } else {
                    System.out.println("The braces is not valid");
                    return;
                }
            }
        }
        System.out.println("The braces is valid");
    }

    public static void main(String[] args) {
        BracesValidation bracesValidation = new BracesValidation();
        String ok = "()()(){}{}{}{";
        bracesValidation.checkBraces(ok);

    }
}
