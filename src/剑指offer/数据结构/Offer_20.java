package 剑指offer.数据结构;

public class Offer_20 {

    /**
     * 思路1： 比较简单清晰，  将字符串分割为  小数或者整数 然后分别判断
     * 思路2： 有限状态机 ？？？
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        // 数值由  ，，，，小数/整数 (e/E 整数)，，，，
        s = s.trim().toUpperCase();
        if (s.contains(".")) {
            if (s.contains("E")) {
                // 小数 e/E 整数
                int index = s.indexOf("E");
                return isFloat(s.substring(0, index)) && isInteger(s.substring(index  + 1, s.length()));
            } else {
                // 小数
                return isFloat(s);
            }
        } else {
            // 整数   ||  整数 e/E 整数
            if (s.contains("E")) {
                // 整数 e / E  整数
                int index = s.indexOf("E");
                return isInteger(s.substring(0, index)) && isInteger(s.substring(index  + 1, s.length()));
            } else {
                // 整数
                return isInteger(s);
            }
        }
    }

    public boolean isFloat(String s) {
        if (s == null || s.length() == 0) return false;
        if (!s.contains(".")) {
            return false;
        }
        boolean hasPoint = false;
        boolean hasNum = false;
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                if (s.length() == 1) {
                    return false;
                }
            } else {
                if (c == '.') {
                    if (hasPoint || s.length() == 1) {
                        // 多个. 或者只有.
                        return false;
                    }
                    hasPoint = true;
                } else {
                    if (c < '0' || c > '9') {
                        return false;
                    } else {
                        hasNum = true;
                    }
                }

            }
        }
        return hasPoint && hasNum;
    }

    public static boolean isInteger(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                // 第一位字符并且 是 + 或 -开头
                if (s.length() == 1) {
                    return false;
                }
            } else {
                if (c < '0' || c > '9') {
                    return false;
                }
            }
        }
        return true;
    }
}
