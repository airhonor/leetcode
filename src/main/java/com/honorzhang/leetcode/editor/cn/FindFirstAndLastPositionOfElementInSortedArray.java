//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1026 👎 0

  
  package com.honorzhang.leetcode.editor.cn;
  public class FindFirstAndLastPositionOfElementInSortedArray{
      public static void main(String[] args) {

           Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
          int[] nums = {};
          int[] result = solution.searchRange(nums, 8);
          for (int i = 0; i < result.length; i++) {
              System.out.print(result[i] + " ");
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int[] searchRange(int[] nums, int target) {
                int[] result = {-1, -1};
                int left = 0;
                int mid = 0;
                int right = nums.length - 1;
                while(left <= right){
                    mid = left + (right - left)/2;
                    if (nums[mid] == target){
                        //判断最开始和最后的位置，以mid为中心，向两边延伸查找
                        int leftIndex = mid;
                        int rightIndex = mid;
                        while(leftIndex > -1 && nums[leftIndex] == target){
                            leftIndex--;
                        }
                        while(rightIndex < nums.length && nums[rightIndex] == target){
                            rightIndex++;
                        }
                            return new int[]{leftIndex + 1, rightIndex - 1};

                    }else if(nums[mid] < target){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                return result;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

  }