//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1127 👎 0

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.Arrays;

/**
   * @author honorzhang
   */


  public class NextPermutation{
      public static void main(String[] args) {
           Solution solution = new NextPermutation().new Solution();
           int[] nums = {1, 4, 5, 9, 7, 6, 5};
           solution.nextPermutation(nums);
          for (int i = 0; i < nums.length; i++) {
              System.out.print(nums[i] + " ");
          }
      }


      //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
           //反向查找，找到第一个低位比高位数大的位置，记低位数位置为，
            // 然后继续从最低位查找第一个比位置数字的大的数，交换，并让位置i
            //后面的数保持升序
           int i = nums.length - 2;
           while(i >= 0 && nums[i] >= nums[i + 1]){
               i--;
           }

           if (i >= 0){
               int j = nums.length - 1;
               while (j >= 0 && nums[i] >= nums[j]){
                   j--;
               }
               swap(nums, i , j);
           }
           reverse(nums, i + 1);
        }

        public void reverse(int[] nums, int start){
            int right = nums.length - 1;
            while (start < right){
                swap(nums, start, right);
                start++;
                right--;
            }
        }

        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

  }