package 剑指offer.数据结构;

import commons.sturcture.ListNode;

public class Offer_24 {

    public static void main(String [] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);


        Offer_24 offer_24 = new Offer_24();
        offer_24.printNode(head);
        ListNode lastNode = offer_24.reverseListWithPoint(head);
        System.out.println(" ");
        offer_24.printNode(lastNode);
    }

    public void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }


    /**
     * 双指针法
     * @param head
     * @return
     */
    public ListNode reverseListWithPoint(ListNode head) {
        // Pre  1->2->3->4->5->null
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 暂存
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    /** 递归1 */
    public ListNode reverseList1(ListNode head) {

        // 1->2->3->4->5->null;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    private ListNode recur(ListNode current, ListNode pre) {

        if (current == null) {
            return pre;
        }
        // 1->2->3->4->5->null
        ListNode lastNode = recur(current.next, current);
        current.next = pre;
        return lastNode;
    }
}
