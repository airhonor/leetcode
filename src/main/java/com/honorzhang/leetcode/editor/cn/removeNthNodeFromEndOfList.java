//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

  
  package com.honorzhang.leetcode.editor.cn;
  public class removeNthNodeFromEndOfList {
      public static void main(String[] args) {
           Solution solution = new removeNthNodeFromEndOfList().new Solution();
           ListNode one = new ListNode(1);
           ListNode two = new ListNode(2);
           ListNode three = new ListNode(3);
           ListNode four = new ListNode(4);
           ListNode five = new ListNode(5);
           one.next = two;
           two.next = three;
           three.next = four;
           four.next = five;
           five.next = null;
           ListNode res = solution.removeNthFromEnd(one, 4);
           while(res != null){
               System.out.println(res.val);
               res = res.next;
           }
      }
      //leetcode submit region begin(Prohibit
      // modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i ++){
            fast = fast.next;
        }
        if (fast == null){
            return head.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }

  }