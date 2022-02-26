package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int result = 0;
        if (nums.length < 2) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1] ) {
                nums[i] = 101;
                i++;
                result++;
            }
        }
        Arrays.sort(nums);
        return nums.length - result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
        System.out.println(rd.removeDuplicates(nums));
    }
}
