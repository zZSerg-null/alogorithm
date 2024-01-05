package sort.other;

import sort.BasicSortClass;

public class InsertionSort extends BasicSortClass {

    public long sort(int[] array) {
        long startTime = System.nanoTime();

        int marker = 1;

        for (int i = 1; i < array.length; i++) {
            int obj = array[marker];
            int mark = i - 1;

            while (mark != 0 && array[mark] >= obj) {
                array[mark + 1] = array[mark];
                mark--;
            }

            array[mark] = obj;
            marker++;
        }
        long endTime = System.nanoTime();
        System.out.println(showResult(startTime, endTime) + " - insertion sort");
        return endTime - startTime;
    }

}
