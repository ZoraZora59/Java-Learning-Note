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
        Bridge bridge = new MyBridge();

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

interface Bridgeable {
    public void method();
}

//某个类1实现该接口
class BridgeSource1 implements Bridgeable {
    @Override
    public void method() {
        System.out.println("BridgeSource1:method");
    }
}

//某个类2实现该接口
class BridgeSource2 implements Bridgeable {
    @Override
    public void method() {
        System.out.println("BridgeSource2:method");
    }
}

//定义一个抽象类桥，它持有接口的实例
abstract class Bridge {

    // 接口对应的实例
    Bridgeable bridgeable;

    // 定义和接口同名的方法
    public void method() {
        bridgeable.method();
    }

    // 设置接口实例
    public void setBridgeable(Bridgeable bridgeable) {
        this.bridgeable = bridgeable;
    }

    // 获取接口实例
    public Bridgeable getBridgeable() {
        return bridgeable;
    }
}

//定义一个普通类，它继承抽象类
class MyBridge extends Bridge {
    // 定义和接口同名的方法
    @Override
    public void method() {
        getBridgeable().method();
    }
}


