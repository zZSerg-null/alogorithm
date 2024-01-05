package tasks;

public class ArrayMedian {

    private double findMedian(int[] arr) {
        int middle = arr.length / 2;
        int a = arr[middle];
        if (arr.length % 2 == 0) {
            int b = arr[middle - 1];
            System.out.println(a + ", " + b);
            return (a + b) / 2.0;
        }
        return a;
    }


}
