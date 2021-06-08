//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1397 👎 0

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
          int[] c = {2,3,5};
          List<List<Integer>> result = solution.permute(c);
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
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return res;
        }
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