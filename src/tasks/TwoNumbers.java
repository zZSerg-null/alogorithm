package tasks;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumbers {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {

                if (hashMap.containsKey(target - nums[i])) {
                    return new int[]{hashMap.get(target - nums[i]), i};
                } else
                    hashMap.put(nums[i], i);

            }
            return new int[0];
        }

    public static void main(String[] args) {
        int[] t = new int[]{3,3};
        TwoNumbers twoNumbers = new TwoNumbers();
        System.out.println(Arrays.toString(twoNumbers.twoSum(t, 6)));
    }
}