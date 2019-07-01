package com.zora;

/**
 * 关于内部类中权限的理解
 *
 * @author Zora
 */
public class ClassRelationship {
    public static void main(String[] args) {
        System.out.println("外部类中的用法：");
        /* 外部类中的静态方法可以直接调用 */
        printOuterStatic();
        /* 外部类中的普通方法，可以使用匿名类 */
        new ClassRelationship().printOuter();
        /* 普通内部类中的的普通方法 */

        /* 普通内部类中的的不能声明静态方法 */

        /* 静态内部类中的的静态方法，直接调用 */
        StaticInnerClass.printInternalStatic();
    }

    private static void printOuterStatic() {
        System.out.println("--静态外部类输出  printOuterStatic();");
    }

    private void printOuter() {
        System.out.println("--外部类输出  new ClassRelationship().printOuter();");
    }

    /**
     * 普通内部类
     */
    class InnerClass {
        void printInner() {
            System.out.println("--内部类输出");
        }
    }

    /**
     * 静态内部类
     */
    static class StaticInnerClass {
        static void printInternalStatic() {
            System.out.println("静态内部类的静态方法输出");
        }

        void printInner() {
            System.out.println("静态内部类输出");
        }
    }
}