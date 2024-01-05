package sort.other;


import sort.BasicSortClass;

public class BubbleSort extends BasicSortClass {

    public void sort(int[] array) {
        long startTime = System.nanoTime();

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1])
                    swap(array, j, j + 1);
            }
        }

        long endTime = System.nanoTime();
        System.out.println(showResult(startTime, endTime) + " - bubble sort");
    }

}
