package sort.merge;

import sort.BasicSortClass;

import java.util.Arrays;

public class MergeTopDown extends BasicSortClass {

    public long sort(int[] array){
        long start = System.nanoTime();
        startSort(array);
        long end = System.nanoTime();
        System.out.println(showResult(start, end) + " top-down merge sort" );
        return end-start;
    }

    public void startSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // массив уже отсортирован или пустой
        }

        int[] temp = new int[array.length]; // временный массив для хранения промежуточных результатов

        mergeSort(array, temp, 0, array.length - 1); // вызов рекурсивной функции сортировки
    }

    private void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2; // находим середину массива

            mergeSort(array, temp, left, middle); // сортируем левую часть

            mergeSort(array, temp, middle + 1, right); // сортируем правую часть

            merge(array, temp, left, middle, right); // слияние отсортированных частей
        }
    }

    private void merge(int[] array, int[] temp, int left, int middle, int right) {
        // копируем значения из исходного массива во временный массив
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int mergeLeft = left; // начальный индекс левой части
        int mergeRight = middle + 1; // начальный индекс правой части
        int pos = left; // текущий индекс в массиве

        while (mergeLeft <= middle && mergeRight <= right) {
            int x = temp[mergeLeft];
            int b = temp[mergeRight];

            if (temp[mergeLeft] <= temp[mergeRight]) {
                array[pos] = temp[mergeLeft];
                mergeLeft++;
            } else {
                array[pos] = temp[mergeRight];
                mergeRight++;
            }

            pos++;
        }

        // копируем оставшиеся элементы из левой части (если есть)
        while (mergeLeft <= middle) {
            array[pos] = temp[mergeLeft];
            mergeLeft++;
            pos++;
        }

        // копируем оставшиеся элементы из правой части (если есть)
        while (mergeRight <= right) {
            array[pos] = temp[mergeRight];
            mergeRight++;
            pos++;
        }
    }

}
