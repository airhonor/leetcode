//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找

  
  package com.honorzhang.leetcode.editor.cn;
  public class DivideTwoIntegers{
      public static void main(String[] args) {
           Solution solution = new DivideTwoIntegers().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        long longDividend = dividend;
        long longDivisor = divisor;
        longDividend = longDividend > 0? longDividend: -longDividend;
        longDivisor = longDivisor > 0? longDivisor: -longDivisor;
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = -1;
        }
        int result = div(longDividend, longDivisor);
        if (sign > 0){
            return result > Integer.MAX_VALUE? Integer.MAX_VALUE: result;
        }
        return -result;

    }

    private int div(long positiveDividend, long positiveDivisor){
        if (positiveDividend < positiveDivisor){
            return 0;
        }
        long tempDivisor = positiveDivisor;
        int positiveResult = 1;
        while((tempDivisor + tempDivisor) <= positiveDividend){
            positiveResult = positiveResult + positiveResult;
            tempDivisor = tempDivisor + tempDivisor;
        }
        return positiveResult + div(positiveDividend - tempDivisor, positiveDivisor);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }