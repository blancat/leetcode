package com.company;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        int a[] = {2, 1, 5, 7, 9, 6, 10};
        quick_sort(a, 0, a.length - 1);
        print_array(a);
    }




    static void quick_sort(int a[], int left, int right) {
        if (left < right) {
            int temp = a[left];
            int i = left, j = right;
            while (i < j) {
                while (i < j && temp <= a[j]) {
                    j--;
                }
                if (i < j) {
                    a[i] = a[j];
                    i++;
                }
                while (i < j && a[i] <= temp) {
                    i++;
                }
                if (i < j) {
                    a[j] = a[i];
                    j--;
                }
                a[i] = temp;
                quick_sort(a, left, i - 1);
                quick_sort(a, i + 1, right);
            }
        }
    }



    static void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    static void merge(int a[], int low, int mid, int high) {
        int left_low = low;
        int left_high = mid;
        int right_low = mid + 1;
        int right_high = high;
        int temp[] = new int[high - low + 1];
        int i;
        for (i = 0; left_low <= left_high && right_low <= right_high; i++) {
            if (a[left_low] < a[right_low]) {
                temp[i] = a[left_low];
                left_low++;
            } else {
                temp[i] = a[right_low];
                right_low++;
            }
        }
        while (left_low <= left_high) {
            temp[i++] = a[left_low];
            left_low++;
        }
        while (right_low <= right_high) {
            temp[i++] = a[right_low];
            right_low++;
        }
        for (int j = 0; j < i; j++) {
            a[low + j] = temp[j];
        }

    }

    /**
     *
     * @param s
     * @param sub
     */
    static void match(String s, String sub) {

        int j = 0, index = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
                if (j == sub.length()) {
                    System.out.println("匹配");
                    return;
                }
            } else {
                i++;
                index++;
                j = 0;
            }
        }
        System.out.println("不匹配");
    }

    /**
     * 二分查找 (递归)
     * @param array
     * @param key
     * @return 下标
     */
    public static int binarySearch(int [] array,int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == key) {
                return mid;
            }
            else if (key > array[mid]) {
                return binarySearch(array, mid + 1, high, key);
            } else {
                return binarySearch(array, low, mid - 1, key);
            }
        }
        return -1;
    }

    /**
     * 二分查找 （非递归）
     * @param array
     * @param key
     * @return
     */
    public static int binarySearch(int [] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void print_array(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
