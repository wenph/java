package day02;

/**
 * Created by pinghua.wph on 2016/3/31.
 */

/*
 * 方法区：类（.class）加载到方法区
 * 栈：局部变量在栈中分配
 * 堆：对象在堆中创建，对象按照属性分配空间
 *
 * 面向对象的3大特征：继承，多态，封装
 * 继承：子类继承父类
 * 继承体现了多态：父类型变量可以引用各种各样的子类型实例
 *   个体的多态：父类型的子类型实例是多种多样的
 *   行为的多态：父类型定义方法被子类重写为多样的
 */
public class JavaClass {
    public static void main(String[] args){
//        Point p1 = new Point();
//        p1.x = 3;
//        p1.y = 4;
//        Point p2 = new Point();
//        p2.x = 5;
//        p2.y = 5;
//        System.out.println(p1.x + "," + p1.y);
//        System.out.println(p2.x + "," + p2.y);
//        p1.up(10);
//        System.out.println(p1.x + "," + p1.y);
//        p2.up();        // 在调用up()方法时，不仅把参数传递过去，而且把对象p2也传递给this参数。
//        System.out.println(p2.x + "," + p2.y);
        Point2 p = new Point2(3,4);
        Point2 p2 = new Point2();
        System.out.println(p2.x + "," + p2.y);
    }
}

/*
 * this的用法
 *
 */
class Point{
    int x;
    int y;
    /*
     * 方法重载：方法名一样，参数不同，实现类似的功能。
     * 调用方法：根据方法名和参数列表调用不同的方法。
     */
    public void up(int dy){
        y -= dy;
    }
    public void up(){
        this.y--;       // this 是方法中当前对象的引用，本质是方法的隐藏参数。
    }
}

/*
 * 构造器（构造方法）：与类名一致，不能有返回值。如果没有定义构造器，则调用默认的，否则使用用户定义的构造器。构造器是可以重载的。
 * 作用：用于创建对象，初始化对象属性。
 * 构造器参数：初始化对象的前提条件。
 */
class Point2{
    int x; int y;
    public Point2(){

    }
    public Point2(int x, int y){
        this.x = x; this.y = y;     // 构造器这种情况下最好不要省略this，怕误会。除非构造器参数用别的名称。
    }
}