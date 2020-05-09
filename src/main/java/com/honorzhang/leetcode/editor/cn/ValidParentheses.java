//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses{
      public static void main(String[] args) {
           Solution solution = new ValidParentheses().new Solution();
          System.out.println(solution.isValid(""));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if (s.length() == 0 || s.length() == 1){
            return false;
        }
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if (st.empty()){
                    return false;
                }
                if (s.charAt(i) == ')'){
                    if (st.pop() == '('){
                       continue;
                    }else {
                        return false;
                    }
                }else if (s.charAt(i) == '}') {
                    if (st.pop() == '{') {
                        continue;
                    } else {
                        return false;
                    }
                }else {
                    if (st.pop() == '[') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return st.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }