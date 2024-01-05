package tasks;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        int sPos = 0;
        int pPos = 0;

        while (sPos != s.length()-1 || pPos != p.length()-1) {

            if (p.charAt(pPos) == '.') {
                pPos++;
                sPos++;
                continue;
            }

            if (p.charAt(pPos) == '*') {
                char prev = 0;
                if (pPos > 0) {
                    prev = p.charAt(pPos - 1);
                }
                if (prev != '.'){
                    if (s.charAt(sPos) != p.charAt(pPos)){
                        return false;
                    }
                }

                char next = 0;
                if (pPos < p.length() - 1) {
                    next = p.charAt(pPos + 1);
                }
                if (next == 0) {
                    return true;
                }

                while (sPos < s.length()-1){
                    if (s.charAt(sPos) == next){
                      break;
                    }
                    sPos++;
                }
               // sPos++;
               // pPos++;
            }

            pPos++;
            if (pPos > sPos) {
                sPos++;
            }

          //  System.out.println(pPos +", "+sPos);
           // System.out.println(p.charAt(pPos) +", "+s.charAt(sPos));

            if (sPos == s.length()){
                return false;
            }
            if (p.charAt(pPos) != s.charAt(sPos)){
                return false;
            }




        }

        System.out.println("END");

        if (sPos == s.length()-1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aasdgggggggggggggggggcf", ".*cf"));
    }
}
