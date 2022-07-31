package leetcode.LinkNode;

import commons.sturcture.ListNode;
import commons.utils.CommonUtils;

import java.util.Arrays;

public class Leetcode_19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1, head);

        // 找到前驱节点
        ListNode nNode = findNthFromEnd(dummy, n + 1);
        nNode.next = nNode.next.next;
        return dummy.next;
    }

    public ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        int count = 0;
        while (count < n) {
            p1 = p1.next;
            count++;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
