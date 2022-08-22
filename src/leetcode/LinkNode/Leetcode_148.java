package leetcode.LinkNode;

import commons.sturcture.ListNode;
import commons.utils.CommonUtils;

import java.util.Arrays;

/**
 * 单链表排序
 */
public class Leetcode_148 {

    public static void main(String[] args) {
        Leetcode_148 leetcode148 = new Leetcode_148();
        leetcode148.test();
    }

    public void test() {
        ListNode p = CommonUtils.buildListNode(Arrays.asList(2, 1, 3));
        CommonUtils.printListNode(sortList2(p));
        return;
    }

    /**
     * 归并排序，自底向上
     * @param head
     * @return
     */
    // 自底向上归并排序
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 计算长度
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        // 虚节点
        ListNode dummy = new ListNode(-1, head);
        for (int subLen = 1; subLen < len; subLen = subLen * 2) {
            // subLen子串长度
            ListNode cur = dummy.next;
            ListNode pre = dummy;
            while (cur != null) {
                ListNode left = cur;
                // 遍历找左链表为subLen长度
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode right = cur.next;
                // 左右链表断开
                cur.next = null;
                // 开始遍历右边链表为subLen的子链表
                cur = right;
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                // 获取右边链表的下一个；
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    // 右边的链表断开
                    cur.next = null;
                }
                // 合并左右两个链表，并且将pre.next = merge
                ListNode mergeNode = mergeTwoNode(left, right);
                pre.next = mergeNode;
                // 记录前一个指针
                while (pre.next != null) {
                    pre = pre.next;
                }
                // 当前指针从下一个开始
                cur = next;
            }
        }
        return dummy.next;
    }



    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            // 无需排序
            return head;
        }
        // 获取中间节点
        ListNode midNode = returnMidNode(head);
        ListNode midNext = midNode.next;
        // 断开链表，拆分为两个
        midNode.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(midNext);
        return mergeTwoNode(leftNode, rightNode);
    }

    public ListNode mergeTwoNode(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = left, p2 = right;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }



    /** 这个一定要向上取整 如 1->2->3->4 返回的中节点一定要是2， 不是3 */
    public ListNode returnMidNode(ListNode head) {
        if (head==null) return head;

        ListNode fast = head.next;  // 快指针 每次走2步
        ListNode slow = head;       // 慢指针 每次走1步
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public int[] sort(int [] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int [] nums, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    /**
     * 合并两个数组
     * @param nums
     * @param start
     * @param mid
     * @param right
     */
    public void merge(int[] nums, int start, int mid, int right) {
        int[] temps = new int[right - start + 1];
        int i = start, j = mid + 1, tempI = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temps[tempI++] = nums[i++];
            } else {
                temps[tempI++] = nums[j++];
            }
        }
        while (i <= mid) {
            temps[tempI++] = nums[i++];
        }
        while (j <= right) {
            temps[tempI++] = nums[j++];
        }
        for (int p = 0; p < temps.length; p++) {
            nums[start++] =temps[p];
        }
    }


}
