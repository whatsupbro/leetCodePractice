//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1245 👎 0

package leetcode.editor.cn;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(-5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        solution.sortList(n1);
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode cur = slow.next;
            slow.next = null;
            slow = cur;
            ListNode first = sortList(head);
            ListNode second = sortList(slow);
            return mergeList(first, second);
        }

        public ListNode mergeList(ListNode node1, ListNode node2) {
            ListNode p1 = node1;
            ListNode p2 = node2;
            ListNode head;
            if (p1.val < p2.val) {
                head = p1;
                p1 = p1.next;
            } else {
                head = p2;
                p2 = p2.next;
            }
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    head.next = p1;
                    p1 = p1.next;
                } else {
                    head.next = p2;
                    p2 = p2.next;
                }
                head = head.next;
            }
            if (p1 != null) {
                head.next = p1;
            } else {
                head.next = p2;
            }
            if (node1.val < node2.val) {
                return node1;
            } else {
                return node2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}