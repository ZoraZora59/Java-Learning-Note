package com.zora;

/**
 * 关于内部类中权限的理解
 *
 * @author Zora
 */
public class ClassRelationship {
    public static void main(String[] args) {
        printClassRelationship();
        new ClassRelationship().new PrintInnerClass().printClassRelationship();
    }

    private static void printClassRelationship() {
        System.out.println("在外部类中调用时：");
        /* 外部类中的静态方法可以直接调用 */
        printOuterStatic();
        System.out.println("  printOuterStatic();");
        /* 外部类中的普通方法，可以使用匿名类 */
        new ClassRelationship().printOuter();
        System.out.println("  new ClassRelationship().printOuter();");
        /* 普通内部类中的的普通方法，先new外部类的实例，再new内部类的，通过实例化得到的对象来进行调用*/
        new ClassRelationship().new InnerClass().printInner();
        System.out.println("  new ClassRelationship().new InnerClass().printInner();");
        /* ###普通内部类中不能声明静态方法### */

        /* 静态内部类中的的静态方法，直接调用 */
        StaticInnerClass.printInnerStatic();
        System.out.println("  StaticInnerClass.printInternalStatic();");
        /* 静态内部类中的的非静态方法，需要先new一个实例然后再调用 */
        new StaticInnerClass().printInner();
        System.out.println("  new StaticInnerClass().printInner();");
    }

    /**
     * 内部类调用展示
     */
    class PrintInnerClass {
        void printClassRelationship() {
            System.out.println("在内部类中调用时：");
            /* 外部类的静态方法，直接调用 */
            printOuterStatic();
            System.out.println("  printOuterStatic();");
            /* 外部类的普通方法，直接调用*/
            printOuter();
            System.out.println("  printOuter();");
        }
    }

    private static void printOuterStatic() {
        System.out.print("--静态外部类输出");
    }

    private void printOuter() {
        System.out.print("--外部类输出");
    }

    /**
     * 普通内部类
     */
    class InnerClass {
        void printInner() {
            System.out.print("--内部类输出");
        }
    }

    /**
     * 静态内部类
     */
    static class StaticInnerClass {
        static void printInnerStatic() {
            System.out.print("--静态内部类的静态方法输出");
        }

        void printInner() {
            System.out.print("--静态内部类输出");
        }
    }


}