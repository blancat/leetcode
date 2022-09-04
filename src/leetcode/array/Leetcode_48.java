package leetcode.array;

import leetcode.LinkNode.Leetcode_167;

public class Leetcode_48 {

    /**
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     *
     * 输入：s = "a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
     *
     */

    public static void main(String[] args) {
        Leetcode_48 leetcode_48 = new Leetcode_48();

        leetcode_48.reverseWords("a good   example");
    }

    public String reverseWords(String s) {
        // 首先去掉收尾空格
        String temp = reverse(s.trim());
        // 去掉中间的空格

        return null;
    }

    private String reverse(String word) {
        char[] chars = word.toCharArray();
        int left = 0, right = chars.length;
        while (left < right) {
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);


    }

}
