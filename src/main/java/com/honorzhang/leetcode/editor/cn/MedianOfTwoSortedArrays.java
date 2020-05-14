//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

  
  package com.honorzhang.leetcode.editor.cn;
  public class MedianOfTwoSortedArrays{
      public static void main(String[] args) {
           Solution solution = new MedianOfTwoSortedArrays().new Solution();
           int[] nums1 = new int[]{1, 3};
           int[] nums2 = new int[]{2};
          System.out.println(solution.findMedianSortedArrays(nums1, nums2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n < m){
            //保证n>=m
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax){
            int i = (iMin + iMax)/2;
            int j = (m + n + 1)/2 - i;
            if (i < iMax && nums1[i] < nums2[j - 1]){
                iMin =i + 1;
            }else if (i > iMin && nums1[i - 1] > nums2[j]){
                iMax = i - 1;
            }else{
                // i is perfect
                int maxLeft;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;

            }
        }
        return 0.0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }