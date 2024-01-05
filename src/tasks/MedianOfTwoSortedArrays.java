package tasks;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int posA = 0;
        int posB = 0;
        int mergePos = 0;
        int[] merge = new int[nums1.length + nums2.length];

        while (posA < nums1.length && posB < nums2.length){
            if (nums1[posA] < nums2[posB]){
                merge[mergePos] = nums1[posA];
                posA++;
            } else {
                merge[mergePos] = nums2[posB];
                posB++;
            }
            mergePos++;
        }

        while (posA < nums1.length) {
            merge[mergePos++] = nums1[posA++];
        }
        while (posB < nums2.length) {
            merge[mergePos++] = nums2[posB++];
        }
        return findMedian(merge);
    }

    public static double findMedian(int[] arr) {
        int a = 0;
        if (arr.length > 0) {
            int middle = arr.length / 2;
            a = arr[middle];
            if (arr.length % 2 == 0) {
                int b = arr[middle - 1];
                return (a + b) / 2.0;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1,3};
        int[] b = {2,7};
        System.out.println( findMedianSortedArrays(a, b) );
    }
}
