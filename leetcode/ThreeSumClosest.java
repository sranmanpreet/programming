package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left;
        int right;
        int mid;
        long closestSum = Integer.MAX_VALUE;
        int tempSum;
        for (left = 0; left < nums.length; left++) {
            mid = left + 1;
            right = nums.length - 1;

            while (mid < right) {
                tempSum = nums[left] + nums[mid] + nums[right];
                closestSum = Math.abs(closestSum - target) < Math.abs(tempSum - target) ? closestSum : tempSum;
                if (tempSum > target) {
                    right--;
                } else if (tempSum < target) {
                    mid++;
                } else {
                    break;
                }

            }
        }
        return (int) closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,1,1,3};
        int target = -1;
        ThreeSumClosest tsc = new ThreeSumClosest();
        System.out.println(tsc.threeSumClosest(nums, target));
    }
}
