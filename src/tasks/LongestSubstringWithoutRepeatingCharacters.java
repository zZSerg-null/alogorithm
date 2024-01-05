package tasks;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = getLen(s.substring(i));
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    private int getLen(String s) {
        Set<Character> set = new HashSet<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!set.contains(c)){
                set.add(c);
            } else {
                break;
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
    }
}
