package sort.other;

import sort.BasicSortClass;

public class SelectionSort extends BasicSortClass {

    public long sort(int[] array) {
        long startTime = System.nanoTime();

        int min;
        int tempMin;

        for (int i = 0; i < array.length - 1; i++) {
            min = i;

            for (tempMin = i + 1; tempMin < array.length - 1; tempMin++) {
                if (array[tempMin] < array[min]) {
                    min = tempMin;
                }
            }

            swap(array, i, min);
        }
        long endTime = System.nanoTime();
        System.out.println(showResult(startTime, endTime) + " - selection sort");
        return endTime - startTime;
    }

}
