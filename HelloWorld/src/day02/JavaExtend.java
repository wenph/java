package day02;

/**
 * Created by pinghua.wph on 2016/3/31.
 */

/*
 * 继承
 * 子类型对象可以赋值给父类型变量
 * 变量是代词，父类型代词可以引用子类型东西
 * 变量的类型定义的属性和方法才能访问
 * 如：Shape s; s只能访问Shap上声明的属性和方法。如果方法被子类重写，执行子类方法
 *
 * 继承中的构造器
 * 1. 类一定有构造器
 * 2. 子类一定调用父类构造器
 *   2.1 子类默认调用父类无参数构造器
 *   2.2 如果父类没有无参构造器，必须使用super()调用父类构造器。
 *
 * 关于super()：一定在子类构造器第一行使用！如果没有，默认存在super()！
 * this()和super()互斥！
 *
 * 方法重写
 * c是子类的引用，调用的是子类的方法，并不执行父类的方法。
 */
public class JavaExtend {
    public static void main(String[] args){
//        Circle c = new Circle(3,4,5);
//        c.up(2);
//        System.out.println(c.x + "," + c.y + "," + c.r);
//        Shape s = c;    // 子类型对象可以赋值给父类型变量
//         System.out.println(s.x + "," + s.y);    // s只能访问Shap上声明的属性和方法
//        Circle c = new Circle(3, 5);        // 编译错误，Circle中没有Circle(int x, int y)构造器
        Circle c = new Circle(3,4,5);
    }
}

class Shape{
    int x; int y;
    public Shape(){ // 构造器，子类型构造器默认调用父类型的无参数构造器！
        System.out.println("Call Shape()");
    }
    public Shape(int x, int y){
        this.x = x; this.y = y;
    }
    public void up(){
        y--;
    }
    public void up(int dy){
        y -= dy;
    }
}

class Circle extends Shape {
    int r;
    public Circle(){
        this(1,2,3);            // 调用本类的其他构造器
    }
    public Circle(int x, int y, int r){
        this.x = x; // 从父类继承的属性
        this.y = y;
        this.r = r;
    }
    /* 计算面积 */
    public double area(){
        return 3.14 * r * r;
    }
}


class Xoo{
    public Xoo(int s){
        System.out.println("Call Xoo(int)");
    }
}

//class Yoo extends Xoo{}     // 编译错误，因为调用不到父类的无参构造器
//class Yoo extends Xoo{public Yoo(){}}   // 编译错误，因为调用不到父类的无参构造器
class Yoo extends Xoo {
    public Yoo(){
        super(100);         // 调用父类Xoo(int)构造器
    }
}