package leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int st = 0, en = nums.length - 1;
        while (st <= en) {
            int mid = (st + en) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[st] <= nums[mid]) {
                if (target >= nums[st] && target < nums[mid]) {
                    en = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[en]) {
                    st = mid + 1;
                } else {
                    en = mid - 1;
                }
            }
        }

        return -1;
    }

    public int binarySearch(int[] nums, int st, int en, int target) {
        int mid = (st + en) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (st > en) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        SearchInRotatedSortedArray srch = new SearchInRotatedSortedArray();
        System.out.println(srch.search(nums, target));
    }
}
