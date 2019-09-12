package com.zora.design.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <h3>JavaTesting</h3>
 * <p>设计模式-代理模式</p>
 *
 * @author zora
 * @date 2019/8/20
 */
public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("不使用代理：");
        ProxySource source=new ProxySource();
        source.method();
        System.out.println("");

        System.out.println("使用代理：");
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.method();
        System.out.println("");

        System.out.println("使用动态代理：");
        DynamicProxy dynamicProxy = new DynamicProxy();
        dynamicProxy.getProxy().method();
    }
}

/**
 * 代理沟通的接口
 */
interface Proxyable {
    /**
     * 功能
     */
    public void method();
}

/**
 * 被代理的类实现接口
 */
class ProxySource implements Proxyable {
    @Override
    public void method() {
        System.out.println("作者出来说话");
    }
}

/**
 * 静态代理
 */
class StaticProxy implements Proxyable {
    private ProxySource proxySource = null;

    StaticProxy() {
        proxySource = new ProxySource();
    }

    @Override
    public void method() {
        System.out.println("代理人收到消息，去找作者");
        proxySource.method();
        System.out.println("代理人的任务做完了");
    }
}

/**
 * 动态代理
 */
class DynamicProxy  {
    /**
     * 配置动态代理调用
     */
    private static final InvocationHandler SOURCE_HANDLE = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(new ProxySource(), args);
            System.out.println("动态代理人的任务做完了");
            return result;
        }
    };

    /**
     * 获取被代理的实例
     */
    Proxyable getProxy() {
        Proxyable proxyInstance;
        System.out.println("动态代理人开始到处找作者");
        proxyInstance = (Proxyable) Proxy.newProxyInstance(ProxySource.class.getClassLoader(),
                new Class[] { Proxyable.class }, SOURCE_HANDLE);
        System.out.println("找到作者了");
        return proxyInstance;
    }
}
