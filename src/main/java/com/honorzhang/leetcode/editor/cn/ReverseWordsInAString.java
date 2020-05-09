//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串

  
  package com.honorzhang.leetcode.editor.cn;
  public class ReverseWordsInAString{
      public static void main(String[] args) {
           Solution solution = new ReverseWordsInAString().new Solution();
          System.out.println(solution.reverseWords("hello   world!"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        //去掉前后空格
        s = s.trim();
        if(s.length() < 3){
            return s;
        }
        int right = s.length();
        int left = right - 1;
        String re = "";
        while(left >= 0){
            if (left == 0){
                re += s.substring(left, right);
                break;
            }
            if (left - 1 >= 0 && s.charAt(left - 1) != ' ' && s.charAt(left) == ' '){
                right = left;
                left --;
                continue;
            }
            if (left - 1 >= 0 && s.charAt(left - 1) == ' ' && s.charAt(left) != ' '){
                re += s.substring(left, right) + " ";
                left --;
                continue;
            }
            left--;

        }
        return re;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }