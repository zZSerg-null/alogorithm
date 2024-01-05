package tasks;

public class _StringToInteger {

    public static int myAtoi(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char c;
        long value = 0;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isLetter(c) && stringBuilder.length() == 0) {
                return 0;
            }

            value = 0;
            if (stringBuilder.length() > 1){
                value = Long.parseLong(stringBuilder.toString());
            }

            if (Character.isDigit(c) || c == '-' || c == '+') {
                if (value > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                } else if (value < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }else stringBuilder.append(c);
            } else if (c == '.'){
                if (stringBuilder.length() > 0){
                    return Integer.parseInt(stringBuilder.toString());
                } else
                return 0;
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("3.14159"));
    }

}
