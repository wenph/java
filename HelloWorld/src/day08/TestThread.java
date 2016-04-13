package day08;

/**
 * Created by pinghua.wph on 2016/4/13.
 */
public class TestThread {
    public static void main(String[] args) {
        Thread t1 = new MyFirstThread();
        Thread t2 = new MySecThread();
        t1.start();
        t2.start();
    }
}
