package TEST;

import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        read();
        solve();
        print();
    }

    int aSize, bSize;
    int[] answer;
    int[] a, b;


    void read() {
        try (var in = new Reader()) {
            aSize = in.readInt();
            a = in.readInts(aSize);

            bSize = in.readInt();
            b = in.readInts(bSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void solve() {
        answer = new int[aSize + bSize];

        int inf = Integer.MAX_VALUE;

        for (int i = 0, j = 0, k = 0; i < aSize || j < bSize; ++k) {
            int aValue = (i == aSize) ? inf : a[i];
            int bValue = (j == bSize) ? inf : b[j];

            if (aValue < bValue) {
                answer[k] = aValue;
                ++i;
            } else {
                answer[k] = bValue;
                ++j;
            }
        }
    }

    void print() {
        try (var out = new PrintWriter(System.out)) {
            for (int v : answer) out.print(v + " ");
            out.println();
        }
    }

    static class Reader implements Closeable {

        BufferedReader in;
        StringTokenizer tok;

        Reader() throws IOException {
            this.in = new BufferedReader(new InputStreamReader(System.in));
            this.tok = new StringTokenizer("");
        }

        String readLine() {
            try {
                return in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String readToken() {
            while (!tok.hasMoreTokens()) {
                String nextLine = readLine();
                if (nextLine == null)
                    return null;
                tok = new StringTokenizer(nextLine);
            }
            return tok.nextToken();
        }

        int readInt() {
            return Integer.parseInt(readToken());
        }

        int[] readInts(int size) {
            int[] a = new int[size];
            for (int i = 0; i < size; ++i)
                a[i] = readInt();
            return a;
        }

        @Override
        public void close() throws IOException {
            in.close();
        }
    }
}