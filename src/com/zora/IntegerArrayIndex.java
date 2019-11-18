package com.zora;


/**
 * <h3>Java-Learning-Note</h3>
 * <p>有序数组定位</p>
 *
 * @author : zora
 * @date : 2019/10/16
 */
public class IntegerArrayIndex {
    public static void main(String[] args) {
        // 数组
        int[] array = init();
        // 待定位的值
        int value = 5;
        // 定位的位置，从1开始算的
        int index;
        printArray(array);
        index = index(array, value) + 1;
        printIndex(index, value);
    }

    private static void printArray(int[] array) {
        System.out.println("Array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printIndex(int index, int value) {
        System.out.println("The number " + value + " is at " + index + " .");
    }

    private static int[] init() {
        return new int[]{1, 3, 4, 5, 9, 11, 14, 15, 16, 19, 22, 29, 31, 32, 36, 45, 47, 48, 51};
    }

    private static int index(int[] array, int value) {
        int head = 0;
        int tail = array.length - 1;
        int mid = (tail - head) / 2;
        while (tail != head) {
            if (array[mid] > value) {
                tail = mid;
            } else if (array[mid] < value) {
                head = mid;
            } else {
                return mid;
            }
            mid = head + (tail - head) / 2;
        }
        return -1;
    }
}