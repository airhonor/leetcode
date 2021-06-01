//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 643 👎 0

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings{
      public static void main(String[] args) {
           Solution solution = new MultiplyStrings().new Solution();
           String num1 = "1123";
           String num2 = "86";
          //System.out.println(solution.multiply(num1, num2));
          System.out.println(solution.add(num1, num2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }


            //以num1为基础，让其每个数字与num2相乘，每次结果存储在数组中，最后相加数字的数
            List<String> list = new ArrayList<>();
            String result = "";
            for (int i = num1.length() - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                int carry = 0;
                for (int j = num2.length() - 1; j >= 0 || carry != 0; j--) {
                    int multiplyOne = num1.charAt(i) - '0';
                    int multiplyTwo = j < 0? 0: num2.charAt(j) - '0';
                    int tempResult = multiplyOne * multiplyTwo + carry;
                    carry = tempResult / 10;
                    sb.insert(0, (tempResult % 10));
                }
                for (int j = 0; j < num1.length() - 1 - i; j++) {
                    sb.append("0");
                }
                result = add(result, sb.toString());
            }
            return result;
        }

        public String add(String str1, String str2) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = str1.length() - 1, j = str2.length() - 1; i >=0 || j >= 0 || carry != 0; i--, j--){
                int str1Add = i < 0? 0: str1.charAt(i) - '0';
                int str2Add = j < 0? 0: str2.charAt(j) - '0';
                int sum = str1Add + str2Add + carry;
                carry = sum / 10;
                sb.append(sum % 10);
            }
            return sb.reverse().toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  }