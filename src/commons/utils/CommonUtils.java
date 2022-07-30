package commons.utils;

import commons.sturcture.ListNode;

import java.util.List;

public class CommonUtils {

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println("");
    }

    public static ListNode buildListNode(List<Integer> valList) {
        ListNode node = new ListNode(-1);
        ListNode p = node;
        for (int o : valList) {
            ListNode item = new ListNode(o);
            p.next = item;
            p = p.next;
        }
        return node.next;
    }
}
