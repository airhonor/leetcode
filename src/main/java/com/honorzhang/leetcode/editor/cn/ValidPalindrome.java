//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

  
  package com.honorzhang.leetcode.editor.cn;
  public class ValidPalindrome {
      public static void main(String[] args) {
          Solution solution = new ValidPalindrome().new Solution();
          String s = "0P";
          System.out.println(solution.isPalindrome(s));
      }

      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public boolean isPalindrome(String s) {
              s = s.toLowerCase();
              int i = s.length() - 1;
              int j = 0;
              while (j < i) {
                  char c = s.charAt(0);
                  if (!((s.charAt(i) <= 'z' && s.charAt(i) >= 'a') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))){
                      i--;
                      continue;
                  }
                  if (!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                      j++;
                      continue;
                  }
                  if (s.charAt(i) != s.charAt(j)) {
                      return false;
                  }
                  i--;
                  j++;
              }
//leetcode submit region end(Prohibit modification and deletion)

              return true;
          }
      }
  }