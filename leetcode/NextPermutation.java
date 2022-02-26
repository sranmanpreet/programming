package leetcode;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && (nums[i+1]<=nums[i])){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i])
                j--;
            swap(nums,i,j);
        }
        reverse(nums, i+1);
    }

    public void reverse(int nums[], int low){
        int high=nums.length-1;
        while(low<high){
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    public void swap(int nums[],int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
