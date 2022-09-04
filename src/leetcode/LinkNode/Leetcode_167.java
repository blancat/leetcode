package leetcode.LinkNode;

public class Leetcode_167 {

    public static void main(String[] args) {
        Leetcode_167 leetcode_167 = new Leetcode_167();
        leetcode_167.test();
    }

    public void test() {
        int [] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        return;
    }

    public int[] twoSum(int[] numbers, int target) {

        // 除了双指针解法，显然还有二分法
        // 遍历数组，从左往右，数字依次递增
        for (int left = 0; left < numbers.length; left ++) {
            int targetNum = target - numbers[left];
            int start = left + 1;
            int end = numbers.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (numbers[mid] == targetNum) {
                    return new int[] {left + 1, mid + 1};
                } else if (numbers[mid] < targetNum) {
                    // 在右侧
                    start = mid + 1;
                } else {
                    // 在左侧
                    end = mid - 1;
                }
            }
            // 循环结束还没找到，说明该left 没有存在可以two sum 的值，left++
        }
        return null;
    }
}
