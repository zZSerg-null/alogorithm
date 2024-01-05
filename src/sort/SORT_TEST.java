package sort;

import sort.merge.MergeBottomUp;
import sort.merge.MergeGPT;
import sort.merge.MergeTopDown;
import sort.merge.MergeTopDown2;
import sort.other.*;
import sort.quicksort.QuickSortMedian;
import sort.quicksort.QuickSortRegular;

import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import java.util.Random;

public class SORT_TEST {


    public int[] genArray(int elemCount, boolean random) {
        int[] array = new int[elemCount];
        Random r = new Random();

        for (int i = 0; i < elemCount; i++) {
            if (random) {
                array[i] = r.nextInt(array.length);
            } else {
                array[i] = i;
            }
        }
        return array;
    }



    public static void main(String[] args) {
        SORT_TEST allTypeSorterClass = new SORT_TEST();
        allTypeSorterClass.sortTest(100_000_000, "1_000_000");
    }

    private void sortTest(int elementsCount, String count) {
        System.out.println("Сортируем массив из " + count + " элементов с числами от 0 до " + count + ":  ....");

        int[] a = new SORT_TEST().genArray(elementsCount, true);
        int[] clone1 = a.clone();
        int[] clone2 = a.clone();

        //System.out.println(new MergeTopDown2().sort(clone2));
        //System.out.println(new MergeTopDown().sort(clone1));


        //int[] clone2 = a.clone();
 /*       int[] clone3 = a.clone();
        int[] clone4 = a.clone();
        int[] clone5 = a.clone();
        int[] clone6 = a.clone();
        int[] clone7 = a.clone();
        int[] clone8 = a.clone();
        int[] clone9 = a.clone();

        if (elementsCount <= 150_000) {
            new BubbleSort().sort(a);
        } else {
            System.out.println("Bubble Sort не участвует...");
        }

        if (elementsCount <= 200_000) {
            new SelectionSort().sort(clone1);
        } else {
            System.out.println("Selection Sort не участвует...");
        }

        if (elementsCount <= 300_000) {
            new InsertionSort().sort(clone2);
        } else {
            System.out.println("Insertion Sort не участвует...");
        }

        new TreeSetSort().sort(clone3);

       new CountingSort().sort(clone4);

        long startTime = System.nanoTime();
        Arrays.sort(clone5);
        long endTime = System.nanoTime();
        System.out.println(new BasicSortClass().showResult(startTime, endTime) + " arrays.sort time");

        new MergeBottomUp().sort(clone6);

        new MergeTopDown().sort(clone7);*/

        new QuickSortRegular().sort(clone1);
        new QuickSortMedian().sort(clone2);

      //  Arrays.sort(clone5);
    }


}
