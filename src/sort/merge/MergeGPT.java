package sort.merge;

import sort.BasicSortClass;

public class MergeGPT extends BasicSortClass {

    public long sort(int[] array){
        long start = System.nanoTime();
        mergeSort(array,0, array.length-1);
        long end = System.nanoTime();
        System.out.println(showResult(start, end) + " top-down merge GPT sort" );
        return end-start;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); // Рекурсивная сортировка левой половины
            mergeSort(arr, mid + 1, right); // Рекурсивная сортировка правой половины
            merge(arr, left, mid, right); // Слияние отсортированных половин
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Копирование элементов во временные массивы
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Слияние временных массивов обратно в основной массив
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Копирование оставшихся элементов из левого массива (если есть)
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Копирование оставшихся элементов из правого массива (если есть)
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
