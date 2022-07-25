package 剑指offer.数据结构;

public class Offer_06 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int res[] = new int[size];
        while (head != null) {
            res[size--] = head.val;
            head = head.next;
        }
        return res;
    }
}
