package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        combination(candidates, target, 0, 0, combination);
        return combinations;
    }

    public void combination(int[] candidates, int target, int currentIndex, int currentSum,
                            List<Integer> currentCombination){
        if(currentSum>target){
            return;
        }
        if(currentSum == target){
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        for(int i=currentIndex; i<candidates.length; i++){
            currentCombination.add(candidates[i]);
            currentSum+=candidates[i];
            combination(candidates, target, i, currentSum, currentCombination);
            currentSum-=candidates[i];
            currentCombination.remove(currentCombination.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum cs = new CombinationSum();
        combinations = cs.combinationSum(candidates, target);
        combinations.forEach(combination -> { combination.forEach(System.out::println); System.out.println("--------------");});
    }
}
