package TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MergeTwoArrays {

    public static void main(String[] args) {
        new MergeTwoArrays().start();
    }

    void start() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int array1Len = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            int array2Len = Integer.parseInt(br.readLine());
            String arr2 = br.readLine();

            if (array1Len == 0 && array2Len == 0) {
                System.out.println("");
                return;
            }
            mergeSort(arr, array1Len, arr2, array2Len);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void mergeSort(String array1, int leftLen, String array2, int rightLen) {
        StringTokenizer left = new StringTokenizer(array1);
        StringTokenizer right = new StringTokenizer(array2);

        long leftVal = getMoreToken(left);
        long rightVal = getMoreToken(right);

        try (var out = new PrintWriter(System.out)) {

            while (leftVal != Long.MAX_VALUE || rightVal != Long.MAX_VALUE || left.hasMoreTokens() || right.hasMoreTokens()) {
                if (leftVal < rightVal) {
                    out.print(leftVal + " ");
                    leftVal = getMoreToken(left);
                } else {
                    out.print(rightVal + " ");
                    rightVal = getMoreToken(right);
                }
            }

            while (left.hasMoreTokens()){
                out.print(leftVal + " ");
                leftVal = getMoreToken(left);
            }

            while (right.hasMoreTokens()){
                out.print(rightVal + " ");
                rightVal = getMoreToken(right);
            }

            out.println();
        }
    }

    long getMoreToken(StringTokenizer tok) {
        return tok.hasMoreTokens() ? Long.parseLong(tok.nextToken()) : Long.MAX_VALUE;
    }


}
