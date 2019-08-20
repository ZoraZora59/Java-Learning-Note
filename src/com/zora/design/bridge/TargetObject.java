package com.zora.design.bridge;

/**
 * <h3>Java-Learning-Note</h3>
 * <p></p>
 *
 * @author : jyh
 * @date : 2019/08/20
 **/
public class TargetObject {
    public static void main(String[] args) {
        Implementor imp = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imp);
        abs.request();
    }
}