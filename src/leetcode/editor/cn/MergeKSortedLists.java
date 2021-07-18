//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1220 👎 0

package leetcode.editor.cn;

import java.util.List;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return mergeKLists(lists, 0, lists.length - 1);
        }

        public ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end)
                return lists[start];
            if (start > end)
                return null;
            int mid = (start + end) >> 1;
            return mergeTwo(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end));
        }

        public ListNode mergeTwo(ListNode one, ListNode two) {
            if (one == null)
                return two;
            if (two == null)
                return one;
            ListNode head = new ListNode(0);
            ListNode node = head;
            while (one != null && two != null) {
                if (one.val < two.val) {
                    node.next = one;
                    one = one.next;
                } else {
                    node.next = two;
                    two = two.next;
                }
                node = node.next;
            }
            node.next = one == null ? two : one;
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}