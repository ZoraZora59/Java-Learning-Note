package com.zora.design.factory;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>设计模式-工厂模式</p>
 *
 * @author : jyh
 * @date : 2019/08/21
 **/
public class NormalFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory;
        System.out.println("工厂模式：");

        System.out.println("想要裙子，来个裙子工厂造一下");
        factory=new DressFactory();
        factory.getClothes().make();

        System.out.println("想要衬衫，来个衬衫工厂造一下");
        factory=new PantsFactory();
        factory.getClothes().make();
    }
}

/**
 * 抽象工厂
 */
abstract class AbstractFactory{
    /**
     * 抽象获取实体的方法
     * @return 衣物实体
     */
    abstract Clothes getClothes();
}
/**
 * 衬衫工厂
 */
class ShirtFactory extends AbstractFactory{
    @Override
    Clothes getClothes(){
        System.out.println("衬衫工厂开工");
        return new Shirt();
    }
}
/**
 * 裙子工厂
 */
class DressFactory extends AbstractFactory{
    @Override
    Clothes getClothes(){
        System.out.println("裙子工厂开工");
        return new Dress();
    }
}
/**
 * 裤子工厂
 */
class PantsFactory extends AbstractFactory{
    @Override
    Clothes getClothes(){
        System.out.println("裤子工厂开工");
        return new Pants();
    }
}