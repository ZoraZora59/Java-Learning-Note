package com.zora.design.bridge;

/**
 * <h3>Java-Learning-Note</h3>
 * <p></p>
 *
 * @author : jyh
 * @date : 2019/08/20
 **/
public class ConcreteImplementorA extends Implementor {

    @Override
    public void doSomething() {
        System.out.println("具体实现A的doSomething执行");
    }

    @Override
    public void doAnything() {
        System.out.println("具体实现A的doAnything执行");
    }
}