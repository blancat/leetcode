package leetcode.LinkNode;

import commons.sturcture.ListNode;
import commons.utils.CommonUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_23 {

    public static void main(String[] args) {
        Leetcode_23 fun = new Leetcode_23();
        ListNode listNode1 = CommonUtils.buildListNode(Arrays.asList(1, 4, 5));
        ListNode listNode2 = CommonUtils.buildListNode(Arrays.asList(1, 3, 4));
        ListNode listNode3 = CommonUtils.buildListNode(Arrays.asList(2, 6));
        ListNode[] lists = {listNode1, listNode2, listNode3};
        fun.mergeKLists2(lists);
    }


    ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode listNode : lists) {
            priorityQueue.add(listNode);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode listNode = priorityQueue.poll();
            p.next = listNode;
            if (listNode.next != null) {
                priorityQueue.add(listNode.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

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
