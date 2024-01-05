package sort.quicksort;

import sort.BasicSortClass;
import sort.SORT_TEST;

import java.util.Arrays;

public class QuickSortRegular extends BasicSortClass {

    public static void main(String[] args) {
        new QuickSortRegular().test();
    }

    private void test() {
        //int[] a = {9, 1, 6, 3, 5, 67, 34, 2};
       // int[] a = new SORT_TEST().genArray(500, true);
        //1,2,3,5,6,9,34,67
        //sort(a);
       // System.out.println(Arrays.toString(a));
    }


    public long sort(int[] array) {
        long startTime = System.nanoTime();

        sort(array, 0, array.length - 1);

        long endTime = System.nanoTime();
        System.out.println(showResult(startTime, endTime) + " - regular quick sort");
        return endTime - startTime;
    }

    private void sort(int[] array, int left, int right) {
        if (right - left > 0) {
            int pivot = array[right];

            int pivotPosAfterSort = miniSort(array, left, right, pivot);

            sort(array, left, pivotPosAfterSort - 1);
            sort(array, pivotPosAfterSort + 1, right);
        }
    }

    private int miniSort(int[] array, int left, int right, int pivot) {
        int leftPos = left - 1;
        int rightPos = right;


        // пока указатели не сошлись, меняем местами элементы которые больше опорного но находятся левее
        // и которые меньше опорного, но находятся правее
        while (true) {

            // бежим по массиву и пропускаем все элементы которые меньше опорного
            // как только встретится тот, что больше, прерываем цикл
            while (array[++leftPos] < pivot);

            // бежим по массиву с конца в начало и пропускаем все элементы которые больше опорного
            // пока не дойдем до нуля или не встретится тот, что меньше
            while (rightPos > 0 && array[--rightPos] > pivot);

            // когда оба вайла завершены, значит найдены два элемента которые надо поменять, или не найдено ничего

            // если ничего не найдено - выходим
            if (leftPos >= rightPos) {
                break;
            } else {
                // если найдено 2 таких элемента, меняем их местами
                swap(array, leftPos, rightPos);
            }
        }

        // и меняем опорный элемент с тем, что был левее всех, потому что он точно больше его
        swap(array, leftPos, right);

        return leftPos;
    }

}
