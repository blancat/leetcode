package leetcode.LinkNode;

import commons.sturcture.ListNode;

public class Leetcode_21 {

    /** 合并两个有序数列 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 合并两个有序数列
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return dummy.next;
    }
}
