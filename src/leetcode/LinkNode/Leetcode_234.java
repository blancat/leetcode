package leetcode.LinkNode;

import commons.sturcture.ListNode;
import commons.utils.CommonUtils;

import java.util.Arrays;

public class Leetcode_234 {

    public static void main(String[] args) {
        Leetcode_234 leetcode_234 = new Leetcode_234();
        ListNode listNode = CommonUtils.buildListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode reverseNode = leetcode_234.reverseNode(listNode);
        CommonUtils.printListNode(reverseNode);
    }

    ListNode left;
    public void isPalindrome(ListNode head) {
        left = head;
        traverse(head);
    }

    private void traverse(ListNode right) {
        if (right == null) return;
        traverse(right.next);
        int leftval = left.val;
        int rightval = right.val;
        System.out.println("left val = " + leftval + "; right val = " + rightval);
        left = left.next;
    }


    private ListNode reverseNode(ListNode head) {

        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;


    }

}
