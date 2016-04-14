package step01.day01;

import java.util.Arrays;

/**
 * Created by pinghua.wph on 2016/3/30.
 */

/*
 * 学习封装
 * public：任何位置可见，修饰：属性，类，方法，内部类。跨包访问类。需要使用import语句导入。
 * protected：当前包中可见，子类中可见。只可以修饰类的成员，只能在类体中使用，包括：属性，方法，内部类。
 * 默认的：当前包内可见，就是没有任何修饰词。修饰：类，属性，方法，内部类等。项目中很少用。
 * private：仅仅在类内部可见。可以修饰类的成员：属性，方法，内部类。
 *
 * 默认类（包内类）的访问范围：当前包内部可见，不能在其他包中访问。
 * 在使用中建议：所有类都是共有类。封装的类使用内部类！
 *
 * java文件规则：
 * 1. 一个java源文件可以有多个类，但只能有一个共有类！其他类都是默认类（包中类）而且java的文件名与共有类类名一致！
 * 2. 一般建议：一个文件一个共有类！一般不在一个文件中写多个类。
 *
 * 私有方法不能被继承，也不能重写！
 *
 * static：静态的，只能在类内部使用，可以修饰：属性，方法，内部类，静态代码块。
 * 静态修饰的成员：属于类级别的成员，是全体类实例共享的资源。
 * 静态属性：只有一份，全体实例共享。类似于全局变量。
 * 静态方法：属于类的方法，使用类名直接调用，不需要创建对象，而且没有隐含参数this，不能访问当前对象资源。
 * 静态代码块：在类加载期间执行，只执行一次，可以用于资源加载。
 *
 * final：最终的，可以修饰：类，方法，变量（属性，局部变量）
 * final的类：不能再继承
 * final的方法：不能再重写
 * final的方法和类，阻止了动态代理模式！
 *   动态代理模式广泛应用在：spring，hibernate，struts2。建议不使用final类和final方法。
 * final的变量：只能初始化一次，不能再修改！
 */
public class Encapsulation {
    public static void main(String[] args){
//        System.out.println("温平华");
//        Foo f = new Koo();
//        f.test();
//        new Goo();
//        new Goo();
        final String[] ary = {"A", "B"};        // 数组变量不可修改，但数组元素可以修改。
        ary[0] = "tom";
        System.out.println(Arrays.toString(ary));
    }
}

class Foo{
    int a = 1;
    public Foo(){
        this.test();        // 调用当前类型的test()方法
    }
//    private void test(){      //私有方法不能被继承，也不能重写！
    public void test(){
        System.out.println("Foo test()" + a);
    }
}

class Koo extends Foo {
    int b = 2;
    public void test(){
        System.out.println("Koo test()"+a+","+b);
    }
}

class Goo{
    {   // 代码块，在创建对象时候执行，类似于构造器作用。
        System.out.println("Hi");
    }
    static { // 静态代码块，在类的加载期间执行，只执行一次。
        System.out.println("Only once");
    }
}