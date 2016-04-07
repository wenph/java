package day03;

/**
 * Created by pinghua.wph on 2016/4/1.
 */

/*
 * 属性由变量类型决定
 * 方法动态绑定到对象的方法
 */
public class JavaExtends {
    public static void main(String[] args){
//        Boo b = new Boo();
        Cheater c = new Cheater();
        Person p = c;
        System.out.println(p.name + "," + c.name);      // 灰太狼,喜洋洋
        p.whoau();  // 喜洋洋
        c.whoau();  // 喜洋洋
    }
}


class Aoo{
    int a = 1;
    public Aoo(){
        this.test();            // 执行这个方法的时候，这个方法被重写。
    }
    public void test(){
        System.out.println("Aoo "+a);
    }
}

class Boo extends Aoo {
    int b = 2;
    public Boo(){
        super();
    }
    public void test(){
        System.out.println("Boo "+a+","+b);
    }
}

class Person{
    String name = "灰太狼";
    public void whoau(){
        System.out.println(this.name);
    }
}

class Cheater extends Person {
    String name = "喜洋洋";
    public void whoau(){
        System.out.println(this.name);
    }
}