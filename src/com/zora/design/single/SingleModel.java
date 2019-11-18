package com.zora.design.single;


/**
 * <h3>Java-Learning-Note</h3>
 * <p>单例模式</p>
 *
 * @author : zora
 * @date : 2019/11/18
 */
public class SingleModel {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(LH.getInstance());
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(EH.getInstance());
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * 饿汉式
 */
class EH {
    private static EH instance = new EH();

    private EH() {
    }

    static EH getInstance() {
        return instance;
    }
}

/**
 * 懒汉式
 */
class LH {
    private static LH instance;

    private LH() {
    }

    synchronized static LH getInstance() {
        if (instance == null) {
            instance = new LH();
        }
        return instance;
    }
}