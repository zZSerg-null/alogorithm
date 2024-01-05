package TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    public static void main(String[] args) {
        try {
            new E().go();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void go() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int studCount = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int[] stud = new int[studCount];
        int[] studLeft = new int[studCount];
        int[] studRight = new int[studCount];

        int i = 0;
        while (tokenizer.hasMoreTokens() && i < studCount) {
            int val = Integer.parseInt(tokenizer.nextToken());

            stud[i] = val;
            studLeft[i] = i - 1 >= 0 ? (studLeft[i - 1] + val) : val;

            i++;
        }
        for (int j = stud.length - 1; j >= 0; j--) {
            studRight[j] = j + 1 < stud.length ? (studRight[j + 1] + stud[j]) : stud[j];
        }


        if (i > 0) {
            System.out.println(Arrays.toString(stud));
            System.out.println(Arrays.toString(studLeft));


            try (var out = new PrintWriter(System.out)) {
                for (int j = 0; j < stud.length; j++) {
                    long a = j >= 1 ? studLeft[j - 1] - (stud[j] * (j-1)) : 0;
                    long b = j < stud.length - 1 ? (studRight[i + 1]) - (stud[j] * (stud.length-1 - j)) : 0;
                    System.out.println(a +" "+ b);
                    //out.print(stud[j] + " ");
                }

                out.println();
            }


        } else {
            System.out.println(0);
        }
    }


}