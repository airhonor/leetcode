//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

  
  package com.honorzhang.leetcode.editor.cn;
  public class ReverseNodesInKGroup{
      public static void main(String[] args) {
           Solution solution = new ReverseNodesInKGroup().new Solution();
           ListNode l11 = new ListNode(1);
          ListNode l12 = new ListNode(4);
          ListNode l13 = new ListNode(5);
          ListNode l14 = new ListNode(7);
          ListNode l15 = new ListNode(8);


          l11.next = l12;
          l12.next = l13;
          l13.next = l14;
          l14.next = l15;

          ListNode res = solution.reverseKGroup(l11, 5);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1){
                return head;
            }
            //k个一组旋转
            ListNode res = new ListNode(0);
            res.next = head;
            ListNode resTemp = res;
            while(head != null){
                ListNode headTemp = head;
                for (int i=0; i<k-1 && head != null; i++){
                    head = head.next;
                }
                if (head == null){
                    break;
                }
                ListNode headNext = head.next;
                head.next = null;
                resTemp.next = reverseListNode(headTemp);

                while(resTemp.next != null){
                    resTemp = resTemp.next;
                }
                resTemp.next = headNext;
                head = resTemp.next;

            }

            return res.next;

        }
        private ListNode reverseListNode(ListNode listNode){
            ListNode tail = null;
            while(listNode != null){
                ListNode temp = listNode.next;
                listNode.next = tail;
                tail = listNode;
                listNode = temp;
            }
            return tail;
        }
    }

      static class ListNode{
          int val;
          ListNode next;
          public ListNode(int val){
              this.val = val;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }