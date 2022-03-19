package leetcode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target, -1);
    }

    private int binarySearch(int[] nums, int st, int en, int target, int closestIndex) {
        int mid = (st+en)/2;

        if(nums[mid]==target) {
            return mid;
        }

        if(target>=nums[st] && target<nums[mid]) {
            return binarySearch(nums, st, mid-1, target, closestIndex);
        } else if (target>nums[mid] && target<=nums[en]) {
            return binarySearch(nums, mid+1, en, target, closestIndex);
        } else {
            if(nums[st]>target) {
                closestIndex = st;
            } else {
                // nums[en]<target
                closestIndex = en+1;
            }
        }

        return closestIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(nums, target));
    }
}
