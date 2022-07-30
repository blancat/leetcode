package leetcode.LinkNode;

import commons.sturcture.ListNode;
import commons.utils.CommonUtils;

import java.util.Arrays;

public class Leetcode_86 {

    public static void main(String[] args) {
        Leetcode_86 fun = new Leetcode_86();
        ListNode partition = fun.partition(CommonUtils.buildListNode(Arrays.asList(1, 4, 3, 2, 5, 2)), 3);
        CommonUtils.printListNode(partition);
    }

    public ListNode partition(ListNode head, int x) {
        // 注意 题意是所有比X小的要出现在大于或等于X的节点之前
        // 也就是说 我们首先可以找到第一个比X打或等于X的节点。然后把小于X的节点挪动在这个节点之前，
        // 并且是按顺序挪动
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                head = head.next;
                p1 = p1.next;
            } else {
                // 比x大的或等于X的，把让放置在p2链上
                p2.next = head;
                head = head.next;
                p2 = p2.next;
            }
        }
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
