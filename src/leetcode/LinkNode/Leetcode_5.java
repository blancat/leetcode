package leetcode.LinkNode;

public class Leetcode_5 {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {

            // 奇数，左右中心点在一个

            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            if (res1.length() > res2.length()) {
                res = res.length() > res1.length()? res : res1;
            } else {
                res = res.length() > res2.length()? res : res2;
            }
            // 偶数, 左右中心分开

        }
        return res;


    }

    // 以双中心，判断是否是回文
    private String palindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);


    }
}
