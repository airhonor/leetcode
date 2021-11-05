//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 182 👎 0


package com.honorzhang.leetcode.editor.cn;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode result = new ListNode(0);
            ListNode temp = result;
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    result.next = list2;
                    list2 = list2.next;
                } else {
                    result.next = list1;
                    list1 = list1.next;
                }
                result = result.next;
            }
            if (list1 != null) {
                result.next = list1;
            }
            if (list2 != null) {
                result.next = list2;
            }
            return temp.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}