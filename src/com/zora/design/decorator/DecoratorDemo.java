package com.zora.design.decorator;

/**
 * <h3>JavaTesting</h3>
 * <p>设计模式-装饰器模式</p>
 *
 * @author zora
 * @date 2019/8/21
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        AbstractComponent baseComponent = new BaseComponent();
        AbstractComponent superComponent = new Decorator(baseComponent);
        System.out.println("基本类：");
        baseComponent.function();
        System.out.println("装饰器增强：");
        superComponent.function();
    }
}

/**
 * 抽象构件，装饰器和基础构件都需要继承它
 */
abstract class AbstractComponent {
    /**
     * 功能
     */
    abstract void function();
}

class BaseComponent extends AbstractComponent {

    @Override
    void function() {
        System.out.println("这里是基本类在小声说话");
    }
}

class Decorator extends AbstractComponent {
    private AbstractComponent component;

    Decorator(AbstractComponent component) {
        this.component = component;
    }

    @Override
    void function() {
        component.function();
        speakLoudly();
    }

    void speakLoudly() {
        System.out.println("然后借助装饰器又喊了一遍");
    }
}