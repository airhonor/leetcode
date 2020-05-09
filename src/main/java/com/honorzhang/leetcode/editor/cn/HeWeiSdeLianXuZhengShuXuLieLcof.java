//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//

  
  package com.honorzhang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof{
      public static void main(String[] args) {
           Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
           int[][] result = solution.findContinuousSequence(9);
           for (int i = 0; i < result.length; i ++){
               for (int j = 0; j < result[i].length; j++){
                   System.out.print(result[i][j]);
               }
               System.out.println();
           }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ls = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sum = 0;
        while (left <= target/2){
            if (sum < target){
                sum = sum + right;
                right ++;
            }else if (sum > target){
                sum = sum - left;
                left ++;
            }else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i ++){
                    arr[i - left] = i;
                }
                ls.add(arr);
                sum = sum - left;
                left ++;
            }
        }
        return ls.toArray(new int[ls.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }