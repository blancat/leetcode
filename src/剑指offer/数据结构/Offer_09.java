package 剑指offer.数据结构;

import java.util.Stack;

public class Offer_09 {

    /**
     *用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     *分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
     *
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * */


    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Offer_09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 出队的时候，利用stack1把数据都灌在stack2上，然后灌完了，把stack2出栈，
     * 然后加入再次入队的时候，只需要直接把最后一个再次压入stack2就行
     *
     * @return
     */
    public int deleteHead() {
        if (!stack2.empty()) {
            // 可能会连续出队
            return stack2.pop();
        }
        if (stack1.empty()) {
            return -1;
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        return result;
    }
}
