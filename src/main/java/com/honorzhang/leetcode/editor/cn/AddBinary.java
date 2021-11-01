//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 625 👎 0

  
  package com.honorzhang.leetcode.editor.cn;
  public class AddBinary{
      public static void main(String[] args) {
          String s1 = "101";
          String s2 = "110";
           Solution solution = new AddBinary().new Solution();
          System.out.println(solution.addBinary(s1, s2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1;
             i >= 0 || j >= 0 || carry != 0; i--, j--){
            int x = i >= 0? a.charAt(i) - '0': 0;
            int y = j >= 0? b.charAt(j) - '0': 0;

            int res = (x + y + carry) % 2;
            carry = (x + y + carry) / 2;

            sb.insert(0, res);

        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }