package TEST;

import java.util.Scanner;

public class MyMergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int array1Len = scanner.nextInt();
        long[] array1 = new long[array1Len];
        for (int i = 0; i < array1Len; i++) {
            array1[i] = scanner.nextLong();
        }

        if (array1Len == 0) {
            System.out.println("");
            return;
        }

        long[] result = mergeSort(array1);
        for (long l : result) {
            System.out.print(l + " ");
        }
    }

    public static long[] mergeSort(long[] array) {
        long[] current = array;
        long[] tmp;
        long[] currentDest = new long[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(current, i, current, i + size, currentDest, i, size);
            }

            tmp = current;
            current = currentDest;
            currentDest = tmp;

            size = size * 2;
        }
        return current;
    }

    private static void merge(long[] src1, int src1Start, long[] src2, int src2Start, long[] dest,
                              int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
    
    
}
