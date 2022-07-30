package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sendo on 20/01/2018.
 */
public class Minimum_Index_Sum_of_Two_Lists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        String[] temp = new String[1000];
        int miniIndex = 9999; // 最小下标数
        int sumIndex; // 标记下标合
        int resultCount = 0; // 标记下标个数
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    sumIndex = i + j;
                    if (sumIndex == miniIndex) {
                        resultCount++;
                        temp[resultCount] = list1[i];
                    }
                    if (sumIndex < miniIndex) {
                        miniIndex = sumIndex;
                        resultCount = 0;
                        temp[resultCount] = list1[i];
                    }
                }
            }
        }
        String[] result = new String[resultCount + 1];
        for (int i = 0; i <= resultCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static String[] findRestaurant2(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int miniIndex = 9999; // 最小下标数
        int sumIndex; // 标记下标合
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    sumIndex = i + j;
                    if (sumIndex == miniIndex) {
                        list.add(list1[i]);
                    }
                    if (sumIndex < miniIndex) {
                        // 清空
                        miniIndex = sumIndex;
                        list.clear();
                        list.add(list1[i]);
                    }
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String[] list1 =  {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] result = findRestaurant2(list1, list2);

    }
}
