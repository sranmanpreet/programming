package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> triplet;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int numIdx1 = 0;
        int numIdx2;
        int numIdx3;
        int numLen = nums.length-1;
        int tempSum;
        while (numIdx1 <= numLen) {
            if (numIdx1 > 0 && nums[numIdx1] == nums[numIdx1 - 1]) {
                numIdx1++;
                continue;
            }
            numIdx2 = numIdx1 + 1;
            numIdx3 = numLen;
            while (numIdx2 < numIdx3 && numIdx2 <= numLen && numIdx3 > numIdx1) {
                tempSum = nums[numIdx1] + nums[numIdx2] + nums[numIdx3];
                if (tempSum > 0) {
                    numIdx3--;
                } else if (tempSum < 0) {
                    numIdx2++;
                } else {
                    triplet = new ArrayList<>(Arrays.asList(nums[numIdx1], nums[numIdx2], nums[numIdx3]));
                    result.add(triplet);
                    numIdx3--;
                    while (numIdx2 < numIdx3 && nums[numIdx3] == nums[numIdx3 + 1]) numIdx3--;
                }
            }
            numIdx1++;
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = {0,0,0,0};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(nums));
    }

}
