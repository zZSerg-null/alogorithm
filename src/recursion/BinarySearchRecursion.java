package recursion;

public class BinarySearchRecursion {

    private void binarySearch(int left, int right, int target, int[] array) {
        if (right < left) {
            System.out.println("ничего не найдено");
            return;
        }

        int middle = (left + right) / 2;
        System.out.println("middle = " + middle);

        if (target == array[middle]) {
            System.out.println("Найдено! ");
        } else {

            if (target > array[middle]) {
                binarySearch(middle + 1, right, target, array);
            } else {
                binarySearch(left, middle - 1, target, array);
            }

        }
    }

    public static void main(String[] args) {
        BinarySearchRecursion recursion = new BinarySearchRecursion();
        int[] arr = new int[100_000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i;
        }

        recursion.binarySearch(0, arr.length, 55, arr);
    }

}
