package leetcode.LinkNode;

import commons.sturcture.ListNode;
import commons.utils.CommonUtils;

import java.util.Arrays;

public class Leetcode_25 {

    public static void main(String[] args) {
        Leetcode_25 leetcode25 = new Leetcode_25();

        ListNode listNode = leetcode25.reverseKGroup(CommonUtils.buildListNode(Arrays.asList(1, 2, 3, 4, 5)), 2);
        return;

    }


    public ListNode reverseKGroup(ListNode head, int k) {

        int leftIndex = 1;
        int rightIndex = k;
        ListNode p = head;
        ListNode firstKNode = nextKNode(p, k);
        ListNode node = firstKNode;
        while (node != null) {
            node = reverseBetween(p, leftIndex, rightIndex);
            leftIndex += k;
            rightIndex += k;
        }
        return firstKNode == null? head : firstKNode;
    }

    public ListNode nextKNode(ListNode head, int k) {
        int count = 1;
        ListNode p = head;

        while (p != null) {
            p = p.next;
            count++;
            if (count == k) {
                return p;
            }
        }
        return null;
    }

    public ListNode reverseBetween(ListNode head, int n, int m) {
        if (m == n) {
            return head;
        }
        if (n == 1) {
            successorNode = null;
            return reverseN(head, m);
        }
        int count = 1;
        ListNode p = head;
        ListNode preNode = head;
        while (n > count) {
            preNode = p;
            p = p.next;
            count++;
        }
        successorNode = null;
        ListNode nNode = reverseN(p, m - n + 1);
        preNode.next = nNode;
        return head;
    }

    ListNode successorNode = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successorNode = head.next;
            return head;
        }


        // 从head.next开始递归的话，还需要反转n-1个节点
        ListNode lastNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successorNode;
        return lastNode;
    }

}
