package leetcode;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums.length==0){
            return result;
        }
        int targetIndex = binarySearch(nums, 0, nums.length - 1, target);
        if (targetIndex == -1) {
            return result;
        }
        int st = targetIndex, en = targetIndex;
        while (st>=0 && nums[targetIndex] == nums[st]){
            st--;
        }
        while (en<nums.length && nums[targetIndex] == nums[en]){
            en++;
        }
        result[0] = st+1;
        result[1] = en-1;
        return result;
    }

    public int binarySearch(int[] nums, int st, int en, int target) {
        int mid = (st + en) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (target >= nums[st] && target < nums[mid]) {
            return binarySearch(nums, st, mid - 1, target);
        } else if (target > nums[mid] && target <= nums[en]) {
            return binarySearch(nums, mid + 1, en, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        FirstAndLastPositionOfElementInSortedArray srch = new FirstAndLastPositionOfElementInSortedArray();
        Arrays.stream(srch.searchRange(nums, target)).forEach(System.out::println);
    }
}
