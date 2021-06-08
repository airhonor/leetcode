//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 716 👎 0

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
          int[] c = {1,1,2};
          List<List<Integer>> result = solution.permuteUnique(c);
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
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0){
                return res;
            }

            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            backTracing(nums, used);
            return res;
        }


          public void backTracing(int[] nums, boolean[] used){
              if (path.size() == nums.length){
                  res.add(new ArrayList<>(path));
                  return;
              }

              for (int i = 0; i < nums.length; i++) {
                  if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]){
                      continue;
                  }
                  if (!used[i]){
                      path.push(nums[i]);
                      used[i] = true;
                      backTracing(nums, used);
                      used[i] = false;
                      path.pop();
                  }else {
                      continue;
                  }
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }