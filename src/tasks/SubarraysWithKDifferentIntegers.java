package tasks;

import java.util.Arrays;

public class SubarraysWithKDifferentIntegers {

    public static int subArraysWithKDistinct(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }

        int count = 0;
        int startPos = 0;
        int pos = 1;
        int min = nums[0];

        while (pos < nums.length-1) {
            //1, 2, 1, 2, 3
           // System.out.println("start: pos:"+pos+", num[pos]:"+nums[pos]);

            while (pos < nums.length && nums[pos++] - min < k){
               // pos++;
               // System.out.println("pos:"+pos+", num[pos]:"+nums[pos-1]);
            }
            pos--;

            count += separateArrays(Arrays.copyOfRange(nums, startPos, pos));

            if (pos == nums.length-1 && nums[pos] - nums[pos-1] < k) {
               count ++;
            //separateArrays(Arrays.copyOfRange(nums, pos - 1, pos + 1));
            }
        }

        //arrayList.forEach(ints -> System.out.print(Arrays.toString(ints) + ", "));
        return count;
    }

    private static int separateArrays(int[] nums){
        System.out.println(Arrays.toString(nums));
        int count = 0;

        int left = 0;
        int right = nums.length-1;
        while (right - left++ > 1){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,3,4};
        System.out.println( subArraysWithKDistinct(a, 3) );
    }
}
// [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
//[1, 2, 1, 2], [1, 2], [2, 3], [2, 1], [1, 2], [1, 2, 1]
//[1, 2, 1, 2], [1, 2], [2, 3], [2, 1], [1, 2], [1, 2, 1],

/*
// , [2,1],  [1,2,1,2]
1,2,1,2
2,1,2
1,2
1,2,1
1,2
*/
