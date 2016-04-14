package step01.day08;

/**
 * Created by pinghua.wph on 2016/4/13.
 */
public class MySecRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("hello " + i + " count");
        }
    }
}
