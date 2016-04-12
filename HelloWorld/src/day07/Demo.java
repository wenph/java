package day07;

/**
 * Created by admin on 16/4/12.
 */
public class Demo {
    public static void main(String[] args) {
        DemoSingleton obj1 = DemoSingleton.getInstance();
        DemoSingleton obj2 = DemoSingleton.getInstance();
        System.out.println(obj1 == obj2);
    }
}
