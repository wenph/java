package step01.day09;

/**
 * Created by pinghua.wph on 2016/4/14.
 */

/**
 * 后台线程也称为守护线程
 * 特点：当当前进程中所有前台线程死亡后，后台线程强制死亡。无论是否还在运行。
 */
public class DemoThread {
    public static void main(String[] args) throws InterruptedException {
        Thread rose = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("let me go!");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Aaaaaaaaaaaaaaa..扑通！");
            }
        };

        Thread jack = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("you jump! i jump!");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Aaaaaaaaaaaaaaa..扑通！");
            }
        };
        jack.setDaemon(true);       // 守护线程，jack守护者rose
        /**
         * 一共3个线程：
         * main线程、rose线程、jack线程
         * 其中
         * main线程、rose线程是前台线程
         * jack是后台线程，后台线程只有等所有的前台线程死掉之后才死。
         */
        rose.start();
        jack.start();
        Thread.sleep(10000);        // 验证main线程不死，jack不死。
    }
}
