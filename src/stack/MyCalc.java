package stack;

import java.util.ArrayList;

public class MyCalc {


    public void myMath(String s) {
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\\\", "/");
        int openBracesLastPos;
        int closeBracesLastPos;
        String result;
        System.out.println(s);

        while (true) {
            if ((openBracesLastPos = s.lastIndexOf("(")) != -1) {
                String subExpression = s.substring(openBracesLastPos);
                closeBracesLastPos = subExpression.indexOf(")");
                String bracesExpression = subExpression.substring(0, closeBracesLastPos + 1);
                result = calculateExpression(bracesExpression);
                s = s.replace(bracesExpression, result);
            } else {
                s = calculateExpression(s);
                break;
            }
        }

        System.out.println("В итоге: "+ calculateExpression(s));
    }

    private String calculateExpression(String bracesExpression) {


        int lastPos = 0;
        ArrayList<String> token = new ArrayList<>();

        for (int i = 0; i < bracesExpression.length(); i++) {
            if ((bracesExpression.charAt(i) == '+')
                    || (bracesExpression.charAt(i) == '-')
                    || (bracesExpression.charAt(i) == '*')
                    || (bracesExpression.charAt(i) == '/')
                    || i == bracesExpression.length() - 1) {
                token.add(bracesExpression.substring(lastPos, i).replace("(", "").replace(")", ""));
                token.add(String.valueOf(bracesExpression.charAt(i)));
                lastPos = i + 1;
            }
        }
        token.removeIf(s -> s.equals(""));
        System.out.println("Выражение: " + token);

        String operand1;
        String operand2;
        int i;
        char operator = '1';
        String result = "";

        while (operator != '<') {
            operator = '<';

            for (i = 0; i < token.size() - 1; i++) {
                if (token.get(i).equals("*") | token.get(i).equals("/")) {
                    operand1 = token.get(i - 1);
                    operand2 = token.get(i + 1);
                    operator = token.get(i).charAt(0);
                    result = calculate(operand1, operand2, operator);
                    break;
                }
            }
            if (operator != '<') {
                token.add(i - 1, result);
                removeOperands(token, i);
                System.out.println("Преобразовано: "  + token);
            }

        }

        while (operator != '>') {
            operator = '>';
            for (i = 0; i < token.size() - 1; i++) {
                if (token.get(i).equals("-") | token.get(i).equals("+")) {
                    operand1 = token.get(i - 1);
                    operand2 = token.get(i + 1);
                    operator = token.get(i).charAt(0);
                    result = calculate(operand1, operand2, operator);
                    break;
                }
            }
            if (operator != '>') {
                token.add(i - 1, result);
                removeOperands(token, i);
                System.out.println("Преобразовано: " + token);
            }

        }

        return token.get(0);
    }

    private void removeOperands(ArrayList<String> token, int i) {
        token.remove(i);
        token.remove(i);
        token.remove(i);
    }

    private String calculate(String operand1, String operand2, char operator) {
        return switch (operator) {
            case '*' -> String.valueOf(Double.parseDouble(operand1) * Double.parseDouble(operand2));
            case '/' -> String.valueOf(Double.parseDouble(operand1) / Double.parseDouble(operand2));
            case '-' -> String.valueOf(Double.parseDouble(operand1) - Double.parseDouble(operand2));
            case '+' -> String.valueOf(Double.parseDouble(operand1) + Double.parseDouble(operand2));
            default -> "";
        };
    }

    public static void main(String[] args) {
        MyCalc myCalc = new MyCalc();

        String r = "54.5 / 3.02 * ((55 - 90 + 56.25) * 329) - 56.44 / (45.5 * 6.4 / 5) * 5";
        String f = "54.5 / 350.43 * 56.25 - 56.44 / 45.5 * 6.4 / 5 * 5";
        String test = "25+25+25+25+(100*2+(100/5+(50/2+20-3*5-(7-2))))+90/2+5*5+7*3+2";
        //myStack.calculateExpression("54.5 \\ 350.43 * 56.25 - 56.44 \\ 45.5 * 6.4 \\ 5 * 5");
        //myStack.calculateMath(r);
        myCalc.myMath(test);
    }
}
