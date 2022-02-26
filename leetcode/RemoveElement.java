package leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(nums, val));
    }
}
