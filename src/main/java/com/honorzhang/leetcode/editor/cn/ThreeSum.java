//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

  
  package com.honorzhang.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
           int[] nums = {1,-1,-1,0};
          List<List<Integer>> rs = solution.threeSum(nums);
          rs.forEach(l ->{
              l.forEach( s ->{
                  System.out.println(s);
              });
          });
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++){
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum < 0){
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    left++;
                }else {
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;
                }
            }
        }
        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }