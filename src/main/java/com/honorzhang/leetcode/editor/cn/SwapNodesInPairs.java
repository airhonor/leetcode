//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

  
  package com.honorzhang.leetcode.editor.cn;
  public class SwapNodesInPairs{
      public static void main(String[] args) {
           Solution solution = new SwapNodesInPairs().new Solution();
           ListNode l11 = new ListNode(1);
          ListNode l12 = new ListNode(4);
          ListNode l13 = new ListNode(5);
          ListNode l14 = new ListNode(7);

          l11.next = l12;
          l12.next = l13;
          l13.next = l14;

          ListNode res = solution.swapPairs(l11);
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
        public ListNode swapPairs(ListNode head) {
            if (head == null){
                return null;
            }
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode temp = pre;
            while(temp.next != null && temp.next.next != null) {
                ListNode start = temp.next;
                ListNode end = temp.next.next;

                temp.next = end;
                start.next = end.next;
                end.next = start;
                temp = start;
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

      static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
      }
  }