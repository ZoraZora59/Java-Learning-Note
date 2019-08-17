package com.zora;

import java.util.Scanner;

public class bytedance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int timerCount = in.nextInt();
        int[][] alert = new int[2][timerCount];
        for (int i = 0; i < timerCount; i++) {
            alert[0][i] = in.nextInt();
            alert[1][i] = in.nextInt();
        }
        int onTheWay = in.nextInt();
        boolean moreThanHour = onTheWay % 60 > 0 ? true : false;
        if(moreThanHour){
            onTheWay=onTheWay-60;
            for(int i=0;i<timerCount;i++){
                alert[0][i]=alert[0][i]+1;
            }
        }
        int[] deadLine = new int[2];
        for (int i = 0; i < 2; i++) {
            deadLine[i] = in.nextInt();
        }
        int restMinute=0;
        for(int i=timerCount-1;i>=0;i--){
            if(deadLine[0]>=alert[0][i]){
                restMinute=(deadLine[0]-alert[0][i])*60;
                if(deadLine[1]+restMinute>=alert[1][i]){
                    System.out.println(alert[0][i]+" "+alert[1][i]);
                }
            }
        }
    }
}


//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//    }
//}