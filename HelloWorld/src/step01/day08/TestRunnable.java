package step01.day08;

/**
 * Created by pinghua.wph on 2016/4/13.
 */
public class TestRunnable {
    public static void main(String[] args) {
        Runnable r1 = new MyFirstRunnable();
        Runnable r2 = new MySecRunnable();
        /**
         * 将两个任务分别交给线程去并发处理
         * 使用线程的重载构造方法
         * Thread(Runnable runnable)
         */
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
