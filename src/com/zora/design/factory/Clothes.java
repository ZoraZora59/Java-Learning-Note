package com.zora.design.factory;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>工厂模式示例类以及接口</p>
 * 抽象衣物接口
 * @author : jyh
 * @date : 2019/08/21
 **/
public interface Clothes {
    /**
     * 制造衣物
     */
    void make();
}
/**
 * 没造出来
 */
class NoClothes implements Clothes {
    @Override
    public void make() {
        System.out.println("啥也没有");
    }
}
/**
 * 裙子
 */
class Dress implements Clothes {
    @Override
    public void make() {
        System.out.println("给你裙子");
    }
}
/**
 * 衬衫
 */
class Shirt implements Clothes {
    @Override
    public void make() {
        System.out.println("给你衬衫");
    }
}
/**
 * 裤子
 */
class Pants implements Clothes {
    @Override
    public void make() {
        System.out.println("给你裤子");
    }
}