//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

  
  package com.honorzhang.leetcode.editor.cn;
  public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
          System.out.println(solution.longestPalindrome("abbdfcfdbba"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        //中心扩散法
        if (s.length() == 0 || s.length() == 1){
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++){
            int oddStringLen = centerDiffusion(s, i, i);
            int evenStringLen = centerDiffusion(s, i, i + 1);

            int finalLen = Math.max(oddStringLen, evenStringLen);
            if (finalLen > end - start){
                start = i - (finalLen - 1)/2;
                end = i + finalLen/2;
            }
        }
        return s.substring(start, end + 1);

    }

    private int centerDiffusion(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        return right -  left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }