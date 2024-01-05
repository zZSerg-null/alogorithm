package search;

import java.util.ArrayList;

public class BinarySearch {

    public void find(long range, long target) {
        find(0L, range, target, 0);
    }

    public void find(long left, long right, long target, int step) {
        while (true) {
            step++;
            long middle = (left + right) / 2;

            if (target == middle) {
                System.out.println(step + ": " + middle);
                break;
            }

            if (left > right || target < right) {
                System.out.println("Not found");
                break;
            }

            if (target > middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    }

    public void find(int[] array, int target) {

        ArrayList<String> s = new ArrayList<>();

        int step = 0;

        int left = 0;
        int right = array.length-1;

        while (true) {
            int middle = (left + right) / 2;
            step++;
            System.out.println("left:"+left+", right: "+right);

            if (array[middle] == target) {
                System.out.println("yes");
                break;
            } else if (left > right){
                System.out.println("NO");
                break;
            } else {
                if (target > array[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        System.out.println("step:" + step);
    }


    public static void main(String[] args) {
        int[] ints = {0,1,2,3,4,5,6,7,8,9};
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.find(ints, 9);
    }
}
