package leetcode;

import java.lang.annotation.Annotation;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int i, j =0;
        int len = nums.length;
        for(i=0; i<len; i++) {
            for(j=i+1; j<len; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum ts = new TwoSum();
        System.out.println(ts.twoSum(nums, target));
    }
}
