package com.zora;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * 学习Java的数组、列表等的基本操作
 *
 * @author Zora
 */

public class ArrayTest {

    private static int MINLENGTH = 5;
    private static int LENGTH = 0;
    private static int[] array;
    private static int TAIL = 0;

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        arrayTest.uiModel(arrayTest);
    }


    private void uiModel(ArrayTest arrayTest) {
        Scanner scanner = new Scanner(System.in);
        out.println("输入数组大小，回车确认，小于5则采用默认值10");
        LENGTH = Integer.parseInt(scanner.nextLine());

        if (LENGTH < MINLENGTH) {
            LENGTH = 10;
        }

        array = new int[LENGTH];

        while (true) {

            out.println("输入标签值，回车确认");
            out.println("1.插入");
            out.println("2.删除");
            out.println("3.显示");
            out.println("4.aA排序");
            out.println("5.退出");

            int switchCase;

            try {
                switchCase = scanner.nextInt();
            } catch (Exception e) {
                out.println("Input Error");
                continue;
            }

            scanner.nextLine();

            switch (switchCase) {
                case 1:
                    try {
                        arrayTest.insertArray(Integer.parseInt(scanner.nextLine()));
                    } catch (Exception e) {
                        out.println("Input Error");
                    }
                    break;
                case 2:
                    arrayTest.removeArrayTail();
                    break;
                case 3:
                    int[] arr = arrayTest.getArrayEntire();
                    for (int i = 0; i < TAIL; i++) {
                        out.println("[" + i + "] = " + arr[i]);
                    }
                    break;
                case 4:
                    arrayTest.sortArray();
                    break;
                case 5:
                    return;
                default:
                    out.println("Input Error");
                    break;
            }

            out.println();
        }
    }

    private void insertArray(int ins) {
        if (TAIL >= LENGTH) {
            out.println("数组已满");
        } else {
            array[TAIL] = ins;
            TAIL++;
        }
    }

    private void removeArrayTail() {
        if (TAIL > 0) {
            TAIL -= 1;
            array[TAIL] = 0;
        } else {
            out.println("数组已空");
        }
    }

    private int[] getArrayEntire() {
        return array;
    }

    private void sortArray() {
        Arrays.sort(array);
    }
}
