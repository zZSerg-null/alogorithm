package tasks;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(1);
        }

        int max = 0;
        String result = "";

        for (int i = 1; i < s.length(); i++) {
            int left = i;
            int right = i;

            while (left-- > 0 && s.charAt(left) == s.charAt(i)) ;
            while (right++ < s.length() - 1 && s.charAt(right) == s.charAt(i)) ;

            if (left != -1 & right < s.length()) {
                while (left != -1 & right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
            }

            String t = s.substring(left+1, right);
            if (t.length() > max) {
                max = t.length();
                result = t;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("agg"));
    }
}
