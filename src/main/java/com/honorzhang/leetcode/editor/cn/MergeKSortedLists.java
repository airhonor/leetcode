//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

  
  package com.honorzhang.leetcode.editor.cn;
  public class MergeKSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeKSortedLists().new Solution();
           ListNode l11 = new ListNode(1);
           ListNode l12 = new ListNode(4);
           ListNode l13 = new ListNode(5);
           ListNode l21 = new ListNode(1);
           ListNode l22 = new ListNode(3);
           ListNode l23 = new ListNode(4);
           ListNode l31 = new ListNode(2);
           ListNode l32 = new ListNode(9);
           ListNode l33 = new ListNode(12);

           l11.next = l12;
           l12.next = l13;

           l21.next = l22;
           l22.next = l23;

           l31.next = l32;
           l32.next = l33;

           ListNode[] ls = new ListNode[]{l11, l21, l31};
          ListNode res = solution.mergeKLists(ls);
          while (res != null){
              System.out.println(res.val);
              res = res.next;
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            //第一个想法是分治，两个链表两个合并，合并后的链表再合并
            if (lists.length == 0){
                return null;
            }
            return helper(lists, 0, lists.length - 1);
        }

    //通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并
    //通过合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
    private ListNode helper(ListNode[] lists, int begin, int end) {
        if(begin==end) {
            return lists[begin];
        }
        int mid = begin+(end-begin)/2;
        ListNode left = helper(lists,begin,mid);
        ListNode right = helper(lists,mid+1,end);
        return mergeTwoSortedListNode(left,right);
    }

    /**
     * 合并两个有序链表
     * @param l1 第一个有序链表
     * @param l2 第二个有序链表
     * @return 合并后的有序链表
     */
        private ListNode mergeTwoSortedListNode(ListNode l1, ListNode l2){
            if (l1 == null || l2 == null){
                return l1 == null? l2: l1;
            }
            if (l1.val > l2.val){
                l2.next = mergeTwoSortedListNode(l1, l2.next);
                return l2;
            }else {
                l1.next = mergeTwoSortedListNode(l1.next, l2);
                return l1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

      static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
      }
  }