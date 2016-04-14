package step01.day06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pinghua.wph on 2016/4/10.
 */
public class day06Class {
    public static void main(String[] args) {
        day06Class day06 = new day06Class();
        System.out.println(day06);
//        System.out.println(toString());     // 静态方法中不能直接引用非静态的属性和方法！非静态方法中可以直接引用静态属性和方法！

        /*
         * 8种基本类型（int,long,double,char,boolean,byte,float,short）保存的是值本身，而引用类型保存的是地址。
         * “==”比较的是不是同一个对象（地址），equals试图比较对象内容是否相等。
         */
        Point p1 = new Point();
        Point p2 = new Point();
        if (p1 == p2){
            System.out.println("对象地址相等");
        }
        if (p1.equals(p2)){
            System.out.println("试图比较对象内容相等");
        }
        /*
         * 字符串对象是引用类型，但不可变，虚拟机对它做了特殊的优化，放在常量池里，字符串的任何变化都会创建新对象。
         * 尽量使用equals。
         *
         * 使用"hello".equals(s1)，不使用s1.equals("hello"),因为不能保证s1是否是null，空指针异常。
         */
        String s1 = "hello";
        String s2 = "hello";
        if (s1 == s2){
            System.out.println("地址相等");
        }
        if (s1.equals(s2)){
            System.out.println("内容相等");
        }


        /*
         * Date类，Calendar类,DataFormat类
         */

        /*
         * 包装类：8个，为了把数据当类使用,java 1.5后自动拆装箱
         */
        Integer i = new Integer(1);     //“装箱”
        int a = 5;
        Integer ii = Integer.valueOf(a);    //“装箱”
        int b = i.intValue();           // 反之“拆箱”

        /*
         * Collection是集合的顶级父类：是一个接口
         * 其下有2个子类：List和Set。
         *
         * List（可重复）Set（不可重复）：用equals判断是否相等，然后决定是否放入。
         * List有2个子类实现：ArrayList和LinkedList
         *
         * 迭代器：Iterator，也有增删改方法。
         */

        List<ComparablePoint> list = new ArrayList<ComparablePoint>();
        list.add(new ComparablePoint(1,5));
        list.add(new ComparablePoint(3,4));
        list.add(new ComparablePoint(2,2));

        /*
         * 使用compareTo方法进行比较。
         */
        Collections.sort(list);
    }

    @Override
    public String toString(){
        return "hahahahaha";
    }


}

class Point {
    int x;
    int y;

    /**
     * 在集合中，先计算hashcode，找到hashcode对应的内存地址，如果地址相同，再用equals比较两个对象是否相等，相等则不存放。
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point p = (Point) obj;
        return this.x==p.x && this.y==p.y;
    }

    @Override
    public String toString(){
        return "["+this.x+","+this.y+"]";
    }

}
