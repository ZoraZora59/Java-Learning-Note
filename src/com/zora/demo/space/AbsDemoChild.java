package com.zora.demo.space;

/**
 * <h3>Java-Learning-Note</h3>
 * <h4>com.zora.demo.space</h4>
 * <p>抽象类测试</p>
 *
 * @author : zora
 * @since : 2019/12/23
 */
public class AbsDemoChild extends AbsDemo {
    AbsDemoChild(int x) {
        super(x);
    }

    // 抽象类的非抽象子类必须实现抽象方法，如果子类也是抽象则可以不实现
    @Override
    void funA() {

    }
}
