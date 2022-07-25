package 剑指offer.数据结构;

import java.util.Collections;

/**
 *
 * @author ysfan
 */
public class Offer_05 {

    public static void main(String [] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        // fun1
//        String temp = "";
//        for (char c : s.toCharArray()) {
//            if (c == ' ') {
//                temp += "%20";
//            } else {
//                temp += c;
//            }
//        }
//        return temp;

        // fun2  *********最优解*********
        int countSpace = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                countSpace++;
            }
        }
        // 多一个空格多2个占位
        char[] tempChars = new char[s.length() + countSpace * 2];
        for (int i = 0, j = 0; j < tempChars.length;) {
            if (s.charAt(i) == ' ') {
                tempChars[j++] = '%';
                tempChars[j++] = '2';
                tempChars[j++] = '0';
            } else {
                tempChars[j++] = s.charAt(i);
            }
            i++;
        }
        return new String(tempChars);

        // fun3
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') {
//                sb.append("%20");
//            } else {
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();
    }
}
