package tasks;



public class ReverseWordsInAStringIII {

    public static String reverseWords(String s){
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");

        StringBuilder temp;
        for (String word: words) {
            temp = new StringBuilder();
            temp.append(word);
            result.append(temp.reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII reverse = new ReverseWordsInAStringIII();
        System.out.println(reverse.reverseWords("Let's take LeetCode contest"));
    }
}
