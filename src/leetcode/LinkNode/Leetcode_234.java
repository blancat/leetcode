package leetcode.LinkNode;

import commons.sturcture.ListNode;
import commons.utils.CommonUtils;

import java.util.Arrays;

public class Leetcode_234 {

    public static void main(String[] args) {
        Leetcode_234 leetcode_234 = new Leetcode_234();
        ListNode listNode = CommonUtils.buildListNode(Arrays.asList(1, 2, 3, 2, 1));
        leetcode_234.isPalindrome2(listNode);
    }


    public boolean isPalindrome2(ListNode head) {
        // 快慢指针算法

        ListNode left = head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode right = reverse(slow);

        while(right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = head.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

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




}
