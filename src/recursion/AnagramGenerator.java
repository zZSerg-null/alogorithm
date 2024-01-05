package recursion;

import java.util.LinkedList;

public class AnagramGenerator {

    private void getAnagram(String creation, String word, LinkedList<String> list){
        if (word.length() == 0){
            list.add(creation);
        } else {

            for (int i = 0; i < word.length(); i++) {
                getAnagram(
                        creation + word.charAt(i),
                        word.substring(0, i) + word.substring(i+1),
                        list
                );
            }
        }
    }



    public static void main(String[] args) {
        AnagramGenerator anagramGenerator = new AnagramGenerator();
        LinkedList<String> list = new LinkedList<>();
        anagramGenerator.getAnagram("", "Котик", list);

        list.forEach(System.out::println);

        System.out.println(list.size());
    }
}
