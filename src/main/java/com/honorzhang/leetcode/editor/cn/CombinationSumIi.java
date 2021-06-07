//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 596 👎 0

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumIi{
      public static void main(String[] args) {
          int[] c = {10,1,2,7,6,1,5};
          Solution solution = new CombinationSumIi().new Solution();
          List<List<Integer>> result = solution.combinationSum2(c, 8);
          for (int i = 0; i < result.size(); i++) {
              for (int j = 0; j < result.get(i).size(); j++) {
                  System.out.print(result.get(i).get(j) + " ");
              }
              System.out.println();
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          List<List<Integer>> res = new ArrayList<>();
          Stack<Integer> path = new Stack<>();
          public List<List<Integer>> combinationSum2(int[] candidates, int target) {
              if(candidates.length == 0){
                  return res;
              }
              Arrays.sort(candidates);
              backTracing(candidates, target, 0);
              return res;
          }

          public void backTracing(int[] candidates, int target, int startIndex){
              if(target == 0){
                  res.add(new ArrayList<>(path));
                  return;
              }

              for(int i=startIndex; i<candidates.length; i++){
                  if(target - candidates[i] < 0){
                      break;
                  }

                  if(i > startIndex && candidates[i] == candidates[i - 1]){
                      continue;
                  }
                  path.push(candidates[i]);
                  backTracing(candidates, target-candidates[i], i+1);
                  path.pop();
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }