package leetcode.LinkNode;

import commons.sturcture.ListNode;

public class Leetcode_92 {




    /**
     * 反转n到m个
     * @param head
     * @param n
     * @param m
     * @return
     */
    ListNode reverseNM(ListNode head,int n,int m) {
        if (m == n) {
            return head;
        }
        if (n == 1) {
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
        ListNode nNode = reverseN(p, m - n + 1);
        preNode.next = nNode;
        return head;
    }


    /**
     *
     * @param head
     * @param n
     * @return
     */
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
