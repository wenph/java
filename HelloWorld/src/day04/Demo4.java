package day04;
import day04.sub.Xoo;

/**
 * Created by pinghua.wph on 2016/4/5.
 */
public class Demo4 {
    public static void main(String[] args){
        Yoo y = new Yoo();
        System.out.println(y.a);
        System.out.println(y.b);
        System.out.println(y.c);
//        System.out.println(y.d);      // d在同一包，但是private不可见
        System.out.println(y.getD());

        Xoo xoo = new Xoo();
        System.out.println(xoo.a);
//        System.out.println(xoo.b);      // d不在同一包，protected不可见
//        System.out.println(xoo.c);      //编译错
//        System.out.println(xoo.d);      //编译错
        System.out.println(xoo.getD());
    }
}

class Too extends Xoo{
    public void test(){
        System.out.println(super.a);
        System.out.println(super.b);            // 保护的，子类中可见
//        System.out.println(super.c);            // 不可见，默认范围：包中可见。
//        System.out.println(super.d);
        System.out.println(super.getD());
    }
}

class Yoo{
    public int a = 5;
    protected int b = 6;
    int c = 7;
    private int d = 8;
    public int getD(){
        return d;
    }
}
