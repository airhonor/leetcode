//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

  
  package com.honorzhang.leetcode.editor.cn;
  public class MergeTwoSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists().new Solution();
           ListNode one = new ListNode(1);
          ListNode two = new ListNode(2);
          ListNode three = new ListNode(4);
          ListNode four = new ListNode(1);
          ListNode five = new ListNode(3);
          ListNode six = new ListNode(4);
          one.next = two;
          two.next = three;
          //three.next = four;
          four.next = five;
          five.next = six;
          ListNode res = solution.mergeTwoLists(one, four);
          while(res != null){
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null){
                return l1 == null? l2: l1;
            }
            ListNode temp = new ListNode(0);
            ListNode res = temp;
            while (l1 != null && l2 != null){
                if (l1.val > l2.val){
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                }else {
                    temp.next =  new ListNode(l1.val);
                    l1 = l1.next;
                }
                temp = temp.next;
            }
            if (l1 == null){
                temp.next = l2;
            }
            if (l2 == null){
                temp.next = l1;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

  }