package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    static List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinations = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();

        combination(candidates, target, combination, 0, 0);
        return combinations;
    }

    private void combination(int[] candidates, int target, List<Integer> currComb, int currIndex, int currSum) {
        if(currSum>target){
            return;
        }
        if(currSum==target){
            combinations.add(new ArrayList<>(currComb));
            return;
        }
        for(int i=currIndex; i<candidates.length; i++){
            if(i>currIndex && candidates[i] == candidates[i-1]){
                continue;
            };
            currComb.add(candidates[i]);
            currSum+=candidates[i];
            combination(candidates, target, currComb, i+1, currSum);
            currSum-=candidates[i];
            currComb.remove(currComb.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSum2 cs2 = new CombinationSum2();
        combinations = cs2.combinationSum2(candidates, target);
        combinations.forEach(combination -> { combination.forEach(System.out::println); System.out.println("--------------");});
    }
}
