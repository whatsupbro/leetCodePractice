//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 535 👎 0

package leetcode.editor.cn;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        solution.deleteDuplicates(node1);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode feakHead = new ListNode(0);
            feakHead.next = head;
            ListNode pre = feakHead;
            while (head != null) {
                if (head.next == null || head.next.val != head.val) {
                    head = head.next;
                    pre = pre.next;
                } else {
                    int curVal = head.val;
                    while (head != null && head.val == curVal) {
                        head = head.next;
                    }
                    pre.next = head;
                }
            }

            return feakHead.next;
        }

        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode pre = head;
            ListNode next = head.next;
            while (next != null) {
                if (next.val == pre.val) {
                    while (next.val == pre.val) {
                        next = next.next;
                    }
                    pre.next = next;
                }
                if (next != null) {
                    next = next.next;
                    pre = pre.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}