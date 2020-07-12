//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串

  
  package com.honorzhang.leetcode.editor.cn;
  public class ImplementStrstr{
      public static void main(String[] args) {
           Solution solution = new ImplementStrstr().new Solution();
           String  haystack = "";
           String needle = "";
          System.out.println(solution.strStr(haystack, needle));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int sLen = haystack.length();
        int pLen = needle.length();
        int[] next = new int[pLen];
        GetNext(needle, next);
        while (i < sLen && j < pLen)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }
  private void GetNext(String needle,int next[])
  {
      int pLen = needle.length();
      next[0] = -1;
      int k = -1;
      int j = 0;
      while (j < pLen - 1)
      {
          //p[k]表示前缀，p[j]表示后缀
          if (k == -1 || needle.charAt(j) == needle.charAt(k))
          {
              ++k;
              ++j;
              next[j] = k;
          }
          else
          {
              k = next[k];
          }
      }
  }



      }
//leetcode submit region end(Prohibit modification and deletion)

  }