//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
           solution.generateParenthesis(3).forEach(ls ->{
               System.out.println(ls);
           });
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return res;
        }
        backTrace(n, n, new StringBuilder());
        return res;
    }
    private void backTrace(int left, int right, StringBuilder sb){
        if (right < left){
            return;
        }
        if (left < 0 || right < 0){
            return;
        }
        if (left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        backTrace(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backTrace(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }