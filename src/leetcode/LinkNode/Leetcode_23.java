package leetcode.LinkNode;

import commons.sturcture.ListNode;

public class Leetcode_23 {


    public ListNode mergeKLists(ListNode[] list) {
        // merge K list
        // 我觉得可以看做是两两合并这样
        if (list.length == 0) {
            return null;
        }
        if (list.length == 1) {
            return list[0];
        }
        ListNode merged = null;

        for (int i = 0; i < list.length; i++) {
            merged = mergeTwoLists(list[i], merged);
        }
        return merged;
    }

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
