//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针


package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum{

    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        List<List<Integer>> res = solution.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
        res.forEach(l ->{
            l.forEach( s ->{
                System.out.print(s + " ");
            });
            System.out.println();
        });
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>(16);
            if (nums.length < 4){
                return Collections.emptyList();
            }

            for (int indexFirst = 0; indexFirst < nums.length - 3; indexFirst ++){
                if (indexFirst > 0 && nums[indexFirst - 1] == nums[indexFirst]){
                    continue;
                }
                for (int indexSecond = indexFirst + 1; indexSecond < nums.length - 2; indexSecond ++){
                    if (indexSecond > indexFirst + 1 && nums[indexSecond - 1] == nums[indexSecond]){
                        continue;
                    }
                    int left = indexSecond + 1;
                    int right = nums.length - 1;
                    while(left < right){
                        int fourNumsSum = nums[indexFirst] + nums[indexSecond] + nums[left] + nums[right];
                        if (fourNumsSum == target){
                            List<Integer> resTemp = new ArrayList<>(16);
                            resTemp.addAll(Arrays.asList(nums[indexFirst], nums[indexSecond], nums[left], nums[right]));
                            res.add(resTemp);
                            while(left < right && nums[left] == nums[left + 1]){
                                left ++;
                            }
                            while(left < right && nums[right] == nums[right - 1]){
                                right --;
                            }
                            left ++;
                            right--;
                        }else if (fourNumsSum < target){
                            while(left < right && nums[left] == nums[left + 1]){
                                left ++;
                            }
                            left ++;
                        }else {
                            while(left < right && nums[right] == nums[right - 1]){
                                right --;
                            }
                            right --;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}