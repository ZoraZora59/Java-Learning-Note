package com.zora.design.factory;

/**
 * <h3>JavaTesting</h3>
 * <p>设计模式-简单工厂模式</p>
 *
 * @author zora
 * @date 2019/8/21
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Clothes clothes;
        System.out.println("简单工厂模式：");
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println("工厂，我需要裤子");
        clothes = simpleFactory.makeClothes("pants");
        clothes.make();
        System.out.println("工厂，我需要衬衫");
        clothes = simpleFactory.makeClothes("shirt");
        clothes.make();
    }
}

class SimpleFactory {
    Clothes makeClothes(String type) {
        Clothes clothes;
        switch (type) {
            case "dress":
                clothes = new Dress();
                break;
            case "shirt":
                clothes = new Shirt();
                break;
            case "pants":
                clothes = new Pants();
                break;
            default:
                clothes = new NoClothes();
                break;
        }
        return clothes;
    }
}
