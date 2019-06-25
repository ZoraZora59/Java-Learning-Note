package com.zora;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

/**
 * Java用三个线程按顺序循环打印 abc 三个字母,比如 abcabcabc
 * 输出10遍abc
 *
 * @author Zora
 * <p>
 * 思路：引入信号量Semaphore的机制来进行多线程调度
 * <p>
 * 参考：https://www.jianshu.com/p/8908b355d91f
 */
public class LoopThreadPrint {
    public static void main(String[] args) {
        goLoop();
    }

    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    private static void goLoop() {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            int count = 0;
            while (count < 11) {
                try {
                    A.acquire();
                    System.out.print('a');
                    count++;
                    B.release();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            int count = 0;
            while (count < 11) {
                try {
                    B.acquire();
                    System.out.print('b');
                    count++;
                    C.release();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            int count = 0;
            while (count < 11) {
                try {
                    C.acquire();
                    System.out.print('c');
                    count++;
                    A.release();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
