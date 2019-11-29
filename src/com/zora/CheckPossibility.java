package com.zora;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>递减校验</p>
 * <p>
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 *
 * @author : zora
 * @date : 2019/11/27
 */
public class CheckPossibility {
    public static void main(String[] args) {
//        int[] array = new int[]{4, 3, 1};
//        int[] array = new int[]{4, 2, 3};
        int[] array = new int[]{-1, 4, 2, 3};
        boolean success = new CheckPossibility().checkPossibility(array);
        System.out.println(success);
    }

    private boolean checkPossibility(int[] nums) {
        if (nums.length < 3) return true;

        int flag = 0;
        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                flag++;
                if (flag >= 2) return false;
                index = i;
            }
        }
        if (index != 0 && index != nums.length - 2) {
            return nums[index - 1] <= nums[index + 1] || nums[index] <= nums[index + 2];
        }
        return true;
    }
}
