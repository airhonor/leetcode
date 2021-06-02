//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 594 👎 0

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.*;

public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
           int n = 4;
           int k = 2;
          List<List<Integer>> result = solution.combine1(n, k);
          for (int i = 0; i < result.size(); i++) {
              for (int j = 0; j < k; j++) {
                  System.out.print(result.get(i).get(j) + " ");
              }
              System.out.println();
          }



      }
      //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
          List<List<Integer>> res = new ArrayList<>();
          Stack<Integer> path = new Stack<>();
          public List<List<Integer>> combine(int n, int k) {

            if (k <= 0 || n < k) {
              return res;
          }
          // 从 1 开始是题目的设定
          dfs(n, k, 1);
        return res;
      }

    private void dfs(int n, int k, int begin) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.push(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.pop();
        }
    }
          Stack<Integer> lst = new Stack<>();
          List<List<Integer>> result = new ArrayList<>();
          public List<List<Integer>> combine1(int n, int k) {
              if (k <= 0 || n < k) {
                  return result;
              }
              backTracing(n, k, 1);
              return result;
          }
          public void backTracing(int n, int k, int i){
              if (lst.size() == k){
                  result.add(new ArrayList<>(lst));
                  return;
              }
              for (int j = i; j <= n; j++) {
                  lst.push(j);
                  backTracing(n, k, j+1);
                  lst.pop();
              }
          }

    }


//leetcode submit region end(Prohibit modification and deletion)

  }