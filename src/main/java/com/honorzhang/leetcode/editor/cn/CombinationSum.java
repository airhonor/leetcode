//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1373 👎 0

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum{
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
           int[] c = {2,3,5};
          List<List<Integer>> result = solution.combinationSum(c, 8);
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
          public List<List<Integer>> combinationSum(int[] candidates, int target) {
              if(candidates.length == 0){
                  return res;
              }
              backTracing(candidates, target, 0);
              return res;
          }

          public void backTracing(int[] candidates, int target, int startIndex){
              if(target < 0){
                  return;
              }
              if(target == 0){
                  res.add(new ArrayList<>(path));
                  return;
              }

              for(int i=startIndex; i<candidates.length; i++){
                  path.push(candidates[i]);
                  backTracing(candidates, target-candidates[i], i);
                  path.pop();
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }