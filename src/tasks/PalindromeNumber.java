package tasks;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 10 & x > -1) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int temp = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result == temp;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-101));
    }
}
