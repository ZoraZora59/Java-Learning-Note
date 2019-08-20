package com.zora.design.proxy;

/**
 * <h3>JavaTesting</h3>
 * <p>设计模式-代理模式</p>
 *
 * @author zora
 * @date 2019/8/20
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.method();
    }
}

/**
 * 定义一个接口
 */
interface Proxyable {
    /**
     * 需要实现的方法
     */
    public void method();
}

/**
 * 某个类实现该接口
 */
class ProxySource implements Proxyable {
    @Override
    public void method() {
        System.out.println("ProxySource:method");
    }
}

/**
 * 代理类实现接口并且在构造器中创建实现同样接口的类，它与装饰器模式非常类似，不同的是，类对象是在构造器中创建，而装饰器的类在外面构建传进来
 */
class Proxy implements Proxyable {
    private ProxySource proxySource = null;

    Proxy() {
        proxySource = new ProxySource();
    }

    @Override
    public void method() {
        System.out.println("Proxy:before");
        proxySource.method();
        System.out.println("Proxy:after");
    }
}