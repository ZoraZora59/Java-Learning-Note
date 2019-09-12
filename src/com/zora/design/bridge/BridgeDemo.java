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
        // 实例化一个桥
        AbstractBridge bridge = new MyBridge();

        // 实例化一个桥接目标
        RunningBridge runningBridge = new RunningBridge();
        // 把目标传入桥
        bridge.setBridgeable(runningBridge);
        // 通过桥使用目标
        bridge.method();

        // 实例化一个桥接目标
        StandingBridge standingBridge = new StandingBridge();
        // 把目标传入桥
        bridge.setBridgeable(standingBridge);
        // 通过桥统一的方法进去
        bridge.method();
    }
}

/**
 * 被桥接的类应该实现这个接口
 */
interface Bridgeable {
    /**
     * 功能接口
     */
    public void method();
}

/**
 * 跑步模式
 */
class RunningBridge implements Bridgeable {
    @Override
    public void method() {
        System.out.println("连接跑步端口\n一直在跑步...");
    }
}

/**
 * 站定模式
 */
class StandingBridge implements Bridgeable {
    @Override
    public void method() {
        System.out.println("连接原地呆着端口\n站在原地不动...");
    }
}

/**
 * 定义一个抽象类桥，定义桥接目标的抽象实例
 */
abstract class AbstractBridge {

    /**
     * 待放入的桥接目标
     */
    private Bridgeable bridgeable;

    /**
     * 使用桥接目标的方法
     */
    public void method() {
        bridgeable.method();
    }

    /**
     * 设置桥接的目标
     */
    void setBridgeable(Bridgeable bridgeable) {
        this.bridgeable = bridgeable;
    }

    /**
     * 获取桥接的目标
     */
    Bridgeable getBridgeable() {
        return bridgeable;
    }
}

/**
 * 实现功能的桥
 */
class MyBridge extends AbstractBridge {
    @Override
    public void method() {
        getBridgeable().method();
    }
}


