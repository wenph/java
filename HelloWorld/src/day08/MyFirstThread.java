package day08;

/**
 * Created by pinghua.wph on 2016/4/13.
 */
public class MyFirstThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
    }
}
