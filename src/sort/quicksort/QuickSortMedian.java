package sort.quicksort;

import sort.BasicSortClass;

import java.util.Scanner;

public class QuickSortMedian extends BasicSortClass {

    public static void main(String[] args) {
        QuickSortMedian qsm = new QuickSortMedian();

        Scanner scanner = new Scanner(System.in);
        int elemCount = scanner.nextInt();
        int[] elem = new int[elemCount];

        for (int i = 0; i < elemCount; i++) {
            if (scanner.hasNextInt()) {
                elem[i] = scanner.nextInt();
            } else {
                break;
            }
        }

        qsm.sort(elem);
    }

    public long sort(int[] array) {
        long startTime = System.nanoTime();

        sortMedian(array, 0, array.length - 1);

        long endTime = System.nanoTime();
        System.out.println(showResult(startTime, endTime) + " - median quick sort");
        return endTime - startTime;
    }

    private void sortMedian(int[] array, int left, int right) {
        if (right - left > 0) {

            long size = right - left + 1;

            if (size <= 3) {
                manualSort(array, left, right);
            } else {
                long median = medianOf3(array, left, right);

                int partition = miniSort2(array, left, right, median);

                sortMedian(array, left, partition - 1); // Сортировка левой части
                sortMedian(array, partition + 1, right); // Сортировка правой части
            }
        }
    }

    public long medianOf3(int[] array, int left, int right) {
        int center = (left + right) / 2;
        // Упорядочение left и center
        if (array[left] > array[center])
            swap(array, left, center);

        // Упорядочение left и right
        if (array[left] > array[right])
            swap(array, left, right);

        // Упорядочение center и right
        if (array[center] > array[right])
            swap(array, center, right);

        swap(array, center, right - 1); // Размещение медианы на правом краю

        return array[right - 1]; // Метод возвращает медиану
    }

    public int miniSort2(int[] array, int left, int right, long pivot) {
        int leftPtr = left; // Левая граница-1 (после ++)
        int rightPtr = right - 1; // Правая граница (after --)

        while (true) {

            // Поиск большего элемента
            while (array[++leftPtr] < pivot) ;

            // Поиск меньшего элемента
            while (array[--rightPtr] > pivot) ;

            if (leftPtr >= rightPtr) // Если указатели сошлись,
                break; // разбиение закончено.
            else // В противном случае
                swap(array, leftPtr, rightPtr); // поменять элементы местами.
        }

        swap(array, leftPtr, right - 1); // Перестановка опорного элемента

        return leftPtr; // Возврат позиции опорного элемента
    }

    public void manualSort(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return; // Сортировка не требуется
        if (size == 2) { // 2-сортировка left и right
            if (array[left] > array[right])
                swap(array, left, right);
            return;
        } else // Размер равен 3
        { // 3-сортировка left, center и right
            if (array[left] > array[right - 1])
                swap(array, left, right - 1); // left, center
            if (array[left] > array[right])
                swap(array, left, right); // left, right
            if (array[right - 1] > array[right])
                swap(array, right - 1, right); // center, right
        }
    }
}
