package com.zora.design.bridge;

/**
 * <h3>JavaTesting</h3>
 * <p>设计模式-桥接模式</p>
 *
 * @author zora
 * @date 2019/8/20
 */
public class BridgeDemo {
    public static void main(String[] args) {
        // 定义一个桥
        AbstractBridge bridge = new MyBridge();

        // 定义实现接口的类1
        BridgeSource1 bridgeSource1 = new BridgeSource1();
        // 给桥传入类1对象
        bridge.setBridgeable(bridgeSource1);
        // 通过桥统一的方法进去
        bridge.method();

        // 定义实现接口的类1
        BridgeSource2 bridgeSource2 = new BridgeSource2();
        // 给桥传入类2对象
        bridge.setBridgeable(bridgeSource2);
        // 通过桥统一的方法进去
        bridge.method();
    }
}

