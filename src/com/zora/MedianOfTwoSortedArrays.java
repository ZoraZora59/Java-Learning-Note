package com.zora;

/**
 * 在两个有序数组中找到中值，期望的时间复杂度为 O(log(m+n))
 *
 * @author Zora
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,1,2,3,6,7,8,9,9,9,1222,1333,1444};
        int[] num2 = new int[]{2,2,3,3,4,4,5,6,7,888,1111};

        System.out.println("Finding median of two sorted arrays...");

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        double result = new MedianOfTwoSortedArrays().findMedianSortedArraysTypeA(num1, num2);
        endTime = System.nanoTime();

        System.out.println("Result is : " + result);
        System.out.println("Function A running time : " + (endTime - startTime));

        startTime = System.nanoTime();
        result = new MedianOfTwoSortedArrays().findMedianSortedArraysTypeB(num1, num2);
        endTime = System.nanoTime();

        System.out.println("Result is : " + result);
        System.out.println("Function B running time : " + (endTime - startTime));
    }

    /**
     * 获取单一数组中的中值
     *
     * @param arr    数组
     * @param length 数组长度
     * @return double类型的中值
     */
    private static double getMedianOfSingleArray(int[] arr, int length) {
        if (length % 2 != 0) {
            length = (length + 1) / 2;
            length -= 1;
            return (double) arr[length];
        } else {
            return (double) (arr[(length / 2) - 1] + arr[length / 2]) / 2.0;
        }
    }
    /**
     * 获取数组中值
     *
     * @param nums1       数组1
     * @param nums2       数组2
     * @param lengthNums1 数组1长度
     * @param lengthNums2 数组2长度
     * @param index       已经计算出的左侧（对于总长度为偶数而言，对于总长度为奇数的则是中值）坐标，从1开始计数。
     * @return 得出的中值
     */
    private static double getIndexPoint(int[] nums1, int[] nums2, int lengthNums1, int lengthNums2, int index) {
        int p1 = 0, p2 = 0, p = -1;
        double ret = 0;
        for (int i = 1; i <= index; i++) {
            if (p1 > lengthNums1 - 1) {
                ret = nums2[p2];
                p2++;
            } else if (p2 > lengthNums2 - 1) {
                ret = nums1[p1];
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                ret = nums2[p2];
                p2++;
            } else {
                ret = nums1[p1];
                p1++;
            }
        }
        if ((lengthNums1 + lengthNums2) % 2 == 0) {
            if (p1 > lengthNums1 - 1) {
                ret = (ret + nums2[p2]) / 2.0;
            } else if (p2 > lengthNums2 - 1) {
                ret = (ret + nums1[p1]) / 2.0;
            } else if (nums1[p1] > nums2[p2]) {
                ret = (ret + nums2[p2]) / 2.0;
            } else {
                ret = (ret + nums1[p1]) / 2.0;
            }
        }
        return ret;
    }
    /* 我的方法 */
    private double findMedianSortedArraysTypeA(int[] nums1, int[] nums2) {
        double ret;

        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;

        if (lengthNums1 == 0) {
            ret = getMedianOfSingleArray(nums2, lengthNums2);
        } else if (lengthNums2 == 0) {
            ret = getMedianOfSingleArray(nums1, lengthNums1);
        } else {
            if ((lengthNums1 + lengthNums2) % 2 != 0) {
                int index = (lengthNums1 + lengthNums2 + 1) / 2;
                ret = getIndexPoint(nums1, nums2, lengthNums1, lengthNums2, index);
            } else {
                int index = (lengthNums1 + lengthNums2) / 2;
                ret = getIndexPoint(nums1, nums2, lengthNums1, lengthNums2, index);
            }
        }
        return ret;
    }
    /* 大佬的方法 */
    private double findMedianSortedArraysTypeB(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {

            if (i >= nums1.length) {
                total[k] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                total[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                total[k] = nums1[i];
                i++;
            } else {
                total[k] = nums2[j];
                j++;
            }
            k++;
        }


        if (total.length % 2 == 0) {
            return (total[total.length / 2] + total[(total.length / 2) - 1]) / 2.0;
        } else {
            return total[total.length / 2];
        }
    }
}
