package com.zora.demo.space;

/**
 * <h3>Java-Learning-Note</h3>
 * <h4>com.zora.demo.space</h4>
 * <p>抽象类测试</p>
 *
 * @author : zora
 * @since : 2019/12/23
 */
public abstract class AbsDemo {
    // 可以有构造方法
    AbsDemo(int x) {
        a = x;
    }

    ;
    int a;
    int b = 5;

    // 抽象方法必须加abstract关键字
    abstract void funA();

    // 不加关键字的必须实现
    void funB() {

    }
}
