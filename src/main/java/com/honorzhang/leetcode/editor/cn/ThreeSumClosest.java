//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest{
      public static void main(String[] args) {
           Solution solution = new ThreeSumClosest().new Solution();
           int[] nums = {1,2,4,8,16,32,64,128};
           int target = 82;
          System.out.println(solution.threeSumClosest(nums, target));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length-2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int threeNumsSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(threeNumsSum - target) < Math.abs(closestSum - target)){
                    closestSum = threeNumsSum;
                }
                if (threeNumsSum - target > 0){
                    right--;
                }else if (threeNumsSum - target < 0){
                    left++;
                }else {
                    return threeNumsSum;
                }
            }
        }
        return closestSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }