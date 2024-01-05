package sort.merge;

import sort.BasicSortClass;

import java.util.Arrays;

public class MergeTopDown2 extends BasicSortClass {

    public static void main(String[] args) {
        new MergeTopDown2().test();
    }

    public long sort(int[] array) {
        long start = System.nanoTime();
        mergeSort(array);
        long end = System.nanoTime();
        System.out.println(showResult(start, end) + " top-down2 merge sort");
        return end - start;
    }

    private void test() {
        int[] a = {9, 1, 6, 3, 5, 67, 34, 2};
        //1,2,3,5,6,9,34,67
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int[] temp = new int[array.length];
        particle(array, temp, 0, array.length - 1);
    }

    private void particle(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            particle(array, temp, left, middle);
            particle(array, temp, middle + 1, right);
            merge(array, temp, left, middle, right);
        }
    }

    private void merge(int[] array, int[] temp, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int max = Integer.MAX_VALUE;

        int leftVal;
        int rightVal;
        for (int index = left, leftPos = left, rightPos = middle + 1; index <= right; index++) {
            leftVal = (leftPos > middle) ? max : temp[leftPos];
            rightVal = (rightPos > right) ? max : temp[rightPos];

            if (leftVal < rightVal) {
                array[index] = leftVal;
                leftPos++;
            } else {
                array[index] = rightVal;
                rightPos++;
            }
        }
    }

}
