package day03;

/**
 * Created by pinghua.wph on 2016/4/1.
 */
public class Demo3 {
    public static void main(String[] args){
        Woo w = new Woo();
        Super s = new Sub();
        w.t(s);     // Woo t(Super) Sub s() 重载的方法调用由参数类型决定，与对象无关。
    }
}

class Woo{
    public void t(Super obj){
        System.out.println("Woo t(Super)");
        obj.s();        // 方法被重写，调用子类型的方法。
    }
    public void t(Sub obj){
        System.out.println("Woo t(Sub)");
        obj.s();
    }
}

class Super{
    public void s(){
        System.out.println("Super s()");
    }
}

class Sub extends Super{
    public void s(){
        System.out.println("Sub s()");
    }
}
